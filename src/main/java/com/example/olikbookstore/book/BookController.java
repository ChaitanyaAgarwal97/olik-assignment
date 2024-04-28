package com.example.olikbookstore.book;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public List<Book> findAll(@RequestParam(name="author", required = false) String author, @RequestParam(name="availableBooks", required = false) Boolean availableBooks, @RequestParam(name="currentlyRented", required = false) Boolean currentlyRented) {
        return bookService.findAllBooks(author, availableBooks, currentlyRented);
    }

    @GetMapping("/{id}")
    public Optional<Book> findById(@PathVariable String id) {
        return bookService.findBookById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Book create(@Valid @RequestBody Book book) {
        return bookService.createBook(book);
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable String id, @Valid @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        bookService.deleteBookById(id);
    }
}
