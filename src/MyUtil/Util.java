package MyUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Util {
	/*
	 * Create Session
	 */
	private static SessionFactory sessionfactory;
	static{
		sessionfactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();	
	}
	
	public static Session getSession(){
		 return sessionfactory.openSession();
	}
	
}
