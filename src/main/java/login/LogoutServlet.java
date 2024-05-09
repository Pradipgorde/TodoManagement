package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet
{
	
	
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		
		HttpSession hs = req.getSession(false);
		
		hs.invalidate();
	
		//hs.setMaxInactiveInterval(0);
		hs=null;
		
		req.getRequestDispatcher("login.html").forward(req, res);
		
		
	}
	

}
