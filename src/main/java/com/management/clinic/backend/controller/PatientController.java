package com.management.clinic.backend.controller;

import com.management.clinic.backend.model.patient.Patient;
import com.management.clinic.backend.model.patient.PatientInfo;
import com.management.clinic.backend.model.patient.PatientInfoNew;
import com.management.clinic.backend.repository.PatientRepository;
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
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity getPatient(@PathVariable Long id) {
        var patient = repository.getReferenceById(id);
        return ResponseEntity.ok(new PatientInfo(patient));
    }

    @GetMapping
    public ResponseEntity<Page<PatientInfo>> listPatients(@PageableDefault(sort = {"name"}) Pageable pagination) {
        var page = repository.findAll(pagination).map(PatientInfo::new);
        return ResponseEntity.ok(page);
    }

    @Transactional
    @PostMapping("/new")
    public ResponseEntity newPatient(@RequestBody @Valid PatientInfoNew info, UriComponentsBuilder uriComponentsBuilder) {
        var patient = new Patient(info);
        repository.save(patient);

        var uri = uriComponentsBuilder.path("/patients/{id}").buildAndExpand(patient.getId()).toUri();

        return ResponseEntity.created(uri).body(new PatientInfo(patient));
    }

    @Transactional
    @PutMapping
    public ResponseEntity editPatient(@RequestBody @Valid PatientInfo info) {
        var patient = repository.getReferenceById(info.id());
        patient.update(info);
        return ResponseEntity.ok(new PatientInfo(patient));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity deletePatient(@PathVariable Long id) {
        var patient = repository.getReferenceById(id);
        repository.delete(patient);

        return ResponseEntity.noContent().build();
    }
}
