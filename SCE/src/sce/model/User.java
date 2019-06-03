package sce.model;
public class User {
	public int user_id;
	public String user_name;
	public String login;
	public String password;
	public boolean admin;
	public boolean isValid;
	
	public int getId() {
		return user_id;
	}
	
	public void setId(int user_id) {
		this.user_id = user_id;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getUsername() {
		return user_name;
	}
	
	public void setUsername(String username) {
		this.user_name = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean getAdmin() {
		return admin;
	}
	
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	public boolean getIsValid() {
		return isValid;
	}
	
	public void setIsValid(boolean isValid) {
		this.isValid = isValid;
	}
	

}
