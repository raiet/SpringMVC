package hust;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ֻҪ�����@controllerע�⣬����ڳ�ʼ����ʱ�򣬾ͻ��������е��࣬ͬʱ�����Ƕ�������һ��controller
 * 
 * ��������ָ��requestMappingע�⣬��Ϊ����ķ���ָ��������ĸ�·��
 * */
@Controller
@RequestMapping("/root")
public class TestController {
	//�����Ƿ���/start·��ʱ�ͻ�ִ���������
	@RequestMapping("/start")
	public String start(){
			return "start";			
	}
	@RequestMapping("/para")
	public String para(HttpServletRequest request){
		String name = request.getParameter("name");
		System.out.println(name);
		return "start";
	}
	//restful���ı���,���е���������һ��urlģ�壬�������ֱ����@PathVariableע����������һ�£���Ϊ��ܻ��Զ���������ֵ
	//�����и����⣬����debug��releaseģʽ�±���ʱ��ͬ�ģ��� debug�£��������ɼ���������release�±��룬�������ǲ��ɼ��ģ�����@PathVariable����Ҫ����Ҫƥ���Ǹ�ģ��
	@RequestMapping("/rest/{name}/{age}")
	public String rest(@PathVariable("name") String name,@PathVariable("age") String age){
		System.out.println(name+" "+age);
		return "start";
	}
	
	//���ݲ�ͬ�����󷽷���post/get����ӳ�䵽��ͬ�Ĵ�����
	@RequestMapping(value = "/method",method=RequestMethod.GET)
	public String get_method(){
		System.out.println("get");
		return "start";
	}
	//�����value���ԣ�ָ���������·����Ҳ���Բ�ָ���������ָ��������༶���ϲ�������·��
	@RequestMapping(value = "/method",method=RequestMethod.POST)
	public String post_method(){
		System.out.println("post");
		return "start";
	}
	//û������·����ֱ�Ӳ������϶����·��
	@RequestMapping(method=RequestMethod.GET)
	public String noPath(){
		System.out.println("no path");
		return "start";
	}
	
	//��·���ϵ������������ͣ�������Ҫʹ�õ�����ĺ�����ʼ�����ݰ�����ע�����Ա༭��
	@RequestMapping(value = "/date/{date}",method=RequestMethod.GET)
	public String dateTest(@PathVariable("date") String date) throws ParseException{
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse(date));
		return "start";
	}
	
	//ע�����Ա༭��
	@InitBinder
	public void initBinded(HttpServletRequest request,ServletRequestDataBinder binder){		
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),false));
	}
	//ʹ��ע��ĺ����������Ǻ�����ģ����Խ��յĲ�������������ļ���
	public void testAllArguments(HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session,//session�����ǿ��õģ�Ҳ���Ǳ���ʼ���ģ�request.getSession(),session.setAttribute()
			@PathVariable("") String text,//��������Ϳ���ʹ��������
			@RequestParam("") String str,//ֱ�ӽ�request�Ĳ���ȡ���������Ϳ����������
			@CookieValue String cookieName,//����ȡ��cookie��ĳ�����ԣ����Ϳ����������
			@RequestHeader String headName,//���������http����ͷ��ĳ�����ԣ����Ϳ����������
			PrintWriter out,//ȡ��response��out���󣬿���ֱ����ҳ��д����
			Map model//ModelAndView�е�model����
			){
		
	}
	//ֱ�ӵĶ����,BindingResult���������ݰ󶨹����еĳ�����Ϣ������ʹ�������������
	@RequestMapping("/commod")
	public String testCommod(User user,BindingResult result){
		System.out.println(user);
		return "start";
	}
	/**
	 * method�ķ���ֵ
	 * �����void����ֵ���������������viewName���ᰴ������·��������Ӧ����ͼ������$(appName)/root/aaa.do --> root/aaa  -->/WEB-/INF/pages/root/aaa.jsp
	 * 
	 * ����string ���������viewName
	 * 
	 * ����һ���������͵Ķ���
	 * public User test(){
	 * 		User myUser = new User();
	 * 		return myUser;
	 * }
	 * ��������ģ���ʵ���ǰѷ��ص����ݷ���model�з��صģ�Ҳ�Ǿ�model(key,value)
	 * �����value���Ƿ��صĶ��󣬵��Ƕ���key��Ĭ�ϵľ�������������ĸСд
	 * ��ʱ�Ϳ�����ҳ����ֱ��ȡ��һ��user�Ķ���
	 * ���⣬��ܵ�Ĭ������������List<User> --> userList ,set<User> userSet,����ʵ�ʶ������ͺ������������
	 * 
	 * Ҳ���Է���model���ͣ�model����ʵ������spring��map���͵�һ����װ
	 * Ҳ����ֱ�ӷ���ModelAndView��
	 * */
	
	
}
