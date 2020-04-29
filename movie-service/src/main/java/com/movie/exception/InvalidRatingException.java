/**
 * 
 */
package com.movie.exception;

/**
 * @author durgesh.s
 *
 */
public class InvalidRatingException extends RuntimeException{
	 private static final long serialVersionUID = 1L;

	    public InvalidRatingException(String exception) {
	        super(exception);
	    }
}
