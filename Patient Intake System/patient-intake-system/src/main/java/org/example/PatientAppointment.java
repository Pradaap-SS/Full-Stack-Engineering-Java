package org.example;

 

import java.time.LocalDateTime;

 

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

 

@Getter
@AllArgsConstructor
@ToString
public class PatientAppointment {

 

private String firstName;
private String lastName;
private Doctor doctor;
private LocalDateTime appointmentDateTime;
}