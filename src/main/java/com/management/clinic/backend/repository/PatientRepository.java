package com.management.clinic.backend.repository;

import com.management.clinic.backend.model.patient.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
