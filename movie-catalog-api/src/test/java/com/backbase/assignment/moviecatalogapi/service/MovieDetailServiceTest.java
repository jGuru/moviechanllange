package com.backbase.assignment.moviecatalogapi.service;

import com.backbase.assignment.moviecatalogapi.model.MovieDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class MovieDetailServiceTest {

    @MockBean
    private MovieDetailService movieDetailService;

    @Test
    public void getMovieDetail(){
        String movieName="The Hurt Locker";
        String apiKey="cef547cf";
        //String url = "http://www.omdbapi.com/?apikey=";
        MovieDetail md=new MovieDetail();
        md.setTitle(movieName);
        md.setWonBestPicture(true);
        md.setResponse("True");
        when(movieDetailService.getMovieDetail(movieName,apiKey)).thenReturn(new ResponseEntity<>(md, HttpStatus.OK));
        ResponseEntity<MovieDetail> responseEntity=movieDetailService.getMovieDetail(movieName,apiKey);
        assertThat(responseEntity.getBody().equals(md));
        assertThat(responseEntity.getStatusCode().equals(HttpStatus.OK));
    }
}