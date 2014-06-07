package hust;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;


/**
 * ʵ��MultiActionController������һ���������д��������󣬾�����õķ���ͨ��methodNameResolve
 * */
public class AddUserActionController4 extends MultiActionController {
	
	//��������û���ҳ�棬����᷵��һ��view��һ��model
	public ModelAndView toAdd(HttpServletRequest request,
			HttpServletResponse response){
		//view ʵ������һ��string
		//model ʵ������һ��map
		ModelAndView mav = new ModelAndView();
		mav.setViewName("addUser");
		mav.addObject("deptList", new String[]{"haha","hehe"});
		return mav;
	}
	//����û���submit
	public ModelAndView addUserAction(HttpServletRequest request,
			HttpServletResponse response,HttpSession session ,User user){
		
		System.out.println(user);
		//����һ��addUserSuccess����ͼ
		return new ModelAndView("addUserSuccess");

	}
	@Override
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		// TODO Auto-generated method stub
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
	}
	
	
}
