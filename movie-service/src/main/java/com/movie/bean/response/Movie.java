package com.movie.bean.response;

public class Movie {
	
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
	public Movie() {
		
	}

	public Movie(int id, String title, String category, double starRating) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.starRating = starRating;
	}


	

}
