package hust;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
/**
 * ���controller��һ��ļ̳�AbstractController��ʵ�֣���������ĶԱ��ķ�װ��Ҫ�����Լ���ʵ�֣���������еģ�
 * ����ȡ�����е�Ԫ�أ�Ȼ�����һ��User���󣬹������Ĵ���
 * 
 * 
 * */
public class AddUserActionController1 extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//ȡ�ôӱ����ݹ���������
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
		//������ҵ���߼���user���д���
		//service.process(user)
		//����һ��addUserSuccess����ͼ
		return new ModelAndView("addUserSuccess");
	}

}
