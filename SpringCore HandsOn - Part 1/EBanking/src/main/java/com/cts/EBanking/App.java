package com.cts.EBanking;

import java.text.DecimalFormat;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		// CODE SKELETON - VALIDATION STARTS
		// DO NOT CHANGE THIS CODE

		new SkeletonValidator();

		// CODE SKELETON - VALIDATION ENDS
		
		DecimalFormat df = new DecimalFormat("#.00");
		ApplicationContext app = new ClassPathXmlApplicationContext("spring.xml");
		    SmartBankAccount sb = (SmartBankAccount) app.getBean("smartBankAccount");
		System.out.println("Welcome Mr/Ms: " + sb.getName());
		System.out.println("Your customer id is :" + sb.getCustomerId());
		int i = 1;
		for (String s : sb.getAccounts()) {

			System.out.println(i + " " + s);
			i++;
		}

		Scanner scanner = new Scanner(System.in);

		switch (scanner.nextInt()) {

		case 1:
			System.out.println("Select transaction type \n 1.Deposit \n 2.Withdraw");
			int choice = scanner.nextInt();
			if (choice == 1) {
				System.out.println("Enter amount to be deposited");
				double amt = scanner.nextDouble();
				double bal = sb.doDeposit(amt);

				System.out.println("Your balance amount is " + df.format(bal));

			} else if (choice == 2) {
				System.out.println("Enter amount to be withdrawn");
				double amt = scanner.nextDouble();
				double bal = sb.doWithdraw(amt);

				System.out.println("Your balance amount is " + df.format(bal));

			} else {
				System.out.println("Wrong choice");
			}
			break;
		case 2:
			System.out.println("Enter monthly installment");
			double amt = scanner.nextDouble();
			System.out.println("Enter tenure in months");
			int mon = scanner.nextInt();
			double bal = sb.calculateRecurringAccount(amt, mon);
			System.out.println("Your balance after " + mon + " months will be " + df.format(bal));

			break;
		case 3:
			System.out.println("Enter FD amount");
			double amount = scanner.nextDouble();
			System.out.println("Enter tenure in months");
			int months = scanner.nextInt();
			double balance = sb.calculateFixedAccount(amount, months);
			System.out.println("Your balance after " + months + " months will be " + df.format(balance));
			break;

		default:
			System.out.println("Wrong Choice");

		}

	}
}