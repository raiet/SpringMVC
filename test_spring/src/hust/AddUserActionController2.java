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

/**
 * 使用AbstractCommandController可以实现数据的绑定（业务模型的转换），将jsp中的数据封装成对象，
 * AbstractCommandController类已经被3.0标记为过期，spring鼓励使用注解的方式
 * 
 * 使用反射的机制实现自动注入，需要让框架知道你的command类型是一个什么类型的对象，所以要在配置文件中配置
 * 
 * 这里面框架自动封装表单参数，但是对于一些特殊的数据类型（这里面的date类型），需要使用属性编辑器，来干涉设值过程，这就是常说的数据绑定问题。
 * 
 * */
public class AddUserActionController2 extends AbstractCommandController {

	@Override
	protected ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, Object command, /*从表单封装的对象*/
			BindException errors)
			throws Exception {
		//将command对象强制转换为User对象
		User user = (User)command;
		System.out.println("我使用了command对象");
		System.out.println(user);
		//返回一个addUserSuccess的视图
		return new ModelAndView("addUserSuccess");
	}
	/**
	 * 数据绑定：databind的对象
	 * 在数据注入对象的时候，就是调用对象的set方法
	 * 对于一些简答的类型，如int的类型，框架可以帮助来进行转换，也就是框架知道，来自表单的数据是一个string类型，所以使用默认的int类型的属性编辑器就可以完成设值
	 * 但是对于date这样的类型，由于他的格式不固定，如可以是yyyy-MM,也可以是yyyy-MM-dd，所以框架不能自动的设值，这时候就需要程序自己提供一些属性编辑器，来完成这一个设值过程
	 * date类型，虽然没有实现默认的数据绑定对象，但是也是实现了一个简单的过度的数据绑定对象，来帮助完成数据绑定
	 * */
	//初始化绑定器，注册自己的属性编辑器
	@Override
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		
		
		MyEditor editor = new MyEditor();
		editor.setPattern("yyyy-MM-dd");
		//注册一个自定义的属性编辑器。这里的两个参数一个是对象类型，另一个是属性编辑器
		
		
		//1，CustomDateEditor是一个框架提供的date类型的属性编辑器，但是还需要用户自己提供日期类型的格式化形式
		//binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
		
		//2，这里注册了一个我们自己自定义的属性编辑器
		binder.registerCustomEditor(Date.class, editor);
		
		//还有第三种方法，在配置文件中注册属性编辑器
	}

}
