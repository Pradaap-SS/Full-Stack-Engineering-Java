package org.example;

import java.util.List;
import java.util.Scanner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

	private static ClinicCalendar calender = new ClinicCalendar();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		displayMenu(scanner);

	}

	private static String displayMenu(Scanner scanner) {
		log.info("Display Menu Function starts here!!");
		while (true) {
			System.out.println("\n\t\tPatient Intake System\n");
			System.out.println("1. Add patient appointment \n2. View Appointments \n3. Exit");
			System.out.println("Enter your choice: ");
			int ch = Integer.parseInt(scanner.nextLine());
			if (ch == 1) {
				patientEntry(scanner);
			} else if (ch == 2) {
				allAppointments();
			} else {
				break;
			}
		}
		log.info("Display Menu Function ends here!");
		return null;
	}

	private static void patientEntry(Scanner scanner) {
		log.info("Patient Entry Function starts here!!");

		System.out.println("Enter First Name:");
		String fName = scanner.next();
		System.out.println("Enter Last Name:");
		String lName = scanner.next();
		System.out.println("Enter Doctor Name:");
		String dName = scanner.nextLine();
		System.out.print("Enter appointment date: ");
		String dT = scanner.nextLine();
		if (fName == "" || lName == "" || dName == "") {
			System.err.println("Invalid Inputs");
		} else {
			calender.addAppointment(fName, lName, dName, dT);
			log.info("Appointment created successfully");
		}
		log.info("Patient Entry ends here!!");
	}

	private static void allAppointments() {
		log.info("View Apointment Function starts here!!");
		List<PatientAppointment> appointmentList = calender.getAppointments();
		if (appointmentList.isEmpty()) {
			System.err.println("Appointment not found");
		} else {
			for (PatientAppointment p : appointmentList) {
				System.out.println(p);
			}
		}
		log.info("View Apointment Function ends here!");
	}
}