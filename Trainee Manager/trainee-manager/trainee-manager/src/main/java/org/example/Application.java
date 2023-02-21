package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.example.dao.TraineeDao;
import org.example.dao.TraineeDaoImpl;
import org.example.exeptions.InvalidTraineeDataException;
import org.example.exeptions.InvalidTraineeOperationException;
import org.example.model.Track;
import org.example.model.Trainee;
import org.example.util.ValidatorUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {

	public static void main(String[] args) {

		TraineeDao dao = new TraineeDaoImpl();
		Application app = new Application();
		ValidatorUtil validatorUtil = new ValidatorUtil();

		Scanner scanner = new Scanner(System.in);
		String choice = "";

		while (true) {
			app.displayMenu();
			choice = scanner.nextLine();

			if (choice.equalsIgnoreCase("a")) {

				Trainee trainee = app.getTraineeFromUser();
				try {
					if(validatorUtil.isValid(trainee)) {
						try {
							dao.registerTrainee(trainee.getCohort(), trainee);
							log.info("Registering trainee...");
						} catch (InvalidTraineeOperationException e) {
							log.error(e.getMessage());
						}
					}
				} catch (InvalidTraineeDataException e) {
					log.error(e.getMessage());
				}
				
				

			} else if (choice.equalsIgnoreCase("b")) {

				Trainee trainee = app.getTraineeFromUser();
				log.info("Removing Trainee ...");
				if (trainee != null) {
					try {
						dao.removeTrainee(trainee.getCohort(), trainee);
					} catch (InvalidTraineeOperationException e) {
						log.error(e.getMessage());
					}
				}

			} else if (choice.equalsIgnoreCase("c")) {

				String cohort = app.getCohortFromUser();
				String fullName = app.getFullNameFromUser();
				try {
					Trainee trainee = dao.findByName(cohort, fullName);
					app.displayTrainee(trainee);

				} catch (InvalidTraineeOperationException e) {
					log.error(e.getMessage());
				}

			} else if (choice.equalsIgnoreCase("d")) {
				String cohort = app.getCohortFromUser();
				List<Trainee> list = dao.findAll(cohort);
				app.displayAll(list);
			}

			else if (choice.equalsIgnoreCase("e")) {
				app.terminate();
				break;
			}
			else {
				log.error("Invalid input");
			}

		}

	}

	public void displayMenu() {
		StringBuilder menu = new StringBuilder();
		menu.append("\n________________________________________");
		menu.append("\nChoose your options");
		menu.append("\n a. Register a Trainee");
		menu.append("\n b. Remove a Trainee");
		menu.append("\n c. Find a trainee by full Name");
		menu.append("\n d. Find all trainees under a cohort");
		menu.append("\n e. Exit");
		menu.append("\n________________________________________\n");

		System.out.println(menu.toString());

	}

	public Trainee getTraineeFromUser() {
		int empId = 877998; // 1
		
		String cohort = "AAA00AA00"; // aa00aa00aa
		String firstName = "Aiswarya"; // aiswarya101
		String lastName = "R"; // r2
		String email = "Aiswarya@gmail.com"; // aiswaeya.com
		Track track = Track.JAVA; 
		String date = "2020-09-05";

		LocalDate joinDate = null;
		try {
			joinDate = LocalDate.parse(date);
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		return new Trainee(empId, cohort, firstName, lastName, email, track, joinDate);

	}

	public String getCohortFromUser() {
		return "AAA00AA00";
	}

	public String getFullNameFromUser() {
		return "Aiswarya R";
	}

	public void terminate() {
		log.info("Terminating Application ..");
	}

	public void displayTrainee(Trainee trainee) {

		StringBuilder details = new StringBuilder();

		String header = String.format("%n| %6s | %15s | %15s | %15s | %15s | %15s | %20s |%n", "Emp Id", "Cohort",
				"First Name", "Last Name", "Email", "Track", "Date of Join");

		details.append(header);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");

		String row = String.format("| %6d | %15s | %15s | %15s | %15s | %15s | %20s |%n", trainee.getEmpid(),
				trainee.getCohort(), trainee.getFirstName(), trainee.getLastName(), trainee.getEmail(),
				trainee.getTrack(), trainee.getJoinDate().format(formatter));

		details.append(row);
		log.info(details.toString());

	}

	public void displayAll(List<Trainee> list) {

		StringBuilder details = new StringBuilder();

		String header = String.format("%n| %6s | %15s | %15s | %15s | %15s | %15s | %20s |%n", "Emp Id", "Cohort",
				"First Name", "Last Name", "Email", "Track", "Date of Join");

		details.append(header);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
		String row = null;
		for (Trainee trainee : list) {

			row = String.format("| %6d | %15s | %15s | %15s | %15s | %15s | %20s |%n", trainee.getEmpid(),
					trainee.getCohort(), trainee.getFirstName(), trainee.getLastName(), trainee.getEmail(),
					trainee.getTrack(), trainee.getJoinDate().format(formatter));
		}
		details.append(row);
		log.info(details.toString());
	}

}
