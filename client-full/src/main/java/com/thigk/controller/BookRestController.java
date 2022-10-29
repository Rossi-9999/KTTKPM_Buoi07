package com.thigk.controller;

import java.util.List;

import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.thigk.model.Book;
import com.thigk.repo.BookService;
import com.thigk.repo.ListenService;
import com.thigk.repo.SendService;

@RestController
@Component
public class BookRestController {
	@Autowired
	private BookService bookService;

//	@Autowired
//	private SendService sendService;
//
//	@Autowired
//	private ListenService listenService;
	
	@Autowired
	JmsTemplate jmsTemplate;

	@GetMapping("/view")
	public List<Book> view() {
		return bookService.getAll();
	}

	@PostMapping("/add")
	public void add(@RequestBody Book book) {
		bookService.save(book);
	}

	@GetMapping("/view/{id}")
	public Book getBook(@PathVariable("id") int id) {
		return bookService.getBook(id);
	}
	
//
//    @PostMapping("/send/{id}")
////    @RequestMapping(value = "/send/{id}", method = RequestMethod.POST)
//    public String sendProductNew(@PathVariable("id") int id) {
//        Book book = bookService.getBook(id);
//        return sendService.SendBook(book);
//    }
//    @GetMapping("/receive")
//    public Book receiveProductNew()  {
//        return listenService.receiveBook();
//    }
//    @PostMapping("/send")
////  @RequestMapping(value = "/send/{id}", method = RequestMethod.POST)
//  public String send() {
//      Book book = new Book(200, "Test", "Test");
//      return sendService.SendBook(book);
//  }

	@PostMapping("/send/{id}")
	public void sendMessage(@PathVariable("id") int id) throws JMSException, JsonProcessingException {
		 Book book = bookService.getBook(id);
		jmsTemplate.convertAndSend("inbound.queue", book);
	}
	@PostMapping("/send")
	public void sendMessageById(@RequestBody Book book) throws JMSException, JsonProcessingException {
		jmsTemplate.convertAndSend("inbound.queue", book);
	}
	
	@GetMapping("/receive")
	public Book getMessage() {
		return (Book) jmsTemplate.receiveAndConvert("inbound.queue");
	}
}
