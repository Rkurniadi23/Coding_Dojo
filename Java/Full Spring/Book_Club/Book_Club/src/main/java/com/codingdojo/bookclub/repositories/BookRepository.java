package com.codingdojo.bookclub.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.models.User;

public interface BookRepository extends CrudRepository<Book, Long>{
	public ArrayList<Book> findAll();
	public ArrayList<Book> findAllByUser(User user);
}
