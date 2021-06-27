package com.backbase.assignment.moviecatalogapi.exception;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;

/**
 * Domain class to hold the error response
 *
 * @author Neeraj Sharma
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse implements Serializable {
    private String title;
    private String details;

    /**
     * ErrorResponse constructor to construct error title and details
     *
     * @param title   The error title
     * @param details The error details
     */
    private ErrorResponse(String title, String details) {
        this.title = title;
        this.details = details;
    }

    /**
     * Builds the error response
     *
     * @param title   The error title
     * @param details The error details
     * @return ErrorResponse
     */
    public static ErrorResponse buildErrorResponse(String title, String details) {
        return new ErrorResponse(title, details);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
