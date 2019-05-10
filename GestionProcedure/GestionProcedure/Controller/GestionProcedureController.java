package GestionProcedure.Controller;

import java.awt.EventQueue;
import java.util.ArrayList;

import Business.GestionProcedure;
import Business.Procedure;
import GestionProcedure.Model.MainProcedureTableModel;
import GestionProcedure.View.MainProcedure;

/**
 * Controller de la fenetre principale (autres controllers vont etre ajoutes pour d'autre fenetres "Dialogs")
 * @author naouf
 *
 */
public class GestionProcedureController {
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Class.forName("Business.GestionProcedure").newInstance(); //Charger la classe (Initialiser depuis BD)
					ArrayList<Procedure> list = GestionProcedure.getAllProcedures(); //Test getAll
					Procedure proc = GestionProcedure.getProcedureCommencePar("proce"); //Test recherche par nom
					
					MainProcedure frame = new MainProcedure(new MainProcedureTableModel()); //Test affichage liste procedure
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
