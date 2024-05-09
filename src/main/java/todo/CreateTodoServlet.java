package todo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/todo")
public class CreateTodoServlet extends HttpServlet
{
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
	
		 HttpSession hs = req.getSession(false);
		 
		 if(hs!=null)
		 {

				String pid = req.getParameter("pid");
			 
				 req.setAttribute("Pid", pid); req.getRequestDispatcher("newTodo.jsp").forward(req, resp);
					
			 
			 
		 }else {
				
				PrintWriter pw = resp.getWriter();
				
				resp.setContentType("html/text");  pw.println("Session expired...");   req.getRequestDispatcher("login.html").include(req, resp);
				
				
				
			}
			
		 
		
		
		
	}
	

}
