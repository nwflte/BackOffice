package GestionProcedure.Controller;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.UIManager;

import Business.GestionProcedure;
import Business.Procedure;
import GestionProcedure.Model.MainProcedureTableModel;
import GestionProcedure.View.MainProcedure;

/**
 * Controller de la fenetre principale (autres controllers vont etre ajoutes pour d'autre fenetres "Dialogs")
 * @author naouf
 *
 */
public class MainProcedureController {
	
	MainProcedure frame;
	
	public MainProcedureController() {
		frame = new MainProcedure(new MainProcedureTableModel());
		frame.pack();
		frame.validate();
		frame.setVisible(true);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				System.out.println("Working Directory = " +
			              System.getProperty("user.dir"));
				try {
					 UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					 //UIManager.setLookAndFeel(ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel());
					 Class.forName("Business.GestionProcedure").newInstance(); //Charger la classe (Initialiser depuis BD)
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				new MainProcedureController();
			}
		});
	}
}
