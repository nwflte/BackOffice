package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	
	public static int add(Chef chef) {
		String addChef = "INSERT into chefs(employe_id, user_id, service_nom, date_creation, date_modification, archived) values(?,?,?,?,?,?)";
		String generatedColumns[] = {"chef_id"};
		
		PreparedStatement st;
		try {
			st = ConnectionSingleton.getConn().prepareStatement(addChef, generatedColumns);
			st.setInt(1, chef.getEmploye().getEmploye_id());
			st.setInt(2, chef.getUser().getUser_id());
			st.setString(3, chef.getService_nom());
			st.setDate(4, Date.valueOf(chef.getDate_creation().toLocalDate()));
			st.setDate(5, Date.valueOf(chef.getDate_creation().toLocalDate()));
			st.setBoolean(6, false);
			
			st.executeUpdate();
			ResultSet rs = st.getGeneratedKeys();
			return rs.getInt("chef_id");
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
		
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
