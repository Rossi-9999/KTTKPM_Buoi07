package com.thigk.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thigk.model.Book;
import com.thigk.repo.BookService;

@Controller

public class BookController {
//	@Autowired
//	private BookService bookService;
//	
//	@RequestMapping(value = "/view")
//	public String view(HttpServletRequest request) {
//		List<Book> list = bookService.getAll();	
//		request.setAttribute("list", list);
//		return "view";
//	}
//	
//	
//	@RequestMapping(value = "/add")
//	public String add(HttpServletRequest request) {
//		
//		return "add";
//	}
//	
//	@RequestMapping(value = "/add", method = RequestMethod.POST)
//	public String add(@ModelAttribute Book book) {
//		bookService.save(book);
//		return "redirect:/view";
//	}
}
