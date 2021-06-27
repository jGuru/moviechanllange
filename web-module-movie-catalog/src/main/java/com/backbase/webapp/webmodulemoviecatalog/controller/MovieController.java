package com.backbase.webapp.webmodulemoviecatalog.controller;

import com.backbase.webapp.webmodulemoviecatalog.model.MovieDetail;
import com.backbase.webapp.webmodulemoviecatalog.model.MovieRating;
import com.backbase.webapp.webmodulemoviecatalog.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

@Controller
public class MovieController {

    final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }


    @GetMapping("/")
    public RedirectView home() {
        return new RedirectView("/login");
    }
    @GetMapping("/menu")
    public String menu(){
        return "menu";
    }

    @GetMapping("/moviesearch")
    public String movieSearch(Model model){
        model.addAttribute("movieDetail", new MovieDetail());
        return "searchmovie";
    }

    @GetMapping("/ratemovie")
    public String rateMovie(Model model){
        model.addAttribute("movieDetail", new MovieDetail());
        return "ratemovie";
    }

    @PostMapping("/ratemovie")
    public String rateMovie(Model model,HttpServletRequest request){
       String movieName=request.getParameter("title");
       int rating=Integer.parseInt(request.getParameter("rating"));
       String apiKey=request.getParameter("apiKey");
       MovieDetail md=movieService.searchMovie(movieName,apiKey);
       if(md.getResponse().equalsIgnoreCase("False"))
       {
           model.addAttribute("message","The movie title you have provided is not found, please try again with another title.");
       }
       else{
           MovieRating movieRating=new MovieRating();
           movieRating.setMovieName(movieName);
           movieRating.setRating(rating);
           Number number=null;
           Locale locale = new Locale("en", "US");
           NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
           try {
               number=currencyFormatter.parse(md.getBoxOffice());
               movieRating.setBoxoffice(number.intValue());
           } catch (ParseException e) {
               e.printStackTrace();
           }
           movieRating.setBoxoffice(number.intValue());
           movieService.saveRating(movieRating);
           model.addAttribute("message","Movie "+movieRating.getMovieName()+" is rated successfully.");
       }
        return "ratemovie";
    }

    @PostMapping("/moviesearch")
    public String movieSearch(HttpServletRequest request, Model model){
        String movieName=request.getParameter("title");
        String apiKey=request.getParameter("apiKey");
        MovieDetail md=movieService.searchMovie(movieName,apiKey);
        model.addAttribute("movieDetail",md);
        return "searchresult";
    }

    @GetMapping("/topratedmovies")
    public String getTopRatedMovies(Model model){
        model.addAttribute("list",movieService.getTopRatedMovies());
        return "toprated";
    }

}
