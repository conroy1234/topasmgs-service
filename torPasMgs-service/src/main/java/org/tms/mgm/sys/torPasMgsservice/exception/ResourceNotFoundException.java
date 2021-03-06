package org.tms.mgm.sys.torPasMgsservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "cannot find resource")
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 7495992020709178631L;
	
	public ResourceNotFoundException(String message) {
		super(message);	
	}

	

}
