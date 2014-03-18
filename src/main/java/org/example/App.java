package org.example;

import org.example.domain.Address;
import org.example.domain.Person;
import org.example.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
    	
        Person p = new Person();
        p.setName("Jan");
        p.setSurname("Kowalski");
        User u = new User();
        u.setUserName("jkowal");
        u.setPassword("password");
        u.setPerson(p);
        p.setUser(u);
        p.setNationalIdentificationNumber("1234567890");
        
        Address a = new Address();
        a.setCity("Gdańsk");
        a.setHouseNumber("55");
        a.setStreet("Brzegi");
        a.setLocalNumber("1");
        a.setPostalCode("80-300");
        a.setPerson(p);
        p.getAddresses().add(a);
        
        session.beginTransaction();
        
        session.save(p);
        session.save(u);
        session.save(a);
        session.getTransaction().commit();
    	
    }
}
