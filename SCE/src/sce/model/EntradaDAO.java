package sce.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EntradaDAO {
	static Connection currentCon = sce.connection.ConnectionManager.getConnection();
	
	public EntradaDAO() {
		super();
	}
	
	public static void Entrada(int id, int quant) {
			
		String sql = "INSERT INTO entrada(produto_id,entrada_quantidade) VALUES(?,?)";
		
        try { 
            PreparedStatement stmt = currentCon.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setInt(2, quant);
            stmt.execute();
            stmt.close();
            
            
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
	}
	
	public static void Saida(int id, int quant) {
		
		String sql = "INSERT INTO saida(produto_id,saida_quantidade) VALUES(?,?)";
		
        try { 
            PreparedStatement stmt = currentCon.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setInt(2, quant);
            stmt.execute();
            stmt.close();
            
            
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
	}
	
	
}
