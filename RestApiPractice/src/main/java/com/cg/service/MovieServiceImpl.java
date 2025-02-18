package com.cg.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cg.dao.MovieDao;
import com.cg.exception.MovieNotFoundException;
import com.cg.model.Movie;

import jakarta.transaction.Transactional;
@Service
public class MovieServiceImpl implements MovieService{
	@Autowired
	private MovieDao movieDao;
	@Transactional
	public Movie addNewMovieService(Movie m) {
		return movieDao.save(m);
	}
	@Override
	public Movie searchMovieService(int movieCode) {
		Optional<Movie> optional=movieDao.findById(movieCode);
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			throw new MovieNotFoundException("Movie not found");
		}
		
	}
	public List<Movie> allmoviesService() {
		List<Movie> movieList= movieDao.findAll();
		if(movieList.isEmpty()) {
			throw new MovieNotFoundException("No movies added");
		}
		else {
			return movieList;
		}
	}
	public List<Movie> searchByGenreService(String genre) {
		List<Movie> movieList= movieDao.findByGenre(genre);
		if(movieList.isEmpty()) {
			throw new MovieNotFoundException("No movies found");
		}
		else {
			return movieList;
		}

	}
	public List<Movie> searchByLanguageService(String lang) {
		List<Movie> movieList= movieDao.findByLanguage(lang);
		if(movieList.isEmpty()) {
			throw new MovieNotFoundException("No movies added");
		}
		else {
			return movieList;
		}
	}
	@Transactional
	public Movie updateMovieService(Movie m, int movieId) {
		Optional<Movie>option=movieDao.findById(movieId);
		if(option.isPresent()) {
			Movie movie=new Movie();
			movie.setMovieId(m.getMovieId());
			movie.setMovieName(m.getMovieName());
			movie.setGenre(m.getGenre());
			movie.setLanguage(m.getLanguage());
			movie.setReleaseDate(m.getReleaseDate());
			return movieDao.save(movie);
		}
		else {
			throw new MovieNotFoundException("Movie not found");
		}
	}

	@Override
	public void deleteMovieService(int movieId) {
		movieDao.deleteById(movieId);
		
	}
	@Override
	public List<Movie> searchBydate(LocalDate date) {
		List<Movie> movieList=movieDao.findbyDate(date);
		if(movieList.isEmpty()) {
			throw new MovieNotFoundException("No such movies");
			
		}
		else {
			return movieList;
		}
		 
	}

}
