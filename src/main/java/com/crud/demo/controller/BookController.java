package com.crud.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.demo.model.Book;
import com.crud.demo.services.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
    public List<Book> getBooks(){   
        return bookService.getBooks();      
    }
	
	@GetMapping("/book/{id}")
	public Book getBook(@PathVariable int id) {
		return bookService.getBook(id);
	}
	
	@PostMapping("/book")
	public Book addBook(@RequestBody Book book) {
		return bookService.saveBook(book);
	}
	
	@PutMapping("/update")
	public Book updateBook(@RequestBody Book book) {
		return bookService.updateBook(book);
	}
	
	@DeleteMapping("/book/{id}")
	public String deleteBook(@PathVariable int id) {
		bookService.deleteBook(id);		
		return "Removed Book Id " + id;
	}
	
	@GetMapping("/maxsold")
	public String maxSold() {
		return bookService.maxSold();
	}
}
