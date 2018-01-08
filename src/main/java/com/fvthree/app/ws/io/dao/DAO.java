package com.fvthree.app.ws.io.dao;

import java.util.List;

import com.fvthree.app.ws.shared.dto.UserDTO;

/**
 * @author Felipe Villanueva III
 *
 */
public interface DAO {
	void openConnection();
	UserDTO getUserByUserName(String userName);
	UserDTO saveUser(UserDTO user);
    UserDTO getUser(String id);
    List<UserDTO> getUsers(int start, int limit);
    void updateUser(UserDTO userProfile);
	void closeConnection();
}
