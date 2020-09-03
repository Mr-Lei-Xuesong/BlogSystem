package com.demo.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFondException extends RuntimeException {

    public NotFondException() {
    }

    public NotFondException(String message) {
        super(message);
    }

    public NotFondException(String message, Throwable cause) {
        super(message, cause);
    }
}
