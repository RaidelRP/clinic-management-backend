package com.management.clinic.backend.controller;


import com.management.clinic.backend.model.doctor.Doctor;
import com.management.clinic.backend.model.doctor.DoctorInfo;
import com.management.clinic.backend.model.doctor.DoctorInfoNew;
import com.management.clinic.backend.repository.DoctorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity getDoctor(@PathVariable Long id) {
        var doctor = repository.getReferenceById(id);
        return ResponseEntity.ok(new DoctorInfo(doctor));
    }

    @GetMapping
    public ResponseEntity<Page<DoctorInfo>> listDoctors(@PageableDefault(sort = {"name"}) Pageable pagination) {
        var page = repository.findAll(pagination).map(DoctorInfo::new);
        return ResponseEntity.ok(page);
    }

    @Transactional
    @PostMapping("/new")
    public ResponseEntity newDoctor(@RequestBody @Valid DoctorInfoNew info, UriComponentsBuilder uriComponentsBuilder) {
        var doctor = new Doctor(info);
        repository.save(doctor);

        var uri = uriComponentsBuilder.path("/doctors/{id}").buildAndExpand(doctor.getId()).toUri();

        return ResponseEntity.created(uri).body(new DoctorInfo(doctor));
    }

    @Transactional
    @PutMapping
    public ResponseEntity editDoctor(@RequestBody @Valid DoctorInfo info) {
        var doctor = repository.getReferenceById(info.id());
        doctor.update(info);
        return ResponseEntity.ok(new DoctorInfo(doctor));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity deleteDoctor(@PathVariable Long id) {
        var doctor = repository.getReferenceById(id);
        repository.delete(doctor);

        return ResponseEntity.noContent().build();
    }
}
