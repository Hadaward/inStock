package sce.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sce.model.UserDAO;

@WebServlet("/ExcluirUser")
public class ExcluirUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExcluirUser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("user_id")!=null){
			int id = Integer.parseInt(request.getParameter("user_id"));
			UserDAO.ExcluirUser(id);
			response.sendRedirect("admin/admin.jsp");
		} else {
			response.sendRedirect("admin/admin.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
