package com.api.jpa.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Product {
	
	@Id	// Primary key in the database
	private int productId;
	private String stockId;	
	private Date timeStamp;
	private int quantity;
	
	public Product() {
		
	}
	
	public Product(String stockId, Date timeStamp, int productId, int quantity) {
		super();
		this.stockId = stockId;
		this.timeStamp = timeStamp;
		this.productId = productId;
		this.quantity = quantity;
	}
	
	public String getId() {
		return stockId;
	}
	
	public int getProductId() {
		return productId;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public Date getTimeStamp() {
		return timeStamp;
	}
	
	public void setId(String stockId) {
		this.stockId = stockId;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "ProductEntity [stockId=" + stockId + ", timeStamp=" + timeStamp + ", productId=" + productId + ", quantity="
				+ quantity + "]";
	}
}