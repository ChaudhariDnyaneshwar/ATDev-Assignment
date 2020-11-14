package Jerscy.JerscySecond;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pojo.Student;
import repository.StudentRepository;

@Path("student")
public class StudentResource 

{
	   StudentRepository srepo=new StudentRepository();
	   
	@GET
	@Produces(MediaType.APPLICATION_JSON)
   public List<Student> getStudent()
   {
		System.out.println("here got ");
	            
		return srepo.getStudent();
   }
	//user for adding data in student table.....
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String insertStudent(Student s)
	{
		int a=srepo.insertStudentData(s);
		String result="";
		if(a>0)
		{
				result="insertion successfully done...";
		}
		else
		{
			result="insertion failed pls try later...";
		}
		return result;
	}
}
