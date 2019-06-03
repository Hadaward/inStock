package sce.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/ProdutoDAO")
public class ProdutoDAO extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Connection currentCon = sce.connection.ConnectionManager.getConnection();
	static ResultSet rs = null;
	static ResultSet nu = null;   
    
    public ProdutoDAO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public static void NovoProduto(Produto produto) {
		
		String nome = produto.getName();
		String codigo = produto.getCodigo();
		String descricao = produto.getDescricao();
		String unidade = produto.getUnidade();
		String fornecedor = produto.getFornecedor();
		int quantidade = 0;
		
		String sql = "INSERT INTO produto(produto_name,produto_codigo,produto_unidade,produto_fornecedor,produto_quant,produto_descricao) VALUES(?,?,?,?,?,?)";
		
        try { 
            PreparedStatement stmt = currentCon.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, codigo);
            stmt.setString(3, unidade);
            stmt.setString(4, fornecedor);
            stmt.setInt(5, quantidade);
            stmt.setString(6, descricao);
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
		
	}
	
	public Produto buscarProduto(int id){
		String sql = "SELECT * FROM produto WHERE produto_id=?";
		Produto retorno = null;
		try {
			PreparedStatement stmt = currentCon.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet resultado = stmt.executeQuery();
			if(resultado.next()) {
				retorno = new Produto();
				retorno.setId(resultado.getInt("produto_id"));
				retorno.setName(resultado.getString("produto_name"));
				retorno.setCodigo(resultado.getString("produto_codigo"));
				retorno.setUnidade(resultado.getString("produto_unidade"));
				retorno.setFornecedor(resultado.getString("produto_fornecedor"));
				retorno.setDescricao(resultado.getString("produto_descricao"));
				retorno.setQuantidade(resultado.getInt("produto_quant"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retorno;		
	}
	
		
	public static void AlterarProduto(Produto produto) {
		
		int id = produto.getId();
		String codigo = produto.getCodigo();
		String nome = produto.getName();
		String descricao = produto.getDescricao();
		String unidade = produto.getUnidade();
		String fornecedor = produto.getFornecedor();
		int quantidade = produto.getQuantidade();
				
		String sql = "UPDATE produto SET produto_name=?,produto_descricao=?,produto_unidade=?,produto_fornecedor=?,produto_quant=?,produto_codigo=? WHERE produto_id=?";
		
        try { 
            PreparedStatement stmt = currentCon.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, descricao);
            stmt.setString(3, unidade);
            stmt.setString(4, fornecedor);
            stmt.setInt(5, quantidade);
            stmt.setString(6, codigo);
            stmt.setInt(7, id);
            
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
		
	}
	
	public static void ExcluirProduto(int id) {
		
		String sql = "DELETE FROM produto WHERE produto_id=?";
		String rmvEntrada = "DELETE FROM entrada WHERE produto_id=?";
		String rmvSaida = "DELETE FROM saida WHERE produto_id=?";
        	
		
		try { 
            PreparedStatement stmt = currentCon.prepareStatement(rmvEntrada);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
            
            stmt = currentCon.prepareStatement(rmvSaida);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
            
            stmt = currentCon.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
		
	}
	
	public List<Produto> listar(){
		String sql = "SELECT * FROM produto";
		List<Produto> retorno = new ArrayList<Produto>();
		try {
			PreparedStatement stmt = currentCon.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery();
			while(resultado.next()) {
				Produto produto = new Produto();
				produto.setId(resultado.getInt("produto_id"));
				produto.setCodigo(resultado.getString("produto_codigo"));
				produto.setName(resultado.getString("produto_name"));
				produto.setDescricao(resultado.getString("produto_descricao"));
				produto.setUnidade(resultado.getString("produto_unidade"));
				produto.setFornecedor(resultado.getString("produto_fornecedor"));
				produto.setQuantidade(resultado.getInt("produto_quant"));
				retorno.add(produto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retorno;		
	}
	
	
}