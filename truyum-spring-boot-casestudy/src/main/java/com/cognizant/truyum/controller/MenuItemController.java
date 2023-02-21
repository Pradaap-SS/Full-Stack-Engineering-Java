package com.cognizant.truyum.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;
import com.cognizant.truyum.validator.CustomUpdateValidation;

@Controller
@SessionAttributes("user")
public class MenuItemController {

	private MenuItemService menuItemService = new MenuItemService();
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);
	private CustomUpdateValidation validation = new CustomUpdateValidation();

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@GetMapping("/show-menu-list-admin")
	public String showMenuItemListAdmin(ModelMap map) {

		LOGGER.info("Start");
		map.put("menuItemList", menuItemService.getMenuItemListAdmin());
		LOGGER.info("End");
		return "menu-item-list-admin";

	}

	@GetMapping("/show-edit-menu-item")
	public String showEditMenuItem(@RequestParam long itemId, ModelMap map) {
		LOGGER.info("Start");
		MenuItem item = menuItemService.getMenuItem(itemId);
		map.put("item", item);
		LOGGER.info("End");
		return "edit-menu-item";

	}

	@PostMapping("/edit-menu-item")
	public String EditMenuItem(@ModelAttribute("item") MenuItem item, ModelMap map, BindingResult result) {
		validation.validate(item, result);
		if (result.hasErrors()) {
			return "edit-menu-item";
		}
		menuItemService.modifyMenuItem(item);
		return "edit-menu-item-status";

	}

	@ModelAttribute("categoryList")
	public List<String> populateDropDown() {
		return menuItemService.CategoryList;
	}

	@GetMapping("/show-menu-list-customer")
	public String showMenuItemListCustomer(ModelMap map, @RequestParam(defaultValue = "") String msg) {

		LOGGER.info("Start");
		map.put("menuItemListCustomer", menuItemService.getMenuItemCustomer());
		LOGGER.info("End");
		map.put("message", msg);
		return "menu-item-list-customer";

	}

}
