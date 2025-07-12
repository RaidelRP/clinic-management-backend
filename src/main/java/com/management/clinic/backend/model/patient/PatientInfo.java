package com.management.clinic.backend.model.patient;

import com.management.clinic.backend.model.Gender;

import java.time.LocalDate;

public record PatientInfo(
        Long id,
        String name,
        Gender gender,
        String email,
        LocalDate birthDate,
        String address
) {

    public PatientInfo(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getGender(), patient.getEmail(), patient.getBirthDate(), patient.getAddress());
    }
}
