package com.saurbah.patientscheduling.repos;

import org.springframework.data.repository.CrudRepository;

import com.saurbah.patientscheduling.entities.Patient;

public interface PatientRepository extends CrudRepository<Patient, Long> {

}
