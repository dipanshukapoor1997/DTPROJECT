package com.shopping.snapdealbackend.Config;



import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.shopping.snapdealbackend.dao.CartDAO;
import com.shopping.snapdealbackend.dao.CategoryDAO;
import com.shopping.snapdealbackend.dao.CheckoutDAO;
import com.shopping.snapdealbackend.dao.ProductDAO;
import com.shopping.snapdealbackend.dao.SupplierDAO;
import com.shopping.snapdealbackend.dao.UserDAO;
import com.shopping.snapdealbackend.daoImpl.CartDAOImpl;
import com.shopping.snapdealbackend.daoImpl.CategoryDAOImpl;
import com.shopping.snapdealbackend.daoImpl.CheckoutDAOImpl;
import com.shopping.snapdealbackend.daoImpl.ProductDAOImpl;
import com.shopping.snapdealbackend.daoImpl.SupplierDAOImpl;
import com.shopping.snapdealbackend.daoImpl.UserDAOImpl;
import com.shopping.snapdealbackend.model.Cart;
import com.shopping.snapdealbackend.model.Category;
import com.shopping.snapdealbackend.model.Checkout;
import com.shopping.snapdealbackend.model.Product;
import com.shopping.snapdealbackend.model.Supplier;
import com.shopping.snapdealbackend.model.User;


  
@Configuration
@ComponentScan("com.niit.fairdeal")
@EnableTransactionManagement
public class Applicationcontext {
	
	@Bean(name = "dataSource")
	public DataSource getH2DataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");

		dataSource.setDriverClassName("org.h2.Driver");

		dataSource.setUsername("sa");
		dataSource.setPassword("");

		
		return dataSource;
	}

	private Properties getHibernateProperties() {
		
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		
		return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		
		sessionBuilder.addProperties(getHibernateProperties());

		sessionBuilder.addAnnotatedClasses(Category.class);
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(Cart.class);
		sessionBuilder.addAnnotatedClass(Checkout.class);
		
		//Alternate to above steps, you can add all the domain objects using the following stmts
		//sessionBuilder.scanPackages("com.niit.fairdeal.domain");

		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager") 
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
	
	@Autowired
	@Bean(name = "productDAO")
	public ProductDAO getProductDao(SessionFactory sessionFactory) {
			return new ProductDAOImpl(sessionFactory);		
	}
	
	@Autowired
	@Bean(name = "supplierDAO")
	public SupplierDAO getSupplierDao(SessionFactory sessionFactory) {
			return new SupplierDAOImpl(sessionFactory);
	}

	@Autowired
	@Bean(name = "categoryDAO")
	public CategoryDAO getCategoryDao(SessionFactory sessionFactory){
		return  new CategoryDAOImpl(sessionFactory);
	} 
	
	@Autowired
	@Bean(name = "userDAO")
	public UserDAO getUserDao(SessionFactory sessionFactory){
		return  new UserDAOImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name = "cartDAO")
	public CartDAO getCartDao(SessionFactory sessionFactory){
		return  new CartDAOImpl(sessionFactory);
	}	
	
	@Autowired
	@Bean(name = "checkoutDAO")
	public CheckoutDAO getCheckoutDao(SessionFactory sessionFactory){
		return new CheckoutDAOImpl(sessionFactory);
	}
}


