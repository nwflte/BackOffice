package GestionProcedure.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GestionProcedure.Model.MainProcedureTableModel;
import ui.ActionMenuItem;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import Business.GestionProcedure;
import Business.Procedure;

/**
 * Fenetre principale de gestion des procedures (Autre fenetre "Dialog" vont etre ajoutees)
 * @author naouf
 *
 */
public class MainProcedure extends JFrame {
	
	private static JMenuBar menuBar;
	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public MainProcedure() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = (JPanel) this.getContentPane();
		setBounds(100, 100, 850, 500);
		contentPane = new JPanel(new BorderLayout(5,20));
		setContentPane(contentPane);
		setJMenuBar(getMenuBarr());
		
		JTable table = new JTable(new MainProcedureTableModel());
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JPanel control = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
		JButton addProc = new JButton("Ajouter Procedure");
		JTextField rechercheProc = new JTextField("");
		rechercheProc.setColumns(40);
		control.add(addProc); control.add(rechercheProc);
		
		contentPane.add(control, BorderLayout.NORTH);
		
		GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();

        setMaximizedBounds(e.getMaximumWindowBounds());
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
	}
	
	 private JMenuBar getMenuBarr() {
	        if (menuBar == null) {
	            menuBar = new JMenuBar();
	            /**
	             * First menu -
	             */
	            JMenu startMnu = new JMenu("Application");
	            JMenuItem logOutMnuItem = new JMenuItem("Log Out");
	            //logOutMnuItem.addActionListener(e -> LogOutButton.handleLogout());
	            startMnu.add(logOutMnuItem);
	            JMenuItem exitMnuItem = new JMenuItem("Close");
	            //exitMnuItem.addActionListener(e -> ExitButton.handleExit());
	            startMnu.add(exitMnuItem);
	            menuBar.add(startMnu);
	            /**
	             * Entry Menu
	             */
	            JMenu entryMenu = new JMenu("Entry");
	            entryMenu.add(ActionMenuItem.create("New Procedure", "about.png", "GestionProcedure.View.AddProcedure"));
	            entryMenu.add(ActionMenuItem.create("New Employe", "", "GestionProcedure.View.AddProcedure"));
	            entryMenu.add(ActionMenuItem.create("New Chef", "", "GestionProcedure.View.AddProcedure"));
	            menuBar.add(entryMenu);

	            /**
	             * Search
	             */
	            JMenu searchMnu = new JMenu("Search");
	            searchMnu.add(ActionMenuItem.create("Search Procedure", "", "GestionProcedure.View.AddProcedure"));
	            searchMnu.add(ActionMenuItem.create("Search Employe", "", "GestionProcedure.View.AddProcedure"));
	            searchMnu.add(ActionMenuItem.create("Search Chef", "", "GestionProcedure.View.AddProcedure"));
	            menuBar.add(searchMnu);

	            /**
	             * Tools Menu This ActionMenuItem should be displayed on JDialog
	             */
	            JMenu toolsMenu = new JMenu("Tools");
	            toolsMenu.add(ActionMenuItem.create("Back up BD", "", "GestionProcedure.View.AddProcedure"));
	            toolsMenu.add(new JSeparator());	            
	            toolsMenu.add(ActionMenuItem.create("Change UserName/Password", "", "GestionProcedure.View.AddProcedure"));
	            menuBar.add(toolsMenu);
	            /**
	             * Last Menu
	             */
	            JMenu helpMenu = new JMenu("Help");
	            JMenuItem readmanualItem = new JMenuItem("Read Manual");
	            helpMenu.add(readmanualItem);
	            helpMenu.add(new JSeparator());
	            JMenuItem supportMnu = new JMenuItem("Support");
	            helpMenu.add(supportMnu);

	            menuBar.add(helpMenu);
	        }
	        return menuBar;

	    }
}
