package com.FirstProject.boot.dao;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.FirstProject.boot.model.ProductModel;

public interface ProductDao {
  
	public int addProduct(ProductModel productModel);
	
	public ProductModel getProductByid(long productId);

	public ProductModel getProductbyName(String productName);
	
	 //public Boolean deleteProductbyId(long productid);
	 
	 public Object getProductbyprice(double productprice);

	public int deleteProductByid(long productid);

	public int Updateproduct(ProductModel productModel);

	public List<ProductModel> getAllProduct();
	
	
	
	
	 
}