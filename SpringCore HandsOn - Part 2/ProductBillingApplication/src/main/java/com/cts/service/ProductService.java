package com.cts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.bean.Product;
import com.cts.dao.ProductDao;
import com.cts.dao.ProductDaoImpl;

@Service
public class ProductService {

	// wire dependency
	@Autowired
	ProductDaoImpl productDaoImpl;

	public Product getProductDetails(int product_code) {
		// add your code here
		Product product=productDaoImpl.getProductDetails(product_code);
		return product;
	}

	public double calculatePrice(int quantity, double product_price) {
		// add your code here
		double price = quantity * product_price;
		return price;
	}

	public boolean validateProductCode(int product_code) {
		// add your code here
		if (product_code > 999 && product_code < 10000) {
			return true;
		}else
		return false;
	}

	public boolean validateQuantity(int quantity) {
		// add your code here
		if (quantity>0) {
			return true;
		}else
		return false;
	}
}