package com.backbase.assignment.moviecatalogapi.controller;

import com.backbase.assignment.moviecatalogapi.exception.InvalidAPIKeyException;
import com.backbase.assignment.moviecatalogapi.exception.MovieNotFoundException;
import com.backbase.assignment.moviecatalogapi.model.MovieDetail;
import com.backbase.assignment.moviecatalogapi.model.MovieRating;
import com.backbase.assignment.moviecatalogapi.model.MoviesAwardsInfo;
import com.backbase.assignment.moviecatalogapi.repository.MovieAwardsInfoRepository;
import com.backbase.assignment.moviecatalogapi.repository.MovieRatingRepository;
import com.backbase.assignment.moviecatalogapi.service.MovieDetailService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/movieinfo")
public class MoviesController {

    private final MovieRatingRepository repository;
    private final MovieDetailService movieDetailService;
    private final MovieAwardsInfoRepository movieAwardsInfoRepository;
    public MoviesController(MovieRatingRepository repository, MovieDetailService movieDetailService, MovieAwardsInfoRepository movieAwardsInfoRepository) {
        this.repository = repository;
        this.movieDetailService = movieDetailService;
        this.movieAwardsInfoRepository = movieAwardsInfoRepository;
    }

    @GetMapping("/{movieName}/{apiKey}")
    public ResponseEntity<MovieDetail> getMovieDetail(@PathVariable String movieName, @PathVariable String apiKey) throws MovieNotFoundException, InvalidAPIKeyException {
        ResponseEntity<MovieDetail> responseEntity=movieDetailService.getMovieDetail(movieName,apiKey);
        MovieDetail md=responseEntity.getBody();
        if(md.getResponse().equalsIgnoreCase("false")&&md.getError().equalsIgnoreCase("Movie not found!")){
            throw new MovieNotFoundException("The movie "+movieName+" not found.");
        }
        if(md.getResponse().equalsIgnoreCase("false")&&md.getError().equalsIgnoreCase("Invalid API key!")){
            throw new InvalidAPIKeyException("The API key is invalid, please check the your API key.");
        }
        MoviesAwardsInfo moviesAwardsInfo=movieAwardsInfoRepository.getMoviesAwardsInfoByNomineeAndCategory(movieName,"Best Picture");
        if(moviesAwardsInfo!=null& moviesAwardsInfo.getWon().equalsIgnoreCase("YES"))
        {
            md.setWonBestPicture(true);
        }
        else {
            md.setWonBestPicture(false);
        }
         return new ResponseEntity<>(md, HttpStatus.OK);
    }
    @GetMapping("/toprated")
    public ResponseEntity<List<MovieRating>> getTopRatedMovies()
    {
        Pageable pageable=PageRequest.of(0,10, Sort.by(Sort.Direction.DESC,"boxoffice","rating"));
        Page<MovieRating> all=repository.findAll(pageable);
        ArrayList<MovieRating> movieRatingArrayList=new ArrayList<>();
        if(all.getTotalPages()>0){
            for(MovieRating mr:all.getContent())
                movieRatingArrayList.add(mr);
        }
        return new ResponseEntity<>(movieRatingArrayList,HttpStatus.OK);
    }

    @PostMapping(path="/ratemovie",consumes = "application/json", produces = "application/json")
    public ResponseEntity<MovieRating> rateMovie(@RequestBody MovieRating movieRating) {
        MovieRating mr=repository.save(movieRating);
        return new ResponseEntity<MovieRating>(mr,HttpStatus.CREATED);
    }
}
