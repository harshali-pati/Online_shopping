package com.FirstProject.boot.serviceimpl;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.util.comparator.ComparableComparator;

import com.FirstProject.boot.dao.ProductDao;
import com.FirstProject.boot.daoimpl.ProductDaoimpl;
import com.FirstProject.boot.model.ProductModel;
import com.FirstProject.boot.service.ProductService;

public class ProductServiceimpl implements ProductService {
	
	ProductDao dao = new ProductDaoimpl();

	@Override
	public int addProduct(ProductModel productModel) {
		
	   //  String productId = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
	  //	productModel.setProductId(Long.parseLong(productId)); 
		
		java.sql.Date createddate=new java.sql.Date(System.currentTimeMillis());
		productModel.setCreateddate(createddate);
		
		return dao.addProduct(productModel);
	}

	@Override
	public ProductModel getProductByid(long productId) {
		
		return dao.getProductByid(productId);
	}

	
	@Override
	public ProductModel getProductbyName(String productName) {
		
		return dao.getProductbyName(productName);
	}
	

	/*@Override
	public Boolean deleteProductbyId(long productid) {
		
		return dao.deleteProductbyId(productid);
	}*/

	@Override
	public Object getProductbyprice(double productprice) {
		
		return dao.getProductbyprice(productprice);
	}

	@Override
	public int deleteProductByid(long productid) {
		
		return dao.deleteProductByid(productid);
	}

	@Override
	public int Updateproduct(ProductModel productModel) {
		int status=0;
		ProductModel dbproduct = getProductByid(productModel.getProductId());
		
		if(dbproduct !=null)
		{
			status=dao.Updateproduct(productModel);
		}
		
		else
		{
			status=2;
		}
		
		
		return status;
	

	
	}

	@Override
	public List<ProductModel> getAllProduct() {
		
		return dao.getAllProduct();
	}
	

	@Override
	public List<ProductModel> sortProduct(String ordertype, String propertyName) {
		
		List<ProductModel> list = getAllProduct();
		
		Comparator<ProductModel> comparator=null;
		
		if(!list.isEmpty())
		{
			switch (propertyName) {
			case "productName":
			{
				comparator=Comparator.comparing(ProductModel::getProductName);
				
			     break;
			}
			
			case "productPrice":
			{
				comparator=Comparator.comparing(ProductModel::getProductPrice);
				
				break;
			}
			
			  default:
				  comparator=Comparator.comparing(ProductModel::getProductId);
				break;
			}
			
			if(ordertype.equalsIgnoreCase("desc"))
			{
				comparator=comparator.reversed();
			}
			
			Stream<ProductModel> sorted = list.stream().sorted(comparator);
		     list = sorted.collect(Collectors.toList());
		}
		
		else
		{
			return list;
		}
		
		
		return list;
	}

	
	
	
	

	

	
}
