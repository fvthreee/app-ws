package com.fvthree.app.ws.ui.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.fvthree.app.ws.annotations.Secured;
import com.fvthree.app.ws.service.UsersService;
import com.fvthree.app.ws.shared.dto.UserDTO;
import com.fvthree.app.ws.ui.model.request.CreateUserRequestModel;
import com.fvthree.app.ws.ui.model.response.UserProfileRest;


/**
 * @author Felipe Villanueva III
 *
 */

@Path("/users")
public class UsersController {
	
	@Autowired
    private UsersService userService;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public UserProfileRest createUser(CreateUserRequestModel requestObject) {
		UserProfileRest returnValue = new UserProfileRest();
		
		// Prepare UserDTO
		UserDTO userDto = new UserDTO();
		BeanUtils.copyProperties(requestObject, userDto);
		
		// Create new user
		UserDTO createdUserProfile = userService.createUser(userDto);
		
		// Prepare response
		BeanUtils.copyProperties(createdUserProfile, returnValue);
		
		return returnValue;
	}
	
	@Secured
	@GET
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON,  MediaType.APPLICATION_XML} )
    public UserProfileRest getUserProfile(@PathParam("id") String id)
    {
        UserProfileRest returnValue = null;
        
        UserDTO userProfile = userService.getUser(id);
                
        returnValue = new UserProfileRest();
        BeanUtils.copyProperties(userProfile, returnValue);
        
        return returnValue;
    }
	
	@GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<UserProfileRest> getUsers(@DefaultValue("0") @QueryParam("start") int start, 
            @DefaultValue("50") @QueryParam("limit") int limit) {
  
        List<UserDTO> users = userService.getUsers(start, limit);
        
        // Prepare return value 
        List<UserProfileRest> returnValue = new ArrayList<UserProfileRest>();
        for (UserDTO userDto : users) {
            UserProfileRest userModel = new UserProfileRest();
            BeanUtils.copyProperties(userDto, userModel);
            userModel.setHref("/users/" + userDto.getUserId());
            returnValue.add(userModel);
        }
        
        return returnValue;
 }
}
