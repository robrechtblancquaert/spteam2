package database;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import books.Book;
import training.Training;
/**
 * 
 * @author Robrecht Blancquaert
 *
 * @param <T> A DatabaseObject type.
 */
public class Dao<T extends DatabaseObject> {
	private static SessionFactory sessionFactory = new Configuration().configure("/database/hibernate.cfg.xml").buildSessionFactory();
	private T dbObject;
	
	public static void backup(String filepath) {
		File f1 = new File(filepath);
	    f1.mkdir();
		try {
			Runtime.getRuntime().exec("mysqldump -u SP2Team2 -pxkpRRfJ SP2Team2 -r " + filepath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void restore(String filepath) {
		try {
			Runtime.getRuntime().exec("mysql -u SP2Team2 -pxkpRRfJ SP2Team2 < " + filepath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Dao(Class<T> dbClass) {
		try {
			this.dbObject = dbClass.newInstance();
		} catch (InstantiationException | IllegalAccessException | NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	public String getClassName() {
		return dbObject.getClass().getName();
	}
	
	public void delete(T t) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(t);
			session.getTransaction().commit();
		} catch(Exception e) {
			if (session.getTransaction()!=null) session.getTransaction().rollback();
			e.printStackTrace(); 
		} finally {
			session.close();
		}
	}
	
	public T save(T t) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			t.setSId(session.save(t));
			session.getTransaction().commit();
		} catch(Exception e) {
			if (session.getTransaction()!=null) session.getTransaction().rollback();
			e.printStackTrace(); 
		} finally {
			session.close();
		}
		return t;
	}
	
	public List<T> selectObject(String hql) {
		if(!hql.toLowerCase().contains(dbObject.getClass().getName().toLowerCase())) throw new IllegalArgumentException("Query did not contain correct from clause, from clause must contain " + dbObject.getClass().getName() +".");
		if(!hql.toLowerCase().contains("from")) throw new IllegalArgumentException("Query must contain FROM clause.");
		
		Session session = sessionFactory.openSession();
		List<T> results = new ArrayList<T>();
		try {
			session.beginTransaction();
			Query query = session.createQuery(hql);
			results = query.getResultList();
		} catch(Exception e) {
			if (session.getTransaction()!=null) session.getTransaction().rollback();
			e.printStackTrace(); 
		} finally {
			session.close();
		}
		return results;
	}
	
	public static List<Object[]> selectColumns(String hql) {
		if(!hql.toLowerCase().contains("from")) throw new IllegalArgumentException("Query must contain FROM clause.");
		Session session = sessionFactory.openSession();
		List<Object[]> results = new ArrayList<Object[]>();
		try {
			session.beginTransaction();
			Query query = session.createQuery(hql);
			results = query.getResultList();
		} catch(Exception e) {
			if (session.getTransaction()!=null) session.getTransaction().rollback();
			e.printStackTrace(); 
		} finally {
			session.close();
		}
		return results;
	}

	
	public void update(T t) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(t);
			session.getTransaction().commit();
		} catch(Exception e) {
			if (session.getTransaction()!=null) session.getTransaction().rollback();
			e.printStackTrace(); 
		} finally {
			session.close();
		}
	}
	
	public T getById(Serializable id) {
		Session session = sessionFactory.openSession();
		T t = null;
		String hql = "FROM " + dbObject.getClass().getName() + " T WHERE T.id = \'" + id + "\'";
		try {
			session.beginTransaction();
			Query query = session.createQuery(hql);
			t = (T) query.getSingleResult();
		} catch(Exception e) {
			if (session.getTransaction()!=null) session.getTransaction().rollback();
			e.printStackTrace(); 
		} finally {
			session.close();
		}
		return t;
	}
	
	public T refreshObject(T t) {
		if(t.getSId() == null) return null;
		t = getById(t.getSId());
		return t;
	}
}
