package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.Order;

public interface SalesRepository extends JpaRepository<Order, Long> {
  
	@Query(nativeQuery = true,value="select * from sales_order s where s.sales_order_key=?1")
	Optional<Order> findById(String key);

}
