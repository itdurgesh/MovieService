/**
 * 
 */
package com.movie.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.movie.MovieServiceApplication;
import com.movie.bean.request.MovieRquest;
import com.movie.bean.response.Movie;

/**
 * @author durgesh.s
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MovieServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MovieControllerIntegrationTest {
	@Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void contextLoads() {

    }
	
  
    
    @Test
    public void testCreateMovie() {
    	MovieRquest movieReq = new MovieRquest();
    	movieReq.setTitle("The Accountent");
    	movieReq.setCategory("13+");
    	movieReq.setStarRating(3.9);
        
        ResponseEntity<Movie> postResponse = restTemplate.postForEntity(getRootUrl() + "/movie/create", movieReq, Movie.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

  @Test
    public void testRetriveAllMovies() {
    HttpHeaders headers = new HttpHeaders();
       HttpEntity<String> entity = new HttpEntity<String>(null, headers);
       ResponseEntity<List> response = restTemplate.exchange(getRootUrl() + "/movie/retrive",
       HttpMethod.GET, entity, List.class);  
       assertNotNull(response.getBody());
   }

 // @Test
	public void testUpdateMovie() {
		MovieRquest movieReq = new MovieRquest();
		movieReq.setId(1);
		movieReq.setTitle("The Accountent");
		movieReq.setCategory("13+");
		movieReq.setStarRating(3.9);

		Movie postResponse = restTemplate.postForObject(getRootUrl() + "/movie/update", movieReq, Movie.class);
		assertNotNull(postResponse);
	}
 
  @Test
	public void testRemoveMovie() {
	  	Integer movieId = 1;
	  	Map<String,Integer> variables = new HashMap<>();
		variables.put("movieId", movieId);
		
		try {
			restTemplate.delete(getRootUrl() + "/movie/remove/{movieId}",variables);
			List<Movie>  response = restTemplate.getForObject(getRootUrl() + "/movie/retrive", List.class,variables );
		    assertNotNull(response);

		} catch (final HttpClientErrorException e) {
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}
}
