package com.api.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.constant.Constant;
import com.api.converters.ProductRequestToProduct;
import com.api.converters.ProductToProductResponse;
import com.api.domain.ProductRequest;
import com.api.domain.ProductResponse;
import com.api.jpa.entity.Product;
import com.api.jpa.repository.ProductRepository;
import com.api.service.StockService;


@Service
public class StockServiceImpl implements StockService {
	
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