package com.example.demo;

public class CalificacioneNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CalificacioneNotFoundException(Long id) {
		super("Could not find entity " + id);
	}
}
