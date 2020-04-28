/**
 * 
 */
package com.movie.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.movie.bean.MovieEntity;
import com.movie.bean.request.MovieRquest;
import com.movie.bean.response.Movie;
import com.movie.dao.MovieDao;
import com.movie.exception.MovieException;
import com.movie.mapper.Mapper;
import com.movie.service.MovieService;

/**
 * @author durgesh.s
 *
 */
@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
	MovieDao movieDao;

	@Override
	public Movie createMovie(MovieRquest movieRequest) {
		MovieEntity movie = Mapper.mapRequestIntoEntity(movieRequest);
		movie =movieDao.save(movie);
		return Mapper.mapEntityIntoMovie(movie);
		
		
	}

	@Override
	public Movie updateMovie(MovieRquest movieRequest) throws MovieException {
		Optional<MovieEntity> entity = movieDao.findById(movieRequest.getId());
		Movie movie = null;
		if(entity.isPresent()) {
			MovieEntity dbEntity = entity.get();
			if(!StringUtils.isEmpty(movieRequest.getTitle())) {
				dbEntity.setTitle(movieRequest.getTitle());
			}
			if(!StringUtils.isEmpty(movieRequest.getCategory())) {
				dbEntity.setCategory(movieRequest.getCategory());
			}
			if(!StringUtils.isEmpty(movieRequest.getStarRating())) {
				dbEntity.setStarRating(movieRequest.getStarRating());
			}
			dbEntity = movieDao.save(dbEntity);
			return Mapper.mapEntityIntoMovie(dbEntity);
		}else {
			throw new MovieException("Movie not found Exception");
		}
	}

	@Override
	public List<Movie> retriveMovies(Integer movieId) {
		List<Movie> movies = new ArrayList<>();
		if(movieId == null || movieId ==0 ) {
			List<MovieEntity> moviesEntity = (List<MovieEntity>) movieDao.findAll();
			movies = Mapper.mapEntitysIntoMovies(moviesEntity);
		}else {
			Optional<MovieEntity> movie = movieDao.findById(movieId);
			if(movie.isPresent()) {
				movies.add( Mapper.mapEntityIntoMovie(movie.get()));
			}
		}
		
		return movies;
	}

	@Override
	public String removeMovie(Integer movieRequest) {
		Optional<MovieEntity> optional = movieDao.findById(movieRequest);
		if(optional.isPresent()) {
			movieDao.delete(optional.get());
			return "success";
		}else {
			throw new MovieException("movie not found exception");
		}
		
		
	}

}
