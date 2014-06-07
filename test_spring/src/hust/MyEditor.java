package hust;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 实现自己的属性编辑器，只要实现了PropertyEditorSupport类，并重写它的setAsText方法就可以
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
	 * 重写setAsText方法，这个方法是将传入的string类型转换成我们需要的类型，
	 * 这里首先解析date类型，然后调用父类的setValue方法，正确设值。
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
