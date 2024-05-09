package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Project.ProjectBean;
import Project.ProjectDAO;


@SuppressWarnings("serial")
@WebServlet("/log")
public class LoginServlet extends HttpServlet
{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
	
       LoginBean lb= new LoginBean();
 
 
        lb.setEmail(req.getParameter("uname"));    lb.setPassword(req.getParameter("pwd"));
 
       lb = new LoginDAO().getLogin(lb);
      if(lb!=null)
      {
    	  

			
    	  HttpSession hs = req.getSession();
    	  
    	    	  ArrayList<ProjectBean> pb = new ProjectDAO().getProjectDetails(lb);
    	  
    	 System.out.println(" list"+pb);
			req.setAttribute("msg", "Login Sucessfully...");
			hs.setAttribute("adminlog", lb);
			 req.setAttribute("project", pb);
			
    	     req.getRequestDispatcher("ProjectView.jsp").forward(req, res);
    	  
    	  
    	  
      }{
    		
    		PrintWriter pw = res.getWriter();

    		pw.println(" <script>  document.prompt(' login failed') </script");

    	 req.getRequestDispatcher("login.html").include(req, res);

    		
    	}

 
	 	 
	
	}
	
	

}
