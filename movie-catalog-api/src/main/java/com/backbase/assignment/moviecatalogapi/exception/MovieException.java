package com.backbase.assignment.moviecatalogapi.exception;


/**
 * Custom exception to represent the error scenario of invalid movie
 * @author Neeraj Sharma
 * **/
public class MovieException extends Exception {

    private String message;

    public MovieException() {
    }

    public MovieException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
