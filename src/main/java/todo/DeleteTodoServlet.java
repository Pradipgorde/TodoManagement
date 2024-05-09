package todo;

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

@WebServlet("/delete")
public class DeleteTodoServlet extends HttpServlet
{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
	 
     HttpSession hs = req.getSession(false);
     
     if(hs!=null)
     {
    	 
    	 
    	 TodoBean tb = new TodoBean();
    	 
    	 tb.setTodo_id(req.getParameter("tid"));
    	 
    	 
    	 int k = new TodoDAO().deleteTodo(tb);
    	 if(k>0) {
    		 
    			req.setAttribute("msg", " todo Deleted sucessfully....");
 	           ProjectBean pb = new ProjectBean();
 			    pb.setProjectId(tb.getProjectId());
 			    
 			      pb = new ProjectDAO().getprojectdetails(pb);
 			      
 			      ArrayList<TodoBean> todoList = new TodoDAO().getTodoDetails(pb);
 			      
 			      
 			      hs.setAttribute("todo", todoList);
 			      
 			    req.setAttribute("projectopen", pb);
 			    
 				req.getRequestDispatcher("OpenProject.jsp").forward(req, resp);
 				
    		 
    		 
    		 
    		 
    	 }
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
     }else {
			PrintWriter pw = resp.getWriter();
			resp.setContentType("text/html");

			pw.println("   Session expired");

		 req.getRequestDispatcher("login.html").include(req, resp);

			
		}


     
     
	
	}
	

}
