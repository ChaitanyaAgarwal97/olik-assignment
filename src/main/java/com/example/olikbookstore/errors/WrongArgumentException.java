package com.example.olikbookstore.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WrongArgumentException extends IllegalArgumentException {
    public WrongArgumentException(String s) {
        super(s);
    }
}
