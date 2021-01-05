package utils;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
/**
 * 自定义拦截器，继承MethodFilterInterceptor类
 * @author 
 *
 */
public class Myinterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//从session中获取user对象，如果获取不到，直接返回
		if(ServletActionContext.getRequest().getSession().getAttribute("loginUser")==null)
		{
			return "no_login";
		}
		//如果user对象不为空，则继续执行下一步操作
		return invocation.invoke();
	}

}
