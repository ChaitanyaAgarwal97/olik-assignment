package com.example.olikbookstore.book;

import com.example.olikbookstore.rental.Rental;
import com.example.olikbookstore.rental.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final RentalService rentalService;

    @Autowired
    public BookService(BookRepository bookRepository, RentalService rentalService) {
        this.bookRepository = bookRepository;
        this.rentalService = rentalService;
    }

    public List<Book> findAllBooks(String author, Boolean availableBooks, Boolean currentlyRented) {
        if (currentlyRented != null && currentlyRented) return findRentedBooks();
        if (availableBooks != null && availableBooks) return findAvailableBooks();
        if (author != null && !author.isBlank() ) return bookRepository.findByAuthor(author);
        return bookRepository.findAll();
    }

    public Optional<Book> findBookById(String id) {
        return bookRepository.findById(id);
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(String id, Book book) {
        book.setId(id);
        return bookRepository.save(book);
    }

    public void deleteBookById(String id) {
        bookRepository.deleteById(id);
    }

    public List<Book> findRentedBooks() {
        List<Rental> nonReturnedRentals = rentalService.findNonReturnedRentals();
        List<String> rentedBookId = nonReturnedRentals.stream().map(Rental::getBookId).toList();
        return bookRepository.findAllById(rentedBookId);
    }

    public List<Book> findAvailableBooks() {
        List<Rental> nonReturnedRentals = rentalService.findNonReturnedRentals();
        List<String> rentedBookId = nonReturnedRentals.stream().map(Rental::getBookId).toList();
        List<Book> allBooks = bookRepository.findAll();

        return allBooks.stream().filter(book -> !rentedBookId.contains(book.getId())).collect(Collectors.toList());
    }
}
