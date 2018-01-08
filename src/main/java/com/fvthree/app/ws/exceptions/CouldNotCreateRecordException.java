package com.fvthree.app.ws.exceptions;


/**
 * @author Felipe Villanueva III
 *
 */
public class CouldNotCreateRecordException extends RuntimeException {

	private static final long serialVersionUID = 255875089844597984L;

	public CouldNotCreateRecordException(String message) {
        super(message);
    }

}
