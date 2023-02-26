package com.BookManagementSystem.BookmanagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.BookManagementSystem.BookmanagementSystem.service.MyBookListService;

@Controller
public class MyBookListController {
	
	@Autowired
	private MyBookListService service; 
	
	@RequestMapping("/deleteMyList/{id}")
	public String deleteMyList( @PathVariable("id") int id) {
		service.deletById(id);
		return "redirect:/my_books";
	}

}
