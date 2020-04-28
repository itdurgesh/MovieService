/**
 * 
 */
package com.movie.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.movie.bean.MovieEntity;
/**
 * @author durgesh.s
 *
 */
@Repository
public interface MovieDao extends CrudRepository<MovieEntity,Integer> {

}
