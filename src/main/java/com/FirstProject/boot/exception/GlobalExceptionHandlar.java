package com.FirstProject.boot.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.FirstProject.boot.model.CustomizeExceptionResponse;

@RestControllerAdvice
public class GlobalExceptionHandlar {

	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> methodArgumentNotValidException(MethodArgumentNotValidException ex)
	{
		Map<String, String> errorMap = new HashMap<>(); 
		
		List<FieldError> fieldErrors = ex.getFieldErrors();
		
		for (FieldError fieldError : fieldErrors) 
		{
			String field = fieldError.getField();
			String defaultMessage = fieldError.getDefaultMessage();
			
			errorMap.put(field, defaultMessage);
		}
		return errorMap;
	}
	
	@ExceptionHandler(ProductAlreadyExistException.class)
	@ResponseStatus(code = HttpStatus.CONFLICT)
	public CustomizeExceptionResponse productAlreadyExistException(ProductAlreadyExistException ex)
	{
		CustomizeExceptionResponse response = new CustomizeExceptionResponse();
		
		response.setDefaultMessage(ex.getMessage());
		response.setStatuscode(HttpStatus.CONFLICT.value());
		response.setDate(new Date());
		
		return response;
		
	}
}
