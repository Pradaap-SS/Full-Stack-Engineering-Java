package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

@Repository
public class MenuItemDaoCollectionImpl implements MenuItemDao {

	@Autowired
	private List<MenuItem> menuItemList;
	
	
	public void setMenuItemList(List<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

//	public MenuItemDaoCollectionImpl() {
//      
//		if(menuItemList.isEmpty()||this.menuItemList == null) {
//
//			// instantiate list
//			this.setMenuItemList(new ArrayList<MenuItem>());
//
//			// create multiple instances and add them to list
//			// MenuItem obj = new MenuItem();
//			// menuListItem.add(obj);
//			
//			
//			MenuItem mObj1 = new MenuItem(1,
//					"Sandwich",
//					99.0f ,
//					true,
//					DateUtil.convertToDate("12/04/2020"),
//					"Main Course",
//					true);
//			
//			menuItemList.add(mObj1);
//      }
//		
//	      
//	}

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		return this.menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {

		// Initialize an ArrayList for type MenuItem
		List<MenuItem> menuItemListAvailable = new ArrayList<MenuItem>();

		// Iterate through menuItemList and perform the following steps:
		for (MenuItem m : menuItemList) {

			Date today = new Date();

			// Is the launch date of the menu item is today or before today?
			if (m.getDateOfLaunch().before(today) || m.getDateOfLaunch().equals(today)) {

				// Is the menu item available is active?
				if (m.getItemActive() == true) {

					// If the above conditions satisfy, add the menu item into the ArrayList created
					// in the first step.
					menuItemListAvailable.add(m);
				}
			}
		}
		return menuItemListAvailable;

	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		// Iterate through the menuItemList and find the matching menu item
		for (MenuItem m : menuItemList) {
			// Update the matching menuItem in the ArrayList
			if (m.getItemId() == menuItem.getItemId()) {
				m.setItemName(menuItem.getItemName());
				m.setItemPrice(menuItem.getItemPrice());
				m.setItemActive(menuItem.getItemActive());
				m.setDateOfLaunch(menuItem.getDateOfLaunch());
				m.setFreeDelivery(menuItem.getFreeDelivery());
			}

		}
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {

		// Iterate through menuItemList and find the matching menu item
		for (MenuItem m : menuItemList) {
			if (m.getItemId() == menuItemId) {
				return m;
			}

		}
		return null;
	}

}
