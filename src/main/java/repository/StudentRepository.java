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
		 
		 // this code for  covert date java.util to java.sql
		 java.sql.Date dob=new java.sql.Date(s.getStudent_dob().getTime());
		 java.sql.Date doj=new java.sql.Date(s.getStudent_doj().getTime());
		 
		String query="insert into student values(?,?,?,?)";
		 try {
		
			 PreparedStatement ps=DatabaseConnectionRepository.getConnection().prepareStatement(query);
		     ps.setString(1,s.getStudent_no());
		     ps.setString(2,s.getStudent_name());
		     ps.setDate(3,dob);
		     ps.setDate(4,doj);
		    count= ps.executeUpdate();
		 
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return count;
	 }
	
	 //this method is use to get all student data....
	
	public List<Student> getStudent()
	{
		
		ArrayList<Student> slist=new ArrayList<>();
		
		  try {
			PreparedStatement ps=DatabaseConnectionRepository.getConnection().prepareStatement("select * from student");
		    ResultSet rs=ps.executeQuery();
		  while(rs.next())
		  {
			  Student s=new Student();
			  s.setStudent_no(rs.getString(1));
			  s.setStudent_name(rs.getString(2));
			  s.setStudent_dob(rs.getDate(3));
		      s.setStudent_doj(rs.getDate(4));
		      slist.add(s);
		  }
		  
		  
		  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  
		return slist;
	}
	
//this method is user for the updating the student table data...
	public int updateStudent(Student s)
	{
		  String query="update student set student_name=? , student_dob=? ,student_doj=? where student_no=?";
		
		  // this code for  covert date java.util to java.sql
			 java.sql.Date dob=new java.sql.Date(s.getStudent_dob().getTime());
			 java.sql.Date doj=new java.sql.Date(s.getStudent_doj().getTime());
			
		int count=0;
		  try {
		PreparedStatement ps=DatabaseConnectionRepository.getConnection().prepareStatement(query);
		  ps.setString(1,s.getStudent_name());
		  ps.setDate(2, dob);
		  ps.setDate(3, doj);
		  ps.setString(4,s.getStudent_no());
	count=ps.executeUpdate();
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
}
