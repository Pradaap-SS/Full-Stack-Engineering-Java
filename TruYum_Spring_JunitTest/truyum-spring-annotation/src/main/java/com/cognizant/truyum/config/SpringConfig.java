package com.cognizant.truyum.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartDaoCollectionImpl;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

@Configuration
@ComponentScan(basePackages = "com.cognizant.truyum")
public class SpringConfig {
	
	
    private Date dateFormatter(String date) {
        try {
			return new SimpleDateFormat("dd-MM-yyyy").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
    }
	
	@Bean
	public MenuItem sandwich() {
		
		MenuItem sandwich = new MenuItem();
		sandwich.setItemId(1);
		sandwich.setItemName("Sandwich");
		sandwich.setItemPrice(99.00);
		sandwich.setItemActive(true);
		sandwich.setCategory("Main Course");
		sandwich.setDateOfLaunch(dateFormatter("15-03-2017"));
		sandwich.setFreeDelivery(true);
		return sandwich;
		
	}
	
	@Bean
	public MenuItem burger() {
		
		MenuItem burger = new MenuItem();
		burger.setItemId(2);
		burger.setItemName("Burger");
		burger.setItemPrice(129.00);
		burger.setItemActive(true);
		burger.setCategory("Main Course");
		burger.setDateOfLaunch(dateFormatter("21-08-2018"));
		burger.setFreeDelivery(false);
		return burger;
		
	}
	
	@Bean
	public MenuItem pizza() {
		
		MenuItem pizza = new MenuItem();
		pizza.setItemId(3);
		pizza.setItemName("Pizza");
		pizza.setItemPrice(149.00);
		pizza.setItemActive(true);
		pizza.setCategory("Main Course");
		pizza.setDateOfLaunch(dateFormatter("21-08-2017"));
		pizza.setFreeDelivery(false);
		return pizza;
		
	}
	
	@Bean
	public MenuItem fries() {
		
		MenuItem fries = new MenuItem();
		fries.setItemId(4);
		fries.setItemName("French Fries");
		fries.setItemPrice(57.00);
		fries.setItemActive(false);
		fries.setCategory("Starters");
		fries.setDateOfLaunch(dateFormatter("02-07-2017"));
		fries.setFreeDelivery(true);
		return fries;
		
	}
	
	@Bean
	public MenuItem brownie() {
		
		MenuItem brownie = new MenuItem();
		brownie.setItemId(5);
		brownie.setItemName("Chocolate Brownie");
		brownie.setItemPrice(32.00);
		brownie.setItemActive(true);
		brownie.setCategory("Dessert");
		brownie.setDateOfLaunch(dateFormatter("02-11-2022"));
		brownie.setFreeDelivery(true);
		return brownie;
		
	}
	
	@Bean
	public List<MenuItem> menuItems() {
		
		List<MenuItem> menuItems = new ArrayList<MenuItem>();
		menuItems.add(sandwich());
		menuItems.add(burger());
		menuItems.add(pizza());
		menuItems.add(fries());
		menuItems.add(brownie());
		return menuItems;
	}
	
	@Bean
	public List<MenuItem> userCartMenuList() {
		
		List<MenuItem> userCartMenuList = new ArrayList<MenuItem>();
		userCartMenuList.add(sandwich());
		return userCartMenuList;
	}
	
	@Bean
	public Cart cart() {
		return new Cart(userCartMenuList(),99.00);
	}
	
	@Bean
	public Map<Long,Cart> userCarts() {
		
		Map<Long, Cart> userCarts = new HashMap<Long, Cart>();
		userCarts.put((long) 1,cart());
		return userCarts;
	}
	
	@Bean
	public CartDaoCollectionImpl cartDao() {
		CartDaoCollectionImpl cartDao = new CartDaoCollectionImpl();
		cartDao.setUserCarts(userCarts());
		return cartDao;
	}

}
