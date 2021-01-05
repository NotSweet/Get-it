package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	//���幤��
	private static SessionFactory sessionFactory;
	
	static{
		sessionFactory = new Configuration().configure().buildSessionFactory();
		
	}
	//��ȡ�Ự����
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
	//��ȡ�Ự
	public static Session openSession()
	{
		return sessionFactory.openSession();
	}
	
	
}

