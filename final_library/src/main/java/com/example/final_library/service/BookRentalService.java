package com.example.final_library.service;

import com.example.final_library.model.BookRental;
import com.example.final_library.repository.BookRentalRepository;
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