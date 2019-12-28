package com.api.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.api.domain.ProductRequest;
import com.api.jpa.entity.Product;


@Component
public class ProductRequestToProduct implements Converter<ProductRequest, Product>{
	
	@Override
	public Product convert(ProductRequest request) {
		Product entity = new Product();
		entity.setProductId(request.getProductId());
		entity.setId(request.getId());
		entity.setQuantity(request.getQuantity());
		entity.setTimeStamp(request.getTimeStamp());
		return entity;
	}

}