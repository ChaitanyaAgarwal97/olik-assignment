package com.example.olikbookstore.author;

import com.example.olikbookstore.errors.WrongArgumentException;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "authors")
public class Author {
    @Id
    @NotEmpty
    private String id;
    @NotEmpty
    private String name;
    private String biography;

    public Author(String id, String name, String biography) {
        this.id = id;
        this.name = name;
        this.biography = biography;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}
