package com.cognizant.truyum.service;

import java.awt.Menu;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.internal.matchers.StartsWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.mockito.Mockito.when;

import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

public class CartServiceTest {

	
	CartService cartService;
	ApplicationContext context;

	@Before
	public void initializeService() {

		//context = new ClassPathXmlApplicationContext("com/cognizant/truyum/config/spring-config.xml");
		context = new AnnotationConfigApplicationContext(com.cognizant.truyum.config.SpringConfig.class);
		cartService = context.getBean("cartService", CartService.class);

	}

	@Test
	public void testGetAllCartItems1() throws CartEmptyException {

		List<MenuItem> expectedList = new ArrayList<MenuItem>();
		expectedList.add(getExpectedListItem());

		double actualPrice = cartService.getAllCartItems(1).get(0).getItemPrice();
		double expectedPrice = expectedList.get(0).getItemPrice();
		
		Assert.assertTrue(expectedPrice == actualPrice);

	}

	// test for empty cart
	@Test
	public void testRemoveCartItem() {
		
		
		
		List<MenuItem> list = new ArrayList<MenuItem>();
		try {
			cartService.removeCartItem(1, 1);
			list = cartService.getAllCartItems(1);
		}catch(CartEmptyException e) {
			Assert.assertTrue(e.getClass().getName().equals("CartEmptyException"));
		}
		

	}

	

	@Test
	public void testAddCartItem() throws CartEmptyException {
		cartService.addCartItem(1, 1);

		List<MenuItem> expectedList = new ArrayList<MenuItem>();
		expectedList.add(getExpectedListItem());

		double actualPrice = cartService.getAllCartItems(1).get(0).getItemPrice();
		double expectedPrice = expectedList.get(0).getItemPrice();
		Assert.assertTrue(expectedPrice == actualPrice);

	}

	private MenuItem getExpectedListItem() {

		MenuItem item = new MenuItem();
		item.setItemId(1);
		item.setItemName("Sandwich");
		item.setItemPrice(99.00); 
		item.setItemActive(true);
		Date d = null;
		try {
			d = new SimpleDateFormat("dd-MM-yyyy").parse("23-12-2017");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		item.setDateOfLaunch(d);
		item.setCategory("Main Course");
		item.setFreeDelivery(true);

		return item;
	}

}
