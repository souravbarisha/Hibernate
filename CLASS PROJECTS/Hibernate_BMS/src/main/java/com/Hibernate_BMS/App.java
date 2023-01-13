package com.Hibernate_BMS;

import java.util.Scanner;

import com.BMS.daoImpl.BankDaoImpl;

public class App 
{
    public static void main( String[] args ) {
    	BankDaoImpl dao = new BankDaoImpl();
    	char c;
		do {
			System.out.println("press 1 to create account in our bank");
			System.out.println("press 2 to deposit money in your account");
			System.out.println("press 3 to withdraw money from you account");
			System.out.println("press 4 to update your account");
			System.out.println("press 5 to delete your account");
			System.out.println("press 6 to to check your account details");
			System.out.println("press 7 to change your pin");
			System.out.println("press 8 to exit");
			
			Scanner sc = new Scanner(System.in);
			
			 int a= sc.nextInt();
		        switch(a) {
		        case 1: dao.createAccount();
		        break;
		        case 2: dao.deposit();
		        break;
		        case 3: dao.withdrawal();
		        break;
		        case 4: dao.update();
		        break;
		        case 5: dao.delete();
		        break;
		        case 6: dao.showAccount();
		        break;
		        case 7: dao.changePin();
		        break;
		        case 8: System.exit(0);
		        System.out.println("Thank you");
		        break;
		        default: System.out.println("Invalid Choice!");
		        }
		        System.out.println("Do you want to continue? Y/N");
		        c = sc.next().charAt(0);
		        }while(c=='Y' || c=='y');
		        System.out.println("Thank you");
      }
    }
