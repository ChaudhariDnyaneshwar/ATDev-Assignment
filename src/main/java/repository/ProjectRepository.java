package repository;

import java.util.ArrayList;
import java.util.List;

import pojo.Project;

public class ProjectRepository {
	
	
	public List<Project> getAllProject()
	{
		ArrayList<Project> plist=new ArrayList<>();
		
		Project p=new Project();
		p.setPrj_name("service hub");
		p.setPrj_no("1");
		p.setPrj_dur(5);
		p.setPrj_platform("java");
		plist.add(p);
		
		return plist;
	}

}
