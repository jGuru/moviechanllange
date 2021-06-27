package com.backbase.webapp.webmodulemoviecatalog.service;

import com.backbase.webapp.webmodulemoviecatalog.model.MovieDetail;
import com.backbase.webapp.webmodulemoviecatalog.model.MovieRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private RestTemplate restTemplate;


    public MovieDetail searchMovie(String movieName, String apiKey) {
        String url = "http://localhost:8080/v1/movieinfo/";
        MovieDetail md = (MovieDetail) restTemplate.getForObject(url   + movieName+"/"+ apiKey, MovieDetail.class);
        return md.getResponse().equalsIgnoreCase("True")?md:null;
    }

    public MovieRating saveRating(MovieRating movieRating)
    {
        HttpEntity<MovieRating> entity=new HttpEntity<>(movieRating,null);
        ResponseEntity<MovieRating>responseEntity=restTemplate.postForEntity("http://localhost:8080/v1/movieinfo/ratemovie",entity,MovieRating.class);
        return responseEntity.getBody();
    }

    public List<MovieRating> getTopRatedMovies(){
        String url = "http://localhost:8080/v1/movieinfo/toprated";
        ResponseEntity<List<MovieRating>> responseEntity=restTemplate.exchange(url, HttpMethod.GET,null,new ParameterizedTypeReference<List<MovieRating>>() {});
        return responseEntity.getBody();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
