package dao;

import java.util.List;

import domain.Task;

public interface ITaskDao {

	/**
	 * 1.保存用户
	 * @param User
	 */
	public abstract void saveTask(Task task);

	/**
	 * 2.更新用户
	 * @param User
	 */
	public abstract void updateTask(Task task);

	/**
	 * 3.根据id查询用户
	 * @param id
	 */

	public abstract Task findTaskById(String id);

	/**
	 * 4. 删除用户
	 * @param User
	 */
	public abstract void deleteTask(Task task);

	/**5.//查询所有用户
	 * @return uList
	 */
	public abstract List<Task> findAll();
	 public abstract List<Task> findAllByName(String user);


}