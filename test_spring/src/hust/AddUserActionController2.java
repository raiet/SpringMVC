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
 * ʹ��AbstractCommandController����ʵ�����ݵİ󶨣�ҵ��ģ�͵�ת��������jsp�е����ݷ�װ�ɶ���
 * AbstractCommandController���Ѿ���3.0���Ϊ���ڣ�spring����ʹ��ע��ķ�ʽ
 * 
 * ʹ�÷���Ļ���ʵ���Զ�ע�룬��Ҫ�ÿ��֪�����command������һ��ʲô���͵Ķ�������Ҫ�������ļ�������
 * 
 * ���������Զ���װ�����������Ƕ���һЩ������������ͣ��������date���ͣ�����Ҫʹ�����Ա༭������������ֵ���̣�����ǳ�˵�����ݰ����⡣
 * 
 * */
public class AddUserActionController2 extends AbstractCommandController {

	@Override
	protected ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, Object command, /*�ӱ���װ�Ķ���*/
			BindException errors)
			throws Exception {
		//��command����ǿ��ת��ΪUser����
		User user = (User)command;
		System.out.println("��ʹ����command����");
		System.out.println(user);
		//����һ��addUserSuccess����ͼ
		return new ModelAndView("addUserSuccess");
	}
	/**
	 * ���ݰ󶨣�databind�Ķ���
	 * ������ע������ʱ�򣬾��ǵ��ö����set����
	 * ����һЩ�������ͣ���int�����ͣ���ܿ��԰���������ת����Ҳ���ǿ��֪�������Ա���������һ��string���ͣ�����ʹ��Ĭ�ϵ�int���͵����Ա༭���Ϳ��������ֵ
	 * ���Ƕ���date���������ͣ��������ĸ�ʽ���̶����������yyyy-MM,Ҳ������yyyy-MM-dd�����Կ�ܲ����Զ�����ֵ����ʱ�����Ҫ�����Լ��ṩһЩ���Ա༭�����������һ����ֵ����
	 * date���ͣ���Ȼû��ʵ��Ĭ�ϵ����ݰ󶨶��󣬵���Ҳ��ʵ����һ���򵥵Ĺ��ȵ����ݰ󶨶���������������ݰ�
	 * */
	//��ʼ��������ע���Լ������Ա༭��
	@Override
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		
		
		MyEditor editor = new MyEditor();
		editor.setPattern("yyyy-MM-dd");
		//ע��һ���Զ�������Ա༭�����������������һ���Ƕ������ͣ���һ�������Ա༭��
		
		
		//1��CustomDateEditor��һ������ṩ��date���͵����Ա༭�������ǻ���Ҫ�û��Լ��ṩ�������͵ĸ�ʽ����ʽ
		//binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
		
		//2������ע����һ�������Լ��Զ�������Ա༭��
		binder.registerCustomEditor(Date.class, editor);
		
		//���е����ַ������������ļ���ע�����Ա༭��
	}

}
