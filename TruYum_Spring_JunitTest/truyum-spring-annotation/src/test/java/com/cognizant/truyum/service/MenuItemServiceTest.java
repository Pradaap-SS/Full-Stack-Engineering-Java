package com.cognizant.truyum.service;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.cognizant.truyum.model.MenuItem;

public class MenuItemServiceTest {

	MenuItemService menuItemService;
	ApplicationContext context;

	@Before
	public void initializeService() {

//		context = new ClassPathXmlApplicationContext("com/cognizant/truyum/config/spring-config.xml");

		context = new AnnotationConfigApplicationContext(com.cognizant.truyum.config.SpringConfig.class);
		menuItemService = context.getBean("menuItemService", MenuItemService.class);


	}

	@Test
	public void testGetMenuItemListAdminSize() {
		List<MenuItem> listReturned = menuItemService.getMenuItemListAdmin();
		Assert.assertEquals(5, listReturned.size());

	}

	@Test
	public void testGetMenuItemListAdminContainsSandwich() {
		List<MenuItem> listReturned = menuItemService.getMenuItemListAdmin();

		// 1, "Sandwich", 99.00, true, "15-03-2017", "Main Course", true
		MenuItem expected = new MenuItem();
		expected.setItemId(1);
		expected.setItemName("Sandwich");
		expected.setItemPrice(99.00);
		expected.setItemActive(true);
		Date d = null;
		try {
			d = new SimpleDateFormat("dd-MM-yyyy").parse("15-03-2017");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		expected.setDateOfLaunch(d);
		expected.setCategory("Main Course");
		expected.setFreeDelivery(true);

		MenuItem actual = null;
		for (MenuItem m1 : listReturned) {
			if (m1.getItemName().equals("Sandwich")) {
				actual = m1;
			}
		}

		Assert.assertEquals(actual.getItemName(), expected.getItemName());
	}

	@Test
	public void testGetMenuItemListCustomerSize() {
		List<MenuItem> listReturned = menuItemService.getMenuItemListCustomer();
		Assert.assertEquals(3, listReturned.size());

	}

	@Test
	public void testGetMenuItemListCustomerNotContainsFrenchFries() {
		Assert.assertTrue(isNotContained("French Fries"));
	}

	@Test
	public void testGetMenuItemListCustomerNotContainsBrownies() {
		Assert.assertTrue(isNotContained("Chocolate Brownie"));
	}

	private boolean isNotContained(String itemName) {
		List<MenuItem> listReturned = menuItemService.getMenuItemListCustomer();
		Boolean notContained = true;
		for (MenuItem mObj : listReturned) {
//			System.out.println(mObj.getItemName() +" "+ mObj.getDateOfLaunch()+" "+mObj.getItemActive());
			if (mObj.getItemName().equals(itemName)) {
				notContained = false;
			}
		}
		
		return notContained;
	}
	
	@Test
	public void testGetMenuItem() {
		MenuItem menuItem = menuItemService.getMenuItem(1);
		Assert.assertEquals("Sandwich", menuItem.getItemName());
	}
	
	@Test
	public void testModifyMenuItem() {
		
		MenuItem expected = new MenuItem();
		expected.setItemId(1);
		expected.setItemName("Sandwich");
		expected.setItemPrice(100.00); //new value
		expected.setItemActive(true);
		Date d = null;
		try {
			d = new SimpleDateFormat("dd-MM-yyyy").parse("15-03-2017");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		expected.setDateOfLaunch(d);
		expected.setCategory("Main Course");
		expected.setFreeDelivery(true);
		
		menuItemService.editMenuItem(expected);
		MenuItem actual = menuItemService.getMenuItem(1);
		
		Assert.assertEquals(expected.getItemPrice(), actual.getItemPrice(), 0.0001);
		
	}
	
	

}
