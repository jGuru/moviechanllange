package com.backbase.assignment.moviecatalogapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * This class is used to hold rating information for a movie
 * It is supporting class for MovieDetail
 * @author Neeraj Sharma
 * @see MovieDetail
 * **/

public class Ratings implements Serializable {
    @JsonProperty("Source")
    private String source;
    @JsonProperty("Value")
    private String value;

    public Ratings() {
    }

    public Ratings(String source, String value) {
        this.source = source;
        this.value = value;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ratings ratings = (Ratings) o;
        return Objects.equals(source, ratings.source) &&
                Objects.equals(value, ratings.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, value);
    }
}
