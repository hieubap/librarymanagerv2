package spring.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.com.entity.HeadBook;
import spring.com.repository.HeadBookRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HeadBookService {
    private final HeadBookRepository headBookRepository;

    @Autowired
    public HeadBookService(HeadBookRepository headBookRepository) {
        this.headBookRepository = headBookRepository;
    }

    public List<HeadBook> getAllHeadBook() {
        return headBookRepository.findAll();
    }

    public Optional<HeadBook> findHeadBookById(Long id) {
        return headBookRepository.findById(id);
    }

    public void addHeadBook(HeadBook headBook) {
        headBookRepository.save(headBook);
    }

    public void updateHeadBook(HeadBook headBook) {
        HeadBook headBook1 = headBookRepository.getOne(headBook.getId());
        headBook1.setHeadBook(headBook);
        headBookRepository.save(headBook1);
    }




    public void deleteHeadBookById(Long id) {
        headBookRepository.deleteById(id);
    }

    public boolean isExist(Long id){
        return headBookRepository.findById(id).isPresent();
    }
}
