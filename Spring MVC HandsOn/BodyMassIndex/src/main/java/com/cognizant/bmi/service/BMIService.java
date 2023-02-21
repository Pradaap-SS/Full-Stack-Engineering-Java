package com.cognizant.bmi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cognizant.bmi.bean.User;
@Service
public class BMIService{
	
	public static List<String> genderType=new ArrayList<String>();
public 	static Map<Integer,User> userList=new HashMap<>();
	private static int userId=1000;
	
	public BMIService() {
		genderType.add("Male");
		genderType.add("Female");
		genderType.add("Others");
	}

//add the code as per the requirement
	
	public User addUserDetails(User user) {
		userId = userId + 1;
		user.setUserId(userId);
		return user;
// 		return null;
	}

	
	public double calculateBMI(User user) {
		  // multiplication by 100*100 for cm to m conversion
	    double bmi = user.getWeight() / (user.getHeight() * user.getHeight()) * 10000;
		return (double)Math.ceil(bmi);
	   //  return 0.0;
	}
	
	public String getBMIStatus(double bmi) {
        String status = "";
		if (bmi < 18.5) {
			status = "underweight";
		} else if (bmi >= 18 && bmi < 25) {
			status = "normal";
		} else if (bmi >= 25 && bmi < 30) {
			status = "overweight";
		} else {
			status = "obese";
		}
		return "You are " + status;
// 		return null;
	}

}
