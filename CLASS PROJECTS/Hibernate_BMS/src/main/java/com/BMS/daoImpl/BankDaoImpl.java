package com.BMS.daoImpl;


import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.BMS.config.HibernateUtil;
import com.BMS.dao.BankDao;
import com.BMS.entity.Bank;


public class BankDaoImpl implements BankDao{
	int ac, pin ;
	double acc_bal;
	String name, ifsc, branch, type;
	// createAccount method
	public void createAccount() {
		
		Scanner sc = new Scanner(System.in);
			
		System.out.println("Enter Account Holder name: ");
		name = sc.next();
		System.out.println("Enter Account Number: ");
		ac = sc.nextInt();
		System.out.println("Enter Branch: ");
		branch = sc.next();
        System.out.println("Enter IFSC CODE: ");
        ifsc = sc.next();
		System.out.println("Enter Account Type: ");
		type = sc.next();
        System.out.println("Enter Account Balance: ");
		acc_bal = sc.nextDouble();
		System.out.println("Enter PIN: ");
		pin = sc.nextInt();
		
		Bank b = new Bank();
		b.setAcc_holder(name);;
		b.setAcc_no(ac);
		b.setBranch(branch);
		b.setIfsc(ifsc);
		b.setAcc_type(type);
		b.setAcc_bal(acc_bal);
		b.setPin(pin);
		
       Session sess = HibernateUtil.getSessionFactory().openSession();
       Transaction t = sess.beginTransaction();
       sess.save(b);
       t.commit();	

			System.err.println("___NEW ACCOUNT CREATED___");
		
	}
	// deposit method
	public void deposit() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter AC No: ");
		int acc_no=sc.nextInt();
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction t=session.beginTransaction();
		Bank b=session.get(Bank.class, acc_no);
		
		System.out.println("Enter deposit ammount: ");
		double dipo = sc.nextDouble();
		double updateBalance =  b.getAcc_bal() + dipo;
				b.setAcc_bal(updateBalance);
				session.update(b);
				 System.out.println("deposit Successfully...");
				    t.commit();
	}
	// withdrawal method
	public void withdrawal() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter AC No: ");
		int acc_no=sc.nextInt();
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction t=session.beginTransaction();
		Bank b=session.get(Bank.class, acc_no);
		
		System.out.println("Enter withdrawal ammount: ");
		double withdraw = sc.nextDouble();
		double updateBalance =  b.getAcc_bal() - withdraw;
				b.setAcc_bal(updateBalance);
				session.update(b);
				 System.out.println("withdrawal Successfully...");
				    t.commit();
	}
	// update method
	public void update() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter AC No: ");
		int acc_no=sc.nextInt();
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction t=session.beginTransaction();
		Bank b=session.get(Bank.class, acc_no);
		
		System.out.println("PRESS 1 : To change Name \n PRESS 2 : To change Branch Name \n PRESS 3 : To change IFSC");
		int x = sc.nextInt();
		switch(x) {
		case 1 : 
			System.out.println("Enter the new name: ");
		    String acc_holder = sc.next();
		    b.setAcc_holder(acc_holder);
		    session.update(b);
		    break;
		case 2 : 
			System.out.println("Enter the new Branch Name: ");
		    String branch = sc.next();
		    b.setBranch(branch);
		    session.update(b);
		    break;
		case 3 :
			System.out.println("Enter the new IFSC: ");
		    String ifsc = sc.next();
		    b.setIfsc(ifsc);
		    session.update(b);
		    break;
        default: System.out.println("Invalid Choice!");
		}
		
		// System.out.println("you can edit your name: ");
		
	    System.out.println("Updated Successfully...");
	    t.commit();
		
	}
	// delete method
	public void delete() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter AC No: ");
		int acc_no = sc.nextInt();
		
		Session sess = HibernateUtil.getSessionFactory().openSession();
	    Transaction t = sess.beginTransaction();
	    
	    Bank b = sess.get(Bank.class,acc_no);
	    sess.delete(b);
	    System.out.println("Deleted Successfully...");
	    t.commit();
	}
	// showAccount method
	public void showAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter AC No: ");
		int acc_no=sc.nextInt();
	      Session sess = HibernateUtil.getSessionFactory().openSession();
	      Bank b = sess.get(Bank.class,acc_no);
	      System.out.println(b.getAcc_no()+" "+b.getAcc_holder()+" "+b.getIfsc()+" "+b.getBranch()+" "+b.getAcc_type()+" "+b.getAcc_bal()+" "+b.getPin());
	}
	public void changePin() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter AC No: ");
		int acc_no=sc.nextInt();
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction t=session.beginTransaction();
		Bank b=session.get(Bank.class, acc_no);
		System.out.println("Enter pin number: ");
		int pin=sc.nextInt();
		b.setPin(pin);
		session.update(b);
		System.out.println("pin changed successfully...");
		t.commit();}
}
