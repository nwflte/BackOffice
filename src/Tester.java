

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;

import Business.Chef;
import Business.Document;
import Business.Employe;
import Business.Etape;
import Business.GestionChef;
import Business.GestionDocument;
import Business.GestionEmploye;
import Business.GestionEtape;
import Business.GestionProcedure;
import Business.GestionUser;
import Business.Procedure;
import Business.User;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("Business.GestionProcedure").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println(GestionUser.getUser(1).getUsername());
		
		Etape etape = new Etape();
		etape.setEtape_nom("testetape");
		etape.setEmploye(GestionEmploye.getEmploye(1));
		etape.setNbr_documents(2);
		etape.setDate_creation(LocalDateTime.now());
		etape.setDate_modification(LocalDateTime.now());
		etape.setDocuments(new ArrayList(GestionDocument.getAllDocuments().subList(2, 4)));
		
		GestionEtape.addEtape(etape);
		GestionEtape.getAllEtapes().forEach(d -> System.out.println(d.getEtape_nom()));
		
		///////////
		
		Procedure procedure = new Procedure();
		procedure.setChef(GestionChef.getChef(1));
		procedure.setDate_creation(LocalDateTime.now());
		procedure.setDate_modification(LocalDateTime.now());
		procedure.setProcedure_nom("testprocedure");
		procedure.setService_nom("service1");
		procedure.setNbr_etapes(2);
		procedure.setNbr_documents(2);
		procedure.setDocuments(new ArrayList(GestionDocument.getAllDocuments().subList(2, 4)));
		procedure.setEtapes(new ArrayList(GestionEtape.getAllEtapes().subList(0, 2)));
		
		GestionProcedure.addProcedure(procedure);
		GestionProcedure.getAllProcedures().forEach(d -> System.out.println(d.getProcedure_nom()));
		
		////////
		
		Employe employe = new Employe();
		employe.setCIN("B1122");
		employe.setDate_creation(LocalDateTime.now());
		employe.setDate_modification(LocalDateTime.now());
		employe.setDate_naissance(LocalDateTime.of(LocalDate.of(1960, Month.AUGUST, 12), LocalTime.now()));
		employe.setDate_recrutement(LocalDateTime.of(LocalDate.of(2000, Month.AUGUST, 12), LocalTime.now()));
		employe.setEmail("employe@email.com");
		employe.setGenre("male");
		employe.setSomme("54643");
		employe.setTelephone("06102023555");
		employe.setNom("naoufal");
		employe.setPrenom("naoufal");
		employe.setUser(new User("useremploye11", "password", "employe", LocalDateTime.now()));
		
		GestionEmploye.addEmploye(employe);
		GestionEmploye.getAllEmployes().forEach(d -> System.out.println(d.getNom() + d.getUser().getUsername()));
		
		//////
		
		Chef chef = new Chef();
		chef.setDate_creation(LocalDateTime.now());
		chef.setDate_modification(LocalDateTime.now());
		chef.setService_nom("Service");
		chef.setEmploye(GestionEmploye.getEmploye(2));
		chef.setUser(new User("userchef", "password", "chef", LocalDateTime.now()));
		
		GestionChef.addChef(chef);
		GestionChef.getAllChefs().forEach(d -> System.out.println(d.getChef_id() + " " + d.getEmploye().getNom()));
	}

}
