package hust.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


//实现自己的拦截器
public class MyInterceptor implements HandlerInterceptor {
	
	//在下面的所有的操作结束后，释放资源
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("afterCompletion");

	}
	//controller执行完成，生成视图之前，向模型中加入公共成员
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("postHandle");
	}
	//处理之前的操作,在递交到请求的controller之前
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler//拦截器链上的下一个对象
			) throws Exception {
		System.out.println("preHandle");
		//true:继续下一个拦截器
		//false:拦截器链中断
		return true;
	}

}
