package com.example.final_library.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @JsonFormat(pattern = "yyyy-mm-dd")
    @Column(name = "added_date")
    private Date addedDate;
    @Column(name = "status")
    private boolean status;
    @Column(name = "note")
    private String note;

    @Column(name = "book_rental_id")
    private Long bookRentalId;

    //    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "book_rental_id",insertable = false,updatable = false)
    private BookRental bookRentalInBook;

//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "head_book")
//    private HeadBook headBook;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
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

    @JsonBackReference
    public BookRental getBookRentalInBook() {
        return bookRentalInBook;
    }

    public void setBookRentalInBook(BookRental bookRentalInBook) {
        this.bookRentalInBook = bookRentalInBook;
    }

}
