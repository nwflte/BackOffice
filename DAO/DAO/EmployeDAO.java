package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Business.Employe;
import Business.GestionUser;

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
