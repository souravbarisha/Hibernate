package com.Hibernate_InheritanceSingleTable;

import com.vehicleSingleTable.daoImpl.DaoImpl;

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
