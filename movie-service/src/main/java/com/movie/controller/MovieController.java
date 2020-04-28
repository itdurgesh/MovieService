/**
 * 
 */
package com.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movie.bean.request.MovieRquest;
import com.movie.bean.response.Movie;
import com.movie.service.MovieService;

/**
 * @author durgesh.s
 *
 */

@RestController
@RequestMapping("movie")
public class MovieController {
	@Autowired
	MovieService movieService;
	
	@PostMapping(path = "create", produces = "application/json")
	public Movie createMovie(@RequestBody MovieRquest movieRequest) {
		return movieService.createMovie(movieRequest);
		
	}
	@PutMapping(path = "update", produces = "application/json")
	public Movie updateMovie(@RequestBody MovieRquest movieRequest) {
		return movieService.updateMovie(movieRequest);
		
	}
	@GetMapping(path = "retrive", produces = "application/json")
	public List<Movie> retriveMovies(@RequestParam(required = false) Integer movieId) {
		return movieService.retriveMovies(movieId);
		
	}
	
	@DeleteMapping(path = "remove/{movieId}", produces = "application/json")
	public String removeMovie(@PathVariable(value = "movieId") Integer movieId) {
		return movieService.removeMovie(movieId);
		
	}

}
