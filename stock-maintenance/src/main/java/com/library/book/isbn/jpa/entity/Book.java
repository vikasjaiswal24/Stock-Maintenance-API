package com.library.book.isbn.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Vikas Jaiswal
 */

@Entity
public class Book {

	@Id	// Primary key in the database
	private String isbn;
	private String author;
	private String title;
	private int numberOfComments;

	public Book() {

	}

	public Book(String isbn, String author, String title, int numberOfComments) {
		super();
		this.isbn = isbn;
		this.author = author;
		this.title = title;
		this.numberOfComments = numberOfComments;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNumberOfComments() {
		return numberOfComments;
	}

	public void setNumberOfComments(int numberOfComments) {
		this.numberOfComments = numberOfComments;
	}

	@Override
	public String toString() {
		return "Book Details [isbn : " + isbn + ", author : " + author
				+ ", title : " + title + ", numberOfComments : " + numberOfComments + "]";
	}
}