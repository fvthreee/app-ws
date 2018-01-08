package com.fvthree.app.ws.service;

import java.util.List;

import com.fvthree.app.ws.shared.dto.UserDTO;

/**
 * @author Felipe Villanueva III
 *
 */

public interface UsersService {
	public UserDTO createUser(UserDTO user);
	UserDTO getUser(String id);
	UserDTO getUserByUserName(String userName);
	List<UserDTO> getUsers(int start, int limit);
}
