package sce.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sce.model.EntradaDAO;
import sce.model.Produto;
import sce.model.ProdutoDAO;

@WebServlet("/EntradaProduto")
public class EntradaProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EntradaProduto() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Produto prodOld = new Produto();
			Produto prodNew = new Produto();
			ProdutoDAO dao = new ProdutoDAO();
								
			int id = Integer.parseInt(request.getParameter("produto_id"));
			int qntEntrada = Integer.parseInt(request.getParameter("qnt_entrada"));
			prodOld = dao.buscarProduto(id);
			
			prodNew.setId(prodOld.getId());
			prodNew.setCodigo(prodOld.getCodigo());
			prodNew.setName(prodOld.getName());
			prodNew.setUnidade(prodOld.getUnidade());
			prodNew.setDescricao(prodOld.getDescricao());
			prodNew.setFornecedor(prodOld.getFornecedor());
			int qntNew = prodOld.getQuantidade() + qntEntrada;
			EntradaDAO.Entrada(id, qntNew);
			prodNew.setQuantidade(qntNew);
			
			ProdutoDAO.AlterarProduto(prodNew);
			
			response.sendRedirect("user/user.jsp?msg_success=Entrada feita com sucesso");
		}
		
		catch(Throwable theException) {
			System.out.println(theException);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
