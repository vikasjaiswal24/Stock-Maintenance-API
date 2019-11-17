package com.library.book.isbn.exception;

public class ISBNException extends RuntimeException {

	private static final long serialVersionUID = 3487449746577748032L;

	public ISBNException(String isbn) {
		super(isbn);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
