package repository;

import java.util.ArrayList;
import java.util.List;

import pojo.Student;

public class StudentRepository 
{

	public List<Student> getStudent()
	{
		
		ArrayList<Student> st=new ArrayList<>();
		
		Student s=new Student();
		s.setStudent_no("3");
		s.setStudent_name("dnyaneshwar");
		s.setStudent_dob("1997/02/25");
		s.setStudent_doj("1887/25/14");
		st.add(s);
		
		
		return st;
	}
	
}
