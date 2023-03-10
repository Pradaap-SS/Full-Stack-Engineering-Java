package com.cognizant.truyum.dao;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.cognizant.truyum.model.*;
@Repository
public interface MenuItemDao {
	
	List<MenuItem> getMenuItemListAdmin();
	List<MenuItem> getMenuItemListCustomer(); 
	void modifyMenuItem(MenuItem menuItem);
	MenuItem getMenuItem(long menuItemId);

}
