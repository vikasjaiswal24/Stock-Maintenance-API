package com.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.api.jpa.entity.Product;
import com.api.loaddata.DataLoader;
import com.api.service.StockService;


@SpringBootApplication
@ComponentScan("com.api")
public class StockManagementApplication implements ApplicationRunner {

	@Autowired
	StockService stocksService;
	
	public static void main(String[] args) {
		SpringApplication.run(StockManagementApplication.class, args);
	}
	
	/**
	 * This method will load the data on the application start up.
	 */
	@Override
	public void run(ApplicationArguments args) throws Exception {
	    List<Product> productList = DataLoader.createDemoData();
	    stocksService.loadInitialData(productList);
	}
}