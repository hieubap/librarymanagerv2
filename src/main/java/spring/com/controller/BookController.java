package spring.com.controller;

import com.final_library.exception.bookexception.BookNotFoundException;
import com.final_library.exception.generalexception.ServerError;
import spring.com.entity.Book;
import com.final_library.response.Response;
import spring.com.entity.HeadBook;
import spring.com.exception.ApiRequestException;
import spring.com.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import spring.com.service.HeadBookService;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    private final BookService bookService;
    private final HeadBookService headBookService;

    @Autowired
    public BookController(BookService bookService,
                          HeadBookService headBookService) {
        this.bookService = bookService;
        this.headBookService = headBookService;
    }

    @RequestMapping(value = "/books/show", method = RequestMethod.GET)
    public Response<List<Book>> getAllBook() {
        try {
            List<Book> books = bookService.getAllBook();
            if (books.isEmpty()) {
                throw new ApiRequestException("books is empty");
            }
            return new Response<>(HttpStatus.OK, "Find all books", books);
        } catch (ServerError serverError) {
            throw new ServerError();
        }
    }

    @RequestMapping(value = "/books/add", method = RequestMethod.POST)
    public Response<Book> addBook(@RequestBody Book book) {
        try {

            if (book.getId() == null || book.getHeadBookId() == null) {
                throw new ApiRequestException("id/headbookid field of book is not null");
            }
            if (bookService.isExist(book.getId())) {
                throw new ApiRequestException("The given id is exist !");
            }
            if (!headBookService.isExist(book.getHeadBookId())){
                throw new ApiRequestException("this headbook with id = " + book.getHeadBookId() + " is not exist!");
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

            throw new ApiRequestException("this book is not exist");
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
            throw new ApiRequestException("this id is not exist");

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
