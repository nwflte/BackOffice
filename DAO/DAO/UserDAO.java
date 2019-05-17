package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	
	public static int add(User user) {
		String addUser = "INSERT INTO users(username, password, role, date_creation)"
				+ " VALUES(?,?,?,?)";
		
		PreparedStatement st;
		try {
			st = ConnectionSingleton.getConn().prepareStatement(addUser, PreparedStatement.RETURN_GENERATED_KEYS);
			st.setString(1, user.getUsername());
			st.setString(2, user.getPassword());
			st.setString(3, user.getRole());
			st.setDate(4, Date.valueOf(user.getDate_creation().toLocalDate()));
			
			st.executeUpdate();
			ResultSet rs = st.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);
		}  catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
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

	public static boolean remove(User user) {
		String remove = "DELETE FROM users where user_id = " + user.getUser_id();
		
		try {
			Statement st = ConnectionSingleton.getConn().createStatement();
			st.executeUpdate(remove);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
}
