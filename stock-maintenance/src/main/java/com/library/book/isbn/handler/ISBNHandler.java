package com.library.book.isbn.handler;

import com.library.book.isbn.constant.Constant;
import com.library.book.isbn.exception.ISBNException;
import com.library.book.isbn.exception.ISBNFormatException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ISBNHandler {

    /**
     * Converts the ID to ISBN number.
     */
    public String calculateISBN(String id) {

        if(id == null || id.length() != 12 || !id.matches("[0-9]+")) {
            throw new ISBNFormatException(Constant.ERROR_MSG_ID_NOT_VALID);
        }
        String first9ISBNDigits = id.substring(3);

        return first9ISBNDigits + calculateLastDigitForErrorControl(first9ISBNDigits);
    }

    /**
     * Calculates the last digit for error control.
     */
    public String calculateLastDigitForErrorControl(String first9ISBNDigits) {

        int sum = 0;
        int lastDigit = 0;

        for(int i = 0; i < first9ISBNDigits.length() ; i++) {
            sum += Character.getNumericValue(first9ISBNDigits.charAt(i))*(Constant.ISBN_10_DIGITS_LONG-i);
        }

        int mod = sum % Constant.ISBN_10_DIGITS_MODULUS;
        if (mod != 0) {
            lastDigit = Constant.ISBN_10_DIGITS_MODULUS - mod;
            if(lastDigit == 10) {
                return "X";
            }
        } else {
            lastDigit = mod;
        }
        return String.valueOf(lastDigit);
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input;
            while ((input = br.readLine()) != null) {
                input = input.trim();
                if(input.length() == 0) continue;
                String isbn = new ISBNHandler().calculateISBN(input.trim());
                System.out.println("Calculated ISBN : " + isbn);
            }
        } catch (ISBNException isbnEx) {
            System.err.println(isbnEx.getMessage());
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }
}
