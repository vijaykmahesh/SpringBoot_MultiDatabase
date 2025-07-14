package com.boot.mds.spring_boot_mds;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.boot.mds.spring_boot_mds.entity.productEntity.Product;
import com.boot.mds.spring_boot_mds.mysql.repository.ProductRepository;
import com.boot.mds.spring_boot_mds.orderentity.Orders;
import com.boot.mds.spring_boot_mds.postgres.repository.OrderRepository;

@SpringBootApplication
public class SpringBootMdsApplication implements CommandLineRunner {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMdsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("inserting using p[ostgres");
		Product p = new Product("dice");
		
		productRepository.save(p);
		
		Orders o1 = new Orders("tennis", LocalDate.now());
		
		orderRepository.save(o1);
		
		
		
	}

}
