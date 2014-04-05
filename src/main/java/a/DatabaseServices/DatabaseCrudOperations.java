package a.DatabaseServices;

import java.util.List;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import a.DatabaseClases.Director;
import a.DatabaseClases.Movie;

public  class DatabaseCrudOperations {

	static SessionFactory factory = new Configuration().configure().buildSessionFactory();
	public static void saveToDatabase(Object a)
	{
		
        Session session = factory.openSession();
    	
        
        
        session.beginTransaction();
        session.saveOrUpdate(a);
        
        session.getTransaction().commit();
        
        session.close();
        
        
	}
	public static List<Movie> loadMoviesFromDatabase()
	{
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
    	
        
        
        session.beginTransaction();
         List<Movie> movies =  ((List<Movie>)session.createQuery("from Movie").list());
        
        session.getTransaction().commit();
        
        session.close();
        return movies;
	}
}
