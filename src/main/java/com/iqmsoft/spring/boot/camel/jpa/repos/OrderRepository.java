package com.iqmsoft.spring.boot.camel.jpa.repos;

import org.springframework.data.repository.CrudRepository;

import com.iqmsoft.spring.boot.camel.jpa.domain.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
