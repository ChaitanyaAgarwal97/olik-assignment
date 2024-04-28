package com.example.olikbookstore.author;

import com.example.olikbookstore.author.AuthorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("")
    public List<Author> findAll() {
        return authorService.findAllAuthors();
    }

    @GetMapping("/{id}")
    public Optional<Author> findById(@PathVariable String id) {
        return authorService.findAuthorById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Author create(@Valid @RequestBody Author author) {
        return authorService.createAuthor(author);
    }

    @PutMapping("/{id}")
    public Author update(@PathVariable String id, @Valid @RequestBody Author author) {
        return authorService.updateAuthor(id, author);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        authorService.deleteAuthorById(id);
    }
}
