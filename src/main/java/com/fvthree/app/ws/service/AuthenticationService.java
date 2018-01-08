/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fvthree.app.ws.service;

import com.fvthree.app.ws.exceptions.AuthenticationException;
import com.fvthree.app.ws.shared.dto.UserDTO;

/**
 *
 * @author Felipe Villanueva III
 */
public interface AuthenticationService {
    UserDTO authenticate(String userName, String password) throws AuthenticationException;
    String issueAccessToken(UserDTO userProfile) throws AuthenticationException;
    public void resetSecurityCridentials(String password, UserDTO userProfile);
}
