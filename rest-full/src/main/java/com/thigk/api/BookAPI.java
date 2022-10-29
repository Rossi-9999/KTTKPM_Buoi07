package com.thigk.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thigk.entity.Book;
import com.thigk.repo.BookService;

@RestController
@RequestMapping("/api")
public class BookAPI {
	@Autowired
	BookService bookRepo;
	
	
	@GetMapping("/books")
	public List<Book> getAll() {
		return bookRepo.findAll();
	}
	
	@PostMapping("/books")
	public void add(@RequestBody Book book) {
		 bookRepo.save( book);
	}

	@GetMapping("/books/{id}")
	public 	Book getBook(@PathVariable("id")int id) {
		 Optional<Book> book = bookRepo.findById(id);
		 return book.get();
	}
}
