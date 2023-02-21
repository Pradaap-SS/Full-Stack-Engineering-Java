package com.cts.patient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

import com.cts.patient.model.Patient;
import com.cts.patient.service.PatientService;

//fill the code
@Configuration
@PropertySource("patient_details.properties")
public class AppConfig {

	//fill the code
	@Bean
	public Patient patient() {
	    return new Patient();
	}
	@Bean
	public PatientService patientService() {
	    //Patient patient = new Patient();
	    PatientService patientService = new PatientService();
	    patientService.setPatient(patient());
	    return new PatientService();
	}
}
