package com.thigk.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.thigk.model.Book;
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private RestTemplate restTemplate;

	private String newURL;

	@Autowired
	private BookServiceImpl(RestTemplate Template, @Value("${url}") String url) {
		restTemplate = Template;
		newURL = url;
	}

	@Override
	public List<Book> getAll() {
		ResponseEntity<List<Book>> responseEntity = restTemplate.exchange(newURL, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Book>>() {
				});
		List<Book> sanPhams = responseEntity.getBody();
		return sanPhams;

	}

	@Override
	public void save(Book book) {
//		int sanphamID = book.getSubId();
//		if (sanphamID == 0) {
//			
//
//		}
		restTemplate.postForEntity(newURL, book, String.class);
	}
	public Book getBook(int id) {
		ResponseEntity<Book> responseEntity = restTemplate.exchange(newURL+"/"+id, HttpMethod.GET, null,
				new ParameterizedTypeReference<Book>() {
				});
		Book book = responseEntity.getBody();
		return book;
	}
}
