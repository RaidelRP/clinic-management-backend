package com.management.clinic.backend.model.patient;

import com.management.clinic.backend.model.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PatientInfoNew(
        @NotBlank String name,
        @NotNull Gender gender,
        @NotBlank @Email String email,
        @NotNull LocalDate birthDate,
        @NotBlank String address
) {

    public PatientInfoNew(Patient patient) {
        this(patient.getName(), patient.getGender(), patient.getEmail(), patient.getBirthDate(), patient.getAddress());
    }
}
