package spring.com.controller;//package com.example.final_library.controller;

import com.final_library.exception.bookexception.BookNotFoundException;
import com.final_library.exception.generalexception.ServerError;
import com.final_library.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import spring.com.entity.Book;
import spring.com.entity.HeadBook;
import spring.com.exception.ApiRequestException;
import spring.com.service.HeadBookService;

import java.util.List;
import java.util.Optional;

@RestController
public class HeadBookController {
    private final HeadBookService headbookService;

    @Autowired
    public HeadBookController(HeadBookService bookService) {
        this.headbookService = bookService;
    }

    // danh sách các đầu sách
    @RequestMapping(value = "/headbook/show", method = RequestMethod.GET)
    public Response<List<HeadBook>> getAllBook() {

        List<HeadBook> books = headbookService.getAllHeadBook();
        if (books.isEmpty()) {
            throw new ApiRequestException("headbooks is empty");
        }
        return new Response<List<HeadBook>>(HttpStatus.OK, "Find all headbooks", books);
    }

    @RequestMapping(value = "/headbook/add", method = RequestMethod.POST)
    public Response<HeadBook> addBook(@RequestBody HeadBook headBook) {
        try {

            if (headBook.getId() == null || headBook.getName() == null ||
            headBook.getAuthor() == null || headBook.getPublisher()== null ||
            headBook.getPrice() == null || headBook.getNumberOfPages() == null) {
                throw new ApiRequestException("id/name/author/publisher/price/numberofpage field of headbook is null");
            }
            if (headbookService.isExist(headBook.getId())) {
                throw new ApiRequestException("The given id is exist !");
            }

            headBook.setId(headBook.getId());
            headbookService.addHeadBook(headBook);
            return new Response<>(HttpStatus.CREATED, "Create Successful", headBook);
        } catch (ServerError serverError) {
            throw new ServerError();
        }
    }

    @RequestMapping(value = "headbook/getOne", method = RequestMethod.GET)
    public Response<Optional<HeadBook>> findBook(@RequestParam Long id) {
        try {
            if (headbookService.isExist(id)) {
                Optional<HeadBook> book = headbookService.findHeadBookById(id);
                return new Response<>(HttpStatus.OK, "information of headbook with id = " + id, book);
            }
            throw new BookNotFoundException();
        } catch (ServerError serverError) {
            throw new ServerError();
        }
    }

    @RequestMapping(value = "/headbook/update", method = RequestMethod.PUT)
    public Response<HeadBook> update(@RequestBody HeadBook book, @RequestParam Long id) {
        try {
            if (headbookService.isExist(id)) {
                headbookService.updateHeadBook(book);
                return new Response<>(HttpStatus.OK, "Update Successful", book);
            }
            throw new ApiRequestException("this id is not exist");
        } catch (ServerError serverError) {
            throw new ServerError();
        }
    }

    @RequestMapping(value = "/headbook/delete", method = RequestMethod.DELETE)
    public Response<Optional<HeadBook>> delete(@RequestParam Long id) {
        try {
            if (headbookService.isExist(id)) {
                headbookService.deleteHeadBookById(id);
                return new Response<>(HttpStatus.OK, "Delete successful", headbookService.findHeadBookById(id));
            }
            throw new BookNotFoundException();

        } catch (ServerError serverError) {
            throw new ServerError();
        }
    }
}
