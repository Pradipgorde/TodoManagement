package login;

import static login.DBConnection.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionDAO implements DBConnection
{
    public static Connection con ;
	
	
	public static Connection getConnection()
	{try {
		
	System.out.println("hello 1");
				Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println(" hello 2");
            con = DriverManager.getConnection(url, uname, pwd);
		System.out.println(" hello");
		
	} catch (ClassNotFoundException e) 
	{
		e.printStackTrace();
		System.out.println(" class not found");
		
	} catch (SQLException e) {
		System.out.println(" sql exception");
	}
	
		System.out.println("connection......."+con);
		return  con;
		
	}
	
	

}
 