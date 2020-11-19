package spring.com.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @Column(name = "id")
    private Long id;
    private Long headBookId;
    @JsonFormat(pattern = "yyyy-mm-dd")
    @Column(name = "added_date")
    private Timestamp addedDate;

    private String status;// dang cho muon / mat / binh thuong
    private String note;

    @Column(name = "book_rental_id")
    private Long bookRentalId;

    @ManyToOne
    @JoinColumn(name = "book_rental_id",insertable = false,updatable = false)
    private BookRental bookRentalInBook;

    @ManyToOne
    @JoinColumn(name = "headBookId",insertable = false,updatable = false)
    private HeadBook headBook;

    public void setBook(Book book){
        if(book.getNote() != null){
            this.setNote(book.getNote());
        }
        if(book.getStatus() != null){
            this.setStatus(book.getStatus());
        }
        if(book.getAddedDate() != null){
            this.setAddedDate(book.getAddedDate());
        }
    }

    public BookRental getBookRentalInBook() {
        return bookRentalInBook;
    }

    public void setBookRentalInBook(BookRental bookRentalInBook) {
        this.bookRentalInBook = bookRentalInBook;
    }

    public Long getHeadBookId() {
        return headBookId;
    }

    public void setHeadBookId(Long headBookId) {
        this.headBookId = headBookId;
    }

    public HeadBook getHeadBook() {
        return headBook;
    }

    public void setHeadBook(HeadBook headBook) {
        this.headBook = headBook;
    }

    public Book(){
        this.addedDate = new Timestamp(System.currentTimeMillis());
        this.status = "tot";
        this.note = "";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Timestamp addedDate) {
        this.addedDate = addedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getBookRentalId() {
        return bookRentalId;
    }

    public void setBookRentalId(Long bookRentalId) {
        this.bookRentalId = bookRentalId;
    }

}
