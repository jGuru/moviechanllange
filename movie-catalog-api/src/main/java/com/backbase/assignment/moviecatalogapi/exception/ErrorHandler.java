package com.backbase.assignment.moviecatalogapi.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    private HttpHeaders headers;

    public ErrorHandler() {
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    /**
     * Builds the error response for a corresponding exception
     *
     * @param status  The http status
     * @param title   The title
     * @param details The details
     * @return ResponseEntity
     */
    private ResponseEntity<ErrorResponse> buildErrorResponse(HttpStatus status, String title, String details) {
        return new ResponseEntity<>(ErrorResponse.buildErrorResponse(title, details), headers, status);
    }

    /**
     * Generic error exception handler
     *
     * @param t The throwable
     * @return The response entity of the error response
     */
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ErrorResponse> genericError(Throwable t) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return buildErrorResponse(status, status.getReasonPhrase(), t.getMessage());
    }

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<ErrorResponse> movieNotFoundException(MovieNotFoundException e) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        return buildErrorResponse(status, status.getReasonPhrase(), e.getMessage());
    }

    @ExceptionHandler(InvalidAPIKeyException.class)
    public ResponseEntity<ErrorResponse> invalidAPIKeyException(InvalidAPIKeyException e) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return buildErrorResponse(status, status.getReasonPhrase(), e.getMessage());
    }
}
