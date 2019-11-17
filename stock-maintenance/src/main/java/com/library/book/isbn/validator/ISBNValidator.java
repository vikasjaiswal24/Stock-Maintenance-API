package com.library.book.isbn.validator;

import com.library.book.isbn.constant.Constant;
import com.library.book.isbn.exception.ISBNException;
import com.library.book.isbn.exception.ISBNFormatException;
import com.library.book.isbn.exception.ISBNLengthException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Vikas Jaiswal
 */

public class ISBNValidator {

    public boolean verifyISBN(String isbn) {


        if (isbn == null) {
            throw new ISBNFormatException(Constant.ERROR_MSG_NOT_NULL);
        } else if(isbn.length() == Constant.ISBN_10_DIGITS_LONG) {
            return validate10DigitsISBN(isbn);
        } else if(isbn.length() == Constant.ISBN_13_DIGITS_LONG && isbn.matches("[0-9]+")) {
            return validate13DigitsISBN(isbn);
        } else {
            throw new ISBNLengthException(Constant.ERROR_MSG_INCORRECT_LENGTH);
        }
    }

    private boolean validate10DigitsISBN(String isbn) {

        // Checking the first 9 digits, should only be numbers
        if (!isbn.substring(0,9).matches("[0-9]+")) {
            throw new ISBNFormatException(Constant.ERROR_MSG_FIRST_9_DIGITS);
        } else {
            // Checking last digit.
            char last = isbn.charAt(9);
            if (last != 'X' && (last < '0' || last > '9')) {
                throw new ISBNFormatException(Constant.ERROR_MSG_LAST_DIGIT);
            }
        }

        int sum = 0;

        for (int i = 0; i < Constant.ISBN_10_DIGITS_LONG; i++) {

            if(i == 9 && isbn.charAt(i)== 'X') {
                sum += 10;
            } else {
                sum += Character.getNumericValue(isbn.charAt(i))*(Constant.ISBN_10_DIGITS_LONG-i);
            }
        }
        return (sum % Constant.ISBN_10_DIGITS_MODULUS == 0);
    }

    private boolean validate13DigitsISBN(String isbn) {

        int sum =0;

        for (int i = 0; i < Constant.ISBN_13_DIGITS_LONG; i++) {

            if(i%2 == 0) {
                sum+= Character.getNumericValue(isbn.charAt(i));
            }
            else {
                sum+= Character.getNumericValue(isbn.charAt(i))*3;
            }
        }
        return (sum % Constant.ISBN_13_DIGITS_MODULUS == 0);
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input;
            while ((input = br.readLine()) != null) {
                input = input.trim();
                if(input.length() == 0) continue;
                boolean isbn = new ISBNValidator().verifyISBN(input.trim());
                if(isbn) {
                    System.out.println("Correct ISBN : " + isbn);
                } else {
                    System.err.println("[ERROR] Incorrect ISBN number : " + isbn);
                }
            }
        } catch (ISBNException isbnEx) {
            System.err.println(isbnEx.getMessage());
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }
}
