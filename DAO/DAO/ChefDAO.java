package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Business.Chef;
import Business.GestionEmploye;
import Business.GestionUser;

public class ChefDAO {

	public static ArrayList<Chef> getAll() {
		ArrayList<Chef> listeAllChefs = new  ArrayList<Chef>();
		try {
		Statement st = ConnectionSingleton.getConn().createStatement();
		String getAll = "SELECT * FROM chefs";
		ResultSet result = st.executeQuery(getAll);
		while(result.next()) {
			listeAllChefs.add(resultToChef(result));
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listeAllChefs;
	}
	
	private static Chef resultToChef(ResultSet result) {
		Chef chef = new Chef();
		
		try {
			chef.setChef_id(result.getInt("chef_id"));
			chef.setEmploye(GestionEmploye.getEmploye(result.getInt("employe_id")));
			chef.setUser(GestionUser.getUser(result.getInt("user_id")));
			chef.setService_nom(result.getString("service_nom"));
			chef.setDate_creation(HelpersDAO.dateToLocalDateTime(result.getDate("date_creation")));
			chef.setDate_modification(HelpersDAO.dateToLocalDateTime(result.getDate("date_modification")));
			chef.setArchived(result.getBoolean("archived"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return chef;
	}
}
