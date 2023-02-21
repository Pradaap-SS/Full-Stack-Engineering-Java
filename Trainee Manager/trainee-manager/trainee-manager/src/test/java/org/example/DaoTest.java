package org.example;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.example.dao.TraineeDao;
import org.example.dao.TraineeDaoImpl;
import org.example.exeptions.InvalidTraineeOperationException;
import org.example.model.Track;
import org.example.model.Trainee;
import org.junit.Test;

public class DaoTest {

	TraineeDao dao = new TraineeDaoImpl();
	
	@Test
	public void testRegisterTrainee() throws InvalidTraineeOperationException {
		dao.registerTrainee("AAA00AA00", (new Trainee(877998, "AAA00AA00", "Tommas", "Shelby", "Shelby@gmail.com", Track.JAVA, LocalDate.of(2020,9,05))));
		assertTrue(dao.findAll("AAA00AA00").size()==1);
	}
	/**
	 * @throws InvalidTraineeOperationException
	 */
	@Test
	public void testRegisterTrainee2() throws InvalidTraineeOperationException {
		dao.registerTrainee("AAA00AA00", (new Trainee(877998, "AAA00AA00", "Khal", "Drogo", "Drogo@gmail.com", Track.JAVA, LocalDate.of(2020,9,05))));
		dao.registerTrainee("AAA00AA00", (new Trainee(770011, "AAA00AA00", "Jamie", "Lannister", "Jamie@gmail.com", Track.JAVA, LocalDate.of(2020,9,05))));
		assertTrue(dao.findAll("AAA00AA00").size()==2);
	}
	
	@Test
	public void testDeleteTrainee() throws InvalidTraineeOperationException {
		dao.registerTrainee("AAA00AA00", (new Trainee(877998, "AAA00AA00", "Khal", "Drogo", "Drogo@gmail.com", Track.JAVA, LocalDate.of(2020,9,05))));
		dao.registerTrainee("AAA00AA00", (new Trainee(770011, "AAA00AA00", "Jamie", "Lannister", "Jamie@gmail.com", Track.JAVA, LocalDate.of(2020,9,05))));
		assertTrue(dao.findAll("AAA00AA00").size()==0);
	}
	
	@Test
	public void testFindByName1() throws InvalidTraineeOperationException {
		Trainee trainee= new Trainee(877998, "AAA00AA00", "Khal", "Drogo", "Drogo@gmail.com", Track.JAVA, LocalDate.of(2020,9,05));
		dao.registerTrainee("AAA00AA00", trainee);
		Trainee actual = dao.findByName("AAA00AA00", "Khal Drogo");
		assertTrue(trainee.equals(actual));
	}

	@Test
	public void testFindByName2()   {
		Trainee trainee= new Trainee(877998, "AAA00AA00", "Khal", "Drogo", "Drogo@gmail.com", Track.JAVA, LocalDate.of(2020,9,05));
		Trainee actual = null;
		try {
			dao.registerTrainee("AAA00AA00", trainee);
			actual = dao.findByName("AAA00AA00", "Another Name");
		} catch (InvalidTraineeOperationException e) {
			assertTrue(e.getMessage().contains("Trainee Another Name not present under cohort AAA00AA00"));
		}
	}
	
	@Test
	public void testFindByName3()   {
		Trainee actual = null;
		try {
			
			actual = dao.findByName("AAA00AA00", "Another Name");
		} catch (InvalidTraineeOperationException e) {
			assertTrue(e.getMessage().contains("Cohort AAA00AA00 is not present"));
		}
	}
	
	

}
