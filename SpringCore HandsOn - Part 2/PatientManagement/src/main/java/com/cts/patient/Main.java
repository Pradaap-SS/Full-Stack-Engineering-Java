package com.cts.patient;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.cts.patient.config.AppConfig;
import com.cts.patient.service.*;

public class Main {

	public static void main(String[] args) {
	//fill the code
	ApplicationContext con = new AnnotationConfigApplicationContext(AppConfig.class);
 		PatientService patientService = (PatientService) con.getBean("patientService");
 		
 		patientService.getPatientDetails();

	}

}
