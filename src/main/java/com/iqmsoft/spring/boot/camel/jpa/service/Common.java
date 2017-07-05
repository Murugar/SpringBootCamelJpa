
package com.iqmsoft.spring.boot.camel.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iqmsoft.spring.boot.camel.jpa.domain.Book;
import com.iqmsoft.spring.boot.camel.jpa.domain.Order;
import com.iqmsoft.spring.boot.camel.jpa.repos.BookRepository;
import com.iqmsoft.spring.boot.camel.jpa.repos.OrderRepository;

@Component
public class Common {

    @Autowired
    private BookRepository books;

    @Autowired
    private OrderRepository orders;

    public Iterable<Book> findBooks() {
        return books.findAll();
    }

    public Order findOrder(Integer id) {
        return orders.findOne(id);
    }
}
