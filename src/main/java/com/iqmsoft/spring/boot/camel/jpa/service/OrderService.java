
package com.iqmsoft.spring.boot.camel.jpa.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iqmsoft.spring.boot.camel.jpa.domain.Order;
import com.iqmsoft.spring.boot.camel.jpa.repos.BookRepository;

@Component
public class OrderService {

    @Autowired
    private BookRepository books;

    private final Random amount = new Random();

    public Order generateOrder() {
        Order order = new Order();
        order.setAmount(amount.nextInt(10) + 1);
        order.setBook(books.findOne(amount.nextInt(2) + 1));
        return order;
    }
}
