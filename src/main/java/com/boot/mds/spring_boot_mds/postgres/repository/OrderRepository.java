package com.boot.mds.spring_boot_mds.postgres.repository;

import org.springframework.data.repository.CrudRepository;

import com.boot.mds.spring_boot_mds.orderentity.Orders;

public interface OrderRepository extends CrudRepository<Orders, Integer> {

}
