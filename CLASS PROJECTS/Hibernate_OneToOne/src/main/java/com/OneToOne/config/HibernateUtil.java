package com.OneToOne.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//creating session method within the HibernateUtil class
public class HibernateUtil {
	public static Session activeSession() {
		SessionFactory sFactory = new Configuration().configure().buildSessionFactory();
		 Session session = sFactory.openSession();
		 
		 return session;
	}
}
