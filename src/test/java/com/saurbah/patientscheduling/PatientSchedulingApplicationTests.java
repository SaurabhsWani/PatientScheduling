package com.saurbah.patientscheduling;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.saurbah.patientscheduling.entities.Appointment;
import com.saurbah.patientscheduling.entities.Doctor;
import com.saurbah.patientscheduling.entities.Insurance;
import com.saurbah.patientscheduling.entities.Patient;
import com.saurbah.patientscheduling.repos.AppointmentRepository;
import com.saurbah.patientscheduling.repos.DoctorRepository;
import com.saurbah.patientscheduling.repos.PatientRepository;

@SpringBootTest
class PatientSchedulingApplicationTests {

	@Autowired
	DoctorRepository doctorRepository;

	@Autowired
	PatientRepository patientRepository;

	@Autowired
	AppointmentRepository appointmentRepository;

	@Test
	void createDoctorTest() {
		Doctor doctor1 = new Doctor();
		doctor1.setFirstName("Rohit");
		doctor1.setLastName("Sharma");
		doctor1.setSpeciality("Dentist");
		Doctor doctor2 = new Doctor();
		doctor2.setFirstName("Virat");
		doctor2.setLastName("Kohali");
		doctor2.setSpeciality("Ortho");
		Doctor doctor3 = new Doctor();
		doctor3.setFirstName("Mahendrasingh");
		doctor3.setLastName("Dhoni");
		doctor3.setSpeciality("Throat");
		List<Doctor> doctors = new ArrayList<Doctor>(Arrays.asList(doctor1, doctor2, doctor3));
		doctorRepository.saveAll(doctors);
	}

	@Test
	void createPatientTest() {
		Patient patient = new Patient();
		patient.setFirstName("Sam");
		patient.setLastName("Karan");
		patient.setPhone("1234567892");

		Insurance samInsurance = new Insurance();
		samInsurance.setProviderName("BCCI");
		samInsurance.setCopay(50000d);

		patient.setInsurance(samInsurance);

		Optional<Doctor> docObj = doctorRepository.findById(1L);
		Doctor docForSam = docObj.get();

		patient.setDoctors(Arrays.asList(docForSam));

		patientRepository.save(patient);
	}

	@Test
	void creatAppointmentTest() {
		Appointment appointment = new Appointment();
		appointment.setReason("Problem with throat, paining to much");

		Timestamp appointmentTime = new Timestamp(new Date().getTime());
		appointment.setAppointmentTime(appointmentTime);

		appointment.setStarted(true);
		appointment.setPatient(patientRepository.findById(4L).get());
		appointment.setDoctor(doctorRepository.findById(1L).get());

		appointmentRepository.save(appointment);
	}
}
