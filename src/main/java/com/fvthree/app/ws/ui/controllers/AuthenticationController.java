package com.fvthree.app.ws.ui.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.fvthree.app.ws.service.AuthenticationService;
import com.fvthree.app.ws.service.impl.AuthenticationServiceImpl;
import com.fvthree.app.ws.shared.dto.UserDTO;
import com.fvthree.app.ws.ui.model.request.LoginCredentials;
import com.fvthree.app.ws.ui.model.response.AuthenticationDetails;


/**
 * @author Felipe Villanueva III
 *
 */
@Path("/authentication")
public class AuthenticationController {
	
    @Autowired
    AuthenticationService authService;
	
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public AuthenticationDetails userLogin(LoginCredentials loginCredentials) {
        AuthenticationDetails returnValue = new AuthenticationDetails();
        
        UserDTO authenticatedUser = authService.authenticate(loginCredentials.getUserName(), loginCredentials.getUserPassword());

       // Reset Access Token
        authService.resetSecurityCridentials(loginCredentials.getUserPassword(), 
                 authenticatedUser);
        
        String accessToken = authService.issueAccessToken(authenticatedUser);
        
        returnValue.setId(authenticatedUser.getUserId());
        returnValue.setToken(accessToken);
        
        return returnValue;
    }
}
