package com.library.book.isbn.service;

import com.library.book.isbn.jpa.entity.Book;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public interface LibraryService {
	
	public Book addBook(Book book);

	public Book updateBook(Book book);
	
	public Book getBookByISBN(Integer isbn) throws EntityNotFoundException;

	public void deleteBook(Integer isbn) throws EntityNotFoundException;

	public List<Book> getAllBooks();

}