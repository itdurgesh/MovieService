/**
 * 
 */
package com.movie.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import com.movie.bean.MovieEntity;
import com.movie.bean.request.MovieRquest;
import com.movie.bean.response.Movie;

/**
 * @author durgesh.s
 *
 */
public interface Mapper {
	public static MovieEntity  mapRequestIntoEntity(MovieRquest movieRequest) {
		MovieEntity entity = new MovieEntity();
		entity.setId(movieRequest.getId());
		entity.setTitle(movieRequest.getTitle());
		entity.setStarRating(movieRequest.getStarRating());
		entity.setCategory(movieRequest.getCategory());
		return entity;
	}
	
	public static List<Movie> mapEntitysIntoMovies(List<MovieEntity> moviesEntity) {
		List<Movie> movies = new ArrayList<>();
		if(!CollectionUtils.isEmpty(moviesEntity)) {
			movies = moviesEntity.stream().map(movie -> new Movie(movie.getId(),movie.getTitle(),movie.getCategory()
					,movie.getStarRating())).collect(Collectors.toList());
		}
		return movies;
	}
	
	public static Movie mapEntityIntoMovie(MovieEntity movieEntity) {
		Movie movie = new Movie(movieEntity.getId(),movieEntity.getTitle(),movieEntity.getCategory()
				,movieEntity.getStarRating());
		
		return movie;
	}
	
	
}
