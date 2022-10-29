package com.thigk.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.thigk.model.Book;

@Service
public class SendService {

	@Autowired
	JmsTemplate jTemplate; 
	String topic = "jpa-topic";
	
	public String SendBook(Book book) {
		jTemplate.convertAndSend("test", book); 
		return "Send successfull : " + book.toString();
	}
}
 