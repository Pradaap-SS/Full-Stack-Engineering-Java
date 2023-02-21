package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.example.model.Track;
import org.example.model.Trainee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConsoleMsgTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;
	
	Application app = new Application();

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void restoreStreams() {
	    System.setOut(originalOut);
	    System.setErr(originalErr);
	}
	
	@Test
	public void testDisplayMenu() {
	    app.displayMenu();
	    StringBuilder menu = new StringBuilder();
		
		menu.append("\nChoose your options");
		menu.append("\n a. Register a Trainee");
		menu.append("\n b. Remove a Trainee");
		menu.append("\n c. Find a trainee by full Name");
		menu.append("\n d. Find all trainees under a cohort");
		menu.append("\n e. Exit");

	    assertTrue(outContent.toString().contains(menu.toString()));
	}

	@Test
	public void testDisplayAll() {
		Trainee trainee = new Trainee(877998, "AAA00AA00", "Thomas", "Shelby", "Shelby@gmail.com", Track.JAVA, LocalDate.of(2020,9,05));
		app.displayAll(Arrays.asList(trainee));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
		
		String row = String.format("| %6d | %15s | %15s | %15s | %15s | %15s | %20s |%n", trainee.getEmpid(),
				trainee.getCohort(), trainee.getFirstName(), trainee.getLastName(), trainee.getEmail(),
				trainee.getTrack(), trainee.getJoinDate().format(formatter));
	    assertTrue(outContent.toString().contains(row));
	}
	
	@Test
	public void testDisplayTrainee() {
		Trainee trainee = new Trainee(877998, "AAA00AA00", "Thomas", "Shelby", "Shelby@gmail.com", Track.JAVA, LocalDate.of(2020,9,05));
		app.displayTrainee(trainee);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
		
		String row = String.format("| %6d | %15s | %15s | %15s | %15s | %15s | %20s |%n", trainee.getEmpid(),
				trainee.getCohort(), trainee.getFirstName(), trainee.getLastName(), trainee.getEmail(),
				trainee.getTrack(), trainee.getJoinDate().format(formatter));
	    assertTrue(outContent.toString().contains(row));
	}
	
	
}
