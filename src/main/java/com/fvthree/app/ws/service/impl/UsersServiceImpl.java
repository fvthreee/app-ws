package com.fvthree.app.ws.service.impl;

import java.util.List;
import javax.inject.Inject;

import com.fvthree.app.ws.exceptions.CouldNotCreateRecordException;
import com.fvthree.app.ws.exceptions.NoRecordFoundException;
import com.fvthree.app.ws.io.dao.DAO;
import com.fvthree.app.ws.io.dao.impl.MySQLDAO;
import com.fvthree.app.ws.service.UsersService;
import com.fvthree.app.ws.shared.dto.UserDTO;
import com.fvthree.app.ws.ui.model.response.ErrorMessages;
import com.fvthree.app.ws.utils.UserProfileUtils;

/**
 * @author Felipe Villanueva III
 *
 */

public class UsersServiceImpl implements UsersService {
	
    DAO database;

    public UsersServiceImpl() {
        this.database = new MySQLDAO();
    }
	
    @Inject
    UserProfileUtils userProfileUtils;

    public UserDTO createUser(UserDTO user) {
        UserDTO returnValue = null;
		
        // Validate required fields
        userProfileUtils.validateRequiredFields(user);
		
        // Check if user already exists
        UserDTO existingUser = this.getUserByUserName(user.getEmail());
        if (existingUser != null) {
            throw new CouldNotCreateRecordException(ErrorMessages.RECORD_ALREADY_EXISTS.name());
        }
		
	// Generate Secure Public User ID
        String userId = userProfileUtils.generateUserId(30);
        user.setUserId(userId);
		
	// Generate salt
        String salt = userProfileUtils.getSalt(30);
	// Generate secure password
        String encryptedPassword = userProfileUtils.generateSecurePassword(user.getPassword(), salt);
        user.setSalt(salt);
        user.setEncryptedPassword(encryptedPassword);
		
	// Record data into a database
        returnValue = this.saveUser(user);
		
	// return back the user profile
		
	return returnValue;
    }
	
    public UserDTO getUser(String id) {
        UserDTO returnValue = null;
        try {
            this.database.openConnection();
            returnValue = this.database.getUser(id);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new NoRecordFoundException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
        } finally {
            this.database.closeConnection();
        }
        return returnValue;
    }
	
    public UserDTO getUserByUserName(String userName) {
        UserDTO userDto = null;

        if (userName == null || userName.isEmpty()) {
            return userDto;
        }

        // Connect to database 
        try {
            this.database.openConnection();
            userDto = this.database.getUserByUserName(userName);
        } finally {
            this.database.closeConnection();
        }

        return userDto;
    }
    
    public List<UserDTO> getUsers(int start, int limit) {

        List<UserDTO> users = null;

        // Get users from database
        try {
            this.database.openConnection();
            users = this.database.getUsers(start, limit);
        } finally {
            this.database.closeConnection();
        }

        return users;
    }
    
    private UserDTO saveUser(UserDTO user) {
        UserDTO returnValue = null;
        // Connect to database 
        try {
            this.database.openConnection();
            returnValue = this.database.saveUser(user);
        } finally {
            this.database.closeConnection();
        }

        return returnValue;
    } 

}
