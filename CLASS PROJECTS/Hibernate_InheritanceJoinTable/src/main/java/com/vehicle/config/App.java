package com.vehicle.config;

import com.vehicle.daoImpl.DaoImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	DaoImpl dao = new DaoImpl();
    	dao.addVehicle();
        
    }
}
