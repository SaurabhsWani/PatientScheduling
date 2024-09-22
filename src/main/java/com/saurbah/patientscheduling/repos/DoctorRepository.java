package com.saurbah.patientscheduling.repos;

import org.springframework.data.repository.CrudRepository;

import com.saurbah.patientscheduling.entities.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {

}
