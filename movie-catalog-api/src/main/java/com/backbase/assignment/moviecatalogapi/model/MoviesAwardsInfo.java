package com.backbase.assignment.moviecatalogapi.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * Entity class to represent the model for awards which is initially supplied in CSV format
 * @author Neeraj Sharma
 * **/
@Entity(name = "awards")
public class MoviesAwardsInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "yr")
    private String year;
    @Column(name = "category")
    private String category;
    @Column(name = "nominee")
    private String nominee;
    @Column(name = "info")
    private String info;
    @Column(name = "won")
    private String won;

    public MoviesAwardsInfo() {
    }

    public MoviesAwardsInfo(String year, String category, String nominee, String info, String won) {
        this.year = year;
        this.category = category;
        this.nominee = nominee;
        this.info = info;
        this.won = won;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNominee() {
        return nominee;
    }

    public void setNominee(String nominee) {
        this.nominee = nominee;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getWon() {
        return won;
    }

    public void setWon(String won) {
        this.won = won;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoviesAwardsInfo that = (MoviesAwardsInfo) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(year, that.year) &&
                Objects.equals(category, that.category) &&
                Objects.equals(nominee, that.nominee) &&
                Objects.equals(info, that.info) &&
                Objects.equals(won, that.won);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, year, category, nominee, info, won);
    }

    public String toString()
    {
        return this.id+" : "+this.year+" : "+this.category+" : "+this.nominee+" : "+this.info+" : "+this.won;
    }
}
