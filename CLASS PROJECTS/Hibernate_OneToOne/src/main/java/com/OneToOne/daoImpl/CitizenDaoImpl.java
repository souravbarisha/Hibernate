package com.OneToOne.daoImpl;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.OneToOne.config.HibernateUtil;
import com.OneToOne.dao.CitizenDao;
import com.OneToOne.entity.Address;
import com.OneToOne.entity.Citizen;

public class CitizenDaoImpl implements CitizenDao{
// creating instance objects so we can excess globally
	Session session = HibernateUtil.activeSession();
    Transaction t = session.beginTransaction();
    Scanner scan = new Scanner(System.in);

    public void addCitizen() {
    	
    	// adding citizen properties
    	Citizen c = new Citizen();
    	c.setCname("Sourav");
    	c.setSurname("Das");
    	c.setPhone(875953332);
    	c.setEmail("sourav@gmail.com");
    	c.setDob("1998-05-28");
    	
    	// adding address properties
    	Address a = new Address();
    	a.setId(12345);
    	a.setIdType("aadhar");
    	a.setAddress("xyz house");
    	a.setCity("kolkata");
    	a.setState("west bengal");
    	a.setPincode(700076);
    	
    	// setting aggragation property to Citizen object
    	c.setAddress(a);
    	
    	session.save(c);
    	System.out.println("adding done");
    	t.commit();
    }
    
     public void fetchCitizen() {
    	 @SuppressWarnings("rawtypes")
    	 Query q = session.createQuery("from Citizen");
    	 
    	 //list with citizen entity
    	 @SuppressWarnings("unchecked")
    	 List<Citizen> l = q.getResultList();
    	 
    	 // traverse
    	 Iterator<Citizen> itr = l.iterator();
    	 while(itr.hasNext()) {
    		 Citizen c1 = itr.next();
    		 Address a1 = c1.getAddress();
    		 
    		 // output
    		 System.out.println("Customer details:"+c1.getCid()+" "
    				 +c1.getCname()+" "+c1.getSurname()+" "+c1.getPhone()+" "+c1.getEmail()+" "+c1.getDob());
    	 
    	 
    		 System.out.println("Address details:"+a1.getId()+" "+a1.getIdType()+" "
    				 +" "+a1.getCity()+" "+a1.getState()+" "+a1.getAddress());
    	 }
    	 
    	 
     }

}
