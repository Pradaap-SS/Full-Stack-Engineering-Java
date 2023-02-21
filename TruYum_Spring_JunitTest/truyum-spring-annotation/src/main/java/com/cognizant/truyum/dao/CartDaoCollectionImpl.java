package com.cognizant.truyum.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.dao.*;

@Repository
public class CartDaoCollectionImpl implements CartDao {

	
	private Map<Long, Cart> userCarts;
	
	@Autowired
	private MenuItemService menuItemService;
	
	public void setMenuItemService(MenuItemService menuItemService) {
		this.menuItemService = menuItemService;
	}

	public void setUserCarts(Map<Long, Cart> userCarts) {
		this.userCarts = userCarts;
	}

	@Override
	public void addCartItem(long userId, long menuItemId) {

		MenuItem itemFound = menuItemService.getMenuItem((long) menuItemId);

		// Check existence of user in userCarts based on userId
		if (userCarts.containsKey(userId)) {

			Cart userCartObj = userCarts.get(userId);
			List<MenuItem> menuItemList = userCartObj.getMenuItemList();
			menuItemList.add(itemFound);
			userCartObj.setMenuItemList(menuItemList);

		}

		else {

			List<MenuItem> menuItemList = new ArrayList<MenuItem>();
			double total = 0;
			menuItemList.add(itemFound);

			Cart cartObj = new Cart(menuItemList, total);
			userCarts.put(userId, cartObj);
		}
	}

	@Override
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {

		// Get the menuItemList based on userId from the HashMap of userCarts
		Cart cartObj = userCarts.get(userId);
		List<MenuItem> menuItemList = cartObj.getMenuItemList();

		// If the returned list is empty
		if (menuItemList.contains(null)) {
			// Create new CartEmptyException and throw it
			throw new CartEmptyException("CartEmptyException: The cart is Empty!");
		} else {
			// If the returned list is not empty
			// Iterate through the menuItemList and add up the prices.
			long total = 0;

			for (MenuItem m : menuItemList) {
				total += m.getItemPrice();
			}

			// Set the total instance variable of cart with the added up menu item prices.
			cartObj.setTotal(total);
		}

		return menuItemList;

	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {

		// Get the List<MenuItem> from userCarts based on userId
		Cart cartObj = userCarts.get(userId);
		List<MenuItem> menuItemList = cartObj.getMenuItemList();

		// Iterate through the List of MenuItem and perform the below steps
		for (MenuItem m : menuItemList) {
			// If menuItemId matches then remove the menu item from the list

			if (menuItemId == m.getItemId()) {
				menuItemList.remove(menuItemList.indexOf(m));
				cartObj.setMenuItemList(menuItemList);
				break;
			}

		}

	}

	

}
