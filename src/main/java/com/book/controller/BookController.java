package com.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.book.model.Book;
import com.book.repository.BookRepository;

@RestController
public class BookController {
	
	
	@Autowired
	BookRepository repository;
	
	@PostMapping("/addbook")
	public String createBook(@RequestBody Book book) {
		repository.save(book);
		return "Book Created with Id :" + book.getId();
	}
	
	
	@GetMapping("/findAllBooks")
	public List<Book> getBooks() {
		return	repository.findAll();
	}
	
	@GetMapping("/findBookWithId/{id}")
	public Optional<Book> getBook(@PathVariable int id) {
		return	repository.findById(id);
	}
	
	@DeleteMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable int id) {
			repository.deleteById(id);
			return "Book deleted";
	}
	
	
	
	
	

}
