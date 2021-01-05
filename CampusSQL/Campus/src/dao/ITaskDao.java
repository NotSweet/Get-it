package dao;

import java.util.List;

import domain.Task;

public interface ITaskDao {

	/**
	 * 1.�����û�
	 * @param User
	 */
	public abstract void saveTask(Task task);

	/**
	 * 2.�����û�
	 * @param User
	 */
	public abstract void updateTask(Task task);

	/**
	 * 3.����id��ѯ�û�
	 * @param id
	 */

	public abstract Task findTaskById(String id);

	/**
	 * 4. ɾ���û�
	 * @param User
	 */
	public abstract void deleteTask(Task task);

	/**5.//��ѯ�����û�
	 * @return uList
	 */
	public abstract List<Task> findAll();
	 public abstract List<Task> findAllByName(String user);


}