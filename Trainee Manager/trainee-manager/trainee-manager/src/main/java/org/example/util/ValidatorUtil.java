package org.example.util;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.example.exeptions.InvalidTraineeDataException;
import org.example.model.Trainee;


public class ValidatorUtil {

	public boolean isValid(Trainee trainee) throws InvalidTraineeDataException {

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		// Validate bean
		Set<ConstraintViolation<Trainee>> constraintViolations = validator.validate(trainee);

		StringBuilder messages = new StringBuilder(); 
		// Show errors
		if (!constraintViolations.isEmpty()) {
			for (ConstraintViolation<Trainee> violation : constraintViolations) {
				messages.append(violation.getMessage());
				messages.append("\n");
			}
		} else {
			return true;
		}
		throw new InvalidTraineeDataException(messages.toString());
		
	}
}
