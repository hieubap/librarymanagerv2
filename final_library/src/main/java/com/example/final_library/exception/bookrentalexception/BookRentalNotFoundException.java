package com.example.final_library.exception.bookrentalexception;

public class BookRentalNotFoundException extends RuntimeException {
    public BookRentalNotFoundException() {
        super("Book Rental is not found");
    }

}
