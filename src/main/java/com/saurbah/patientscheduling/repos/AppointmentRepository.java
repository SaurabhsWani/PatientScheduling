package com.saurbah.patientscheduling.repos;

import org.springframework.data.repository.CrudRepository;

import com.saurbah.patientscheduling.entities.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

}
