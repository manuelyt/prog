package com.rest.API.model;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue
    private Long id;
@NotBlank
    private String book_name;
@NotBlank
    private String author_name;
@NotBlank
    private String isbn;
public Book(){
        super();
    }
public Book(Long id, String book_name, String author_name, String isbn) {
        super();
        this.id = id;
        this.book_name = book_name;
        this.author_name = author_name;
        this.isbn=isbn;
    }
public Long getId() {
        return id;
    }
public void setId(Long id) {
        this.id = id;
    }
public String getBook_name() {
        return book_name;
    }
public void setBook_name(String book_name) {
        this.book_name = book_name;
    }
public String getAuthor_name() {
        return author_name;
    }
public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }
public String getIsbn() {
        return isbn;
    }
public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}