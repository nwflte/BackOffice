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
}
