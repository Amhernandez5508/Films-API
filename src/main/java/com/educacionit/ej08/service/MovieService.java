package com.educacionit.ej08.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educacionit.ej08.model.Movie;
import com.educacionit.ej08.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	MovieRepository movieRepository;

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
		//1 obtener el id del objeto que voy a modificar
		//2 buscar el objeto a modificar con getMovieById
		//3 verificar uno a uno los atributos y actualizar solo aquellos que vienen en el objeto nuevo
		movieRepository.save(movie);
	}

	public List<Movie> getAllMoviesByYear(Integer year) {
		return movieRepository.getAllMoviesByYear(year);
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
