package com.spring.ui;
import com.spring.app.*;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {
	
	
	public static AddressBook loadAddressBook()
	{
	    ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
	    AddressBook obj=(AddressBook) context.getBean("addressbook");

		return obj;
	}
	
	public static void main(String[] args)
{
		//invoke the loadAddressBook() method from main retrieve the AddressBook object, get the details from the user set the values and display the values
		Scanner scan=new Scanner(System.in);
		
		AddressBook tempAdbook=loadAddressBook();
		Address tempAdd=tempAdbook.gettempAddress();
		
		System.out.println("Enter the temporary address");
		System.out.println("Enter the house name");
		tempAdd.sethouseName(scan.nextLine());
		System.out.println("Enter the street");
		tempAdd.setstreet(scan.nextLine());
		System.out.println("Enter the city");
		tempAdd.setcity(scan.nextLine());
		System.out.println("Enter the state");
		tempAdd.setstate(scan.nextLine());
		System.out.println("Enter the phone number");
		tempAdbook.setphoneNumber(scan.nextLine());
		tempAdbook.settempAddress(tempAdd);
		
		System.out.println("Temporary address");
		System.out.println("House name:"+tempAdd.gethouseName());
		System.out.println("Street:"+tempAdd.getstreet());
		System.out.println("City:"+tempAdd.getcity());
		System.out.println("State:"+tempAdd.getstate());
		System.out.println("Phone number :"+tempAdbook.getphoneNumber());
}
}