package com.example.final_library.exception.bookrentalexception;

public class BookRentalIsNullException extends RuntimeException {
    public BookRentalIsNullException() {
        super("Book Rental is not null");
    }
}
