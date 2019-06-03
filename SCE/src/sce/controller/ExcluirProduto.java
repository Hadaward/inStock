package sce.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sce.model.ProdutoDAO;

@WebServlet("/ExcluirProduto")
public class ExcluirProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExcluirProduto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("produto_id")!=null){
			int id = Integer.parseInt(request.getParameter("produto_id"));
			ProdutoDAO.ExcluirProduto(id);
			response.sendRedirect("user/user.jsp?msg_success=Excluido com sucesso!");
		} else {
			response.sendRedirect("user/user.jsp?msg_error=Não foi possível excluir o usuário");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
