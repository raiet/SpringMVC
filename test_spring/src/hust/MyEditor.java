package hust;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * ʵ���Լ������Ա༭����ֻҪʵ����PropertyEditorSupport�࣬����д����setAsText�����Ϳ���
 * 
 * */
public class MyEditor extends PropertyEditorSupport {
	private String pattern;
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	
	/**
	 * ��дsetAsText��������������ǽ������string����ת����������Ҫ�����ͣ�
	 * �������Ƚ���date���ͣ�Ȼ����ø����setValue��������ȷ��ֵ��
	 * */
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Date date = null;
		try {
			 date = new SimpleDateFormat(pattern).parse(text);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setValue(date);
	}


}
