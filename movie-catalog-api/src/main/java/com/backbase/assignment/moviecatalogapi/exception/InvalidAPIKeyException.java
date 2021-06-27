package com.backbase.assignment.moviecatalogapi.exception;

/**
 * Custom exception class to handle error scenario of invalid key
 * @author Neeraj Sharma
 * **/

public class InvalidAPIKeyException extends Exception {
    private String message;

    public InvalidAPIKeyException(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
