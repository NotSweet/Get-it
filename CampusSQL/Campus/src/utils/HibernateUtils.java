package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	//定义工厂
	private static SessionFactory sessionFactory;
	
	static{
		sessionFactory = new Configuration().configure().buildSessionFactory();
		
	}
	//获取会话工厂
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
	//获取会话
	public static Session openSession()
	{
		return sessionFactory.openSession();
	}
	
	
}

