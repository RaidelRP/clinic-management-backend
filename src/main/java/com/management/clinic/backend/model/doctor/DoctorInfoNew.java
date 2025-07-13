package com.management.clinic.backend.model.doctor;

import com.management.clinic.backend.model.Gender;
import com.management.clinic.backend.model.Speciality;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DoctorInfoNew(
        @NotBlank String name,
        @NotNull Gender gender,
        @NotBlank @Email String email,
        @NotNull Speciality speciality) {
}
