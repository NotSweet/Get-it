package service;

import java.util.List;

import domain.User;

public interface IUserService {
	/**
	 * 1.�����û�
	 * @param User
	 */
	public abstract void saveUser(User user);

	/**
	 * 2.�����û�
	 * @param User
	 */
	public abstract void updateUser(User user);

	/**
	 * 3.����id��ѯ�û�
	 * @param id
	 */

	public abstract User findUserById(Integer id);

	/**
	 * 4. ɾ���û�
	 * @param User
	 */
	public abstract void deleteUser(User user);

	/**5.//��ѯ�����û�
	 * @return uList
	 */
	public abstract List<User> findAll();

	/**5.//�����û�������������ѯ�û����൱�ڵ�¼
	 * ����ֵ����ΪUser
	 * 
	 * @return dList
	 */

	//public User findUserByLogin(User user)
	public abstract User findUserByLogin(String username, String password);

}
