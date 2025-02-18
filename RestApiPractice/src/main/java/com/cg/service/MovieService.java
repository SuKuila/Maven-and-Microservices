package com.cg.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.model.Movie;

public interface MovieService {
	Movie addNewMovieService(Movie m);
	Movie searchMovieService(int movieCode);
	List<Movie> allmoviesService();
	List<Movie> searchByGenreService(String genre);
	List<Movie> searchByLanguageService(String genre);
	Movie updateMovieService(Movie m, int movieId);
	void deleteMovieService(int movieId);
	List<Movie> searchBydate(LocalDate date);
}
