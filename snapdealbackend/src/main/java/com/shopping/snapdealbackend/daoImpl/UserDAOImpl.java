package com.shopping.snapdealbackend.daoimpl;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.snapdealbackend.dao.UserDao;
import com.shopping.snapdealbackend.dto.User;


@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public boolean registerUser(User user) {
		try {
		 getSession().save(user);
		return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public User getUserById(String id) {
		System.out.println("In  User DAO impl : "+id);
		User user=(User)getSession().get(User.class, id);
		return user;
	}

}
