package simple_session_management.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/profile")
public class ProfileController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpsession = req.getSession();
		
		if(httpsession.getAttribute("userSession") !=null) {
			req.getRequestDispatcher("profile.jsp").forward(req, resp);
		}else {
			req.setAttribute("msg", "you are not logged in ");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		
	}
}
