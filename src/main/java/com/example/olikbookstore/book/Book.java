package com.example.olikbookstore.book;

import com.example.olikbookstore.author.Author;
import com.example.olikbookstore.errors.WrongArgumentException;
import com.example.olikbookstore.utils.ISBNValidator;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

import java.time.Year;
import java.util.Date;

@Document("books")
public class Book {
    @Id
    @NotEmpty
    private String id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String author;

    @NotEmpty
    private String isbn;

    private int publicationYear;

    public Book(String id, String title, String author, String isbn, int publicationYear) {
        if (!ISBNValidator.isValidISBN(isbn)) throw new WrongArgumentException("Wrong isbn format");
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
}
