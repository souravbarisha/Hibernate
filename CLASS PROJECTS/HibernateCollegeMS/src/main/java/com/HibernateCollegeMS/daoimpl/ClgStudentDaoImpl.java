package com.HibernateCollegeMS.daoimpl;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.HibernateCollegeMS.entity.ClgStudent;
import com.HibernateCollegeMS.dao.ClgStudentDao;
import com.HibernateCollegeMS.config.HibernateUtil;


public class ClgStudentDaoImpl implements ClgStudentDao{
	public void addStudent() { // add student in DB
		Scanner sc = new Scanner(System.in);
		String n,d,y,e;
		long p;
		System.out.println("Enter name: ");
		n= sc.nextLine();
		System.out.println("Enter dep: ");
		d= sc.nextLine();
		System.out.println("Enter year: ");
		y= sc.nextLine();
		System.out.println("Enter email: ");
		e= sc.nextLine();
		System.out.println("Enter phone: ");
		p= sc.nextLong();
		
		ClgStudent s = new ClgStudent();
		s.setName(n);
		s.setDept(d);
		s.setYear(y);
		s.setEmail(e);
		s.setPhone(p);
		
    Session sess = HibernateUtil.getSessionFactory().openSession();
    Transaction t = sess.beginTransaction();
    sess.save(s);
    t.commit();	
}
  public void updateStudent() { // update existing data from DB
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ID: ");
		int id = sc.nextInt();
		
		Session sess = HibernateUtil.getSessionFactory().openSession();
	    Transaction t = sess.beginTransaction();
	   
	    ClgStudent std = sess.get(ClgStudent.class,id);
	    System.out.println("Enter phone number: ");
	    long phone = sc.nextLong();
	    std.setPhone(phone);
	    sess.update(std);
	    System.out.println("Updated Successfully...");
	    t.commit();
	    
	    
	}
	
  public void deleteStudent() { // delete data from DB
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter ID: ");
	int id = sc.nextInt();
	
	Session sess = HibernateUtil.getSessionFactory().openSession();
    Transaction t = sess.beginTransaction();
    
    ClgStudent std1 = sess.get(ClgStudent.class,id);
    sess.delete(std1);
    System.out.println("Deleted Successfully...");
    t.commit();
	
	}
	
	public void fetchStudent() { // fetch data from DB
      Scanner sc = new Scanner(System.in);
      int id;
      System.out.println("Enter id: ");
      id= sc.nextInt();
      Session sess = HibernateUtil.getSessionFactory().openSession();
      ClgStudent s1 = sess.get(ClgStudent.class, id);
      System.out.println(s1.getId()+" "+s1.getName()+" "+s1.getDept()+" "+s1.getEmail()+" "+s1.getPhone());
	
	}	
}
