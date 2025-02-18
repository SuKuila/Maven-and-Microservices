 package com.cg.restapi;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cg.model.Movie;
import com.cg.service.MovieService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/movies")
public class MovieCatalogue {
	@Autowired
	private MovieService movieService;
	@PostMapping
	public ResponseEntity<Movie> addMovie(@RequestBody @Valid Movie m) {
		return new ResponseEntity<Movie>(movieService.addNewMovieService(m),HttpStatus.CREATED);
	}
	@PostMapping("/{mid}")
	public ResponseEntity<Movie> updateMovie(@RequestBody @Valid   Movie m,@PathVariable("mid") int mid) {
		return new ResponseEntity<Movie>(movieService.addNewMovieService(m),HttpStatus.ACCEPTED);
	}
	@GetMapping
	public List<Movie> listAllMovies(){
		 return movieService.allmoviesService();
	}
	@GetMapping("/{mid}")	
	public Movie searchById(@PathVariable int mid) {
		 //call service
		 return movieService.searchMovieService(mid);
	}
	@DeleteMapping("/{mid}")
	public void deleteMovie(@PathVariable   int mid) {
		 movieService.deleteMovieService(mid);
	}
	@GetMapping("/searchgenre")
	public List<Movie> searchByGenre(@RequestParam("genre") String genre) {
		 return movieService.searchByGenreService(genre);
	}
	@GetMapping("/searchlang")
	public List<Movie> searchByLang(@RequestParam("language") String lang) {
		
		 return movieService.searchByLanguageService(lang);
	}
	@GetMapping("/searchbyDate")
	public List<Movie> searchByDate(@RequestParam("date") LocalDate date){
		return movieService.searchBydate(date);
	}
}
