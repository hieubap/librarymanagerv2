package spring.com.service;

import spring.com.entity.BookRental;
import spring.com.repository.BookRentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookRentalService {
    private final BookRentalRepository bookRentalRepository;

    @Autowired
    public BookRentalService(BookRentalRepository bookRentalRepository) {
        this.bookRentalRepository = bookRentalRepository;
    }

    public List<BookRental> getAllBookRental() {
        return bookRentalRepository.findAll();
    }

    public void createBookRental(BookRental bookRental) {
        bookRentalRepository.save(bookRental);
    }

    public void updateBookRental(BookRental bookRental) {
        bookRentalRepository.save(bookRental);
    }

    public Optional<BookRental> findBookRentalById(Long id) {
        return bookRentalRepository.findById(id);
    }


    public void deleteBookRentalById(Long id) {
        bookRentalRepository.deleteById(id);
    }

    public boolean isExist(Long id) {
        return bookRentalRepository.findById(id).isPresent();
    }
}