package GestionProcedure.Controller;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.UIManager;

import Business.GestionProcedure;
import Business.Procedure;
import GestionProcedure.Model.MainProcedureTableModel;
import GestionProcedure.View.AddProcedure;
import GestionProcedure.View.MainProcedure;
import com.seaglasslookandfeel.*;
/**
 * Controller de la fenetre principale (autres controllers vont etre ajoutes pour d'autre fenetres "Dialogs")
 * @author naouf
 *
 */
public class MainProcedureController {
	
	MainProcedure mainProcedureWindow;
	
	public MainProcedureController() {
		mainProcedureWindow = new MainProcedure();
		addListeners();
		mainProcedureWindow.pack();
		mainProcedureWindow.validate();
		mainProcedureWindow.setVisible(true);
		
	}
	
	private void addListeners() {
		mainProcedureWindow.addButtonsListeners("btnAddProc", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				AddProcedureController addProcedureController = new AddProcedureController();
				
			}
			
		});
		
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
					 //UIManager.setLookAndFeel(new com.seaglasslookandfeel.SeaGlassLookAndFeel());
					 Class.forName("Business.GestionProcedure").newInstance(); //Charger la classe (Initialiser depuis BD)
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				new MainProcedureController();
			}
		});
	}
}
