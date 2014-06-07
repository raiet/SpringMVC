package hust;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;


/**
 * ����������
 * */
public class AddUserActionController3 extends SimpleFormController {
	
	//Ĭ�������ֻ����post�����ύ����ʱ��Ż�ִ���������
	@Override
	protected ModelAndView onSubmit(Object command) throws Exception {
		// TODO Auto-generated method stub
		return new ModelAndView("addUserSuccess");
	}
	
	//����ҳ���ϵĶ�̬���ݿ���ͨ�������������
	@Override
	protected Map referenceData(HttpServletRequest request, Object command,
			Errors errors) throws Exception {
		Map<String,Object> modelMap = new HashMap<String, Object>();
		
		modelMap.put("deptList", new String[]{"sales","hr"});
		return modelMap;
	}

	@Override
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		// TODO Auto-generated method stub
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
	}
	
}
