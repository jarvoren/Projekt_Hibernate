package a.DatabaseServices;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import a.DatabaseClases.Movie;

public  class DatabaseCrudOperations {

	static Session session = new Configuration().configure().buildSessionFactory().openSession();
	public static void saveMovieToDatabase(Movie a)
	{
		
	}
}
