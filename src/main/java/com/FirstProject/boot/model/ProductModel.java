package com.FirstProject.boot.model;

import java.sql.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ProductModel {
  
	private long productId;
	
	@NotBlank(message = "Product Name Id Required")
	@Pattern(regexp = "^[a-zA-Z0-9\\s]{3,50}$", message="product name should consist of letter, numbers, and spaces , and be between 3 and 50 characters long.")
	private String productName;
	
	@Min(1)
	private double productPrice;
	
	@Min(1)
	private int productQty;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date mfgDate;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date expDate;
	
	private Date createdDate;
	
	public ProductModel ()
	{
		
	}

	public ProductModel(long productId, String productName, double productPrice, int productQty, Date mfgDate,
			Date expDate, Date createdDate) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQty = productQty;
		this.mfgDate = mfgDate;
		this.expDate = expDate;
		this.createdDate = createdDate;
	}
	

	public long getProductId()
	{
		return productId;
	}

	public void setProductId(long productId)
	{
		this.productId = productId;
	}

	public String getProductName() 
	{
		return productName;
	}

	public void setProductName(String productName) 
	{
		this.productName = productName;
	}

	public double getProductPrice() 
	{
		return productPrice;
	}

	public void setProductPrice(double productPrice)
	{
		this.productPrice = productPrice;
	}

	public int getProductQty()
	{
		return productQty;
	}

	public void setProductQty(int productQty)
	{
		this.productQty = productQty;
	}

	public Date getMfgdate()
	{
		return mfgDate;
	}

	public void setMfgDate(Date mfgDate) 
	{
		this.mfgDate = mfgDate;
	}

	public Date getExpDate()
	{
		return expDate;
	}

	public void setExpdate(Date expDate)
	{
		this.expDate = expDate;
	}

	public Date getCreatedDate() 
	{
		return createdDate;
	}

	public void setCreateddate(Date createdDate)
	{
		this.createdDate = createdDate;
	}

	@Override
	public String toString()
	{
		return "ProductModel [productId=" + productId + ", productName=" + productName + ", productPrice="
				+ productPrice + ", productQty=" + productQty + ", mfgDate=" + mfgDate + ", expDate=" + expDate
				+ ", createdDate=" + createdDate + "]";
	}
	
	
	
	
	
	
}
