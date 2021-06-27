package com.backbase.webapp.webmodulemoviecatalog.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * class to represent movie rating
 * @author Neeraj Sharma
 * **/

public class MovieRating implements Serializable {

    private Integer id;
    private Integer rating;
    private Integer boxoffice;
    private String movieName;

    public MovieRating(){}
    public MovieRating(Integer id, String movieName, Integer rating, Integer boxoffice){
        this.id=id;
        this.movieName=movieName;
        this.rating=rating;
        this.boxoffice=boxoffice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getBoxoffice() {
        return boxoffice;
    }

    public void setBoxoffice(Integer boxoffice) {
        this.boxoffice = boxoffice;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieRating that = (MovieRating) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(rating, that.rating) &&
                Objects.equals(boxoffice, that.boxoffice) &&
                Objects.equals(movieName, that.movieName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rating, boxoffice, movieName);
    }
}
