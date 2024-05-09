package Project;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import todo.TodoBean;
import todo.TodoDAO;

@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewProjectServlet extends HttpServlet
{
	
	 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
	
		HttpSession hs = req.getSession(false);
		
		
		if(hs!=null)
		{
			
		    ProjectBean pb = new ProjectBean();
		    
		    pb.setProjectId(req.getParameter("Pid")); 
		    
		      pb = new ProjectDAO().getprojectdetails(pb);
		      
		      ArrayList<TodoBean> todoList = new TodoDAO().getTodoDetails(pb);
		      
		      
		      hs.setAttribute("todo", todoList);
		      
		    req.setAttribute("projectopen", pb);
		    
			req.getRequestDispatcher("OpenProject.jsp").forward(req, resp);
			
			
		}else {
			
			PrintWriter pw = resp.getWriter();
			
			resp.setContentType("html/text");  pw.println("Session expired...");   req.getRequestDispatcher("login.html").include(req, resp);
			
			
			
		}
		
		
		
	}	
	
	
	
	
	

}
