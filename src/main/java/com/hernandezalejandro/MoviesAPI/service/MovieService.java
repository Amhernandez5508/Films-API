package com.hernandezalejandro.MoviesAPI.service;

import java.util.List;
import java.util.Optional;

import com.hernandezalejandro.MoviesAPI.repository.MovieRepositoryCustomImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hernandezalejandro.MoviesAPI.model.Movie;
import com.hernandezalejandro.MoviesAPI.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	MovieRepositoryCustomImpl movieRepositoryCustomImpl;

	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	public Optional<Movie> getMovieById(Long id) {
		return movieRepository.findById(id);
	}

	public void addMovie(Movie movie) {
		movieRepository.save(movie);
	}

	public void delMovie(Long id) {
		movieRepository.deleteById(id);
	}

	public void updMovie(Movie movie) {
		Optional<Movie> movieAux = getMovieById((Long) movie.getId());
		if (movieAux.isPresent()){
			
			movieAux.get().setId(movie.getId());
			
			if( !movieAux.get().getName().equals(movie.getName()) ) {
				movieAux.get().setName(movie.getName());
			}
			
			if( !movieAux.get().getSummary().equals(movie.getSummary()) ) {
				movieAux.get().setSummary(movie.getSummary());
			}
			
			if( !movieAux.get().getDurationInMinutes().equals(movie.getDurationInMinutes()) ) {
				movieAux.get().setDurationInMinutes(movie.getDurationInMinutes());
			}
			
			if( !movieAux.get().getYearOfRelease().equals(movie.getYearOfRelease()) ) {
				movieAux.get().setYearOfRelease(movie.getYearOfRelease());
			}
			
			movieRepository.save(movieAux.get());
		}
	}

	public List<Movie> getAllMoviesByName(String name) {
		return movieRepository.getAllMoviesByName(name);
	}

	public List<Movie> getAllMoviesByYearCriteria(Integer year) {
		return movieRepository.getAllMoviesByYearCriteria(year);
	}

	public List<Movie> getAllMoviesByYearAndDuration(Integer year, Integer duration) {
		return movieRepository.getAllMoviesByYearAndDuration(year, duration);
	}

	public List<Movie> getAllMoviesByYearDerived(Integer year) {
		return movieRepository.findByYearOfRelease(year);
	}

	public List<Movie> getAllMoviesWithYearLessThan(Integer year) {
		return movieRepository.findByYearOfReleaseLessThan(year);
	}

}
