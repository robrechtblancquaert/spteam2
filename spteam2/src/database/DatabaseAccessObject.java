package database;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 
 * @author Robrecht Blancquaert
 * @deprecated
 */
public abstract class DatabaseAccessObject {
	private static SessionFactory sessionFactory = new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory();
	
	protected static void delete(Object o) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(o);
			session.getTransaction().commit();
		} catch(Exception e) {
			if (session.getTransaction()!=null) session.getTransaction().rollback();
			e.printStackTrace(); 
		} finally {
			session.close();
		}
	}
	
	@SuppressWarnings("rawtypes")
	protected static List select(String hql) {
		Session session = sessionFactory.openSession();
		List results = null;
		
		try {
			session.beginTransaction();
			Query query = null;
			query = session.createQuery(hql);
			results = query.getResultList();
		} catch(Exception e) {
			if (session.getTransaction()!=null) session.getTransaction().rollback();
			e.printStackTrace(); 
		} finally {
			session.close();
		}
		return results;
	}
	
	protected static Serializable save(Object o) {
		Serializable result = null;
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			result = session.save(o);
			session.getTransaction().commit();
		} catch(Exception e) {
			if (session.getTransaction()!=null) session.getTransaction().rollback();
			e.printStackTrace(); 
		} finally {
			session.close();
		}
		return result;
	}
	
	protected static void update(Object o) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(o);
			session.getTransaction().commit();
		} catch(Exception e) {
			if (session.getTransaction()!=null) session.getTransaction().rollback();
			e.printStackTrace(); 
		} finally {
			session.close();
		}
	}
	
	protected static void saveOrUpdate(Object o) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(o);
			session.getTransaction().commit();
		} catch(Exception e) {
			if (session.getTransaction()!=null) session.getTransaction().rollback();
			e.printStackTrace(); 
		} finally {
			session.close();
		}
	}
	
	protected static Session getSession() {
		return sessionFactory.openSession();
	}
}
