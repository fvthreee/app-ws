package com.fvthree.app.ws.ui.model.response;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * @author Felipe Villanueva III
 *
 */
@XmlRootElement
public class AuthenticationDetails {
	
	private String id;
    private String token;
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }
}
