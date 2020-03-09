package org.tms.mgm.sys.torPasMgsservice.exception.advise;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.tms.mgm.sys.torPasMgsservice.exception.BadRequestException;
import org.tms.mgm.sys.torPasMgsservice.exception.ResourceNotFoundException;
import org.tms.mgm.sys.torPasMgsservice.exception.model.ExceptionResponse;

@RestController
@ControllerAdvice
public class PassResponseEntityExceptionHaldler extends ResponseEntityExceptionHandler {
	

	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<Object> handleNotFoundException(ResourceNotFoundException ex, WebRequest request){
		ExceptionResponse exceptionResponse =new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(true));
		
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BadRequestException.class)
	public final ResponseEntity<Object> handleBadRequestFoundException(BadRequestException ex, WebRequest request){
		ExceptionResponse exceptionResponse =new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(true));
		
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

}
