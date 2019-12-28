package com.api.domain;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import com.api.constant.Constant;


public class ProductRequest {
	
	@NotNull @Size(min = 3, message = Constant.ID_MSG)
	private String id;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date timeStamp;
	
	@NumberFormat
	private int productId;
	
	@NumberFormat
	private int quantity;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

}