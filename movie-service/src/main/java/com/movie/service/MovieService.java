/**
 * 
 */
package com.movie.service;

import java.util.List;

import com.movie.bean.request.MovieRquest;
import com.movie.bean.response.Movie;
import com.movie.exception.MovieException;

/**
 * @author durgesh.s
 *
 */
public interface MovieService {
	Movie createMovie(MovieRquest movieRequest) throws MovieException;
	
	Movie updateMovie(MovieRquest movieRequest);
	
	List<Movie> retriveMovies(Integer movieId);
	
	String removeMovie(MovieRquest movieRequest);
}
