package com.example.demo;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;



import com.example.configuration.FeignConfiguration;
import com.example.model.Stock;

@FeignClient(value = "stock-service",url = "http://localhost:8010",
configuration = FeignConfiguration.class)
public interface StockClient {

	
	   @GetMapping(value = "/stock-product-api/stock",produces = "application/json")
	    public List<Stock> getNewAllStock();
}
