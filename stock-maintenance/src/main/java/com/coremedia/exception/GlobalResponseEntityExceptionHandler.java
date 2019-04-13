package com.coremedia.exception;

import java.util.Date;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.coremedia.constant.Constant;


@ControllerAdvice
@RestController
public class GlobalResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
    	ExceptionResponse exceptionResponse = 
    			new ExceptionResponse(new Date(), Constant.VALIDATION_FAILED, ex.getBindingResult().toString());
    	return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
    
    // General exception
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse handleException(Exception exception) {
        return new ExceptionResponse(new Date(), Constant.UNEXPECTED_ERROR, null);
    }
    
    // if no entity exists for given productId.
    @ExceptionHandler(value = EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handleException(EntityNotFoundException exception){
    	return new ExceptionResponse(new Date(), Constant.PRODUCT_NOT_FOUND, null);
    }
}