package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Order;
import com.example.model.Product;

import com.example.repository.SalesRepository;

@Service
public class SalesService {

	@Autowired
	SalesRepository salesRepository;
	
	public void save(Product p) {
       
		
		
		Order o= new Order();
     
        o.setSalesOrderKey("SO-"+p.getPid());
        o.setPid(p.getPid());
		o.setPname(p.getPname());
		o.setAmount(p.getPrice());
		o.setSupplierContact(p.getSupplierContact());
		o.setSupplierName(p.getSupplierName());
		salesRepository.save(o);
	}
	
	public void addProducts(List<Product> list) {
		// TODO Auto-generated method stub
		
List<Product> fine= new ArrayList<>();
    	
   	
    	List<Order> product=new ArrayList<>();
    	
    	for(Product s:fine) {
 
    		Order o= new Order();
            o.setSalesOrderKey("SO-"+s.getPid());
            o.setPid(s.getPid());
    		o.setPname(s.getPname());
    		o.setAmount(s.getPrice());
            o.setSupplierContact(s.getSupplierContact()); 
            o.setSupplierName(s.getSupplierName());
               product.add(o);
    	}
    	
    	salesRepository.saveAll(product); 
    	
	}

	public Optional<Order> getOrderByKey(String key) {

		return salesRepository.findById(key);
	}	
}
