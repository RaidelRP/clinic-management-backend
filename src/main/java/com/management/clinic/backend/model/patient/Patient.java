package com.management.clinic.backend.model.patient;

import com.management.clinic.backend.model.Gender;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Gender gender;
    private String email;
    private LocalDate birthDate;
    private String address;

    public Patient(@Valid PatientInfoNew info) {
        this.name = info.name();
        this.gender = info.gender();
        this.email = info.email();
        this.birthDate = info.birthDate();
        this.address = info.address();
    }

    public void update(@Valid PatientInfo info) {
        this.name = info.name() != null ? info.name() : getName();
        this.gender = info.gender() != null ? info.gender() : getGender();
        this.email = info.email() != null ? info.email() : getEmail();
        this.birthDate = info.birthDate() != null ? info.birthDate() : getBirthDate();
        this.address = info.address() != null ? info.address() : getAddress();
    }
}
