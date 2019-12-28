package com.api.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.api.domain.ProductRequest;
import com.api.domain.ProductResponse;
import com.api.jpa.entity.Product;

@Service
public interface StockService {
	
	public ProductRequest createOrUpdateStock(ProductRequest stock);
	
	public ProductResponse getProductbyId(Integer productId) throws EntityNotFoundException;
	
	public List<Product> getAllStock();
	
	public void loadInitialData(List<Product> list);

}