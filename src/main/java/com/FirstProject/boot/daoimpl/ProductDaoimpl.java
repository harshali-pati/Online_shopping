package com.FirstProject.boot.daoimpl;

import java.lang.reflect.Array;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.FirstProject.boot.dao.ProductDao;
import com.FirstProject.boot.model.ProductModel;

public class ProductDaoimpl implements ProductDao {
	
	List<ProductModel> list= new ArrayList<>();
	
	public ProductDaoimpl()
	{
		list.add(new ProductModel(3l,"book", 30d, 100, new Date(2022-12-12),new Date (2024-12-12),new Date(2023-14-12)));
		list.add(new ProductModel(2l,"pencil", 50d, 100, new Date(2022-12-12),new Date (2024-12-12),new Date(2023-14-12)));
		list.add(new ProductModel(1l,"pen", 80d, 100, new Date(2022-12-12),new Date (2024-12-12),new Date(2023-14-12)));
	}
 
	@Override
	public int addProduct(ProductModel productModel) 
	{
		int status=0;
		
		for (ProductModel prd : list) 
		{
			if(prd.getProductName().equals(productModel.getProductName()))
			{	
				status=2;
				break;
			}
		}
		if(status!=2)
		{
			try
			{
				list.add(productModel);
				status=1;
			}
			catch (Exception e)
			{
				e.printStackTrace();
				status=3;
			}
		}
		
		
		return status;
	}

	@Override
	public ProductModel getProductByid(long productId) {
		
		for (ProductModel productModel : list) {
			if(productModel.getProductId()==productId)
			{
				return productModel;
			}
			
		}
		
		
		
		return null;
	}

	@Override
	public ProductModel getProductbyName(String productName) {
		
		for (ProductModel productModel : list) {
			if(productModel.getProductName().equals(productName))
			{
				return productModel;
			}
		}
		return null;
	}

	/*@Override
	public Boolean deleteProductbyId(long productid) {
		
		for (ProductModel prod : list) {
			
			if(prod.getProductId()==productid)
			{
				return list.remove(prod);
			}
		}
		return null;
	}*/

	@Override
	public Object getProductbyprice(double productprice) {
		
		List<ProductModel> list1 = new ArrayList<>();
		
		for (ProductModel product : list) {
			
			if(product.getProductPrice()>=productprice)
			{
				list1.add(product);
			return list1;
	}

		}

	
		return "product not found";
	}

	@Override
	public int deleteProductByid(long productid) {
		
		int status=0;
		
		Iterator<ProductModel> itr=list.iterator();
		
		while (itr.hasNext()) {
			ProductModel productModel = (ProductModel) itr.next();
			
			try {
				if(productModel.getProductId()==productid)
				{
					itr.remove();
					status=1;
					break;
				}
			} 
			catch (Exception e)
			{
				status=3;
			}
		
		}
		
		if(status !=1)
		{
			status=2;
		}
		
		return status;
	}

	@Override
	public int Updateproduct(ProductModel productModel) {
		int status=0;
		
		try 
		{
			for (ProductModel dbproduct : list) {
				if(dbproduct.getProductId()==productModel.getProductId())
				{
					list.set(list.indexOf(dbproduct), productModel);
					status=1;
				}
			}
			
		} 
		
		catch (Exception e) 
		{
			status=3;
		}
		
		
		return status;
	}

	
	@Override
	public List<ProductModel> getAllProduct() {
		
		return list;
	}

	
	}
	

	
		

	
	
	
	

	
