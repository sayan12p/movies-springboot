package com.home.movies.repository;

import org.springframework.data.repository.CrudRepository;

import com.home.movies.bean.Movie;

public interface MovieRepository extends CrudRepository<Movie,String>{
	
	public Movie findByTitle(String title);
	

}
