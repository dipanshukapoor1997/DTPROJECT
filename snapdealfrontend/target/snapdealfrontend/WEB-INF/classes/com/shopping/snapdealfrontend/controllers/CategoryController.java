package com.shopping.snapdealfrontend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class CategoryController {
	@Autowired
	Category catObj;
	
	Product product=new Product();
	
	
	
	@RequestMapping(value="category",method=RequestMethod.GET)
	public String getProductPage(){
		return "CategoryPage";
	}
}
	
	
	@RequestMapping(value="addcategory",method=RequestMethod.GET)
	public String (ModelMap map){
		return "AddCategory";
		}	
	
	@RequestMapping(value="addcategory",method=RequestMethod.GET)
	public String AddProduct(ModelMap map){
		
		return"AddCategory";
			
	}
}

	@RequestMapping(value="submitcategory",method=RequestMethod.POST)
	public String SubmitAddProduct(@RequestParam("categoryName")String categoryName,ModelMap map){
		Category cat=new Category();
		cat.setCategoryName(categoryName);
		cat.setCategory_isactive("Active");
		
		System.out.println("Category Added Succefully");
		
		boolean cat1=catObj.addCategory(cat);
		if(cat1==true){
			return "Sucess";
		}
		else{
			return"Failure";
		}
		
		
	
	}
	
	@RequestMapping(value="viewAllCategory",method=RequestMethod.GET)
	public String listCategories(ModelMap map){
		List<Category> categories=catObj.category(); 
		map.addAttribute("catList", categories);
		return "ViewAllCategories";
	}
}