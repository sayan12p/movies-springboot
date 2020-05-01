package com.home.movies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.home.movies.bean.Movie;
import com.home.movies.exception.DuplicateMovieException;
import com.home.movies.service.MovieServiceImpl;

@RestController
public class MovieController {

	@Autowired
	MovieServiceImpl movieservice;
	
	@RequestMapping(value="movie", method =RequestMethod.POST )
	public boolean insertMovie(@RequestBody Movie movie) throws DuplicateMovieException {
		return movieservice.insertMovie(movie);
	}
	@RequestMapping(value="movie/{id}", method=RequestMethod.GET)
		public Movie getMovie(@RequestParam String id) {
			return movieservice.getMovie(id);
		}
	@RequestMapping(value="delmovie/{id}", method=RequestMethod.DELETE)
	public void deleteMovie(@RequestParam String id) {
		movieservice.deleteMovie(id);
	}
	@RequestMapping(value="updatemovie", method=RequestMethod.PATCH)	
	public boolean updateMovie(@RequestBody Movie movie) {
		return movieservice.updateMovie(movie);
	}
	
	
}
