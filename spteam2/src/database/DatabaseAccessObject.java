package database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public abstract class DatabaseAccessObject {
	public static void saveDao(DatabaseAccessObject o) {
		Session session = DatabaseConnection.getConnection();
		session.beginTransaction();
		
		session.save(o);
		session.getTransaction().commit();
		session.close();
	}
	
	private static class DatabaseConnection {
		private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		public static Session getConnection() {
			return sessionFactory.openSession();
		}
	}

}
