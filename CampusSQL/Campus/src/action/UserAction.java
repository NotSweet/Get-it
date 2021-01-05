package action;

import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.ITaskDao;
import dao.IUserDao;
import dao.TaskDao;
import dao.UserDao;

import domain.Task;
import domain.User;

public class UserAction extends ActionSupport implements ModelDriven<User>{

	User user=new User();//�ֶ�ʵ����
	IUserDao userDao=new UserDao();
	
	
	public String login(){
		
		User loginUser = userDao.findUserByLogin(user.getUsername(), user.getPassword());
		if(loginUser!=null){
			//�жϵ�¼�û��Ƿ�Ϊ�գ�����ǿգ����û���Ϣд��session��ת����ҳ���������µ�½
			ServletActionContext.getRequest().getSession().setAttribute("loginUser",loginUser);
			return "success";
		}else{
			return "login";
		}
		
	}
	public String register(){
		
		
		userDao.saveUser(user);
		
			return "login";
		
	}
	
	public String pay() {
		User user1=(User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
		user1.setScore(user1.getScore()+user.getScore());
		userDao.updateUser(user1);
		
		return "pay_success";
		
	}
	
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	
	
	
}
