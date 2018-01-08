package com.fvthree.app.ws.utils;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Felipe Villanueva III
 *
 */
public class HibernateUtils {
	private static final SessionFactory sessionFactory;
    
    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }       
    }
     
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    } 
}
