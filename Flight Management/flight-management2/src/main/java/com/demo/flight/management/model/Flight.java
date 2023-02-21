package com.demo.flight.management.model;

import com.demo.flight.management.exceptions.InvalidFlightOperaration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Flight {

    private String id;
	private String flightType;
    private List<Passenger> passengers = new ArrayList<>();

    public boolean addPassenger(Passenger passenger) throws InvalidFlightOperaration{
    	
    	if(flightType.equalsIgnoreCase("Economy")) {
            passengers.add(passenger);
            return true;    
        }
        else {
            if(passenger.isVip()) {
                passengers.add(passenger);
                return true;
            }
        }
        return false;
    }

    public boolean removePassenger(Passenger passenger) throws InvalidFlightOperaration{

    	 if(passenger.isVip()) {
             return false;           
         }
         passengers.remove(passenger);
         return true;
    }
}
