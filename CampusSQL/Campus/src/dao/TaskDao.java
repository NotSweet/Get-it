package dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import utils.HibernateSessionFactory;
import domain.Task;

public class TaskDao implements ITaskDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IUserDao#saveUser(domain.User)
	 */
	@Override
	public void saveTask(Task task) {
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(task);
		transaction.commit();
		session.close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IUserDao#updateUser(domain.User)
	 */
	@Override
	public void updateTask(Task task) {
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();
		session.update(task);
		transaction.commit();
		session.close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IUserDao#findUserById(java.lang.Integer)
	 */

	public Task findTaskById(String id) {
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();
		Task user = (Task) session.get(Task.class, id);
		transaction.commit();
		session.close();
		return user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IUserDao#deleteUser(domain.User)
	 */
	@Override
	public void deleteTask(Task task) {
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();
		session.delete(task);
		transaction.commit();
		session.close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IUserDao#findAll()
	 */

	public List<Task> findAll() {

		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();
		// 5.1 ʹ��hql��ѯ�����û�����ѯ����������
		String hql = "from Task";
		Query query = session.createQuery(hql);
		List<Task> list1 = query.list();// ����ж�����¼��ʹ��list����

		transaction.commit();
		session.close();
		return list1;
	}

	public List<Task> findAllByName(String user) {

		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();
		// 5.1 ʹ��hql��ѯ�����û�����ѯ����������
		
		String hql = "from Task as t where t.username='"+ user+ "'";
		Query query = session.createQuery(hql);
		List<Task> list1 = query.list();// ����ж�����¼��ʹ��list����

		transaction.commit();
		session.close();
		return list1;
	}

}
