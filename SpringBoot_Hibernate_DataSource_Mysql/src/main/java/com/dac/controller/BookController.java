package com.dac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dac.bean.Book;
import com.dac.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	
	
	@RequestMapping("/")
	public String home() {
		System.out.println("In Home");
		return "home.jsp";
	}
	
	// add a new record in database.
    @PostMapping(value= "/create")
    public ResponseEntity<Book> create(@RequestBody Book book) {
        int id = bookService.addBook(book);
        if(id != 0)
            return new ResponseEntity<Book>(HttpStatus.CREATED);
 
        return new ResponseEntity<Book>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
 
    // Fetch all books from the database.
    @GetMapping(value= "/getall")
    public ResponseEntity<List<Book>> findAll() {
        return ResponseEntity.ok(bookService.findAll());
    }
 
    // Fetch particular book from the database.
    @GetMapping(value= "/get/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int bookid) {
       
    	System.out.println("hey i am here...");
    	Book book = bookService.findById(bookid);
        if(book == null)
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
 
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }
	
}
