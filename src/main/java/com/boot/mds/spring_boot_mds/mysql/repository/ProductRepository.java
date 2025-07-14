package com.boot.mds.spring_boot_mds.mysql.repository;

import org.springframework.data.repository.CrudRepository;

import com.boot.mds.spring_boot_mds.entity.productEntity.Product;


public interface ProductRepository extends CrudRepository<Product, Integer> {

}
