package com.example.repository;




import org.springframework.data.jpa.repository.JpaRepository;



import com.example.model.OrderData;

public interface SalesRepository extends JpaRepository<OrderData, Long> {
  
	
}
