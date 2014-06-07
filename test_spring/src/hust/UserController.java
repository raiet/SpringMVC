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
//commond controller�Ѿ���3.0��ʾΪ���ڣ�����ʹ��ע��ķ�ʽ������װ
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
	
	//���ݰ�
	//@Override
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder)throws  Exception{
		//ע��һ�����Ա༭��
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
		
	}
	
}
