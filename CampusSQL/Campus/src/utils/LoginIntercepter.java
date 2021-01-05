package utils;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginIntercepter extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		if(ServletActionContext.getRequest().getSession().getAttribute("loginUser")==null)	{
			return "no_login";
				}
			//如果user对象不为空，则继续执行下一步操作
			return invocation.invoke();
			

	}

}
