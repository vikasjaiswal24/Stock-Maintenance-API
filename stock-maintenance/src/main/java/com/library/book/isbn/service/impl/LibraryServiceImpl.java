package com.library.book.isbn.service.impl;

import com.library.book.isbn.constant.Constant;
import com.library.book.isbn.jpa.entity.Book;
import com.library.book.isbn.jpa.repository.BookRepository;
import com.library.book.isbn.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    BookRepository bookRepository;


    @Override
    public Book addBook(Book book) {
        boolean isBookExist = bookRepository.existsById(Integer.valueOf(book.getIsbn()));
        if(isBookExist) {
            System.out.println(Constant.BOOK_ALREADY_AVAILABLE);
            return null;
        } else {
            return bookRepository.save(book);
        }
    }

    @Override
    public Book updateBook(Book book) {
        return null;
    }

    @Override
    public Book getBookByISBN(Integer isbn) throws EntityNotFoundException {
        Book book = bookRepository.getOne(isbn);
        if(book == null) {
            throw new EntityNotFoundException(Constant.BOOK_NOT_FOUND);
        }
        return book;
    }

    @Override
    public void deleteBook(Integer isbn) throws EntityNotFoundException {
        boolean isBookExist = bookRepository.existsById(isbn);
        if(isBookExist) {
            bookRepository.deleteById(isbn);
        } else {
            throw new EntityNotFoundException(Constant.BOOK_NOT_FOUND);
        }
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> bookList = bookRepository.findAll();
        if(bookList == null) {
            throw new EntityNotFoundException(Constant.NO_BOOK_AVAILABLE_IN_LIBRARY);
        }
        return bookList;
    }
}
