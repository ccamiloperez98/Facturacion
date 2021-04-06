package com.example.facturacion.exception;

import java.time.LocalDateTime;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.facturacion.dto.ErrorDto;


@ControllerAdvice
@RestController
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {
	
	private LocalDateTime ldt=LocalDateTime.now();
	
	@ExceptionHandler(ModelNotFoundException.class)
	public final ResponseEntity<ErrorDto> ModelNotFoundExceptionHandler(ModelNotFoundException ex, WebRequest request){
		ErrorDto error= new ErrorDto(ldt, HttpStatus.NOT_FOUND.toString(),HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDto>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NullPointerException.class)
	public final ResponseEntity<ErrorDto> NullPointerExceptionHandler (NullPointerException ex, WebRequest request){
		ErrorDto error = new ErrorDto(ldt, HttpStatus.INTERNAL_SERVER_ERROR.toString(),
				HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDto>(error, HttpStatus.INTERNAL_SERVER_ERROR);			
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDto>ExceptionHandler (Exception ex, WebRequest request){
		ErrorDto error = new ErrorDto(ldt, HttpStatus.INTERNAL_SERVER_ERROR.toString(),
				HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDto>(error, HttpStatus.INTERNAL_SERVER_ERROR);			
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorDto error = new ErrorDto(ldt, HttpStatus.BAD_REQUEST.toString(),HttpStatus.BAD_REQUEST.getReasonPhrase(),
				"El Json no tiene la estructura adecuada",request.getDescription(false));
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);			
		
	}

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorDto error = new ErrorDto(ldt, HttpStatus.METHOD_NOT_ALLOWED.toString(),HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(error, HttpStatus.METHOD_NOT_ALLOWED);			
	}

	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		ErrorDto error = new ErrorDto(ldt, HttpStatus.NOT_FOUND.toString(),HttpStatus.NOT_FOUND.getReasonPhrase(), "No encontrado", request.getDescription(false));
		return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
	}	
	
}
