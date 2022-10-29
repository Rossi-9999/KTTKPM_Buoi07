package com.thigk.repo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.thigk.model.Book;

@Component
public class ListenService {
	Book book = null;
	@JmsListener(destination = "test")
	public void receive(Book book) {
		this.book = book;
		System.out.println(book);
	}
	
	public Book receiveBook() {
		// TODO Auto-generated method stub
		return book;
	}
}
