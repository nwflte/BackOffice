package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Business.Employe;
import Business.GestionUser;
import Business.User;

public class EmployeDAO {
	
	public static ArrayList<Employe> getAll() {
		ArrayList<Employe> listeAllEmployes = new  ArrayList<Employe>();
		try {
		Statement st = ConnectionSingleton.getConn().createStatement();
		String getAll = "SELECT * FROM employes";
		ResultSet result = st.executeQuery(getAll);
		while(result.next()) {
			listeAllEmployes.add(resultToEmploye(result));
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listeAllEmployes;
	}
	
	
	public static int add(Employe employe) {
		String addEmp = "INSERT INTO employes(user_id, somme, nom, prenom, email, genre, CIN, telephone,"
				+ "date_naissance, date_recrutement, date_creation, date_modification, archived) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement st;
		try {
			st = ConnectionSingleton.getConn().prepareStatement(addEmp, PreparedStatement.RETURN_GENERATED_KEYS);
			st.setInt(1, employe.getUser().getUser_id());
			st.setString(2, employe.getSomme());
			st.setString(3, employe.getNom());
			st.setString(4, employe.getPrenom());
			st.setString(5, employe.getEmail());
			st.setString(6, employe.getGenre());
			st.setString(7, employe.getCIN());
			st.setString(8, employe.getTelephone());
			st.setDate(9, Date.valueOf(employe.getDate_naissance().toLocalDate()));
			st.setDate(10, Date.valueOf(employe.getDate_recrutement().toLocalDate()));
			st.setDate(11, Date.valueOf(employe.getDate_creation().toLocalDate()));
			st.setDate(12, Date.valueOf(employe.getDate_modification().toLocalDate()));
			st.setBoolean(13, false);
			
			st.executeUpdate();
			ResultSet rs = st.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);
			
		}catch (SQLException e) {
			GestionUser.removeUser(employe.getUser());
			e.printStackTrace();
			return 0;
		}
	}


	private static Employe resultToEmploye(ResultSet result) {
		Employe employe = new Employe();
		
		try {
			employe.setEmploye_id(result.getInt("employe_id"));
			employe.setUser(GestionUser.getUser(result.getInt("user_id")));
			employe.setSomme(result.getString("somme"));
			employe.setNom(result.getString("nom"));
			employe.setPrenom(result.getString("prenom"));
			employe.setEmail(result.getString("email"));
			employe.setGenre(result.getString("genre"));
			employe.setCIN(result.getString("CIN"));
			employe.setTelephone(result.getString("telephone"));
			employe.setDate_naissance(HelpersDAO.dateToLocalDateTime(result.getDate("date_naissance")));
			employe.setDate_recrutement(HelpersDAO.dateToLocalDateTime(result.getDate("date_recrutement")));
			employe.setDate_creation(HelpersDAO.dateToLocalDateTime(result.getDate("date_creation")));
			employe.setDate_modification(HelpersDAO.dateToLocalDateTime(result.getDate("date_modification")));
			employe.setArchived(result.getBoolean("archived"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return employe;
	}
	
}
