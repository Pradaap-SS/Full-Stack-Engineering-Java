package com.cts.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cts.bean.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	//wire dependency
	@Autowired
	JdbcTemplate jdbcTemplte;

	@Override
	public Product getProductDetails(int product_code) {
		//add your code here
		Product product=(Product) jdbcTemplte.queryForObject("select * from product where product_code=?",new Object[] {product_code},new BeanPropertyRowMapper(Product.class));
	return product;
	}

}