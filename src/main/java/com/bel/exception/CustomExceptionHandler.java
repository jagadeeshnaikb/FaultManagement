package com.bel.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<String> errorList = new ArrayList<>();
		for(FieldError error : ex.getFieldErrors())
		{
			errorList.add(error.getField()+" : "+error.getDefaultMessage());
		}
		
		ErrorMessage errorMessage = new ErrorMessage(new Date(), "Validation Failed",  errorList.toString());
		ResponseEntity<Object> resp = new ResponseEntity<Object>(errorMessage, HttpStatus.BAD_REQUEST);
		return resp;
	}
}
