package com.management.clinic.backend.model.doctor;

import com.management.clinic.backend.model.Gender;
import com.management.clinic.backend.model.Speciality;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
    @GeneratedValue()
    private Long id;

    private String name;
    private Gender gender;
    private String email;
    private Speciality speciality;
}
