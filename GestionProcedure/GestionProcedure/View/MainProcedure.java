package GestionProcedure.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GestionProcedure.Model.MainProcedureTableModel;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import Business.GestionProcedure;
import Business.Procedure;

public class MainProcedure extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Class.forName("Business.GestionProcedure").newInstance();
					ArrayList<Procedure> list = GestionProcedure.getAllProcedures();
					System.out.println("Here");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainProcedure(MainProcedureTableModel mainProcedureTableModel) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 875, 568);
		contentPane = new JPanel(new BorderLayout(5,20));
		setContentPane(contentPane);
		
		
		JTable table = new JTable(mainProcedureTableModel);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JPanel control = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
		JButton addProc = new JButton("Ajouter Procedure");
		JTextField rechercheProc = new JTextField("");
		rechercheProc.setColumns(40);
		control.add(addProc); control.add(rechercheProc);
		
		contentPane.add(control, BorderLayout.NORTH);
	}

}
