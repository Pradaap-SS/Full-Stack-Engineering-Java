package com.spring.app;

import java.security.KeyStore.Entry;
import java.util.Map;

import javax.swing.text.html.parser.Entity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CurrencyConverter {

	private Map<String, String> mObj;

	// Getters and Setters
	public Map<String, String> getMObj() {
		return mObj;
	}

	public void setMObj(Map<String, String> mObj) {
		this.mObj = mObj;
	}

	public int getTotalCurrencyValue(String value) {
		int n=0;
		int total=0;
		/*for (int i = 0; i < value.length(); i++) {
			if(Character.isDigit(value.charAt(i)))
				n+=Character.getNumericValue(value.charAt(i));
		}*/
		String str=value;
		String no=str.replaceAll("[^0-9]", "");
		n+=Integer.parseInt(no);
		for (Map.Entry<String,String> e:mObj.entrySet()) {
			if(value.toUpperCase().contains(e.getKey()))
				total+=n*Integer.parseInt(e.getValue());
		}
		
		
		return total;

	}

}