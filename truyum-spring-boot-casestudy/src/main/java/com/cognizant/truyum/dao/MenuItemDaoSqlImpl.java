package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.MenuItem;

@Component
public class MenuItemDaoSqlImpl implements MenuItemDao {

	public MenuItem getMenuItem(long menuItemId) {
		System.out.println("\nRunning getMenuItem :");
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from menu_table where item_id=?";
		MenuItem menuItemObj = null;

		try {
			conn = ConnectionHandler.getConnection();
			;
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, menuItemId);

			ResultSet rs = pstmt.executeQuery();

			// rs.absolute(1);
			if (rs.next()) {
				long itemId = rs.getLong(1);
				String itemName = rs.getString(2);
				double itemPrice = rs.getDouble(3);
				boolean itemActive = false;
				if (rs.getString(4).equalsIgnoreCase("Yes")) {
					itemActive = true;
				}

				Date dateOfLaunch = rs.getDate(5);
				String Category = rs.getString(6);
				;
				boolean freeDelivery = false;
				if (rs.getString(7).equalsIgnoreCase("Yes")) {
					freeDelivery = true;
				}

				menuItemObj = new MenuItem(itemId, itemName, itemPrice, itemActive, dateOfLaunch, Category,
						freeDelivery);
				System.out.println("First row :" + itemId + " " + itemName + " " + itemPrice + " " + itemActive + " "
						+ dateOfLaunch + " " + Category + " " + freeDelivery);
			}

			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return menuItemObj;

	}

	public List<MenuItem> getMenuItemListAdmin() {
		System.out.println("\nRunning getMenuItemListAdmin :");
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from menu_table";
		List<MenuItem> menuItemList = new ArrayList<MenuItem>();

		long menuId = 1;

		try {
			conn = ConnectionHandler.getConnection();
			
			pstmt = conn.prepareStatement(sql);

			

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				long itemId = rs.getLong(1);
				String itemName = rs.getString(2);
				double itemPrice = rs.getDouble(3);
				boolean itemActive = false;
				if (rs.getString(4).equalsIgnoreCase("Yes")) {
					itemActive = true;
				}

				Date dateOfLaunch = rs.getDate(5);
				String Category = rs.getString(6);
				;
				boolean freeDelivery = false;
				if (rs.getString(7).equalsIgnoreCase("Yes")) {
					freeDelivery = true;
				}

				MenuItem mObj = new MenuItem(itemId, itemName, itemPrice, itemActive, dateOfLaunch, Category,
						freeDelivery);

				System.out.println(itemId + " " + itemName + " " + itemPrice + " " + itemActive + " " + dateOfLaunch
						+ " " + Category + " " + freeDelivery);

				menuItemList.add(mObj);
			}

			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 4. Return the menuItem created in the previous step

		return menuItemList;

	}

	public List<MenuItem> getMenuItemListCustomer() {

		System.out.println("\nRunning getMenuItemListCustomer :");

		// Get connection using ConnectionHandler
		Connection conn = null;
		PreparedStatement pstmt = null;

		// 2. Initialize an ArrayList of MenuItem
		List<MenuItem> menuItemList = new ArrayList<MenuItem>();

		// 3. Using PreparedStatement execute the select query that retrieves the
		// records from menu_item table applying the following filters:
		// a. The menu item is active and
		// b. The menu item is past the launch date

		String sql = "select * from menu_table where date_of_launch<=? and item_active=?";

		String isItemActive = "Yes";

		try {

			conn = ConnectionHandler.getConnection();
			;
			pstmt = conn.prepareStatement(sql);

			pstmt.setDate(1, java.sql.Date.valueOf(java.time.LocalDate.now()));
			// Date d = new Date();
			// pstmt.setDate(1, (java.sql.Date)d);
			pstmt.setString(2, isItemActive);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				long itemId = rs.getLong(1);
				String itemName = rs.getString(2);
				double itemPrice = rs.getDouble(3);
				boolean itemActive = false;
				if (rs.getString(4).equalsIgnoreCase("Yes")) {
					itemActive = true;
				}

				Date dateOfLaunch = rs.getDate(5);
				String Category = rs.getString(6);
				;
				boolean freeDelivery = false;
				if (rs.getString(7).equalsIgnoreCase("Yes")) {
					freeDelivery = true;
				}

				System.out.println(itemId + " " + itemName + " " + itemPrice + " " + itemActive + " " + dateOfLaunch
						+ " " + Category + " " + freeDelivery);

				MenuItem mObj = new MenuItem(itemId, itemName, itemPrice, itemActive, dateOfLaunch, Category,
						freeDelivery);
				menuItemList.add(mObj);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// 4. Iterate through the ResultSet
		// 5. For each item in the ResultSet create a new MenuItem instance and add it
		// to the
		// ArrayList created in the step 2 and return the ArrayList

		return menuItemList;

	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {

		// Get connection using ConnectionHandler

		System.out.println("Running editMenuItem");
		Connection conn = null;
		PreparedStatement pstmt = null;

		// 2. Execute update statement using PreparedStatement that modifies the values
		// of
		String sql = "update menu_table " + "set item_name=?, " + "item_price=?, " + "item_active=?, "
				+ "date_of_launch=?, " + "category=?, " + "free_delivery=? " + "where item_id=?";

		try {
			conn = ConnectionHandler.getConnection();
			;
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, menuItem.getItemName());
			pstmt.setDouble(2, menuItem.getItemPrice());
			String active = "Yes";
			if (menuItem.getItemActive() == false) {
				active = "No";
			}
			pstmt.setString(3, active);
			// new java.sql.Date(menuItem.getDateOfLaunch().getTime())
			// (java.sql.Date) menuItem.getDateOfLaunch()
			pstmt.setDate(4, new java.sql.Date(menuItem.getDateOfLaunch().getTime()));
			pstmt.setString(5, menuItem.getCategory());
			String free = "Yes";
			if (menuItem.getFreeDelivery() == false) {
				free = "No";
			}
			pstmt.setString(6, free);
			pstmt.setLong(7, menuItem.getItemId());

			int rowAffected = pstmt.executeUpdate();
			System.out.println(rowAffected + " records Affected");

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		// menuItem table based on menuItemId.

		// 3. Set the parameters of the PreparedStatement and execute the statement.

	}

	public void addCartItem(long userId, long menuItemId) {
		// Get connection using ConnectionHandler

		// Execute insert statement using PreparedStatement for inserting data into cart
		// table with userId and menuItemId.
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into cart values=(?,?,?) ";
		long cartId = 0;
		try {
			conn = ConnectionHandler.getConnection();
			;
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, cartId);
			pstmt.setLong(2, menuItemId);
			pstmt.setLong(3, userId);
			int rowAffected = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}