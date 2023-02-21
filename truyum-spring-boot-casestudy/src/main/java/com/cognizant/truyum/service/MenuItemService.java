package com.cognizant.truyum.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.truyum.controller.MenuItemController;
import com.cognizant.truyum.dao.MenuItemDaoSqlImpl;
import com.cognizant.truyum.model.MenuItem;

@Service
public class MenuItemService {

	
	private MenuItemDaoSqlImpl menuItemDao = new MenuItemDaoSqlImpl();
	
	public static List<String> CategoryList = Arrays.asList("Main Course", "Starters", "Dessert");
	
	public boolean validateAdmin(String username, String password) {
		if (username.equals("admin") && password.equals("password")) {
			return true;
		}

		return false;
	}

	public List<MenuItem> getMenuItemListAdmin() {
//		List<MenuItem> list = Arrays.asList( new MenuItem(1, "Sandwich", 99.00, false, new Date(), "Main Course", true),
//				 new MenuItem(2, "Burger", 50.00, true, new Date(), "Main Course", false)
//				);
		
		return menuItemDao.getMenuItemListAdmin();
	}

	public MenuItem getMenuItem(long itemId) {
		return menuItemDao.getMenuItem(itemId);
	}
	
	public void  modifyMenuItem(MenuItem item) {
		menuItemDao.modifyMenuItem(item);
	}
	
	public List<MenuItem> getMenuItemCustomer() {
		return menuItemDao.getMenuItemListCustomer();
	}
	
}
