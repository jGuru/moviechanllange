package com.backbase.assignment.moviecatalogapi.repository;

import com.backbase.assignment.moviecatalogapi.model.MoviesAwardsInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Data repository for Movie awards info which was supplied as CSV
 * @see MoviesAwardsInfo
 * @author Neeraj Sharma
 * **/

@Repository
public interface MovieAwardsInfoRepository extends JpaRepository<MoviesAwardsInfo,Integer> {
    public MoviesAwardsInfo getMoviesAwardsInfoByNomineeAndCategory(String nominee, String category);
}
