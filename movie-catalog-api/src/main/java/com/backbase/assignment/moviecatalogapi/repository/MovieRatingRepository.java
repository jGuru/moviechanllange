package com.backbase.assignment.moviecatalogapi.repository;

import com.backbase.assignment.moviecatalogapi.model.MovieRating;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Data repository for getting and sorting for movie rating based on 10 top-rated rating ordered by boxoffice value.
 *
 * @author Neeraj Sharma
 * **/
@Repository
public interface MovieRatingRepository extends PagingAndSortingRepository<MovieRating, Integer> {
}
