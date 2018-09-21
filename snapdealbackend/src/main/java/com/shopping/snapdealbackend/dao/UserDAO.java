package com.shopping.snapdealbackend.dao;

import java.util.List;

import com.shopping.snapdealbackend.dto.User;




public interface UserDao {
	
	boolean registerUser(User product);
	User getUserById(String id);
	
}

