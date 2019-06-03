package sce.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sce.model.User;
import sce.model.UserDAO;

@WebServlet("/AlterarUser")
public class AlterarUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AlterarUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			User user = new User();
			Integer id = Integer.parseInt(request.getParameter("user_id").trim());
			user.setId(id);
			user.setUsername(request.getParameter("user_name"));
			user.setLogin(request.getParameter("user_login"));
			user.setPassword(request.getParameter("user_password"));
			
			UserDAO.AlterarUser(user);
			
			response.sendRedirect("admin/admin.jsp?msg_success=Usuário alterado com sucesso");
		}
		
		catch(Throwable theException) {
			System.out.println(theException);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
