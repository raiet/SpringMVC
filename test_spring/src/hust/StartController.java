package hust;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class StartController implements Controller {

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("controller is working!!");
		//����һ���߼��Ͻ�����start������ͼ��������ôʵ�������ͼ��controller�������ģ�ʵ��controller��view�Ľ���
		return new ModelAndView("start");
		//return null;
	}

}
