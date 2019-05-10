package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionSingleton {
	private static Connection connection;
	
	static {
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root", "");
				System.out.println("Connecté a la base de donnees");
			} catch (Exception e) {
				e.printStackTrace();
			} 	
	}
	
	public static Connection getConn() {
		return connection;
	}
}
