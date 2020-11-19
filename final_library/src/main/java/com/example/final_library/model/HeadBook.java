//package com.example.final_library.model;
//
//import javax.persistence.*;
//import java.util.Collection;
//
//@Entity
//@Table(name = "head_book")
//public class HeadBook {
//    @Id
//    @Column(name = "id")
//    private Long id;
//    @Column(name = "name")
//    private String name;
//    @Column(name = "publisher")
//    private String publisher;
//    @Column(name = "author")
//    private String author;
//    @Column(name = "nop")
//    private Long numberOfPages;
//    @Column(name = "price")
//    private Long price;
//    @OneToMany(mappedBy = "headBook",cascade = CascadeType.ALL)
//    private Collection<Book> books;
//
//    public HeadBook() {
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getPublisher() {
//        return publisher;
//    }
//
//    public void setPublisher(String publisher) {
//        this.publisher = publisher;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public Long getNumberOfPages() {
//        return numberOfPages;
//    }
//
//    public void setNumberOfPages(Long numberOfPages) {
//        this.numberOfPages = numberOfPages;
//    }
//
//    public Long getPrice() {
//        return price;
//    }
//
//    public void setPrice(Long price) {
//        this.price = price;
//    }
//
//    public Collection<Book> getBooks() {
//        return books;
//    }
//
//    public void setBooks(Collection<Book> books) {
//        this.books = books;
//    }
//}
