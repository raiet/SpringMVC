package hust;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class StartController implements Controller {

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("controller is working!!");
		//返回一个逻辑上叫做“start”的视图，至于怎么实现这个视图，controller并不关心，实现controller和view的解耦
		return new ModelAndView("start");
		//return null;
	}

}
