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
 * 实现MultiActionController可以在一个控制器中处理多个请求，具体调用的方法通过methodNameResolve
 * */
public class AddUserActionController4 extends MultiActionController {
	
	//记载添加用户的页面，这里会返回一个view和一个model
	public ModelAndView toAdd(HttpServletRequest request,
			HttpServletResponse response){
		//view 实际上是一个string
		//model 实际上是一个map
		ModelAndView mav = new ModelAndView();
		mav.setViewName("addUser");
		mav.addObject("deptList", new String[]{"haha","hehe"});
		return mav;
	}
	//添加用户的submit
	public ModelAndView addUserAction(HttpServletRequest request,
			HttpServletResponse response,HttpSession session ,User user){
		
		System.out.println(user);
		//返回一个addUserSuccess的视图
		return new ModelAndView("addUserSuccess");

	}
	@Override
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		// TODO Auto-generated method stub
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
	}
	
	
}
