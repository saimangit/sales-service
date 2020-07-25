package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




import com.example.model.Stock;
import com.example.model.StockProducts;
import com.example.service.SalesService;

@RestController
@RequestMapping("/stock-sales")
public class StockProductController {

	   
	@Autowired
	SalesService salesService;
	    
	    @GetMapping(value = "/stock/",produces = "application/json")
	    public List<Stock> getStockDetails() {
	    	
	    	return salesService.getStock(); 
	    }

		
	    @GetMapping(value = "/stock/{sid}",produces = "application/json")
	    public Iterable<StockProducts> getProdcutDetails(@PathVariable("sid") String sid) {
	    	
	    	return salesService.getProducts(sid);
	    	
	    }

	    @GetMapping(value = "/stock/{sid}/product/{pid}/qty/{qty}",produces = "application/json")
	    public ResponseEntity<String> placeOrder(@PathVariable("sid") String sid,
	    		@PathVariable("pid") String pid,
	    		@PathVariable("qty") String qty)  {
	    	
	    	return salesService.placeOrder(sid, pid, qty);
	    }
	    
}
