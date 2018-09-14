package com.shopping.snapdealbackend.testcase;

import org.junit.BeforeClass;
import org.junit.Ignore;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shopping.snapdealbackend.dao.CartDAO;
import com.shopping.snapdealbackend.model.Cart;



public class CartTestCase 
{
	@Autowired
	private static CartDAO cartDAO;

	@Autowired
	private static Cart cart;

	@BeforeClass
	public static void initialize() 
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		cart = (Cart) context.getBean("cart");
		cartDAO = (CartDAO) context.getBean("cartDAO");

	}
	
	
	@Test
	@Ignore

	public void saveCartTestCase()
	{
		cart.setPrice(20000L);
		cart.setProductid(68);
		cart.setProductname("samsung galaxy s8 edge");
		cart.setQuantity(2);
		cart.setStatus("P");
		cart.setUserid(13);
		
		boolean flag = cartDAO.save(cart);
		assertEquals("saveCartTestCase", true, flag);
	}
	
	@Test
	@Ignore

	public void deleteCartTestCase()
	{
		cart.setId(5);
		boolean flag = cartDAO.delete(cart);
		assertEquals("deleteCartTestCase", true, flag);
	}
}
