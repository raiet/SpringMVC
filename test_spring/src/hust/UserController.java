package hust;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;
import org.springframework.web.servlet.mvc.AbstractController;

import sun.print.resources.serviceui;

//public class UserController extends AbstractController {
//commond controller已经被3.0标示为过期，鼓励使用注解的方式，表单封装
public class UserController extends AbstractCommandController {
	
	@Override
	protected ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, Object commond, BindException exception)
			throws Exception {
		User user = (User)commond;
		System.out.println(user);
		//service.add_user(user);
		return new ModelAndView("addUserSuccess");
	}
	
	//数据绑定
	//@Override
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder)throws  Exception{
		//注册一个属性编辑器
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
		
	}
	
}
