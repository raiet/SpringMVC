package hust.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


//ʵ���Լ���������
public class MyInterceptor implements HandlerInterceptor {
	
	//����������еĲ����������ͷ���Դ
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("afterCompletion");

	}
	//controllerִ����ɣ�������ͼ֮ǰ����ģ���м��빫����Ա
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("postHandle");
	}
	//����֮ǰ�Ĳ���,�ڵݽ��������controller֮ǰ
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler//���������ϵ���һ������
			) throws Exception {
		System.out.println("preHandle");
		//true:������һ��������
		//false:���������ж�
		return true;
	}

}
