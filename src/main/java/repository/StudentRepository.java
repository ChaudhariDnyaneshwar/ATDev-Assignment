package repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pojo.Student;

public class StudentRepository 
{

	//this method is use for adding data in student table..
	
	 public int insertStudentData(Student s)
	 {
		 System.out.println(s);
		   
		 int count=0;
		 
		 String dob=s.getStudent_dob();
		 Date d=new Date(dob);
		 java.sql.Date dob1=new java.sql.Date(d.getTime());
		 
		 String doj=s.getStudent_doj();
		 Date jd=new Date(doj);
		 java.sql.Date doj1=new java.sql.Date(jd.getTime());
		 
		String query="insert into student values(?,?,?,?)";
		 try {
		
			 PreparedStatement ps=DatabaseConnectionRepository.getConnection().prepareStatement(query);
		     ps.setString(1,s.getStudent_no());
		     ps.setString(2,s.getStudent_name());
		     ps.setDate(3,dob1);
		     ps.setDate(4,doj1);
		    count= ps.executeUpdate();
		 
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		 return count;
	 }
	
	
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
