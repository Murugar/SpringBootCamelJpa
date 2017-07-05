
package com.iqmsoft.spring.boot.camel.jpa.repos;

import org.springframework.data.repository.CrudRepository;

import com.iqmsoft.spring.boot.camel.jpa.domain.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
	
}
