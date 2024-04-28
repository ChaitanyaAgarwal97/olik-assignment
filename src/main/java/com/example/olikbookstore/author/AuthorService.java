package com.example.olikbookstore.author;

import com.example.olikbookstore.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public Optional<Author> findAuthorById(String id) {
        return authorRepository.findById(id);
    }

    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author updateAuthor(String id, Author author) {
        author.setId(id);
        return authorRepository.save(author);
    }

    public void deleteAuthorById(String id) {
        authorRepository.deleteById(id);
    }
}
