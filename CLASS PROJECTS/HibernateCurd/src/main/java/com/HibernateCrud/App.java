package com.HibernateCrud;

import java.util.Scanner;

import com.HibernateCrud.daoimpl.StudentDaoImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        StudentDaoImpl dao = new StudentDaoImpl(); 
        char c;
        do {
        	Scanner sc = new Scanner(System.in);
        	System.out.println("PRESS 1 for add student \n PRESS 2 for display student \n "
        			+ "     PRESS 3 for upodate \n PRESS 4 for delete \n PRESS 5 for Exite");;
        int a= sc.nextInt();
        switch(a) {
        case 1: dao.addStudent();
        break;
        case 2: dao.fetchStudent();
        break;
        case 3: dao.updateStudent();
        break;
        case 4: dao.deleteStudent();
        break;
        case 5: System.exit(0);
        break;
        default: System.out.println("Invalid Choice!");
        }
        System.out.println("Do you want to continue? Y/N");
        c = sc.next().charAt(0);
        }while(c=='Y' || c=='y');
        System.out.println("Thank you");
    }
}
