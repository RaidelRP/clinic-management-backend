package com.management.clinic.backend.model.doctor;

import com.management.clinic.backend.model.Gender;
import com.management.clinic.backend.model.Speciality;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Gender gender;
    private String email;
    private Speciality speciality;

    public Doctor(DoctorInfoNew info) {
        this.name = info.name();
        this.gender = info.gender();
        this.email = info.email();
        this.speciality = info.speciality();
    }

    public void update(@Valid DoctorInfo info) {
        this.name = info.name() != null ? info.name() : this.getName();
        this.gender = info.gender() != null ? info.gender() : this.getGender();
        this.email = info.email() != null ? info.email() : this.getEmail();
        this.speciality = info.speciality() != null ? info.speciality() : this.getSpeciality();
    }
}
