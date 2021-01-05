package utils;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class MyIntercepter extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		if(ServletActionContext.getRequest().getSession().getAttribute("loginUser")!=null)
			return invocation.invoke();
		else
			return "login";
	}

}
