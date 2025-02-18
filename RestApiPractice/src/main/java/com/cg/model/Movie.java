package com.cg.model;

import java.time.LocalDate;



import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Movie {
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", genre=" + genre + ", language=" + language
				+ ", releaseDate=" + releaseDate + "]";
	}

	@Id
	@GeneratedValue
	private int movieId;
	@NotBlank(message = "Movie name should be entered")
	@NotNull(message = "Movie name should not null")
	private String movieName;
	@NotBlank(message = "Movie genre should be entered")
	@NotNull(message = "Movie genre should not null")
	private String genre;
	@NotBlank(message = "Movie language should be entered")
	@NotNull(message = "Movie language should not null")
	private String language;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate releaseDate;

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}
