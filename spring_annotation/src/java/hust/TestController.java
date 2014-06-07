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
 * 只要添加了@controller注解，框架在初始化的时候，就会搜索所有的类，同时把他们都当做是一个controller
 * 
 * 在类上面指定requestMapping注解，则为下面的方法指定了请求的根路径
 * */
@Controller
@RequestMapping("/root")
public class TestController {
	//当我们访问/start路径时就会执行这个方法
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
	//restful风格的变量,其中的中括号是一个url模板，它的名字必须和@PathVariable注解后面的名字一致，因为框架会自动解析并赋值
	//这里有个问题，就是debug和release模式下编译时不同的，在 debug下，变量名可见，但是在release下编译，变量名是不可见的，所以@PathVariable后面要加上要匹配那个模板
	@RequestMapping("/rest/{name}/{age}")
	public String rest(@PathVariable("name") String name,@PathVariable("age") String age){
		System.out.println(name+" "+age);
		return "start";
	}
	
	//根据不同的请求方法（post/get）来映射到不同的处理方法
	@RequestMapping(value = "/method",method=RequestMethod.GET)
	public String get_method(){
		System.out.println("get");
		return "start";
	}
	//这里的value属性，指定了请求的路径，也可以不指定，如果不指定则会在类级别上查找请求路径
	@RequestMapping(value = "/method",method=RequestMethod.POST)
	public String post_method(){
		System.out.println("post");
		return "start";
	}
	//没有请求路径，直接查找类上定义的路径
	@RequestMapping(method=RequestMethod.GET)
	public String noPath(){
		System.out.println("no path");
		return "start";
	}
	
	//绑定路径上的特殊数据类型，这里需要使用的下面的函数初始化数据绑定器来注册属性编辑器
	@RequestMapping(value = "/date/{date}",method=RequestMethod.GET)
	public String dateTest(@PathVariable("date") String date) throws ParseException{
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse(date));
		return "start";
	}
	
	//注册属性编辑器
	@InitBinder
	public void initBinded(HttpServletRequest request,ServletRequestDataBinder binder){		
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),false));
	}
	//使用注解的函数，参数是很随意的，可以接收的参数至少有下面的几种
	public void testAllArguments(HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session,//session必须是可用的，也就是被初始化的，request.getSession(),session.setAttribute()
			@PathVariable("") String text,//这里的类型可以使任意类型
			@RequestParam("") String str,//直接将request的参数取出来，类型可以是任意的
			@CookieValue String cookieName,//这里取出cookie的某个属性，类型可以是任意的
			@RequestHeader String headName,//这里解析出http请求头的某个属性，类型可以是任意的
			PrintWriter out,//取出response的out对象，可以直接向页面写东西
			Map model//ModelAndView中的model对象
			){
		
	}
	//直接的对象绑定,BindingResult返回在数据绑定过程中的出错信息，可以使用它来处理出错
	@RequestMapping("/commod")
	public String testCommod(User user,BindingResult result){
		System.out.println(user);
		return "start";
	}
	/**
	 * method的返回值
	 * 如果是void返回值，则会生成隐含的viewName，会按照请求路径生成响应的视图名，如$(appName)/root/aaa.do --> root/aaa  -->/WEB-/INF/pages/root/aaa.jsp
	 * 
	 * 返回string ，代表的是viewName
	 * 
	 * 返回一个任意类型的对象
	 * public User test(){
	 * 		User myUser = new User();
	 * 		return myUser;
	 * }
	 * 对于上面的，其实他是把返回的数据放入model中返回的，也是就model(key,value)
	 * 这里的value就是返回的对象，但是对于key，默认的就是类名的首字母小写
	 * 这时就可以在页面上直接取出一个user的对象，
	 * 另外，框架的默认命名：对于List<User> --> userList ,set<User> userSet,就是实际对象类型后跟容器类型名
	 * 
	 * 也可以返回model类型，model类型实际上是spring对map类型的一个封装
	 * 也可以直接返回ModelAndView。
	 * */
	
	
}
