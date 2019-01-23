package com.javahelps.restservice.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.Date;

@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAnyException(final Exception exception, final HttpStatus httpStatus,
			WebRequest request) {
		ErrorMessage errorMessage = new ErrorMessage(new Date(), httpStatus, exception.getMessage());
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), httpStatus);
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Object> notFindException(final Exception exception, final HttpStatus httpStatus,
			WebRequest request) {
		ErrorMessage errorMessage = new ErrorMessage(new Date(), httpStatus, exception.getMessage());
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), httpStatus);
	}

	/**
	 * @Override: handleMissingServletRequestParameter because we
	 *            use @ControllerAdvice to return error message when don't pass
	 *            required params
	 */
	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String name = ex.getParameterName();
		ErrorMessage errorMessage = new ErrorMessage(new Date(), status, ex.getMessage());
		logger.error(name + " parameter is missing");
		return new ResponseEntity<>(errorMessage, headers, status);

	}

}