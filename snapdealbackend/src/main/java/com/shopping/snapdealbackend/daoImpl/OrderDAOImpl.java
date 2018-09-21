package com.shopping.snapdealbackend.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.snapdealbackend.dao.OrderDAO;
import com.shopping.snapdealbackend.dto.Order;



@Repository("orderDao")
@Transactional
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	public int makeOrder(Order order) {
		return 0;
		//return (int) getSession().save(order);
		
	}

}
