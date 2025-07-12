package com.management.clinic.backend.model.patient;

import com.management.clinic.backend.model.Gender;

import java.time.LocalDate;

public record PatientInfoNew(
        String name,
        Gender gender,
        String email,
        LocalDate birthDate,
        String address
) {

    public PatientInfoNew(Patient patient) {
        this(patient.getName(), patient.getGender(), patient.getEmail(), patient.getBirthDate(), patient.getAddress());
    }
}
