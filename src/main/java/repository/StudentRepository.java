package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		 
		 
		String query="insert into student values(?,?,?,?)";
		 try {
		
			 PreparedStatement ps=DatabaseConnectionRepository.getConnection().prepareStatement(query);
		     ps.setString(1,s.getStudent_no());
		     ps.setString(2,s.getStudent_name());
		     ps.setDate(3,(java.sql.Date) s.getStudent_dob());
		     ps.setDate(4,(java.sql.Date) s.getStudent_doj());
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
		
		  try {
			PreparedStatement ps=DatabaseConnectionRepository.getConnection().prepareStatement("select * from student");
		    ResultSet rs=ps.executeQuery();
		  while(rs.next())
		  {
			  Student s=new Student();
			  s.setStudent_no(rs.getString(1));
			  s.setStudent_name(rs.getString(2));
			  s.setStudent_dob(rs.getDate(3));
		  }
		  
		  
		  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  
		return st;
	}
	
	
}
