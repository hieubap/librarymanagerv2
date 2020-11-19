package com.example.final_library.exception.bookrentalexception;

public class BookRentalExistException extends RuntimeException{
    public BookRentalExistException() {
        super("Book rental is exist");
    }
}
