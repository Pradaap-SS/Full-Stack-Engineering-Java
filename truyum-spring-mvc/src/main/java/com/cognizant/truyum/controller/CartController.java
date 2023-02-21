package com.cognizant.truyum.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CustomerService;

@Controller
@SessionAttributes("user")
public class CartController {

	private CustomerService customerService = new CustomerService();

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);

	@GetMapping("/show-cart")
	public String showCart(ModelMap map) {
		String user = (String) map.get("user");// "user";
		System.out.println(user);
		long userId = customerService.userDetails.get(user);
		List<MenuItem> cartItems = customerService.getMenuItem(userId);
		if (cartItems.isEmpty()) {
			return "cartEmpty";
		}
		double price = 0.0;
		for (MenuItem item : cartItems) {
			price += item.getItemPrice();
		}
		map.put("cartItems", cartItems);
		map.put("total", price);

		return "cart";

	}

	@GetMapping("/delete-cart-item")
	public String removeCartItem(@RequestParam long itemId, ModelMap map) {
		String user = (String) map.get("user");// "user";
		long userId = customerService.userDetails.get(user);

		customerService.removeCartItem(userId, itemId);

		return "redirect:/show-cart";

	}

	@GetMapping("/add-to-cart")
	public String addToCart(@RequestParam long itemId, ModelMap map) {
		String user = (String) map.get("user"); // "user";
		long userId = customerService.userDetails.get(user);

		customerService.addToCart(userId, itemId);
//		map.put("message", "Item Added to cart successfully"); // not displayed .........
		return "redirect:/show-menu-list-customer?msg=Item Added to cart successfully";

	}

}
