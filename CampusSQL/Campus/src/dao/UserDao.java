package dao;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;


import utils.HibernateSessionFactory;
import domain.User;


public class UserDao implements IUserDao {

	/* (non-Javadoc)
	 * @see dao.IUserDao#saveUser(domain.User)
	 */
	@Override
	public void saveUser(User user){
		 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  Date date = new Date();
		user.setCreate_time(dateFormat.format(date));
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();		
		session.save(user);		
		transaction.commit();
		session.close();		
	}
	
	/* (non-Javadoc)
	 * @see dao.IUserDao#updateUser(domain.User)
	 */
	@Override
	public void updateUser(User user){
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();	
		session.update(user);		
		transaction.commit();
		session.close();
	}
	/* (non-Javadoc)
	 * @see dao.IUserDao#findUserById(java.lang.Integer)
	 */
	
	
	public User findUserById(Integer id){
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();		
		User user = (User) session.get(User.class,id);		
		transaction.commit();
		session.close();
		return user;		
	}	
	
	/* (non-Javadoc)
	 * @see dao.IUserDao#deleteUser(domain.User)
	 */
	@Override
	public void deleteUser(User user){
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();		
		session.delete(user);		
		transaction.commit();
		session.close();		
	}
	/* (non-Javadoc)
	 * @see dao.IUserDao#findAll()
	 */
	@Override
	public List<User> findAll(){
	
		
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();		
		//5.1  使用hql查询所有用户，查询出所有属性
		String hql="from User";
	Query query = session.createQuery(hql);
	List<User> list1 = query.list();//结果有多条记录，使用list方法		
	
	transaction.commit();
		session.close();		
		return list1;
	}
	
	/* (non-Javadoc)
	 * @see dao.IUserDao#findUserByLogin(java.lang.String, java.lang.String)
	 */
	
	//public User findUserByLogin(User user)
	@Override
	public User findUserByLogin(String username,String password){		
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();
		//根据用户名和密码来查询用户
		String hql="from User u where u.username=? and u.password=?";
		Query query=session.createQuery(hql);
		
		User user1 = (User) query.setString(0, username).setString(1, password).uniqueResult();		
		//User user1 = (User) query.setString(0, user.getUsername()).setString(1, user.getPassword()).uniqueResult();		
		transaction.commit();
		 HibernateSessionFactory.closeSession();
		//session.close();
		return user1;
	}
	
	
	
	
}
