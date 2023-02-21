package com.cts.eezee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cts.eezee.model.Booking;
import com.cts.eezee.service.TransportService;

public class Main {

public static void main(String[] args) throws ParseException {

   ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
   
        Scanner input=new Scanner(System.in);
   Booking b=new Booking();
   System.out.println("Enter the Customer Name");
b.setCustomerName(input.nextLine());
System.out.println("Enter the Mobile Number");
b.setMobileNumber(Long.parseLong(input.nextLine()));
System.out.println("Enter the Destination");
b.setDestination(input.nextLine());
System.out.println("Enter the Date of Jouney <dd-MM-yyy>");
String str=input.nextLine();
SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
b.setDateOfJourney(dateFormat.parse(str));
TransportService ts=new TransportService();
ts.registerBooking(b);
}

}