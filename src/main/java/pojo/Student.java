package pojo;

import java.util.Date;

public class Student 
{

	private String Student_no;
	private String Student_name;
	private String Student_dob;
	private String Student_doj;
	public String getStudent_no() {
		return Student_no;
	}
	public void setStudent_no(String student_no) {
		Student_no = student_no;
	}
	public String getStudent_name() {
		return Student_name;
	}
	public void setStudent_name(String student_name) {
		Student_name = student_name;
	}
	public String getStudent_dob() {
		return Student_dob;
	}
	public void setStudent_dob(String student_dob) {
		Student_dob = student_dob;
	}
	public String getStudent_doj() {
		return Student_doj;
	}
	public void setStudent_doj(String student_doj) {
		Student_doj = student_doj;
	}
	@Override
	public String toString() {
		return "Student [Student_no=" + Student_no + ", Student_name=" + Student_name + ", Student_dob=" + Student_dob
				+ ", Student_doj=" + Student_doj + "]";
	}
	
	
}
