package spring.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.com.entity.HeadBook;

public interface HeadBookRepository extends JpaRepository<HeadBook,Long> {
}
