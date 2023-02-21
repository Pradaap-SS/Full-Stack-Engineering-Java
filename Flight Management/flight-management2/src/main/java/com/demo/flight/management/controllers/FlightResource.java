package com.demo.flight.management.controllers;

import java.util.ArrayList;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.flight.management.exceptions.InvalidFlightOperaration;
import com.demo.flight.management.model.Flight;
import com.demo.flight.management.model.Passenger;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/flights")
public class FlightResource {

	private Flight economyFlight = new Flight("IND001", "Economy", new ArrayList<>());
    private Flight businessFlight = new Flight("JET001", "Business", new ArrayList<>());
    Passenger passenger= new Passenger("Tommas",true);
	private boolean flag;

	// POST /flights/business
	@PostMapping(value = "/business")
	public boolean forBookingBusinessFlight() {
		log.info("Booking function for Business Flight starts here..!!");

		try {
			flag = businessFlight.addPassenger(passenger);
		} catch (InvalidFlightOperaration e) {
			log.error(e.getStackTrace().toString());
		}
		log.info("Booking function for Business Flight ends here..!!");
		return flag;
	}

// DELETE /flights/business

	@DeleteMapping(value = "/business")
	public boolean forDeletingBusinessFlight() {

		log.info("Delete Business Flight function starts here..!!");
		try {
			flag = businessFlight.removePassenger(passenger);
		} catch (InvalidFlightOperaration e) {
			log.error(e.getStackTrace().toString());
		}

		log.info("Delete Business Flight function ends here..!!");
		return flag;
	}

// POST /flights/economy
	@PostMapping(value = "/economy")
	public boolean forBookingEconomyFlight() {
		log.info("Booking function for Economy Flight starts here..!!");

		try {
			flag = economyFlight.addPassenger(passenger);
		} catch (InvalidFlightOperaration e) {
			log.error(e.getStackTrace().toString());
		}

		log.info("Booking function for Economy Flight ends here..!!");
		return flag;
	}

// DELETE /flights/delete

	@DeleteMapping(value = "/economy")
	public boolean forDeletingEconomyFlight() {
		log.info("Delete function for Economy Flight starts here..!!");
		try {
			flag = economyFlight.removePassenger(passenger);
		} catch (InvalidFlightOperaration e) {
			log.error(e.getStackTrace().toString());
		}

		log.info("Delete function for Economy Flight ends here..!!");
		return flag;
	}
// exception handler for InvalidFlightOperaration }

}
