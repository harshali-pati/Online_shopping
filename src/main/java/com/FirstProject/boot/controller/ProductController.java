package com.FirstProject.boot.controller;

import java.security.Provider.Service;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FirstProject.boot.exception.ProductAlreadyExistException;
import com.FirstProject.boot.model.ProductModel;
import com.FirstProject.boot.service.ProductService;
import com.FirstProject.boot.serviceimpl.ProductServiceimpl;

@RestController
public class ProductController {
	
	ProductService servise = new ProductServiceimpl(); 
	
	   @PostMapping(value="/add-product",produces = "application/json")
	public String addProduct(@RequestBody @Valid ProductModel productModel)
	{
		   int status = servise.addProduct(productModel);
		   if(status==1)
		   {
			   return "added sucessully !";
		   }
		   else if(status==2)
		   {
			   throw new ProductAlreadyExistException("Product Already Exits Product Name ="+productModel.getProductName());
		   }
		   else
		   {
			   return "something went wrog";
		   }
		
	}
	   
	   @GetMapping("/get-product-by-id/{productId}")
	   
	   public Object getProductByid(@PathVariable long productId) 
	   {
		   ProductModel productModel = servise.getProductByid(productId);
		   if(productModel !=null)
		   {
			   return productModel;
		   }
		   else
		   {
			   return "product not found with id= "+productId;
		   }
		 
		   
	   }
	
	   
	  @GetMapping("/get-product-by-name/{productName}")
	  
	  public Object getProductbyName(@PathVariable String productName)
	  {
		  ProductModel productModel = servise.getProductbyName(productName);
				  if(productModel !=null)
				  {
					  return productModel;
				  }
				  else
				  {
					  return "product ot found= "+productName;
				  }
				
	  }
	   
	/*  @DeleteMapping("/delete-product-by-id/{productid}")
	  
	  public String deleteProductbyId(@PathVariable long productid)
	  {
		Boolean deleteProduct = servise.deleteProductbyId(productid);
		{
			if(deleteProduct !=null)
			{
				return "product delete sucessfully= "+productid;
			}
			else
			{
				return "this product not found= "+productid;
			}
		}
	  }*/
 
	  @GetMapping("/get-Product-by-Price/{productprice}")
	  
	  public Object getProductbyprice(@PathVariable double productprice)
	  {
		 return servise.getProductbyprice(productprice);
	  }
	  
	  
	  
	  @DeleteMapping("/delete-Product-by-Id")
	  
	  public String deleteProductByid(@RequestParam long productid)
	  {
		  int status = servise.deleteProductByid(productid);
		  
		  if(status==1)
		  {
			  return "delete sucessfully";
		  }
		  else if(status==2)
		  {
			  return "product not found:- "+productid;
		  }
		  else
		  {
			  return "something went wrong";
		  }
	  }
	  
	  @PutMapping("update-product")
	  
	  public String Updateproduct(@RequestBody ProductModel productModel)
	  {
		 int status= servise.Updateproduct(productModel);
		 
		 if(status==1)
		  {
			  return "update sucessfully";
		  }
		  else if(status==2)
		  {
			  return "product not found:- "+productModel.getProductId();
		  }
		  else
		  {
			  return "something went wrong";
		  }
		  
	  }
	  
	  
       @GetMapping("get-all-product")
	  
	     public Object getAllProduct()
	    {
		  List<ProductModel> list= servise.getAllProduct();
		  
		  if(list !=null && !list.isEmpty())
		  {
			  return list;
		  }
		  else
		  {
			  return "product not found";
		  }
	  }
       
	  
	 @GetMapping("/sorting-product/{ordertype}/{propertyName}")
	  
	  public Object sortProduct(@PathVariable String ordertype, @PathVariable String propertyName)
	  {
		 
		 List<ProductModel> list = servise.sortProduct(ordertype, propertyName);
		 
		 if(list !=null && !list.isEmpty())
		  {
			  return list;
		  }
		  else
		  {
			  return "product not found";
		  }
	  }
	  
	
}
