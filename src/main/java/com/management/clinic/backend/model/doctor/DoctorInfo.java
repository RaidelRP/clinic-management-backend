package com.management.clinic.backend.model.doctor;

import com.management.clinic.backend.model.Gender;
import com.management.clinic.backend.model.Speciality;

public record DoctorInfo(
        Long id,
        String name,
        Gender gender,
        String email,
        Speciality speciality) {

    public DoctorInfo(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getGender(), doctor.getEmail(), doctor.getSpeciality());
    }
}
