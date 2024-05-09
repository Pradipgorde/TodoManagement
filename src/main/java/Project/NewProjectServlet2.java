package Project;

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

import login.LoginBean;

@SuppressWarnings("serial")
@WebServlet("/newproj")
public class NewProjectServlet2 extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
	
		HttpSession hs = req.getSession(false);
		if(hs!=null)
		{
			try {
				
				ProjectBean pb = new ProjectBean();
				
				pb.setProjectId(req.getParameter("pid")); pb.setEmail_id(req.getParameter("mail")); pb.setProjectTitle(req.getParameter("title"));
				
				pb.setDate(new Date(0).valueOf(LocalDate.now()));
			 
				int k = new ProjectDAO().createProject(pb);
				
				if(k>0)
				{
					req.setAttribute("msg", " Project Created Sucessfully....");
					
					LoginBean lb = (LoginBean)    hs.getAttribute("adminlog");
					
						
					ArrayList<ProjectBean> list = new  ProjectDAO().getProjectDetails(lb);
					
					req.setAttribute("project", list);
					
					
				req.getRequestDispatcher("ProjectView.jsp").forward(req, resp);
					
					
				}
				
				
			}catch(Exception e)
			{
				req.setAttribute("msg", " Project already created....");
				
				LoginBean lb = (LoginBean)    hs.getAttribute("adminlog");
				
				
				ArrayList<ProjectBean> list = new  ProjectDAO().getProjectDetails(lb);
				
				req.setAttribute("project", list);
				
				
			req.getRequestDispatcher("ProjectView.jsp").forward(req, resp);
								
			}
			
			
			 
			
			
		}else {
			
			PrintWriter pw = resp.getWriter();
			resp.setContentType("text/html");

			pw.println("   Session expired");

		 req.getRequestDispatcher("login.html").include(req, resp);

			
		}

		
	}
	
	

}
