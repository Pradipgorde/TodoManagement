package Project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/proj")
public class NewProjectServlet  extends HttpServlet
{
	
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
{
	
	HttpSession hs = req.getSession();
	
       if(hs!=null)
{
	 String mail= req.getParameter("email");
	 
	 
	 req.setAttribute("email", mail); req.getRequestDispatcher("newproject.jsp").forward(req, resp);
}else {
	
	PrintWriter pw = resp.getWriter();

	resp.setContentType("text/html");
	pw.println(" Session expired ");

 req.getRequestDispatcher("login.html").include(req, resp);

	
}
	
}
	
	

}
