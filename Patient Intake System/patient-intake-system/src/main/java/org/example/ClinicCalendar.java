package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ClinicCalendar {

	private List<PatientAppointment> appointments;

	public ClinicCalendar() {
		this.appointments = new ArrayList<>();
	}

	public void addAppointment(String firstName, String lastName, String doctor, String dateTime) {
		log.info("Add Appointment Function starts here!!");
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm a");
		LocalDateTime local = LocalDateTime.parse(dateTime, format);
		PatientAppointment patient = new PatientAppointment(firstName, lastName, Doctor.valueOf(doctor), local);
		getAppointments().add(patient);
		log.info("Add Appointment Function ends here!!");
	}

	public List<PatientAppointment> getAppointments() {
		return this.appointments;
	}
}