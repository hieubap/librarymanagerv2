package com.example.final_library.controller;

import com.example.final_library.exception.bookexception.BookExistException;
import com.example.final_library.exception.bookexception.BookIsNullException;
import com.example.final_library.exception.bookexception.BookNotFoundException;
import com.example.final_library.exception.generalexception.ServerError;
import com.example.final_library.model.Book;
import com.example.final_library.response.Response;
import com.example.final_library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/books/show", method = RequestMethod.GET)
    public Response<List<Book>> getAllBook() {
        try {
            List<Book> books = bookService.getAllBook();
            if (books.isEmpty()) {
                throw new BookNotFoundException();
            }
            return new Response<>(HttpStatus.OK, "Find all books", books);
        } catch (ServerError serverError) {
            throw new ServerError();
        }
    }

    @RequestMapping(value = "/books/add", method = RequestMethod.POST)
    public Response<Book> addBook(@RequestBody Book book) {
        try {

            if (bookService.isExist(book.getId())) {
                throw new BookExistException();
            }
            if (book.getId() == null) {
                throw new BookIsNullException();
            }
            book.setId(book.getId());
            bookService.addBook(book);
            return new Response<>(HttpStatus.CREATED, "Create Successful", book);


        } catch (ServerError serverError) {
            throw new ServerError();
        }
    }

    @RequestMapping(value = "books/getOne", method = RequestMethod.GET)
    public Response<Optional<Book>> findBook(@RequestParam Long id) {
        try {
            if (bookService.isExist(id)) {
                Optional<Book> book = bookService.findBookById(id);
                return new Response<>(HttpStatus.OK, "information of book with id = " + id, book);
            }
            throw new BookNotFoundException();
        } catch (ServerError serverError) {
            throw new ServerError();
        }
    }

    @RequestMapping(value = "/books/update", method = RequestMethod.PUT)
    public Response<Book> update(@RequestBody Book book, @RequestParam Long id) {
        try {
            if (bookService.isExist(id)) {
                bookService.updateBook(book);
                return new Response<>(HttpStatus.OK, "Update Successful", book);
            }
            throw new BookNotFoundException();


        } catch (ServerError serverError) {
            throw new ServerError();
        }
    }

    @RequestMapping(value = "/books/delete", method = RequestMethod.DELETE)
    public Response<Optional<Book>> delete(@RequestParam Long id) {
        try {
            if (bookService.isExist(id)) {
                bookService.deleteBookById(id);
                return new Response<>(HttpStatus.OK, "Delete successful", bookService.findBookById(id));
            }
            throw new BookNotFoundException();

        } catch (ServerError serverError) {
            throw new ServerError();
        }
    }
}
