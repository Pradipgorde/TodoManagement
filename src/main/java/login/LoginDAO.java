package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO 
{
	
	
	public LoginBean getLogin(LoginBean lb)
	{
	LoginBean lb1=null;
	
        Connection con = ConnectionDAO.getConnection();
        
        try {
			PreparedStatement ps = con.prepareStatement("select * from userlogin where email=? AND password=?");
		
        ps.setString(1, lb.getEmail()); ps.setString(2, lb.getPassword());
        
        ResultSet rs = ps.executeQuery();
        
        if(rs.next())
        {
        	String email = rs.getString(1);  String name = rs.getString(2);    String pwd = rs.getString(3);
        	
        	if(email.equals(lb.getEmail())&& pwd.equals(lb.getPassword()) )
        	{
        		 lb1 = new LoginBean();
        		lb1.setEmail(email); lb1.setName(name); lb1.setPassword(pwd);   
        		
        		
        		return lb1;
        	}
        	
        }
        
        } catch (SQLException e) 
        {
		
			e.printStackTrace();
		}
        
        
    	  return lb1;
    
	}
	
	
	
	

}
