package sce.connection;

import java.sql.*;

public class ConnectionManager {
	static Connection con;
	static String url;
	
	public static Connection getConnection() {
		try {
			String url ="jdbc:mysql://localhost:3306/sce?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				con=DriverManager.getConnection(url,"root","");
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
		} catch(ClassNotFoundException e) {
			System.out.print(e);
		}
		return con;
	}
}
