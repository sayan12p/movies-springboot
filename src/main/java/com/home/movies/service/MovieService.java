package com.home.movies.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.home.movies.bean.Movie;


@Service
public interface MovieService {

	public  boolean insertMovie(Movie movie) ;
	public boolean updateMovie (Movie movie);
	public List<Movie> getAllMovies();
	public void deleteMovie(String id);
	public Movie getMovie(String id);
}
