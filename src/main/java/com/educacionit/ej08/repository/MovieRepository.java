package com.educacionit.ej08.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.educacionit.ej08.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>, MovieRepositoryCustom {
	
	@Query(nativeQuery=true, value= "SELECT id, name, summary, year_of_release, duration_in_minutes FROM movie WHERE year_of_release= :year")
	List<Movie> getAllMoviesByYear(Integer year);

	List<Movie> findByYearOfRelease(Integer year);

	List<Movie> findByYearOfReleaseLessThan(Integer year);

}
