package sce.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sce.model.Produto;
import sce.model.ProdutoDAO;


@WebServlet("/NovoProduto")
public class NovoProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public NovoProduto() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Produto prod = new Produto();
			prod.setCodigo(request.getParameter("produto_codigo"));
			prod.setName(request.getParameter("produto_nome"));
			prod.setDescricao(request.getParameter("produto_descricao"));
			prod.setUnidade(request.getParameter("produto_unidade"));
			prod.setFornecedor(request.getParameter("produto_fornecedor"));
						
			ProdutoDAO.NovoProduto(prod);
			
			response.sendRedirect("user/user.jsp?msg_success=Produto adicionado com sucesso!");
			
		}
		
		catch(Throwable theException) {
			System.out.println(theException);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
