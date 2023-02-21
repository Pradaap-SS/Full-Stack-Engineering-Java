package com.spring.app;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {
	
public static void main(String[] args)
{
	Scanner sc=new Scanner(System.in);
	ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
	CurrencyConverter c=(CurrencyConverter)ctx.getBean("currencyConverter");
	String str=sc.nextLine();
	int t=c.getTotalCurrencyValue(str);
	System.out.println(t);
	

	
}

}