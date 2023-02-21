package com.validate;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.stereotype.Component;
import com.model.RegistrationBean;
@Component
public class CustomValidator implements Validator{

	
	public void validate(Object arg0, Errors arg1) {
		
		RegistrationBean bean = (RegistrationBean) arg0;
		
// 		User Name cannot be blank
		if (bean.getUserName() == "" || bean.getUserName() == null) {
			arg1.rejectValue("userName", null, "User Name cannot be blank");
		}
		if (String.valueOf(bean.getContactNumber()).length() != 10) {
			arg1.rejectValue("contactNumber", null,
					"Contact Number should be of 10 Digits/ Contact Number should not be blank");
		}
        // Email ID cannot be blank
		if (bean.getEmailId()=="" || bean.getEmailId()==null) {
			arg1.rejectValue("emailId", null, "Email ID cannot be blank");

		}
		if (bean.getConfirmEmailId()=="" || bean.getConfirmEmailId()==null) {
			arg1.rejectValue("confirmEmailId", null, "Confirm Email ID cannot be blank");

		}
        if (!bean.getEmailId().matches("[a-zA-Z0-9]+@[a-z]+.com")) {
			arg1.rejectValue("emailId", null, "Should be a proper email ID format");
		}
		if (!bean.getConfirmEmailId().matches("[a-zA-Z0-9]+@[a-z]+.com")) {
			arg1.rejectValue("confirmEmailId", null, "Should be a proper email ID format");
		}
		else if (!bean.getEmailId().equals(bean.getConfirmEmailId())) {
			arg1.rejectValue("emailId", null, "");
			arg1.rejectValue("confirmEmailId", null, "Email and Confirm Email should be same");

		}

//		status should be checked by the user
		if (bean.isStatus() == false)
			arg1.rejectValue("status", null, "please agree to the terms and conditions");

	
	}	 	  	    	    	     	      	 	

	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return RegistrationBean.class.equals(arg0);
	}
	

}
