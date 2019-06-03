package sce.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sce.model.User;
import sce.model.UserDAO;


@WebServlet("/NovoUser")
public class NovoUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NovoUser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			User user = new User();
			user.setUsername(request.getParameter("user_name"));
			user.setLogin(request.getParameter("user_login"));
			user.setPassword(request.getParameter("user_password"));
			
			if (UserDAO.buscarUserbyLogin(user.getLogin())) {
				response.sendRedirect("admin/admin.jsp?msg_error=Login já cadastrado!");
			} else {
				UserDAO.NovoUser(user);
				response.sendRedirect("admin/admin.jsp?msg_success=Novo usuario cadastrado com sucesso!");
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
