package com.backbase.assignment.moviecatalogapi.exception;

/**
 * Custom exception to represent error scenario in case no movie found
 * @author Neeraj Sharma
 * **/
public class MovieNotFoundException extends MovieException {
    public MovieNotFoundException(String message){
        super(message);
    }
}
