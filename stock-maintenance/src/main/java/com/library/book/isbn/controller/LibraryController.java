package com.library.book.isbn.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.library.book.isbn.demoData.CreateDemoData;
import com.library.book.isbn.jpa.entity.Book;
import com.library.book.isbn.service.LibraryService;
import com.library.book.isbn.validator.ISBNValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Vikas Jaiswal
 */

@RestController
@RequestMapping(value = "/library")
public class LibraryController {

    private static final Logger logger = LoggerFactory.getLogger(LibraryController.class);

    @Autowired
    LibraryService libraryService;

    /*
     * This method is used to add a book into Library.
     */
	@PostMapping(path = "/addBook",
			consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Book> addBook(@Valid @RequestBody Book book) {
		logger.info(LibraryController.class + "Received POST request for adding a book !!");
        Book addedBook = null;
        if (book.getIsbn() != null && book.getAuthor() != null && book.getTitle() != null) {
            ISBNValidator isbnValidator = new ISBNValidator();
            if (isbnValidator.verifyISBN(book.getIsbn())) {
                addedBook = libraryService.addBook(book);
                return new ResponseEntity<>(addedBook, HttpStatus.CREATED);
            }
        }
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

    @GetMapping(path = "/addBooksDemoData")
    public ResponseEntity<Book> updateStock() {
        logger.info("Received GET request for adding books !!");
        CreateDemoData.createDemoData();
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    /*
     * This method is used to get the book details based on the isbn.
     */
    @GetMapping(path = "/getBook")
    public ResponseEntity<Book> getBook(@Valid @NotNull @RequestParam("isbn") Integer isbn) {
        logger.info("Received GET request for isbn: " + isbn);
        Book book = libraryService.getBookByISBN(isbn);

        if (book != null) {
            return new ResponseEntity<>(book, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /*
     * This method is used to get all the books in the library.
     */
    @GetMapping(path = "/allBooks")
    public List<Book> showAllBooks() {
        logger.info("Received GET request for all the stocks !!");
        List<Book> bookList = libraryService.getAllBooks();
        return bookList;
    }
}
