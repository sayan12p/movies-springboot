package com.home.movies.exception;

public class DuplicateMovieException extends Exception{
	
	public DuplicateMovieException(int code, String message) {
		super(message);
	}

}
