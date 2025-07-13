package com.management.clinic.backend.model.patient;

import com.management.clinic.backend.model.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PatientInfo(
        @NotNull Long id,
        String name,
        Gender gender,
        @Email String email,
        LocalDate birthDate,
        String address
) {

    public PatientInfo(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getGender(), patient.getEmail(), patient.getBirthDate(), patient.getAddress());
    }
}
