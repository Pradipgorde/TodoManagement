package Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import login.ConnectionDAO;
import login.LoginBean;

public class ProjectDAO 
{
	
	ArrayList<ProjectBean> list=null;
	
	
	public ArrayList<ProjectBean> getProjectDetails(LoginBean lb)
	{
		list=	new ArrayList<ProjectBean>();
		
		 
		 try( Connection con = ConnectionDAO.getConnection();)
		 {
			PreparedStatement ps = con.prepareStatement("select pId,pTitle from project where email=?");
			
			ps.setString(1, lb.getEmail());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
			
			ProjectBean pb = new ProjectBean();
			pb.setProjectId(rs.getString(1)); pb.setProjectTitle(rs.getString(2));
			list.add(pb);
			
			}
		 
		 
		 }
		 catch (SQLException e)
		 {
		  System.out.println(e.getMessage());
		 
		 }
		
		
		
		
		return list;
	}
	
	
	
	
	
	public int createProject(ProjectBean pb) throws Exception
	{
		int k=0;
		
		try( Connection con = ConnectionDAO.getConnection())
		{
			
			PreparedStatement ps = con.prepareStatement(" insert into project(pid,ptitle,createon,email) values(?,?,?,?)");
			
			ps.setString(1, pb.getProjectId());
			ps.setString(2, pb.getProjectTitle()); 
						ps.setDate(3, pb.getDate());
			ps.setString(4, pb.getEmail_id());
			
			k = ps.executeUpdate();
			if(k>0)
			{
				return k;
			}
			
			
			
		}catch(Exception e) {  
			
		
		throw e;
		
		}
		
		
		
		
		
		return k;
	}
	
	
	
	
	public ProjectBean getprojectdetails( ProjectBean pb) 
	{
		
		Connection con= ConnectionDAO.getConnection();
		
		try {
		PreparedStatement ps = con.prepareStatement("select pid,ptitle,createon from project where pid=?");
		
		ps.setString(1, pb.getProjectId()); 
		ResultSet rs = ps.executeQuery();
		
		if(rs.next())
		{
			pb.setProjectId(rs.getString(1));      pb.setProjectTitle(rs.getString(2));
			pb.setDate(rs.getDate(3));   
		
			System.out.println(pb.getProjectId()+pb.getDate()+pb.getProjectTitle());
			
		}
		
		
		PreparedStatement ps1 = con.prepareStatement("select count(*) AS todo_list from todo where pid=?");
		
		ps1.setString(1, pb.getProjectId());
		ResultSet rs1 = ps1.executeQuery();
		
		if(rs1.next());
		pb.setList_of_TODO(rs1.getInt(1));
		
		System.out.println("total"+pb.getList_of_TODO());
		PreparedStatement ps2 = con.prepareStatement("select count(*) AS completed_Todo from todo where status=? And pid=? ");
		
		ps2.setString(1, "completed"); ps2.setString(2,pb.getProjectId() );
		 

		ResultSet rs2= ps2.executeQuery();
		
		if(rs2.next()) {
			pb.setComplted_todo(rs2.getInt(1));
		System.out.println("coplted "+pb.getComplted_todo());	
		}

		
		
		}catch(Exception e) {e.printStackTrace();}
		
		
		return pb;
		
	}
	
	
	
	
	public int updateTitle(ProjectBean  pb)
	{
		int k=0;		
		try {
			
			Connection con = ConnectionDAO.getConnection();
			
			PreparedStatement ps = con.prepareStatement("update project set title=? where pid=?");
			
			ps.setString(1, pb.getProjectTitle()); ps.setString(2, pb.getProjectId());
			
			k= ps.executeUpdate();
			if(k>0)
			{
				return k;
			}
			
			
		}catch (Exception e) {e.printStackTrace();}
		
		
		return k;
	}
	
	
	

}
