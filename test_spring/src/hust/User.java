package hust;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
	private int no;
	private String name;
	private String phone;
	//需要使用 属性编辑器  才能完成表单对象注入
	private Date date;
	private String dept;
	
	
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String toString(){
		String res = new String();
		res += "No:";
		res +=this.no;
		res +="\n";
		res += "name:";
		res +=this.name;
		res +="\n";
		res += "phone:";
		res +=this.phone;
		
		res +="\n";
		res += "date:";
		res += new SimpleDateFormat("yyyy-MM-dd").format(date);
		
		res +="\n";
		res += "dept:";
		res += this.dept;
		return res;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
}
