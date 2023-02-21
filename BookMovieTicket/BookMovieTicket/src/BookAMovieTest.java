import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BookAMovieTest {

	static BookAMovie bookAMovie;

	@Before
	public void setUp() throws Exception {
		bookAMovie = new BookAMovie();
		//Try to create few MovieTicket objects and add to a list.
		//Set that list to movieTicketList in BookAMovie using setMovieTicketList method
	
	}


	public void test11ValidateCircleWhenKing() throws InvalidMovieTicketException {
		
			//test the validateCircle method when a valid circle “king” is provided
	
	}

	public void test12ValidateCircleWhenQueen() throws InvalidMovieTicketException {
		
		//test the validateCircle method when a valid circle “queen” is provided.
	
	}

	public void test13ValidateCircleWhenInvalid() {
	
		//test the validateCircle method when an invalid circle  is passed to this method
	}

	public void test14AddMovieTicketForValidCircle() {
	
		//test the addMovieTicket method when  valid circle is provided for the MovieTicket
	
	}

	public void test15AddMovieTicketForInvalidCircle() {

		//test the addMovieTicket method when  invalid circle is provided for the MovieTicket
	
	}

	public void test16ViewMovieTicketByIdForValidId() {
	
		//test the viewMovieTicketById method when a ticketId is passed as parameter exists in 
		//the movieTicketList
		
	}

	public void test17ViewMovieTicketByIdForInvalidId() {
	
		// test  the viewMovieTicketById method when a ticketId is passed as parameter 
		//does not exist in the movieTicketList
		
	}

	public void test18ViewMovieTicketByScreen() {
		
		//test the viewMovieTicketByScreen method
		
	}

	
	public void test19VewTicketsMovieWise() {
		
		//test the viewTicketsMovieWise method
	
	}

	public void test20ViewScreenWiseTotalSeatsBooked() {

		//test the viewScreenWiseTotalSeatsBooked method
		
	}

}
