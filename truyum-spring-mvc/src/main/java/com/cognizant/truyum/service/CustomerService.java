package com.cognizant.truyum.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.CartDaoSqlImpl;
import com.cognizant.truyum.model.MenuItem;

@Service
public class CustomerService {

	public static Map<String, Long> userDetails = new HashMap<>();
	private CartDaoSqlImpl dao = new CartDaoSqlImpl();

	static {
		userDetails.put("user", 1l);
		userDetails.put("user2", 2l);
	}

	public boolean validateUser(String username, String password) {
		if (username.equals("user") && password.equals("password")) {
			return true;
		}
		if (username.equals("user2") && password.equals("password2")) {
			return true;
		}

		return false;
	}

	public List<MenuItem> getMenuItem(long userId) {
		return dao.getAllCartItems(userId);
	}

	public void addToCart(long userId, long menuItemId) {
		dao.addCartItem(userId, menuItemId);
	}

	public void removeCartItem(long userId, long menuItemId) {
		dao.removeCartItem(userId, menuItemId);
	}

}
