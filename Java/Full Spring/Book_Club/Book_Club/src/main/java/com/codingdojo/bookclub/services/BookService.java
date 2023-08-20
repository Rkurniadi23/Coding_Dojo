package com.codingdojo.bookclub.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;
	
	public ArrayList<Book> findAll() {
		return bookRepo.findAll();
	}
	
	public Book addBook(Book book) {
		return bookRepo.save(book);
	}
	
	public Book findById(Long id){
		return bookRepo.findById(id).orElse(null);
	}
	
	public Book editBook(Book book) {
		return bookRepo.save(book);
	}
	
	public void deleteBook(Book book) {
		bookRepo.delete(book);
	}

}
