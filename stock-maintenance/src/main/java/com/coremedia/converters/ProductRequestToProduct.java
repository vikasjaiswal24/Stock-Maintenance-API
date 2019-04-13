package com.coremedia.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.coremedia.domain.ProductRequest;
import com.coremedia.jpa.entity.Product;


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