package spring.com.service;

import spring.com.entity.Book;
import spring.com.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void updateBook(Book book) {
        Book book1 = bookRepository.getOne(book.getId());
        book1.setBook(book);
        bookRepository.save(book1);
    }

    public Optional<Book> findBookById(Long id) {
        return bookRepository.findById(id);
    }


    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    public boolean isExist(Long id) {
        return bookRepository.findById(id).isPresent();
    }
}
