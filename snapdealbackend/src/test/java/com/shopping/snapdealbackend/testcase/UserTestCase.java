package com.shopping.snapdealbackend.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shopping.snapdealbackend.dao.UserDAO;
import com.shopping.snapdealbackend.model.User;



public class UserTestCase {

	@Autowired
	private static User user;
	
	@Autowired
	private static UserDAO userDAO;
	
	@BeforeClass
	public static void initialize()
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit");
		context.refresh();
		
		user = (User) context.getBean("user");
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
	@Test
	@Ignore
	public void getAllUsersTestCase()
	{
		int recordFromDB = userDAO.getAllUsers().size();
		
		assertEquals("getAllUsersTestCase", 5, recordFromDB);
	}
	
	@Test
	@Ignore

	public void createUserTestCase()
	{
		user.setName("piyush");
		user.setPassword("piyush");
		user.setMail("piyush@gmail.com");
		user.setContact("098765645");
		user.setEnabled(true);
		user.setRole("ROLE_USER");
		
		boolean flag = userDAO.createUser(user);
		
		assertEquals("createUserTestCase", true, flag);
	}
	
	@Test
	@Ignore

	public void updateUserTestCase()
	{
		user.setName("Akhil");
		user.setPassword("akhil");
		user.setContact("8765432467");
		user.setRole("user");
		
		boolean flag = userDAO.updateUser(user);
		
		assertEquals("updateUserTestCase", true, flag);
	}
	
	@Test
	@Ignore

	public void deleteUserTestCase()
	{
		user.setPassword("siraj");
		
		boolean flag = userDAO.deleteUser(user);
		
		assertEquals("deleteUserTestCase", true, flag);
	}
	
	@Test
	@Ignore

	public void getUserByIDTestCase()
	{
		user = userDAO.getUserByID(01);
		
		assertEquals("getUserByIDTestCase", null, user);
	}
	
	@Test
	@Ignore

	public void getUserByNameTestCase()
	{
		user = userDAO.getUserByName("Siraj");
		
		assertEquals("getUserByNameTestCase", null, user);
	}
	
	@Test
	@Ignore

	public void validateUserTestCase()
	{
		User flag = userDAO.validateUser(01, "siraj");
		
		assertEquals("validateUserTestCase", true, flag);
	}
}
