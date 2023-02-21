package com.cognizant.truyum.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cognizant.truyum.model.MenuItem;

public class CustomUpdateValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return MenuItem.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		MenuItem bean = (MenuItem) target;
		

		if (bean.getItemName() == "" || bean.getItemName() == null) {
			errors.rejectValue("itemName", null, "Item Name cannot be blank");
		}
		if (bean.getItemPrice()<=0 || String.valueOf(bean.getItemPrice())==null) {
			errors.rejectValue("itemPrice", null,
					"Item Price should be greater than 0");
		}
		if (bean.getDateOfLaunch()==null) {
			errors.rejectValue("dateOfLaunch", null, "Launch Date cannot be blank");

		}
       

//		status should be checked by the user
		
	}

}
