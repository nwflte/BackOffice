package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Business.User;

public class UserDAO {
	
	public static ArrayList<User> getAll() {
		ArrayList<User> listeAllUsers = new  ArrayList<User>();
		try {
		Statement st = ConnectionSingleton.getConn().createStatement();
		String getAll = "SELECT * FROM users";
		ResultSet result = st.executeQuery(getAll);
		while(result.next()) {
			listeAllUsers.add(resultToUser(result));
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listeAllUsers;
		
	}
	
	private static User resultToUser(ResultSet result) {
		User user = new User();
		try {
			user.setUser_id(result.getInt("user_id"));
			user.setUsername(result.getString("username"));
			user.setPassword(result.getString("password"));
			user.setRole(result.getString("role"));
			user.setDate_creation(HelpersDAO.dateToLocalDateTime(result.getDate("date_creation")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;	

	}
	
}
