package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/register")
public class RegisterServlet extends HttpServlet
{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
	
       LoginBean lb= new LoginBean();
 
       PrintWriter pw = res.getWriter();
 
        lb.setEmail(req.getParameter("mail"));  lb.setName(req.getParameter("name")); lb.setPassword(req.getParameter("password"));
 
      Boolean register = new RegisterDAO().getRegister(lb);
 
        if(register)
        {
        	
        		pw.println(" <script>  document.prompt(' Register Sucessfully you can login now') </script");
        	
        	req.getRequestDispatcher("login.html").include(req, res);
        	
        	
        	
        }
        else { pw.println(" <script>  document.prompt(' You are old user login please') </script");
	
        req.getRequestDispatcher("login.html").include(req, res);
        
	}
	}
	

}

	
	
	

