package action;

import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.junit.Test;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.ITaskDao;
import dao.IUserDao;
import dao.TaskDao;
import dao.UserDao;


import domain.Task;
import domain.User;

public class TaskAction extends ActionSupport implements ModelDriven<Task>{

	Task task=new Task();//手动实例化
	ITaskDao taskDao=new TaskDao();
	
	IUserDao userDao=new UserDao();
	
	private List<Task> result;
	
	public List<Task> getResult() {
		return result;
	}

	public void setResult(List<Task> result) {
		this.result = result;
	}



	
	public String find() {
		result=taskDao.findAll();
		return "show";
		//ServletActionContext.getRequest().getSession().setAttribute("task",task);
	}
	
	public String hist() {
		User user=(User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");

		result=taskDao.findAllByName(user.getUsername());
		return "show_hist";
		//ServletActionContext.getRequest().getSession().setAttribute("task",task);
	}
	@Test
	public String send() {
		User user=(User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
		task.setUsername(user.getUsername());
		task.setStatus("1");
		taskDao.saveTask(task);
		user.setScore(user.getScore()-task.getScore());
		userDao.updateUser(user);
		return "send";
		//ServletActionContext.getRequest().getSession().setAttribute("task",task);
	}

	
	
	
	@Override
	public Task getModel() {
		// TODO Auto-generated method stub
		return task;
	}

	
	
}
