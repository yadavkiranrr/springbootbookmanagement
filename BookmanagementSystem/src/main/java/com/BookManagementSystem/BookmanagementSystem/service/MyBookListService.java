package com.BookManagementSystem.BookmanagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookManagementSystem.BookmanagementSystem.entity.MyBookList;
import com.BookManagementSystem.BookmanagementSystem.repository.MyBookRepository;

@Service
public class MyBookListService {
	
	@Autowired
	private MyBookRepository mybook;
	
	
	public void saveMyBooks(MyBookList book){
		mybook.save(book);
		
	}
	
	public List<MyBookList> getAllMyBooks(){
		
		return mybook.findAll();
	}
	
	public void deletById(int id) {
		
		mybook.deleteById(id);
	}

}
