package com.thigk.repo;

import java.util.List;




import com.thigk.model.Book;

public interface BookService   {
	
	
   public List<Book> getAll();
	
	public void save(Book book);
	public Book getBook(int id);
	
}
