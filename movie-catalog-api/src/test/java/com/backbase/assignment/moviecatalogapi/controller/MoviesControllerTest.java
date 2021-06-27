package com.backbase.assignment.moviecatalogapi.controller;

import com.backbase.assignment.moviecatalogapi.model.MovieDetail;
import com.backbase.assignment.moviecatalogapi.service.MovieDetailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MoviesControllerTest {

    @Mock
    private MovieDetailService movieDetailService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getMovieDetail() throws Exception {
        String movieName = "The Hurt Locker";
        String apiKey = "cef547cf";
        MovieDetail md = new MovieDetail();
        md.setTitle(movieName);
        md.setWonBestPicture(true);
        md.setResponse("True");
        when(movieDetailService.getMovieDetail(movieName, apiKey)).thenReturn(new ResponseEntity<>(md, HttpStatus.OK));
        MvcResult mvcResult = mockMvc.perform(get("/v1/movieinfo/" + movieName + "/" + apiKey)).andExpect(status().isOk()).andReturn();
    }
}