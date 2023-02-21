package com.spring.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.spring.exception.InvalidParcelWeightException;
import com.spring.service.CourierService;

public class Driver {

	public static void main(String[] args) throws InvalidParcelWeightException {
	    
		//fill the code
		Scanner sc = new Scanner(System.in);
		ApplicationContext context = new FileSystemXmlApplicationContext("src/main/resources/beans.xml");
		CourierService service = context.getBean("courierService", CourierService.class );
		int courierId = 0;
		int weight = 0;
		String cityName = "";
		double courierCharge=0.0;
		System.out.println("Enter the courier ID:");
		courierId = sc.nextInt();
		System.out.println("Enter the total weight of parcel:");
		weight = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the city:");
		cityName = sc.nextLine();
		
		courierCharge = service.calculateCourierCharge(courierId, weight, cityName);
		
		System.out.println("Total Courier Charge: "+courierCharge);
	}

}
