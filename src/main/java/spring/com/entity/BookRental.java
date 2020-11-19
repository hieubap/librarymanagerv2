package spring.com.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "book_rental")
public class BookRental {
    @Id
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "bookRentalInBook", cascade = CascadeType.ALL)
    private List<Book> books ;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "borrowed_date")
    private Date borrowedDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "pay_date")
    private Date payDate;

    public BookRental() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(Date borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }
}
