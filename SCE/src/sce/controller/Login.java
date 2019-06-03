package sce.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sce.model.User;
import sce.model.UserDAO;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			User user = new User();
			user.setLogin(request.getParameter("login"));
			user.setPassword(request.getParameter("password"));
			
			UserDAO.login(user);
			
			if(user.getIsValid()) {
				HttpSession session = request.getSession();
				session.setAttribute("currentSessionUser", user);
				session.setAttribute("admin", user.getAdmin());
				if(user.getAdmin()) {
					response.sendRedirect("admin/admin.jsp");
				} else {
					response.sendRedirect("user/user.jsp");
				}
			} else 
			{
				response.sendRedirect("index.jsp?msg_error=Usuario nao cadastrado");
			}
		}
		
		catch(Throwable theException) {
			System.out.println(theException);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
