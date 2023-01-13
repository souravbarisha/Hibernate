package com.Hibernate_OneToMany;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.Hibernate_OneToMany.entity.Cart;
import com.Hibernate_OneToMany.entity.Items;


public class App 
{
    public static void main( String[] args )
    {
        SessionFactory s = new Configuration().configure().buildSessionFactory();
       Session session = s.openSession();
       Transaction t = session.beginTransaction();
       
       Items i = new Items();
       i.setItemname("Phone");
       i.setPrice(23000);
       i.setQuantity(1);
       
       Items i1 = new Items();
       i1.setItemname("bottles");
       i1.setPrice(2000);
       i1.setQuantity(3);
       
       Items i2 = new Items();
       i2.setItemname("jeans");
       i2.setPrice(3000);
       i2.setQuantity(2);
       
       Items i3 = new Items();
       i3.setItemname("bags");
       i3.setPrice(2300);
       i3.setQuantity(1);
       
       Items i4 = new Items();
       i4.setItemname("watches");
       i4.setPrice(5000);
       i4.setQuantity(1);
       
       ArrayList<Items> a1 = new ArrayList<Items>();
       a1.add(i);
       a1.add(i1);
       a1.add(i2);
       a1.add(i3);
       a1.add(i4);
       
       Cart c = new Cart();
       c.setName("sourav");
       c.setItem(a1);
       session.save(c);
       t.commit();
       System.out.println("Inserted");
       
    }
} 
