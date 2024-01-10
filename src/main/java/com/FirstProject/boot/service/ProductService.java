package com.FirstProject.boot.service;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.FirstProject.boot.model.ProductModel;

public interface ProductService {
  
	public int addProduct(ProductModel productModel);
	
	public ProductModel getProductByid(long productId);
	
	 public ProductModel getProductbyName(String productName);
	 
	 //public Boolean deleteProductbyId(long productid);
	 
	 public Object getProductbyprice(double productprice);

	 public int deleteProductByid(long productid);
	 
	 public int Updateproduct(ProductModel productModel);
	 
	 public List<ProductModel> getAllProduct();
	 
	 public List<ProductModel> sortProduct(String ordertype, String propertyName);
}
	 
	