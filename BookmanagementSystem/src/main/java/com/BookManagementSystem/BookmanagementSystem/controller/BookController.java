package com.BookManagementSystem.BookmanagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.BookManagementSystem.BookmanagementSystem.entity.Book;
import com.BookManagementSystem.BookmanagementSystem.entity.MyBookList;
import com.BookManagementSystem.BookmanagementSystem.service.BookService;
import com.BookManagementSystem.BookmanagementSystem.service.MyBookListService;


import java.util.*;


@Controller
public class BookController {
	
	@Autowired
	private BookService service;
	
	@Autowired
	private MyBookListService myBookService;
	
	
	@GetMapping("/")
	public String home() {
		
		return "home";
	}
	
	@GetMapping("/bookregister")
	public String book_register()
	{
		return "book_register";
	}
	
	
	@GetMapping("/available_books")
	public ModelAndView GetAllBooks() {
		
		List<Book> list=service.getAllBook();
      //  ModelAndView model= new ModelAndView();
//	    model.setViewName("booklist");
//	    model.addObject("book",list);
		
		return new ModelAndView("booklist","book",list);
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		
		service.save(b);
		return "redirect:/available_books";
		
	}
	
	@GetMapping("/my_books")
	public String getMyBooks( Model model) {
		
		List<MyBookList> list=myBookService.getAllMyBooks();
	    model.addAttribute("book",list);
		return "myBooks";
	}
	
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b=service.getBookById(id);
		MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		myBookService.saveMyBooks(mb);
		return "redirect:/my_books";
		
	}
	
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id,Model model ){
		Book b=service.getBookById(id);
		model.addAttribute("book",b);
		return"bookEdit";
	}
	

	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id") int id ) {
//		String userId=user.getUserId();
//		Optional<User> userdata=repo.findById(userId);
		service.deleteById(id);	
		return "redirect:/available_books";
	}
		
	@RequestMapping(value="/login", method= RequestMethod.GET)
	public String LoginPage() {
		
		return "login";
		
	}
	
	@PostMapping(value="/login")
	public String Loginuser(ModelMap model,@RequestParam String userId,@RequestParam String password) {
		
		if(userId.equals("root") && password.equals("root")) {
			
			return "mybooks";
		}
		
		model.put("error try again", "provide correct UserId And Password");
	
	return "loginuser";
	

	}
	
}
