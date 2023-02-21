package com.cognizant.truyum.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class MenuItem {

	private long itemId;

	private String itemName;
	
	private double itemPrice;
	
	private boolean itemActive;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfLaunch;

	private String category;

	private boolean freeDelivery;
	
	
	
	public MenuItem(long itemId, String itemName, double itemPrice, boolean itemActive, Date dateOfLaunch,
			String category, boolean freeDelivery) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemActive = itemActive;
		this.dateOfLaunch = dateOfLaunch;
		this.category = category;
		this.freeDelivery = freeDelivery;
	}



	public long getItemId() {
		return itemId;
	}



	public void setItemId(long itemId) {
		this.itemId = itemId;
	}



	public String getItemName() {
		return itemName;
	}



	public void setItemName(String itemName) {
		this.itemName = itemName;
	}



	public double getItemPrice() {
		return itemPrice;
	}



	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}



	public boolean getItemActive() {
		return itemActive;
	}



	public void setItemActive(boolean itemActive) {
		this.itemActive = itemActive;
	}



	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}



	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public boolean getFreeDelivery() {
		return freeDelivery;
	}



	public void setFreeDelivery(boolean freeDelivery) {
		this.freeDelivery = freeDelivery;
	}
	
	
	
}
