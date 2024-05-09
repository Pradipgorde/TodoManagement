package todo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Project.ProjectBean;
import login.ConnectionDAO;

public class TodoDAO
{
	ArrayList<TodoBean> todoList =null;
	
	public ArrayList<TodoBean>   getTodoDetails(ProjectBean pb)
	{
		todoList = new ArrayList<TodoBean>();		
		try(Connection con = ConnectionDAO.getConnection();)
		{
		
		PreparedStatement ps = con.prepareStatement("select * from todo where pid=?");
		
		ps.setString(1, pb.getProjectId());
ResultSet rs = ps.executeQuery();

          

while(rs.next())
{
	TodoBean td = new TodoBean();

	td.setTodo_id(rs.getString(1));  td.setDescption(rs.getString(2)); td.setStatus(rs.getString(3));
	td.setCreateOn(rs.getDate(4));  td.setUpdate(rs.getDate(5));   td.setProjectId(rs.getString(6));
	
	
		
	
	
	todoList.add(td);
	
}
		}catch(Exception e) {e.printStackTrace();}
		
		
		
		
		
		return todoList;
	}
	
	
	
	
	public int insertTodo(TodoBean tb) throws SQLException
	{
		int k=0;
		
    Connection con = ConnectionDAO.getConnection();		
	
    try {
    	PreparedStatement ps = con.prepareStatement("insert into todo(tid,description,status,cratedon,upateon,pid) values(?,?,?,?,?,?)");
    	                    
		System.out.println("projected id"+tb.getProjectId());
		
		ps.setString(1,tb.getTodo_id() ); ps.setString(2, tb.getDescption()); ps.setString(3, tb.getStatus());
		ps.setDate(4, tb.getCreateOn()); ps.setDate(5, tb.getUpdate()); ps.setString(6, tb.getProjectId());

		 k = ps.executeUpdate();
		
		 if(k>0) return k;
	} catch (SQLException e) 
    {
	 e.printStackTrace(); e.getMessage();
    throw e;
    }
		
		
		
		
		return k;
	}
	
	
	
	public int getUpdate(TodoBean tb) 
	{
		
		int k=0;
		try {

			Connection con = ConnectionDAO.getConnection();
			
			PreparedStatement ps = con.prepareStatement("update todo set description=?, status=?,upateon=? where tid=? ");
			
			ps.setString(1, tb.getDescption()); ps.setString(2, tb.getStatus()); ps.setDate(3, tb.getUpdate());
			ps.setString(1, tb.getTodo_id());
			
			 k = ps.executeUpdate();
			
			 if(k>0) return k;
			
		}catch (Exception e) {e.printStackTrace();}
		
		
		
		return k;
	}
	
	
	
	
	
public int deleteTodo(TodoBean tb)
{
	int k=0;
	
	try {
		
		Connection con = ConnectionDAO.getConnection();
		
		
		PreparedStatement ps = con.prepareStatement("delete from todo where tid=?");
		
		ps.setString(1, tb.getTodo_id());
		k = ps.executeUpdate();
		if(k>0) {
			return k;
		}
		
		
		
		
		
	}catch(Exception e) {e.printStackTrace();}
	
	
	return k;
}
	
	
	
	

}
