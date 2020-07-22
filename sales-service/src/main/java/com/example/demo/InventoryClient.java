package com.example.demo;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.configuration.FeignConfiguration;
import com.example.model.Product;

//"http://localhost:8000"
//"http://stockservicerds-env-1.eba-dwrqj2wp.us-east-1.elasticbeanstalk.com/"
@FeignClient(value = "inventory-service",url = "http://localhost:8000",
configuration = FeignConfiguration.class)
public interface InventoryClient {

	@GetMapping("/ims-api/product/{pid}")
	public Product getProduct(@PathVariable("pid") String pid);

    @GetMapping ("/ims-api/product/vendor/{vendor}")
    public List<Product> getProductsByVendor(@PathVariable("vendor") String vendor);
    
    
    
}
