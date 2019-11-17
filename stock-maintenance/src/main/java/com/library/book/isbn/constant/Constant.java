package com.library.book.isbn.constant;

public class Constant {

    //Constants for 10 digits ISBN
    public static final int ISBN_10_DIGITS_MODULUS = 11;
    public static final int ISBN_10_DIGITS_LONG = 10;

    //Constants for 13 digits ISBN
    public static final int ISBN_13_DIGITS_MODULUS = 10;
    public static final int ISBN_13_DIGITS_LONG = 13;

    // Error messages
    public static final String ERROR_MSG_NOT_NULL = "ISBN number can not be null";
    public static final String ERROR_MSG_INCORRECT_LENGTH = "ISBN number can only be 10 digits (with/without 'X' as last char) or 13 digits long";
    public static final String ERROR_MSG_FIRST_9_DIGITS = "Incorrect ISBN number, first 9 digits can not be other than [0-9]";
    public static final String ERROR_MSG_LAST_DIGIT = "Incorrect ISBN number, Only the last digit can be [0-9] or 'X'";
    public static final String ERROR_MSG_ID_NOT_VALID = "ID is not valid for the conversion to ISBN number";
}
