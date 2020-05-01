package com.home.movies.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.movies.bean.Movie;
import com.home.movies.exception.DuplicateMovieException;
import com.home.movies.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService{

	List<Movie> movielist=new ArrayList<>();
	
	@Autowired
	private MovieRepository repository; 
	
	@Override
	public boolean insertMovie(Movie movie) {
		// TODO Auto-generated method stub
		repository.save(movie);
		return true;
		
	}

	@Override
	public boolean updateMovie(Movie movie) {
		// TODO Auto-generated method stub
		Movie updatedMovie=repository.findById(movie.getId()).get();
		if(movie.getTitle()!=null) {
			updatedMovie.setTitle(movie.getTitle());
		}
		if(movie.getCastandcrew() !=null) {
			updatedMovie.setCastandcrew(movie.getCastandcrew());
		}
		if(movie.getGenre() !=null) {
			updatedMovie.setGenre(movie.getGenre());
		}
		if(movie.getDescription()!=null) {
			updatedMovie.setDescription(movie.getDescription());
		}
		if(movie.getDuration()!=null) {
			updatedMovie.setDuration(movie.getDuration());
		}
		return repository.save(updatedMovie) != null ? true:false;
	}

	@Override
	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		repository.findAll().forEach(movielist ::add);
		return movielist;
	}

	@Override
	public void deleteMovie(String id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

	@Override
	public Movie getMovie(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
		
	}

}
