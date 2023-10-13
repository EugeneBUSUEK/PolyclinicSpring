package com.example.polyclinic.persist.db.postgres;

import com.example.polyclinic.persist.db.postgres.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, UUID> {
}
