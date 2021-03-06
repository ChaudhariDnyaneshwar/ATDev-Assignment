package Jerscy.JerscySecond;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pojo.Project;
import pojo.Student;
import repository.ProjectRepository;
import repository.StudentRepository;

@Path("assignment")
public class AssignmentRsource {

	ProjectRepository prepo=new ProjectRepository();
    StudentRepository srepo=new StudentRepository();
		   
	//===================================================	   
		//use for get all record from student table
		   
		@GET
		@Path("student")
		@Produces(MediaType.APPLICATION_JSON)
	   public List<Student> getStudent()
	   {
			
		            
			return srepo.getStudent();
	   }
		
	//=====================================================
		//use for adding data in student table.....
		@POST
		@Path("student")
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
		
	//=============================================================
		//This request is use for the update Student table
		@PUT
		@Path("student")
		@Consumes(MediaType.APPLICATION_JSON)
		public String updateStudent(Student s)
		{
			int a=srepo.updateStudent(s);
			String result="";
			if(a>0)
			{
					result="updation successfully done...";
			}
			else
			{
				result="updation failed pls try later...";
			}
			return result;

		}
		
	//=======================================================================	
		//this request is user for delete student table data....
		
	    @DELETE
	    @Path("student/{no}")
		public String deleteStudent(@PathParam("no")String student_no)
		{
	    	int a=srepo.deleteStudent(student_no);
			
	    	String result="";
			if(a>0)
			{
					result="delete successfully done...";
			}
			else
			{
				result="delete failed pls try later...";
			}
			return result;
		}
		
//=====================================================================
	    //this request is for geting all information from project...
	    
	    @GET
	    @Path("project")
		@Produces(MediaType.APPLICATION_JSON)
		public List<Project> getProjectList()
		{
			return prepo.getAllProject();	
		}
	
 //===============================================================
	    
//this request if for inserting data into projection table...
	    
	 @POST
	 @Path("project")
	 @Consumes(MediaType.APPLICATION_JSON)
	 public String insertProject(Project p)
	 {
		int a= prepo.insertProject(p);
		 
		String result="";
		if(a>0)
		{
				result="insertion successfully done...";
		}
		else
		{
			result="Insertion failed pls try later...";
		}
		return result;
	 }
	    
//=================================================	 
//this request is use for update project table....
	 @PUT
	 @Path("project")
	 @Consumes(MediaType.APPLICATION_JSON)
	 public String updateProject(Project p)
	 {
		int a= prepo.updateProject(p);
		String result="";
		if(a>0)
		{
				result="update successfully done...";
		}
		else
		{
			result="update failed pls try later...";
		}
		return result;	 
		}
	 
//=============================================================
	 //this request is user for the delete project table row...
	 @DELETE
	 @Path("project/{no}")
	public String deleteProject(@PathParam("no")String prj_no)
	{
		int a=prepo.deleteProject(prj_no);
		String result="";
		if(a>0)
		{
				result="delete successfully done...";
		}
		else
		{
			result="delete failed pls try later...";
		}
		return result;	 
	}
	 
}

	
	

