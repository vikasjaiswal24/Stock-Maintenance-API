package com.library.book.isbn.demoData;

import com.coremedia.domain.ProductRequest;
import com.library.book.isbn.jpa.entity.Book;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CreateDemoData {

    public static List<Book> createDemoData() {

        List<Book> bookList = new ArrayList<>();

        Book book = new Book();

        book.setIsbn("007007013X");
        book.setAuthor("Vikas Jaiswal");
        book.setTitle("How to become a successful Software developer !!!!");
        bookList.add(book);

        book.setIsbn("1555120105");
        book.setAuthor("Peter");
        book.setTitle("How to become a successful Sales Partner");
        bookList.add(book);

        book.setIsbn("0136091814");
        book.setAuthor("Frank");
        book.setTitle("How to become a successful Manager");
        bookList.add(book);

        book.setIsbn("123456789X");
        book.setAuthor("Armando");
        book.setTitle("How to become a successful Leader");
        bookList.add(book);

        return bookList;
    }
}
