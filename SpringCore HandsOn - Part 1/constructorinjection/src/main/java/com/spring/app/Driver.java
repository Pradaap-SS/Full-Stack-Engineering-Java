package com.spring.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Driver {
	
public static void main(String[] args)
{
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	MemberShip memberShipObj = (MemberShip)context.getBean("memberShipObj");
	System.out.println(memberShipObj.getMembershipId());
}

}
