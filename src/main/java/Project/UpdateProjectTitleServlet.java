package Project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/ptitle")
public class UpdateProjectTitleServlet extends HttpServlet
{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
	        
		HttpSession hs = req.getSession(false);
		if(hs!=null)
		{
			
			
			String pid = req.getParameter("pid");
			
			req.setAttribute("pid", pid);
			
			 req.getRequestDispatcher("EditTitle.jsp").forward(req, resp);
			 
			
			
			
			
			
		}else {
PrintWriter pw = resp.getWriter();
			
			resp.setContentType("html/text");  pw.println("Session expired...");   req.getRequestDispatcher("login.html").include(req, resp);
			
		}
         	
	
	}
	
	
	

}
