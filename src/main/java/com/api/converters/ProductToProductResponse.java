package com.api.converters;

import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.api.domain.ProductResponse;
import com.api.domain.Stock;
import com.api.jpa.entity.Product;


@Component
public class ProductToProductResponse implements Converter<Product, ProductResponse>{
	
	@Override
	public ProductResponse convert(Product product) {
		ProductResponse response = new ProductResponse();
		response.setProductId(product.getProductId());
		response.setRequstTimeStamp(new Date());
		Stock stock = new Stock();
		stock.setId(product.getId());
		stock.setQuantity(product.getQuantity());
		stock.setTimeStamp(product.getTimeStamp());
		response.setStock(stock);
		return response;
	}

}