package com.backbase.assignment.moviecatalogapi.service;

import com.backbase.assignment.moviecatalogapi.model.MovieDetail;
import com.backbase.assignment.moviecatalogapi.model.MovieRating;
import com.backbase.assignment.moviecatalogapi.repository.MovieRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

@Service
public class MovieDetailService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    MovieRatingRepository repository;

    //API KEY= cef547cf
    public ResponseEntity<MovieDetail> getMovieDetail(String movieName, String apiKey) {
        String url = "http://www.omdbapi.com/?apikey=";
        MovieDetail md = restTemplate.getForObject(url + apiKey + "&t=" + movieName, MovieDetail.class);
        return new ResponseEntity<>(md, HttpStatus.OK);
    }

    public MovieDetailService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public MovieDetailService() {
    }
}
