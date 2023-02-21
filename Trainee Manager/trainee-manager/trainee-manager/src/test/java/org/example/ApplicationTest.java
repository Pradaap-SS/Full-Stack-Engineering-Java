package org.example;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.example.exeptions.InvalidTraineeDataException;
import org.example.exeptions.InvalidTraineeOperationException;
import org.example.model.Track;
import org.example.model.Trainee;
import org.example.repository.TraineeRepo;
import org.example.repository.TraineeRepoImpl;
import org.example.util.ValidatorUtil;
import org.junit.Test;

public class ApplicationTest {
	
	private TraineeRepo repo = new TraineeRepoImpl();

	@Test
	public void testRegisterTrainee() throws InvalidTraineeOperationException {
		repo.registerTrainee("AAA00AA00", (new Trainee(877998, "AAA00AA00", "Thomas", "Shelby", "Shelby@gmail.com", Track.JAVA, LocalDate.of(2020,9,05))));
		assertTrue(repo.findAll("AAA00AA00").size()==1);
	}
	@Test
	public void testRegisterTrainee2() throws InvalidTraineeOperationException {
		repo.registerTrainee("AAA00AA00", (new Trainee(877998, "AAA00AA00", "Thomas", "Shelby", "Shelby@gmail.com", Track.JAVA, LocalDate.of(2020,9,05))));
		repo.registerTrainee("AAA00AA00", (new Trainee(770011, "AAA00AA00", "Jammie", "Lannister", "Jammie@gmail.com", Track.JAVA, LocalDate.of(2020,9,05))));
		assertTrue(repo.findAll("AAA00AA00").size()==2);
	}
	
	@Test
	public void testDeleteTrainee() throws InvalidTraineeOperationException {
		repo.registerTrainee("AAA00AA00", (new Trainee(877998, "AAA00AA00", "Thomas", "Shelby", "Shelby@gmail.com", Track.JAVA, LocalDate.of(2020,9,05))));
		repo.registerTrainee("AAA00AA00", (new Trainee(770011, "AAA00AA00", "Jammie", "Lannister", "Jammie@gmail.com", Track.JAVA, LocalDate.of(2020,9,05))));
		assertTrue(repo.findAll("AAA00AA00").size()==0);
	}
	
	@Test
	public void testFindByName1() throws InvalidTraineeOperationException {
		Trainee trainee = new Trainee(877998, "AAA00AA00", "Thomas", "Shelby", "Shelby@gmail.com", Track.JAVA, LocalDate.of(2020,9,05));
		repo.registerTrainee("AAA00AA00", trainee);
		Trainee actual = repo.findByName("AAA00AA00", "Thomas Shelby");
		assertTrue(trainee.equals(actual));
	}

	@Test
	public void testFindByName2()   {
		Trainee trainee = new Trainee(877998, "AAA00AA00", "Thomas","Shelby", "Shelby@mail.com", Track.JAVA, LocalDate.of(2020,9,05));
		Trainee actual = null;
		try {
			repo.registerTrainee("AAA00AA00", trainee);
			actual = repo.findByName("AAA00AA00", "Another Name");
		} catch (InvalidTraineeOperationException e) {
			assertTrue(e.getMessage().contains("Trainee Another Name not present under cohort AAA00AA00"));
		}
	}
	
	@Test
	public void testFindByName3()   {
		Trainee actual = null;
		try {
			
			actual = repo.findByName("AAA00AA00", "Another Name");
		} catch (InvalidTraineeOperationException e) {
			assertTrue(e.getMessage().contains("Cohort AAA00AA00 is present"));
		}
	}
	
	@Test
	public void testValidate() throws InvalidTraineeOperationException, InvalidTraineeDataException {
		ValidatorUtil validatorUtil = new ValidatorUtil();
		boolean b = validatorUtil.isValid(new Trainee(877998, "AAA00AA00", "Thomas", "Shelby", "Shelby@gmail.com", Track.JAVA, LocalDate.of(2020,9,05)));
		assertTrue(b);
	}
	
	@Test
	public void testValidate2()  {
		ValidatorUtil validatorUtil = new ValidatorUtil();
		
		try {
			validatorUtil.isValid(new Trainee(1, "AAA00AA00", "Thomas", "Shelby", "Shelby@gmail.com", Track.JAVA, LocalDate.of(2020,9,05)));
		} catch (InvalidTraineeDataException e) {
			assertTrue(e.getMessage().contains("Employee Id should have 6 digits"));
		}
		
	}
	@Test
	public void testValidate3()  {
		ValidatorUtil validatorUtil = new ValidatorUtil();
		
		try {
			validatorUtil.isValid(new Trainee(877998, "AAA00AA", "Thomas", "Shelby", "Shelby@gmail.com", Track.JAVA, LocalDate.of(2020,9,05)));
		} catch (InvalidTraineeDataException e) {
			assertTrue(e.getMessage().contains("Invalid Cohort Name"));
		}
		
	}
	
	@Test
	public void testValidate4()  {
		ValidatorUtil validatorUtil = new ValidatorUtil();
		
		try {
			validatorUtil.isValid(new Trainee(877998, "AAA00AA00", "Thomas", "Shelby", "Tom", Track.JAVA, LocalDate.of(2020,9,05)));
		} catch (InvalidTraineeDataException e) {
			assertTrue(e.getMessage().contains("Enter correct email address"));
		}
		
	}
}
