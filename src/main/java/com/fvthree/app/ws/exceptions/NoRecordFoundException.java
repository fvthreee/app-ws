/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fvthree.app.ws.exceptions;

/**
 * @author Felipe Villanueva III
 */
public class NoRecordFoundException extends RuntimeException {

    private static final long serialVersionUID = 6276765411196369111L;
    
    public NoRecordFoundException(String message)
    {
        super(message);
    }
       
}
