package com.cognizant.truyum.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CustomerService;
import com.cognizant.truyum.service.MenuItemService;


@Controller
@SessionAttributes("user")
public class MainController {

	private MenuItemService menuItemService = new MenuItemService();
	private CustomerService customerService = new CustomerService();
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

	@GetMapping("/")
	public String index(ModelMap map) {

		return "index";
	}

	@RequestMapping(value = "/index")
	private String checkLogin(ModelMap map, @RequestParam String username, @RequestParam String password,
			@RequestParam(defaultValue = "false") String admin) {
		if (admin.equals("true") && menuItemService.validateAdmin(username, password)) {
			map.put("user",username);
			return "redirect:/show-menu-list-admin";
		}
		if (admin.equals("false") && customerService.validateUser(username, password)) {
			map.put("user",username);
			
			return "redirect:/show-menu-list-customer";
		}
		map.put("invalidMsg", "Invalid Credentials");
		return "index";
	}

	@GetMapping("/logout")
	public String logout(ModelMap map) {
		map.put("user", "");
		return "redirect:/";
	}
		
	
	

}
