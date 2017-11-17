package database;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DatabaseConnection {

	
	public DatabaseConnection() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	}
}
