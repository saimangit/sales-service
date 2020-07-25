package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.configuration.FeignConfiguration;

import com.example.model.Stock;

@FeignClient(value = "stock-service",url = "http://localhost:8010",
configuration = FeignConfiguration.class)
public interface StockClient {

	
	   @GetMapping(value = "/stock-product-api/stock",produces = "application/json")
	    public List<Stock> getNewAllStock();
	   
		@GetMapping(value = "stock-product-api/stock/{sid}", produces = "application/json")
		public Optional<Stock> getStockBySid(@PathVariable("sid") String sid);

}
