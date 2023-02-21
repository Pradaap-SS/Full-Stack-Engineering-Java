package org.example;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class exampleTests {

	private ClinicCalendar calender;

	@Before
	public void setup() {
		calender = new ClinicCalendar();
	}

	@Test
	public void testAddAppointmentsForFirstDoc() {
		calender.addAppointment("Thomas", "Shelby", "HALSEY", "31-01-2000 12:00 AM");
		assertEquals(1, calender.getAppointments().size());
	}

	@Test
	public void testAddAppointmentsForSecondDoc() {
		calender.addAppointment("Thomas", "Shelby", "KEYES", "31-01-2000 12:00 AM");
		assertEquals(1, calender.getAppointments().size());
	}

	@Test
	public void testAddAppointmentsForThirdDoc() {
		calender.addAppointment("Thomas", "Shelby", "JONES", "31-01-2000 12:00 AM");
		assertEquals(1, calender.getAppointments().size());
	}

	@Test(expected = Exception.class)
	public void testInvalidDoc() throws Exception {
		calender.addAppointment("Thomas", "Shelby", "abc", "31-01-2000 12:30 PM");
	}

	@Test(expected = Exception.class)
	public void testInvalidDateForKeyes() {
		calender.addAppointment("Thomas", "Shelby", "KEYES", "31-31-0000 59:59 FM");
	}

	@Test(expected = Exception.class)
	public void testInvalidDateForHalsey() {
		calender.addAppointment("Thomas", "Shelby", "Halsey", "31-31-0000 59:59 FM");
	}

	@Test(expected = Exception.class)
	public void testInvalidDateForJones() {
		calender.addAppointment("Thomas", "Shelby", "Jones", "31-31-0000 59:59 FM");
	}
}