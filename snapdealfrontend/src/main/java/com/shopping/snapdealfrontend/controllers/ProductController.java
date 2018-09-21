package com.shopping.snapdealfrontend.controllers;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.shopping.snapdealbackend.dao.CategoryDao;
import com.shopping.snapdealbackend.dao.ProductDao;
import com.shopping.snapdealbackend.dao.SupplierDao;
import com.shopping.snapdealbackend.dto.Category;
import com.shopping.snapdealbackend.dto.Product;
import com.shopping.snapdealbackend.dto.Supplier;



@Controller
public class ProductController {

	@Autowired
	CategoryDao categoryDaoObj;
	
	@Autowired
	SupplierDao supplierDaoObj;
	
	@Autowired
	ProductDao productDaoObj;
	
	@RequestMapping(value="admin",method=RequestMethod.GET)
	public String getAdminHomePage(){
		System.out.println("I m get Admin Home Page");
		return "admin";
	}
	
	@RequestMapping(value="addProductForm",method=RequestMethod.GET)
	public String getAddProductForm(ModelMap map){
		
		
		
		List<Category> categories=categoryDaoObj.listCategories();
		List<Supplier> suppliers=supplierDaoObj.listSuppliers();
		
		map.addAttribute("categoryList",categories);
		map.addAttribute("supplierList",suppliers);
		map.addAttribute("productObj", new Product());
		return "AddProductForm";
	}
	
	
	@RequestMapping(value="/admin/addProduct",method=RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") Product product,
			ModelMap map,HttpSession session){
					System.out.println("I am add PRoduct Form");
		product.setStatus("Active");
		
		String filePathString=session.getServletContext().getRealPath("/");
		String fileName=product.getPimage().getOriginalFilename();
		
		product.setImgname(fileName);
		System.out.println("File Name : "+fileName);
		productDaoObj.insertProduct(product);
		
		try{
			
			byte[] imageBytes=product.getPimage().getBytes();
		
			BufferedOutputStream bos=new BufferedOutputStream(
					new FileOutputStream(filePathString+"/resources/images/"+fileName));
			bos.write(imageBytes);
			bos.close();
			
			System.out.println(filePathString);
			
		}
		
		catch(Exception e){
			e.printStackTrace();
		}

		
		if(true){
			map.addAttribute("msg", "Product Added Succesfully");
			return "ProductPage";
		}
		else {
			map.addAttribute("msg", "Problem in Adding Product . Try Again ");
			return "AddProductForm";
		}
	}

	
	@RequestMapping(value="viewAllProducts",method=RequestMethod.GET)
	public ModelAndView getAllProducts(){
		
		ModelAndView mv=new ModelAndView("ViewAllProductsPage");
		List<Product> products=productDaoObj.getProducts();
		
		System.out.println("Product List : "+products);
		mv.addObject("productList",products);
		return mv;
	}
	
	@RequestMapping(value="/admin/deleteProduct/{proId}",method=RequestMethod.GET)
	public ModelAndView deleteProduct(@PathVariable("proId")int pId){
		
		System.out.println("PRoduct Id : "+pId);
		ModelAndView mv=new ModelAndView("ViewAllProductsPage");
		
		
		productDaoObj.deleteProduct(pId);
		
		List<Product> products=productDaoObj.getProducts();
		mv.addObject("productList",products);
		
		mv.addObject("msg","Product Deleted Succesfully");
		return mv;
		
	}
	
	@RequestMapping(value="getProduct/{category}",method=RequestMethod.GET)
	public ModelAndView getProductsbyCategory(@PathVariable("category")String cat) {
		
		ModelAndView mv=new ModelAndView("ViewAllProductsPage");
		List<Product> products=productDaoObj.getProducts(cat);
		
		System.out.println("Product List : "+products);
		mv.addObject("productList",products);
		return mv;
	}
	
}














