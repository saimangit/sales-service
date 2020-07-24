package com.example.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.InventoryClient;
import com.example.demo.StockClient;
import com.example.model.Stock;
import com.example.model.StockProducts;
import com.example.repository.SalesRepository;

@Service
public class SalesService {

	@Autowired
	SalesRepository salesRepository;
	
	
	 @Autowired
	    InventoryClient inventoryClient;
	    @Autowired
	    StockClient stockClient;
	    
	    

		public List<Stock> getStock() {
			return stockClient.getNewAllStock();
		}
		
		public Iterable<StockProducts> getProducts(String sid) {
			return inventoryClient.getNewAllProducts(sid);
		}
	
	
	
	}
