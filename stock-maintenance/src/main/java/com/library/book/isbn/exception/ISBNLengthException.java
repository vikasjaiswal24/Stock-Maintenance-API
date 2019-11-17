package com.library.book.isbn.exception;

public class ISBNLengthException extends ISBNException {

	private static final long serialVersionUID = 4546824094716226374L;

	public ISBNLengthException(String isbn) {
		super(isbn);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
