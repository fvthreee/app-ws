package com.fvthree.app.ws.exceptions;

/**
 * @author Felipe Villanueva III
 *
 */
public class MissingRequiredFieldException extends RuntimeException {

	private static final long serialVersionUID = -1063627871575769197L;
	
	public MissingRequiredFieldException(String message) {
        super(message);
    }

}
