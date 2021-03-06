package com.example.demo;




import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



import com.example.configuration.FeignConfiguration;


import com.example.model.StockProducts;

//"http://localhost:8000"

@FeignClient(value = "inventory-service",url = "http://localhost:8000",
configuration = FeignConfiguration.class)
public interface InventoryClient {

	 @GetMapping(value = "/product-api/stock/{sid}/product/",produces = "application/json")
		public Iterable<StockProducts> getNewAllProducts(@PathVariable("sid") String sid);
    
	 
	 @GetMapping(path = "/product-api/stock/{sid}/product/{pid}", produces = "application/json")
		public Optional<StockProducts> getProduct(@PathVariable("sid") String sid,
				@PathVariable("pid") String pid);     
}
