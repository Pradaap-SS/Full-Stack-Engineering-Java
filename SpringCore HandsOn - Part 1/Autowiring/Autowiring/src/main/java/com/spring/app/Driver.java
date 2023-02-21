package com.spring.app;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Driver {
public static void main(String[] args)
{
	ApplicationContext ctx=new AnnotationConfigApplicationContext(ApplicationConfig.class);
	
	Employee emp=ctx.getBean("emp",Employee.class);
	System.out.println(emp);
}
	
}

