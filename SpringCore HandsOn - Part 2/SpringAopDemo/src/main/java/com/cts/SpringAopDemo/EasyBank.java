package com.cts.SpringAopDemo;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// Type your code here
@Component
public class EasyBank {

	private int pinCode = 6789;
	private int balance = 10000;
	private int tempPin;

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getTempPin() {
		return tempPin;
	}

	public void setTempPin(int tempPin) {
		this.tempPin = tempPin;
	}

	public void doDeposit(int amount) {

		// Type your code here
		this.balance = amount+balance;
		System.out.println("Your  balance is " +balance);

	}

	public void doWithdraw(int amount) {

		// Type your code here
		if (amount < balance) {
			this.balance = this.balance - amount;
			System.out.println("You have successfully withdrawn " + amount);
		} else {
			System.out.println("Insufficient Fund");
		}

	}

	
	public void doChangePin(int oldPin, int pin)  {

		// Type your code here
		int num=pin;
		
		int c=0;
		while(num!=0)
		{
			num=num/10;
			c++;
		}
		if(c>4)
		{
			throw new RuntimeException();
		}
		
		if (oldPin == pinCode) {
			pin = pinCode;

		} 
		else {
			throw new RuntimeException();
		}

	}

	public void showBalance() {

		// Type your code here
		System.out.println("Your balance is "+balance);

	}

}
