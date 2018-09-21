package com.shopping.snapdealbackend;

import static org.junit.Assert.*;

import java.util.List;


import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shopping.snapdealbackend.dao.CategoryDao;
import com.shopping.snapdealbackend.dao.ProductDao;
import com.shopping.snapdealbackend.dto.Category;
import com.shopping.snapdealbackend.dto.Product;
import com.shopping.snapdealbackend.dto.Supplier;



public class ProductTestCase {

	static CategoryDao categoryObj;
	static ProductDao proObj;
	
	@BeforeClass
	public static void init(){
		
		AnnotationConfigApplicationContext app=new AnnotationConfigApplicationContext();
		app.scan("com.shopping.snapdealbackend");
		app.refresh();
		categoryObj=app.getBean("categoryDao",CategoryDao.class);
		proObj=app.getBean("productDao",ProductDao.class);
	}
	
	@Test
	@Ignore
	public void addProduct(){
		System.out.println("ADD PRODUCT---------------------");
		
		Product pro=new Product();
		pro.setProductName("Iphonex");
		pro.setDescription("Amazing phone");
		pro.setPrice(98000);
		pro.setQuantity(5000);
		

		Product pro1=new Product();
		pro1.setProductName("Samsung9");
		pro1.setDescription("Dual sim smart phone");
		pro1.setPrice(70000);
		pro1.setQuantity(5000);
		

		Product pro2=new Product();
		pro2.setProductName("Shoes");
		pro2.setDescription("Addidas sports hoes");
		pro2.setPrice(850);
		pro2.setQuantity(100);
		
		Category cat=new Category();
		cat.setCategoryName("Shoes");
		/*cat.setCategoryDesc("All brands shoes available");
*/		
		Supplier s=new Supplier();
		s.setSupplierName("Sanjay Shoes co.");
		/*s.setSupplierAddress("Saraswati vihar");*/
		
		s.getProducts().add(pro);
		s.getProducts().add(pro1);
		s.getProducts().add(pro2);
		
		cat.getProducts().add(pro);
		cat.getProducts().add(pro1);
		cat.getProducts().add(pro2);
		
		
		pro.setCategory(cat);
		pro1.setCategory(cat);
		pro2.setCategory(cat);
		
		pro.setSupplier(s);
		pro1.setSupplier(s);
		pro2.setSupplier(s);
		
		
		
		assertTrue("Category Added Succesfully",categoryObj.insertCategory(cat));
		
		
	}
	
	@Test
	@Ignore
	public void updateProductbyId(){
		 
		Product pro3=proObj. getProductById(1);
		
		pro3.setProductName("Television");
		pro3.setDescription("Electronics");
		pro3.setPrice(15000);
		pro3.setQuantity(1500);
		
		Category cat=new Category();
		cat.setCategoryName("Electronics");
		/*cat.setCategoryDesc("HomeAppliances");*/
		
		Supplier supp=new Supplier();
		supp.setSupplierName("Manu Electronics");
		/*supp.setSupplierAddress("Rohini");*/
		
		supp.getProducts().add(pro3);
		
		cat.getProducts().add(pro3);
		
		pro3.setCategory(cat);
		pro3.setSupplier(supp);
		
		assertTrue("Product Updated Succesfully",proObj.updateProduct(pro3));
		
		}
	
		/*@Test
		@Ignore
		public void deleteProductById(){
			
			Product product=proObj.getProduct(3);
			 
			assertEquals("Product Deleted Sucessfully", proObj.deleteProduct(productId););
			
			
		}
	*/
		/*@Test
		public void getProductsById(){
			
		
		 List<Product> pro=proObj.getProducts();
				assertTrue(product, proObj.getProducts());
					
				}*/
			

	
	
		
	}
	

