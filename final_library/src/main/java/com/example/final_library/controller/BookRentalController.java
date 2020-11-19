package com.example.final_library.controller;


import com.example.final_library.exception.bookexception.BookIsNullException;
import com.example.final_library.exception.bookexception.BookNotFoundException;
import com.example.final_library.exception.bookrentalexception.BookRentalExistException;
import com.example.final_library.exception.bookrentalexception.BookRentalIsNullException;
import com.example.final_library.exception.bookrentalexception.BookRentalNotFoundException;
import com.example.final_library.exception.generalexception.ServerError;
import com.example.final_library.model.BookRental;
import com.example.final_library.response.Response;
import com.example.final_library.service.BookRentalService;
import com.example.final_library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookRentalController {
    private final BookRentalService bookRentalService;
    private final BookService bookService;

    @Autowired
    public BookRentalController(BookRentalService bookRentalService, BookService bookService) {
        this.bookRentalService = bookRentalService;
        this.bookService = bookService;
    }

    @RequestMapping(value = "bookRentals/show", method = RequestMethod.GET)
    public Response<List<BookRental>> getAllBooks() {
        try {
            List<BookRental> bookRentals = bookRentalService.getAllBookRental();
            if (bookRentals.isEmpty()) {
                throw new BookRentalNotFoundException();
            }
            return new Response<>(HttpStatus.OK, "Find all book rental", bookRentalService.getAllBookRental());

        } catch (ServerError serverError) {
            throw new ServerError();
        }
    }

    @RequestMapping(value = "/bookRentals/add", method = RequestMethod.POST)
    public Response<BookRental> addBook(@RequestBody BookRental bookRental) {
        try {

            if (bookRentalService.isExist(bookRental.getId())) {
                throw new BookRentalExistException();
            }
            if (bookRental.getId() == null) {
                throw new BookRentalIsNullException();
            }
            if (bookRental.getBooks() == null) {
                throw new BookIsNullException();
            }
            bookRental.getBooks().forEach(book -> {
                if (!bookService.findBookById(book.getId()).isPresent()) {
                    throw new BookNotFoundException();
                }
            });
            bookRental.getBooks().forEach(book -> {
                book.setBookRentalId(bookRental.getId());
                bookService.updateBook(book);
            });


            bookRental.setId(bookRental.getId());
            bookRentalService.createBookRental(bookRental);
            return new Response<>(HttpStatus.CREATED, "Create Successful", bookRental);


        } catch (
                ServerError serverError) {
            throw new ServerError();
        }

    }

    @RequestMapping(value = "bookRentals/getOne", method = RequestMethod.GET)
    public Response<Optional<BookRental>> findBook(@RequestParam Long id) {
        try {
            if (bookRentalService.isExist(id)) {
                Optional<BookRental> bookRental = bookRentalService.findBookRentalById(id);
                return new Response<>(HttpStatus.OK, "information of book with id = " + id, bookRental);
            }
            throw new BookRentalNotFoundException();
        } catch (ServerError serverError) {
            throw new ServerError();
        }
    }

    @RequestMapping(value = "/bookRentals/update", method = RequestMethod.PUT)
    public Response<BookRental> update(@RequestBody BookRental bookRental, @RequestParam Long id) {
        try {
            if (bookRentalService.isExist(id)) {
                bookRentalService.updateBookRental(bookRental);
                return new Response<>(HttpStatus.OK, "Update Successful", bookRental);
            }
            throw new BookRentalNotFoundException();


        } catch (ServerError serverError) {
            throw new ServerError();
        }
    }

    @RequestMapping(value = "/bookRentals/delete", method = RequestMethod.DELETE)
    public Response<Optional<BookRental>> delete(@RequestParam Long id) {
        try {
            if (bookRentalService.isExist(id)) {
                bookRentalService.deleteBookRentalById(id);
                return new Response<>(HttpStatus.OK, "Delete successful", bookRentalService.findBookRentalById(id));
            }
            throw new BookNotFoundException();

        } catch (ServerError serverError) {
            throw new ServerError();
        }
    }
}
