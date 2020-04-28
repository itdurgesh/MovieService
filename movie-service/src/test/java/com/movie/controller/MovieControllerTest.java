/**
 * 
 */
package com.movie.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.movie.bean.request.MovieRquest;
import com.movie.bean.response.Movie;
import com.movie.service.MovieService;

/**
 * @author durgesh.s
 *
 */
@SpringBootTest
public class MovieControllerTest {
	@InjectMocks
	MovieController movieController;
	
	@Mock
	MovieService movieService;
	
	@Test
	public void createMovieTest() {
		Movie movie = new Movie();
		MovieRquest createRequtest = new MovieRquest();
		when(movieService.createMovie(createRequtest)).thenReturn(movie);
		assertEquals(movie, movieService.createMovie(createRequtest));
	}
	
	@Test
	public void updateMovieTest() {
		Movie movie = new Movie();
		MovieRquest createRequtest = new MovieRquest();
		when(movieService.createMovie(createRequtest)).thenReturn(movie);
		assertEquals(movie, movieService.createMovie(createRequtest));
	}
	@Test
	public void fetchMovieTest() {
		Movie movie1 = new Movie(1,"The100","18+",4.6);
		Movie movie2 = new Movie(1,"lost in space","9+",3.6);
		List<Movie> movies = new ArrayList<>(Arrays.asList(movie1,movie2));
		
		Integer id = null;
		when(movieService.retriveMovies(id)).thenReturn(movies);
		assertEquals(movies.size(), movieService.retriveMovies(id).size());
	}
	@Test
	public void removeMovieTest() {
		Movie movie = new Movie();
		MovieRquest createRequtest = new MovieRquest();
		when(movieService.createMovie(createRequtest)).thenReturn(movie);
		assertEquals(movie, movieService.createMovie(createRequtest));
	}
	
	
	
	
	
	
	
	

}
