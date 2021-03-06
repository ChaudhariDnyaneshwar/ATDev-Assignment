package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Project;

public class ProjectRepository {
	
	//this method is use for insert all project information
	public int insertProject(Project p) 
	{
		  int count=0;
		try {
			PreparedStatement ps=DatabaseConnectionRepository.getConnection().prepareStatement("insert into project values(?,?,?,?)");
		    ps.setString(1,p.getPrj_no());
		    ps.setString(2,p.getPrj_name());
		    ps.setInt(3,p.getPrj_dur());
		    ps.setString(4,p.getPrj_platform());
		    count=ps.executeUpdate();  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}

	// this method is use for the get all project information...
	
	public List<Project> getAllProject() 
	{
		ArrayList<Project> plist=new ArrayList<>();
		
		String query="select * from project";
		try {
			PreparedStatement ps=DatabaseConnectionRepository.getConnection().prepareStatement(query);
		     ResultSet rs=ps.executeQuery();
		   while(rs.next())
		   {
			  Project p=new Project();
			  p.setPrj_no(rs.getString(1));
			  p.setPrj_name(rs.getString(2));
			  p.setPrj_dur(rs.getInt(3));
			  p.setPrj_platform(rs.getString(4));
			  plist.add(p);
		   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return plist;
		}

	
	//this method is use for the update project table
	public int updateProject(Project p)
	{
		int count=0;
		String query="update project set prj_name=? , prj_dur=? ,prj_platform=? where prj_no=?";
		try {
		PreparedStatement ps=DatabaseConnectionRepository.getConnection().prepareStatement(query);
	     ps.setString(1,p.getPrj_name());
	     ps.setInt(2,p.getPrj_dur());
	     ps.setString(3,p.getPrj_platform());
	     ps.setString(4,p.getPrj_no());
	    count= ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	//this method is use for the delete the project table row...
	
	public int deleteProject(String prj_no)
	{
		int count=0;
		String query="delete from project where prj_no=?";
		
		try {
			PreparedStatement ps=DatabaseConnectionRepository.getConnection().prepareStatement(query);
		     ps.setString(1, prj_no);
		    count=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
}
