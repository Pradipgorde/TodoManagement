package todo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
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
@WebServlet("/newtodo")
public class NewTodoServlet  extends HttpServlet
{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
	
 	 HttpSession hs = req.getSession(false);
 	 
 	 if(hs!=null)
 	 {
 		 TodoBean tb = new TodoBean();
 		 try {
 			 

 	 		
 	 		 
 	 		 tb.setTodo_id(req.getParameter("tid"));  tb.setDescption(req.getParameter("desc"));  tb.setStatus(req.getParameter("status")); 
 	 		 tb.setProjectId(req.getParameter("pid1"));
 	 		 tb.setCreateOn(Date.valueOf(LocalDate.now())); tb.setUpdate(Date.valueOf(LocalDate.now()));
 	 		 
 	 		 System.out.println("projec "+tb.getStatus());
 	 		 
 	 		 int k = new TodoDAO().insertTodo(tb);
 	 		 
 	 		 if(k>0)
 	 		 {
 	 			req.setAttribute("msg", " todo created sucessfully....");
 	           ProjectBean pb = new ProjectBean();
 			    pb.setProjectId(tb.getProjectId());
 			    
 			      pb = new ProjectDAO().getprojectdetails(pb);
 			      
 			      ArrayList<TodoBean> todoList = new TodoDAO().getTodoDetails(pb);
 			      
 			      
 			      hs.setAttribute("todo", todoList);
 			      
 			    req.setAttribute("projectopen", pb);
 			    
 				req.getRequestDispatcher("OpenProject.jsp").forward(req, resp);
 				
 	 			 
 	 		 }

 			 
 			 
 		 }catch (Exception e)
 		 {
 			 
 			req.setAttribute("msg", " Todo already created....");
 			 
 			   ProjectBean pb = new ProjectBean();
			    pb.setProjectId(tb.getProjectId());
			    
			      pb = new ProjectDAO().getprojectdetails(pb);
			      
			      ArrayList<TodoBean> todoList = new TodoDAO().getTodoDetails(pb);
			      
			      
			      req.setAttribute("todo", todoList);
			      
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
