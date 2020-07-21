package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.InventoryClient;
import com.example.exception.OrderNotFoundException;
import com.example.model.Order;
import com.example.model.Product;
import com.example.repository.SalesRepository;
import com.example.service.SalesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/sales-api")
@Api(value = "sales-service",description = "operations related to sales")
public class SalesController {

	@Autowired
	InventoryClient inventoryClient;
	
	@Autowired
	SalesService salesService;
	
	@RequestMapping(value = "/asales/{pid}",method = RequestMethod.POST)
    @ApiOperation(value = "adding an order by pid")
	public void addOrder(@PathVariable String pid) {
		Product p=inventoryClient.getProduct(pid);
		salesService.save(p);
	}
	
	@RequestMapping(value = "/sales/vendor/{vendor}",method = RequestMethod.GET)
    @ApiOperation(value = "adding an order by pid")
	public List<Product> getOrderByVendor(@PathVariable String vendor) {
	
		  return inventoryClient.getProductsByVendor(vendor);
	}
	
	@RequestMapping(value = "/sales/view/{key}",method = RequestMethod.GET)
    @ApiOperation(value = "get an order by key")
    public ResponseEntity<Optional<Order>> getOrder(@PathVariable String key) throws OrderNotFoundException {
    	
		Optional<Order> raw= salesService.getOrderByKey(key);
        if(!raw.isPresent()) {
     	   throw new OrderNotFoundException("order not found for the key:"+key);
        }
        
        return ResponseEntity.ok().body(raw);
		
    }	
}
