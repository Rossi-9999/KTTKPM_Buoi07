package com.thigk.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thigk.entity.Book;
@Repository
public interface BookService  extends  JpaRepository<Book,Integer>{

}
