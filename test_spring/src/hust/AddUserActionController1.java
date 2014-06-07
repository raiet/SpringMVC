package hust;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
/**
 * 这个controller是一般的继承AbstractController的实现，所以里面的对表单的封装需要我们自己来实现，就像代码中的，
 * 我们取出表单中的元素，然后填充一个User对象，共后续的处理。
 * 
 * 
 * */
public class AddUserActionController1 extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//取得从表单传递过来的数据
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		int no = Integer.parseInt(request.getParameter("no"));
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
		String dept = request.getParameter("deptment");
		
		User user = new User();
		user.setDate(date);
		user.setDept(dept);
		user.setName(name);
		user.setNo(no);
		user.setPhone(phone);
		System.out.println(user);
		//真正的业务逻辑对user进行处理
		//service.process(user)
		//返回一个addUserSuccess的视图
		return new ModelAndView("addUserSuccess");
	}

}
