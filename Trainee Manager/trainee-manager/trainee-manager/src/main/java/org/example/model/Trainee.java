package org.example.model;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Trainee {
	
	@NotNull
	@Min(value = 100000, message = "Employee Id should have 6 digits")
	@Max(value = 999999, message = "Employee Id should have 6 digits")
    private Integer empid;
	
	@NotNull
	@Pattern(regexp = "[A-Z]{3}[0-9]{2}[A-Z]{2}[0-9]{2}", message = "Invalid Cohort Name")
    private String cohort;
	
	@Pattern(regexp = "[A-Za-z]*", message = "Invalid Employee Firstname")
    private String firstName;
	
	@Pattern(regexp = "[A-Za-z]*", message = "Invalid Employee Lastname")
    private String lastName;
    
    @Email
    private String email;
    
	@NotNull
    private Track track;
    
	@NotNull
    private LocalDate joinDate;
}
