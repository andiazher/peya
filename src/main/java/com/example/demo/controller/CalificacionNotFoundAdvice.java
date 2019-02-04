package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.CalificacioneNotFoundException;

public class CalificacionNotFoundAdvice {
	@ResponseBody
	@ExceptionHandler(CalificacioneNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String employeeNotFoundHandler(CalificacioneNotFoundException ex) {
		return ex.getMessage();
	}
}
