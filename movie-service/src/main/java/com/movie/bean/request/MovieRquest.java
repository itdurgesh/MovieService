package com.movie.bean.request;
/**
 * 
 * @author durgesh.s
 * The Bean class is use as request to call create and update movie services
 */
public class MovieRquest {
	private int id;
	private String title;
	private String category;
	private double starRating;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getStarRating() {
		return starRating;
	}
	public void setStarRating(double starRating) {
		this.starRating = starRating;
	} 
	
	

}
