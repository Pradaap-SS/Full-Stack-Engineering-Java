package com.cts.EBanking;

import java.text.DecimalFormat;
import java.util.List;

public class SmartBankAccount extends BankAccount {
    
	public SmartBankAccount(int customerId, String name, double balance, List<String> accounts) {
		super(customerId, name, balance, accounts);
		// TODO Auto-generated constructor stub
	}

	
	public double calculateFixedAccount(double amount, int months) {
		// TODO Auto-generated method stub
		DecimalFormat formatter = new DecimalFormat("0.##");
		double p=amount;
	    double rate=0.10;
		double month=months;
		double result=0;
		if (amount > 9999 && amount < 1000001) {
			if (months > 0 && months < 121) {
			
			//  result = Math.pow((1+(0.1/12)),months)*amount;  
			result=p*(Math.pow((1+(rate/12)),month));
            return Double.parseDouble(formatter.format(result));
			}
		}
	   
	        return -1;
	    
	}

	
	public double calculateRecurringAccount(double amount, int months) {
		double result = 0;
		double month=months;
    DecimalFormat formatter = new DecimalFormat("0.##");
		if (amount > 999 && amount < 50001) {
			if (months > 0 && months < 61) {
				
				double a=amount*month;
				double d=month+1;
				double e=(double)d/24;
				
		//	result = (amount*months)+(((months*(months+1))/24)*0.07)*amount;	
				result = a + (amount*(month*e)*(0.07));
        	return Double.parseDouble(formatter.format(result));
			}
		}
		
		    return -1;

	

	// type your code here
	}
}