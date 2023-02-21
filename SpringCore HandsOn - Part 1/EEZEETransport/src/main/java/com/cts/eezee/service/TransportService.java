package com.cts.eezee.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cts.eezee.model.Booking;
import com.cts.eezee.model.Vehicle;

public class TransportService {
private Vehicle vehicle;

public Vehicle getVehicle() {
return vehicle;
}

public void setVehicle(Vehicle vehicle) {
this.vehicle = vehicle;
}

public void registerBooking(Booking booking) throws ParseException {
   
    ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
    Vehicle v=(Vehicle) ctx.getBean("vehicle");
       TransportService ts=new TransportService();
   ts.calculateTravelCost(v.getSource(), booking.getDestination(), booking.getDateOfJourney());



}
public void calculateTravelCost(String source, String destination, Date doj) {

TransportService ts=new TransportService();
boolean check=ts.checkAvailableDateForTravel(doj);
if(check){
   System.out.println("Total Travel Cost is Rs."+ts.getCost(destination));
}
else{
   System.out.println("Invalid Travel Date");
}


}

public boolean checkAvailableDateForTravel(Date doj) {

SimpleDateFormat sdfo = new SimpleDateFormat("dd-MM-yyyy");
 
        Date date1 = new Date();
        Calendar c2=Calendar.getInstance();
        c2.setTime(doj);
        c2.set(Calendar.MILLISECOND, 0);
        c2.set(Calendar.SECOND, 0);
        c2.set(Calendar.MINUTE, 0);
        c2.set(Calendar.HOUR, 12);
        doj=c2.getTime();
       
        Calendar c1=Calendar.getInstance();
        c1.setTime(date1);
        c1.set(Calendar.MILLISECOND, 0);
        c1.set(Calendar.SECOND, 0);
        c1.set(Calendar.MINUTE, 0);
        c1.set(Calendar.HOUR, 0);
        date1=c1.getTime();
       
        Date date2 = new Date();
       
        Calendar c=Calendar.getInstance();
        c.setTime(date2);
        c.add(Calendar.DATE, 1);
        c.set(Calendar.MILLISECOND, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.HOUR, 0);
        date2=c.getTime();
       
        System.out.println(doj);
       
        if(doj.compareTo(date1)>=0)
            return true;
        else
            return false;
}

public double getCost(String destination) {

ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
Vehicle v=(Vehicle) ctx.getBean("vehicle");
double cost=0;
for(Map.Entry<String,Double> m: v.getDestinationMap().entrySet()){
   if(destination.contentEquals(m.getKey())){
       cost=m.getValue();
   }
}


return cost;
}


}