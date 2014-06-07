package hust;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/user")
public class UserController {
	@RequestMapping(method=RequestMethod.GET)
	public String addForm() {
		return "start";
	}
	@RequestMapping(method=RequestMethod.POST)
	public String addUser( User user,BindingResult result){
		if(result.hasErrors()){
			//¥¶¿Ì¥ÌŒÛ
			return "";
		}
		System.out.println(user);
		//return "redirect:user.do";
		return "addUserSuccess";
	}
	
}
