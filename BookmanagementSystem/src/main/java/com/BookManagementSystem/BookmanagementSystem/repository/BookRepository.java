package com.BookManagementSystem.BookmanagementSystem.repository;

import java.util.List;

import org.hibernate.engine.spi.EntityEntryFactory;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BookManagementSystem.BookmanagementSystem.entity.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	

}
