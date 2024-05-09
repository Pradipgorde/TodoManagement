package login;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegisterDAO
{
	
	
	public boolean getRegister(LoginBean lb)
	{
		
		try( Connection con= ConnectionDAO.getConnection();)
		{
			
			PreparedStatement ps = con.prepareStatement("insert into userlogin values(?,?,?)");
			
			ps.setString(1, lb.getEmail()); ps.setString(2, lb.getName()); ps.setString(3, lb.getPassword());
			int k = ps.executeUpdate();
			if(k>0) {
				return true;
			}
			
			
			
		}catch(Exception e)
		{
			return false;
		}
		
		
		
		
		
		return false;
	}

}
