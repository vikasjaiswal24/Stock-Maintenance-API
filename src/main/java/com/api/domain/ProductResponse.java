package com.api.domain;

import java.util.Date;

public class ProductResponse {
	
	private int productId;
	private Date requstTimeStamp;
	private Stock stock;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public Date getRequstTimeStamp() {
		return requstTimeStamp;
	}
	public void setRequstTimeStamp(Date requstTimeStamp) {
		this.requstTimeStamp = requstTimeStamp;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}

}