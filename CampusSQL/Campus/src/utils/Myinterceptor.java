package utils;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
/**
 * �Զ������������̳�MethodFilterInterceptor��
 * @author 
 *
 */
public class Myinterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//��session�л�ȡuser���������ȡ������ֱ�ӷ���
		if(ServletActionContext.getRequest().getSession().getAttribute("loginUser")==null)
		{
			return "no_login";
		}
		//���user����Ϊ�գ������ִ����һ������
		return invocation.invoke();
	}

}
