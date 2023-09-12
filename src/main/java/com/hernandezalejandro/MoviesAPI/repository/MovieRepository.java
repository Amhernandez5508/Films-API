package com.hernandezalejandro.MoviesAPI.repository;

import java.util.List;

import com.hernandezalejandro.MoviesAPI.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovieRepository extends JpaRepository<Movie, Long>, MovieRepositoryCustom {
	
	@Query(nativeQuery=true, value= "SELECT id, name, summary, year_of_release, duration_in_minutes FROM movie WHERE name= :name")
	List<Movie> getAllMoviesByName(String name);

	List<Movie> findByYearOfRelease(Integer year);

	List<Movie> findByYearOfReleaseLessThan(Integer year);

}
