package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.cloud.openfeign.EnableFeignClients;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.apache.*;



@SpringBootApplication
@EnableFeignClients
//@EnableEurekaClient
@EnableJpaRepositories("com.example.*")
@EntityScan("com.example.*")
@ComponentScan("com.example.*")
public class SalesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesServiceApplication.class, args);
	}
}
