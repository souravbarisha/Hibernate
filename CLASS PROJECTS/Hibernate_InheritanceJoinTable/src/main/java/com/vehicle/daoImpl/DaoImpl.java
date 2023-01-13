package com.vehicle.daoImpl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vehicle.config.HibernateUtil;
import com.vehicle.dao.Dao;
import com.vehicle.entity.FourWheels;
import com.vehicle.entity.TwoWheels;

public class DaoImpl implements Dao {
public void addVehicle() {
	Session session = HibernateUtil.activeSession();
	Transaction t = session.beginTransaction();
	
	TwoWheels tw = new TwoWheels();
	tw.setFuel("petrol");
	tw.setEnginePower("500cc");
	tw.setSpeed(200);
	tw.setVtype("Bike");
	tw.setPrice(200000);
	tw.setModelno(1234);
	tw.setModelname("abc");
	tw.setAbs(true);
	tw.setTyretype(140);
	tw.setBtype("Sport Bike");
	
	FourWheels fs = new FourWheels();
	fs.setFuel("electric");
	fs.setEnginePower("1000cc");
	fs.setSpeed(400);
	fs.setVtype("Car");
	fs.setPrice(800000);
	fs.setModelno(5678);
	fs.setModelname("swift");
	fs.setMusicSystem(true);
	fs.setEtype("auto");
	fs.setAc(true);
	
	session.save(tw);
	session.save(fs);
	t.commit();
	System.out.println("Joining done....");
	
}
}
