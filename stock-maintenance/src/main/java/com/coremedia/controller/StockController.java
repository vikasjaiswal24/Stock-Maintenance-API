package com.coremedia.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coremedia.domain.ProductRequest;
import com.coremedia.domain.ProductResponse;
import com.coremedia.jpa.entity.Product;
import com.coremedia.service.StockMaintenanceService;


@RestController
@RequestMapping(value = "/coremedia/api")
public class StockController {
	
	private static final Logger logger = LoggerFactory.getLogger(StockController.class);
	
	@Autowired
	StockMaintenanceService stockMaintenanceService;
	
	/*
	 * This method is used to add or update the product into Stock.
	 */
	@PostMapping(path = "/updateStock", 
			consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, 
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<ProductRequest> updateStock(@Valid @RequestBody ProductRequest product) {
		logger.info(StockController.class + "Received POST request for adding/updating stock !!");
		ProductRequest productRequest = stockMaintenanceService.createOrUpdateStock(product);
		return new ResponseEntity<>(productRequest, HttpStatus.CREATED);
	}
	
	/*
	 * This method is used to get the product details based on the productId.
	 */
	@GetMapping(path = "/stock")
	public ResponseEntity<ProductResponse> getProductbyId(@Valid @NotNull @RequestParam("productId") Integer productId) {
		logger.info(StockController.class + "Received GET request for productId: " + productId);
		ProductResponse productResponse = stockMaintenanceService.getProductbyId(productId);

		if (null != productResponse) {
			return new ResponseEntity<>(productResponse, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/*
	 * This method is used to get the product details based on the productId.
	 */
	@GetMapping(path = "/allStock")
	public List<Product> getAllStock() {
		logger.info(StockController.class + "Received GET request for all the stocks !!");
		List<Product> productList = stockMaintenanceService.getAllStock();
		return productList;
	}

}