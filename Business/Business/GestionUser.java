package Business;

import java.util.ArrayList;
import java.util.Optional;

import DAO.UserDAO;

public class GestionUser {
	
	private static ArrayList<User> listeUsers;
	
	static {
		listeUsers = UserDAO.getAll();
	}
	
	public static User getUser(int id) {
		Optional<User> user = listeUsers.stream().filter(usr -> usr.getUser_id() == id).findAny();
		return user.isPresent() == true ? user.get() : null;
	}
	
	public static ArrayList<User> getAllUsers() {
		return listeUsers;
	}
	
	public static boolean addUser(User user) {
		if ( user == null ) return false;
		if( listeUsers.stream().anyMatch(us -> us.getUsername().equals(user.getUsername())) ) return false;
		int id = UserDAO.add(user);
		if(id == 0) return false;
		else user.setUser_id(id);
		listeUsers.add(user);
		return true;
	}
}
