package com.educacionit.ej08.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.educacionit.ej08.model.Movie;
import com.educacionit.ej08.service.MovieService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	@GetMapping(value="/")
	@Operation(summary="Devuelve el listado de todas las películas de la base sin paginación", description="No recibe argumentos de entrada", tags = {"Pelis"})
	@ApiResponses(value= {
			@ApiResponse(responseCode="200", description= "Está todo bien"),
			@ApiResponse(responseCode = "404", description = "No se encontraron películas en la bd!")
	})
	public @ResponseBody List<Movie> getAllMovies(){
		return movieService.getAllMovies();
	}
	
	@GetMapping(value="/{idMovie}")
	@Operation(summary="Devuelve una película según su id", description="Recibe el id de la película como parámetro de entrada", tags = {"Pelis"})
	@ApiResponses(value= {
			@ApiResponse(responseCode="200", description= "Se encontró la pelicula!"),
			@ApiResponse(responseCode = "404", description = "No se encontraró niguna película con ese id!")
	})
	public @ResponseBody Optional<Movie> getMovieByID(@Parameter(description="Id de la película") @PathVariable("idMovie") Long id){
		return movieService.getMovieById(id);

	}

	@Operation(summary="Permite ingresar una nueva peli", description="Recibe el objeto película en json", tags = {"Pelis"})
	@PostMapping(value="/", produces="application/json")
	public @ResponseBody void addMovie(Movie movie) {
		movieService.addMovie(movie);
	}

	@DeleteMapping(path="/{id}")
	@Operation(summary="Borra una película", description="No recibe argumentos de entrada", tags = {"Pelis"})
	public @ResponseBody void delMovie(@Parameter(description="id de la pelicula") @PathVariable("id") Long id) {
		movieService.delMovie(id);
	}

	@PutMapping(path="/", produces="application/json")
	@Operation(summary="Modifica una película", description="Recibe el objeto película", tags = {"Pelis"})
	public @ResponseBody void updMovie(Movie movie) {
		movieService.updMovie(movie);
	}

	@GetMapping(value="year/{year}")
	@Operation(summary="Devuelve un listado de peliculas según el año", description="Recibe el año en que se estrenó la película", tags = {"Native Query"})
	public @ResponseBody List<Movie> getAllMoviesByYear(@Parameter(description="Año de la peli") Integer year){
		return movieService.getAllMoviesByYear(year);
	}

	@GetMapping(value="yearcriteria/{year}")
	@Operation(summary="Devuelve un listado de peliculas según el año", description="Recibe el año en que se estrenó la película", tags = {"Criteria"})
	public @ResponseBody List<Movie> getAllMoviesByYearCriteria(@Parameter(description="Año de la peli") Integer year){
		return movieService.getAllMoviesByYearCriteria(year);

	}

	@GetMapping(value="yearandduration/")
	@Operation(summary="Devuelve un listado de peliculas según el año y la duración", description="Recibe el año en que se estrenó la película y la duración en minutos", tags = {"Criteria"})
	public @ResponseBody List<Movie> getAllMoviesByYearAndDuration(@RequestParam("year") Integer year, @RequestParam("duration") Integer duration){
		return movieService.getAllMoviesByYearAndDuration(year, duration);

	}

	@GetMapping(value="yearderived/{year}")
	@Operation(summary="Devuelve el listado de peliculas por año con derived query", description="Recibe el año en que se estrenó la película", tags = {"Derived Query"})
	public @ResponseBody List<Movie> getAllMoviesByYearDerived(@Parameter(description="Año de la peli") Integer year){
		return movieService.getAllMoviesByYearDerived(year);

	}

	@GetMapping(value="yearderivedlessthan/{year}")
	@Operation(summary="Devuelve el listado de peliculas anteriores a un año con derived query", description="Recibe el año en para filtrar", tags = {"Derived Query"})
	public @ResponseBody List<Movie> getAllMoviesWithYearLessThan(@Parameter(description="Año para filtrar") Integer year){
		return movieService.getAllMoviesWithYearLessThan(year);

	}

}
