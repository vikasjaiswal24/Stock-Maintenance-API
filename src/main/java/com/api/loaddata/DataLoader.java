package com.api.loaddata;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.api.jpa.entity.Product;

public class DataLoader {

	public static List<Product> createDemoData() {

		List<Product> productList = new ArrayList<>();

		for (int i=9; i>=0; --i) {
			Product buildStock1 = new Product();
			buildStock1.setId("ST201"+String.valueOf(i));
			buildStock1.setTimeStamp(new Date());
			//buildStock.setTimeStamp();
			buildStock1.setProductId(110+i);
			buildStock1.setQuantity(10+i);
			productList.add(buildStock1);
	
			Product buildStock2 = new Product();
			buildStock2.setId("ST201"+String.valueOf(i));
			buildStock2.setTimeStamp(new Date());
			buildStock2.setProductId(210+i);
			buildStock2.setQuantity(50+i);
			productList.add(buildStock2);
	
			Product buildStock3 = new Product();
			buildStock3.setId("ST201"+String.valueOf(i));
			buildStock3.setTimeStamp(new Date());
			buildStock3.setProductId(310+i);
			buildStock3.setQuantity(80+i);
			productList.add(buildStock3);
	
			Product buildStock4 = new Product();
			buildStock4.setId("ST201"+String.valueOf(i));
			buildStock4.setTimeStamp(new Date());
			buildStock4.setProductId(410+i);
			buildStock4.setQuantity(90+i);
			productList.add(buildStock4);
		}
		return productList;
	}
}
