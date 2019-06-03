package sce.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

@WebServlet("/UserDAO")
public class UserDAO {
	static Connection currentCon = sce.connection.ConnectionManager.getConnection();
	static ResultSet rs = null;
	static ResultSet nu = null;
	
	public UserDAO() {
		super();
	}
	
	public static User login(User user) {
		Statement stmt = null;
		
		String login = user.getLogin();
		String password = user.getPassword();
		
		String searchQuery =
				"SELECT * FROM user WHERE user_login='"
				+ login
				+ "' AND user_password='"
				+ password+"'";
		
		try {
			stmt=currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();
			
			if(!more) {
				System.out.println("Usu�rio n�o registrado");
				user.setIsValid(false);
			} else if(more) {
				String name = rs.getString("user_name");
				boolean isAdmin = rs.getBoolean("user_admin");
				user.setUsername(name);
				if(isAdmin) {
					user.setAdmin(true);
				} else {
					user.setAdmin(false);
				}
				user.setIsValid(true);
			}
		}
		catch(Exception ex) {
			System.out.println("Login falhou!"+ex);
		}
		
		
		return user;
	}
	
	public static void NovoUser(User user) {
					
		String name = user.getUsername();
		String login = user.getLogin();
		String password = user.getPassword();
		
		String sql = "INSERT INTO user(user_name,user_login,user_password,user_admin) VALUES(?,?,?,?)";
		
        try { 
            PreparedStatement stmt = currentCon.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, login);
            stmt.setString(3, password);
            stmt.setBoolean(4, false);
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
		
	}
	
	public User buscarUser(int user_id){
		String sql = "SELECT * FROM user WHERE user_id=?";
		User retorno = null;
		try {
			PreparedStatement stmt = currentCon.prepareStatement(sql);
			stmt.setInt(1, user_id);
			ResultSet resultado = stmt.executeQuery();
			if(resultado.next()) {
				retorno = new User();
				retorno.setId(resultado.getInt("user_id"));
				retorno.setUsername(resultado.getString("user_name"));
				retorno.setLogin(resultado.getString("user_login"));
				retorno.setPassword(resultado.getString("user_password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retorno;		
	}
	
	public static boolean buscarUserbyLogin(String login){
		String sql = "SELECT * FROM user WHERE user_login=?";
		User retorno = null;
		try {
			PreparedStatement stmt = currentCon.prepareStatement(sql);
			stmt.setString(1, login);
			ResultSet resultado = stmt.executeQuery();
			if(resultado.next()) {
				retorno = new User();
				retorno.setLogin(resultado.getString("user_login"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (retorno != null) {
			return true;
		} else {
			return false;
		}
			
	}
	
		
	public static void AlterarUser(User user) {
		
		String name = user.getUsername();
		String login = user.getLogin();
		String password = user.getPassword();
		int id = user.getId();
		
		String sql = "UPDATE user SET user_name=?,user_password=?, user_login=? WHERE user_id=?";
		
        try { 
            PreparedStatement stmt = currentCon.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, password);
            stmt.setString(3, login);
            stmt.setInt(4, id);
                      
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
		
	}
	
	public static void ExcluirUser(int user_id) {
		
		String sql = "DELETE FROM user WHERE user_id=?";
		
        try { 
            PreparedStatement stmt = currentCon.prepareStatement(sql);
            stmt.setInt(1, user_id);
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
		
	}
	
	public List<User> listar(){
		String sql = "SELECT * FROM user WHERE user_admin=false";
		List<User> retorno = new ArrayList<User>();
		try {
			PreparedStatement stmt = currentCon.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery();
			while(resultado.next()) {
				User user = new User();
				user.setId(resultado.getInt("user_id"));
				user.setUsername(resultado.getString("user_name"));
				user.setLogin(resultado.getString("user_login"));
				user.setPassword(resultado.getString("user_password"));
				user.setAdmin(resultado.getBoolean("user_admin"));
				retorno.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retorno;		
	}
}
