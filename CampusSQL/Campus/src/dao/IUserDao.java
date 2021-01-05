package dao;

import java.util.List;

import domain.User;

public interface IUserDao {

	/**
	 * 1.保存用户
	 * @param User
	 */
	public abstract void saveUser(User user);

	/**
	 * 2.更新用户
	 * @param User
	 */
	public abstract void updateUser(User user);

	/**
	 * 3.根据id查询用户
	 * @param id
	 */

	public abstract User findUserById(Integer id);

	/**
	 * 4. 删除用户
	 * @param User
	 */
	public abstract void deleteUser(User user);

	/**5.//查询所有用户
	 * @return uList
	 */
	public abstract List<User> findAll();

	/**5.//按照用户名和密码来查询用户，相当于登录
	 * 返回值类型为User
	 * 
	 * @return dList
	 */

	//public User findUserByLogin(User user)
	public abstract User findUserByLogin(String username, String password);

}