package com.coremedia.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.coremedia.domain.ProductRequest;
import com.coremedia.domain.ProductResponse;
import com.coremedia.jpa.entity.Product;

@Service
public interface StockMaintenanceService {
	
	public ProductRequest createOrUpdateStock(ProductRequest stock);
	
	public ProductResponse getProductbyId(Integer productId) throws EntityNotFoundException;
	
	public List<Product> getAllStock();

}