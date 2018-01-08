/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fvthree.app.ws.exceptions;

import com.fvthree.app.ws.ui.model.response.ErrorMessage;
import com.fvthree.app.ws.ui.model.response.ErrorMessages;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author Felipe Villanueva III
 */
@Provider
public class NoRecordFoundExceptionMapper implements ExceptionMapper<NoRecordFoundException>{

    public Response toResponse(NoRecordFoundException exception) {
        ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(),
                ErrorMessages.NO_RECORD_FOUND.name(), "http://appsdeveloperblog.com");
        
      return Response.status(Response.Status.BAD_REQUEST).entity(errorMessage).build();
    }
    
}

