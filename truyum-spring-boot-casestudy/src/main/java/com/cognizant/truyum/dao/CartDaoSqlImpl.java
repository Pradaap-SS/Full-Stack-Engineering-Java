package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl implements CartDao {
	
	
	
	public void removeCartItem(long userId, long menuItemId) {
		
		System.out.println("\n\nRunning removeCartItem...");
		System.out.println("userId :"+userId +" , menuItemId: "+ menuItemId);
		// Get connection using ConnectionHandler
		Connection conn=null;
		PreparedStatement pstmt = null;
		
		String sql = "Delete from cart where user_id=? and item_id=?";
		
		try{
			conn = ConnectionHandler.getConnection();;
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, userId);
			pstmt.setLong(2, menuItemId);
			
			int row = pstmt.executeUpdate();
			
			int count = 0;
			System.out.println(row+" rows Affected");
			try {
				conn = ConnectionHandler.getConnection();;
				pstmt = conn.prepareStatement("select count(*) from cart");
				
				ResultSet rs = pstmt.executeQuery();
				rs.next();
				count = rs.getInt(1);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println("Remaining no of items in cart "+count);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public  List<MenuItem> getAllCartItems(long userId) {
		
		
		System.out.println("\n\nRunning getAllCartItems...");
		System.out.println("userId :"+userId );
		// Get connection using ConnectionHandler
		
		Connection conn=null;
		PreparedStatement pstmt = null;
		
		
		// Create a new instance of Cart with new ArrayList<MenuItem> and price as 0 in Cart constructor.
		List<MenuItem> list = new ArrayList<MenuItem>();
		double price = 0;
		Cart cObj = new Cart(list, price);
		
		// Execute select statement using PreparedStatement that joins Cart and 
		// MenuItem table to retrieve the list of products filtered based on the input userId.
		String sql = "Select * from cart join menu_table on menu_table.item_id=cart.item_id where cart.user_id=?";
		
		try{
			conn = ConnectionHandler.getConnection();;
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setLong(1, userId);
			ResultSet rs = pstmt.executeQuery();
			
			// Iterate through the ResultSet
			// Execute select statement using PreparedStatement that gets sum of price after joining Cart and MenuItem filtered based on input userId.
			
			while(rs.next()){
    			
				// For each item in the ResultSet create a new Product instance and 
				// add it to the ArrayList created in the step 2 and return the ArrayList
				
				long itemId = rs.getLong("item_id");
    			String itemName = rs.getString("item_name");
    			double itemPrice = rs.getDouble("item_price");
    			boolean itemActive = false;
    			if(rs.getString("item_active").equalsIgnoreCase("Yes")) {
    				itemActive = true;
    			}
    			
    			
    			Date dateOfLaunch = rs.getDate("date_of_launch");
    			String Category = rs.getString("category");;
    			boolean freeDelivery = false;
    			if(rs.getString("free_delivery").equalsIgnoreCase("Yes")) {
    				freeDelivery = true;
    			}
    			
    			
    			MenuItem mObj = new MenuItem(itemId,itemName,itemPrice,itemActive,dateOfLaunch,Category,freeDelivery);
    		    list.add(mObj);
    		    
    		    price += itemPrice;
    		    System.out.println("\nAdded menuItem Object:"+mObj.getItemId()+" "+mObj.getItemPrice());
    		    System.out.println("updated totalprice :"+price);
    			
    		    
    		}
			
			cObj.setMenuItemList(list);
			cObj.setTotal(price);
			System.out.println("\nAdded Cart Object:"+cObj.toString());
		    System.out.println("totalprice :"+price);
			
		    
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void addCartItem(long userId, long menuItemId) {
		
		
		System.out.println("\n\nRunning addCartItem...");
		System.out.println("userId :"+userId +" , menuItemId :"+ menuItemId);
		
		Connection conn=null;
		PreparedStatement pstmt = null;
		
		
		String sql = "insert into cart (item_id,user_id) values (?,?)";
		
		try {
			conn = ConnectionHandler.getConnection();;
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, menuItemId);
			pstmt.setLong(2, userId);
			int row = pstmt.executeUpdate();
			System.out.println(row + " row affected");
			System.out.println("Inserted "+" item_id:"+menuItemId+" user_id:"+userId);
			
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
