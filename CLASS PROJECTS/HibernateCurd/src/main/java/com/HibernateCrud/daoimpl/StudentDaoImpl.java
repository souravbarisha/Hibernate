package com.HibernateCrud.daoimpl;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.HibernateCrud.config.HibernateUtil;
import com.HibernateCrud.dao.StudentDao;
import com.HibernateCrud.entity.Student;

public class StudentDaoImpl implements StudentDao {
	public void addStudent() { // add student in DB
		Scanner sc = new Scanner(System.in);
		String n,d,e;
		long p;
		System.out.println("Enter name: ");
		n= sc.nextLine();
		System.out.println("Enter dep: ");
		d= sc.nextLine();
		System.out.println("Enter email: ");
		e= sc.nextLine();
		System.out.println("Enter phone: ");
		p= sc.nextLong();
		
		Student s = new Student();
		s.setName(n);
		s.setDept(d);
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
	   
	    Student std = sess.get(Student.class,id);
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
    
    Student std1 = sess.get(Student.class,id);
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
      Student s1 = sess.get(Student.class, id);
      System.out.println(s1.getId()+" "+s1.getName()+" "+s1.getDept()+" "+s1.getEmail()+" "+s1.getPhone());
	
	}	
}
