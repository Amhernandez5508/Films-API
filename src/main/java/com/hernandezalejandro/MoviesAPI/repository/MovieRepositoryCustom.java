package com.hernandezalejandro.MoviesAPI.repository;

import java.util.List;

import com.hernandezalejandro.MoviesAPI.model.Movie;

public interface MovieRepositoryCustom {
	
	List<Movie> getAllMoviesByYearCriteria(Integer year);
	
	List<Movie> getAllMoviesByYearAndDuration(Integer year, Integer duration);

}
