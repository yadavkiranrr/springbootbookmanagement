package com.BookManagementSystem.BookmanagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookManagementSystem.BookmanagementSystem.entity.Book;
import com.BookManagementSystem.BookmanagementSystem.repository.BookRepository;


@Service
public class BookService {

	@Autowired
	private BookRepository Brepo;
	
	public void save(Book b) {
		
	         Brepo.save(b);
	}
	
	 public List<Book> getAllBook(){
		return  Brepo.findAll();
		
	 } 
	
	 public Book getBookById(int id) {
		 
		 return Brepo.findById(id).get();
		 
	 }
	 
	 public void deleteById( int id) {
		 
		 
		 Brepo.deleteById(id);
	 }
	 
	

}
