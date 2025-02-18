package com.cg.dao;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cg.model.Movie;

@Repository
public interface MovieDao extends JpaRepository<Movie, Integer> {
	List<Movie> findByGenre(String genre);

	List<Movie> findByLanguage(String lang);

	@Query(value = "select * from movie where release_date <= releasedate",nativeQuery = true)
	List<Movie> findbyDate(@Param("releaseDate") LocalDate date);

}
