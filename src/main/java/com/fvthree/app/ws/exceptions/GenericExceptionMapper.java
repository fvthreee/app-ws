package com.fvthree.app.ws.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.fvthree.app.ws.ui.model.response.ErrorMessage;
import com.fvthree.app.ws.ui.model.response.ErrorMessages;

/**
 * @author Felipe Villanueva III
 *
 */

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {
	
	public Response toResponse(Throwable exception) {
        ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(),
                ErrorMessages.INTERNAL_SERVER_ERROR.name(), "http://appsdeveloperblog.com");

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).
                entity(errorMessage).
                build();
    }
	
}
