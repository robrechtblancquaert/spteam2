package database;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public abstract class User {
	public static boolean checkCredentials(String username, String password) {
		if(password == null || username == null) return false;
		
		SessionFactory sessionFactory = new Configuration().configure("/database/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			String salt = (String) session.createSQLQuery("SELECT SUBSTRING(Password, 1, 29) FROM users WHERE name = \'" + username + "\'").list().get(0);
			String hashedPassword = BCrypt.hashpw(password, salt);
		
			List received = session.createSQLQuery("SELECT 1 FROM users WHERE name = \'" + username + "\' AND password = \'" + hashedPassword + "\'").list();
			if(received.size() == 1) {
				return true;
			}
		} catch(IndexOutOfBoundsException e) {
			return false;
		} finally {
			session.close();
		}
		return false;
	}
	
	public static void createUser(String username, String password, String email) {
		String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(10));
		
		SessionFactory sessionFactory = new Configuration().configure("/database/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		try {
			String query = "INSERT INTO users (name, email, password) VALUES (\'" + username + "\', \'" + email + "\', \'" + hashedPassword + "\')";
			session.createSQLQuery(query).executeUpdate();
		} finally {
			session.close();
		}
	}
}
