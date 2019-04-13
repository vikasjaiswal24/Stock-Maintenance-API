package com.coremedia.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coremedia.constant.Constant;
import com.coremedia.converters.ProductRequestToProduct;
import com.coremedia.converters.ProductToProductResponse;
import com.coremedia.domain.ProductRequest;
import com.coremedia.domain.ProductResponse;
import com.coremedia.jpa.entity.Product;
import com.coremedia.jpa.repository.ProductRepository;
import com.coremedia.service.StockMaintenanceService;


@Service
public class StockMaintenanceServiceImpl implements StockMaintenanceService {
	
	@Autowired
	ProductToProductResponse productToProductResponse;
	
	@Autowired
	ProductRequestToProduct productRequestToProduct;
	
	@Autowired
	ProductRepository productRepository;
	
	/**
	 * Service to store the stock data into H2 in memory database. 
	 * If the stock is already available into the database for the given product Id then the existing stock will be updated. 
	 * Else the new stock will be added into the database.
	 */
	@Override
	public ProductRequest createOrUpdateStock(ProductRequest productRequest)  {
		
		Product product = productRequestToProduct.convert(productRequest);
		productRepository.save(product);
		return productRequest;
		
	}
	
	/**
	 * Service to find the product details by productId
	 */
	@Override
	public ProductResponse getProductbyId(Integer productId) throws EntityNotFoundException {
		
		Product product = productRepository.getOne(productId);
		if(product == null) { 
			throw new EntityNotFoundException(Constant.PRODUCT_NOT_FOUND);
		}
		return productToProductResponse.convert(product);
		
	}
	
	/**
	 * Service to find all the products present into the stock.
	 */
	@Override
	public List<Product> getAllStock() {
		
		List<Product> productList = productRepository.findAll();
		if(productList == null) { 
			throw new EntityNotFoundException(Constant.PRODUCT_NOT_FOUND);
		}
		return productList;
		
	}
	
}