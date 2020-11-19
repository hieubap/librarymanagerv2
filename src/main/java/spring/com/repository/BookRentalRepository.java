package spring.com.repository;

import spring.com.entity.BookRental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRentalRepository extends JpaRepository<BookRental, Long> {
}
