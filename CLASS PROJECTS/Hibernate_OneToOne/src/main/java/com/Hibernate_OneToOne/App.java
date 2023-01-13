package com.Hibernate_OneToOne;

import com.OneToOne.dao.CitizenDao;
import com.OneToOne.daoImpl.CitizenDaoImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CitizenDao dao = new CitizenDaoImpl();
        //adding citizen to DB
        dao.addCitizen();
        // getting citizen from DB
        dao.fetchCitizen();
    }
}
 