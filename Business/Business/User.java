package Business;

import java.time.LocalDateTime;

public class User {
	private int user_id;
	private String username;
	private String password;
	private String role; //Enumeration ?
	private LocalDateTime date_creation;
	
	public User() {
		
	}
	
	public User(String username, String password, String role, LocalDateTime date_creation) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.date_creation = date_creation;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public LocalDateTime getDate_creation() {
		return date_creation;
	}
	public void setDate_creation(LocalDateTime date_creation) {
		this.date_creation = date_creation;
	}
	
	
}
