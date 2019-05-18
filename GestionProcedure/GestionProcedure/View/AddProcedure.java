package GestionProcedure.View;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Business.GestionChef;
import Business.IDInterface;
import GestionProcedure.Model.DocumentsTableModel;
import GestionProcedure.Model.EtapesTableModel;
import ui.DataComboBox;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.awt.event.ActionEvent;


public class AddProcedure extends JDialog {
	private JTextField txtNomProc;
	private JTextField txtServiceProc;
	private JTable tableAllEtapes;
	private JTable tableAddedEtapes;
	private JTable tableAllDoc;
	private JTable tableAddedDoc;
	private JTextField txtNomDoc;
	private JTextField txtTypeDoc;
	private JButton btnAddEtapeToTable;
	private DataComboBox chefComboBox;
	private JButton btnCreateEtape;
	private JButton btnAddDocToTable;
	private JButton btnSaveProc;
	private JButton btnCreateDocument;
	
	public AddProcedure() {
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 903, 452);
		getContentPane().add(tabbedPane);
		
		JPanel infoPanel = new JPanel();
		tabbedPane.addTab("Informations Générales", null, infoPanel, null);
		infoPanel.setLayout(null);
		
		txtNomProc = new JTextField();
		txtNomProc.setBounds(285, 48, 116, 22);
		infoPanel.add(txtNomProc);
		txtNomProc.setColumns(10);
		
		JLabel lblNomProc = new JLabel("Nom");
		lblNomProc.setBounds(90, 51, 56, 16);
		infoPanel.add(lblNomProc);
		
		JLabel lblServiceProc = new JLabel("Service");
		lblServiceProc.setBounds(90, 105, 56, 16);
		infoPanel.add(lblServiceProc);
		
		JLabel lblChefProc = new JLabel("Chef");
		lblChefProc.setBounds(90, 169, 56, 16);
		infoPanel.add(lblChefProc);
		
		txtServiceProc = new JTextField();
		txtServiceProc.setBounds(285, 102, 116, 22);
		infoPanel.add(txtServiceProc);
		txtServiceProc.setColumns(10);
		
		chefComboBox = new DataComboBox(new ArrayList<IDInterface>(GestionChef.getAllChefs()));
		chefComboBox.setBounds(285, 166, 235, 22);
		infoPanel.add(chefComboBox);
		
		JPanel EtapesPanel = new JPanel();
		tabbedPane.addTab("Etapes", null, EtapesPanel, null);
		EtapesPanel.setLayout(null);
		
		JScrollPane scrollPaneAllEtapes = new JScrollPane();
		scrollPaneAllEtapes.setBounds(12, 51, 422, 189);
		EtapesPanel.add(scrollPaneAllEtapes);
		
		tableAllEtapes = new JTable(new EtapesTableModel(EtapesTableModel.EtatInit.NON_VIDE));
		scrollPaneAllEtapes.setViewportView(tableAllEtapes);
		
		JScrollPane scrollPaneAddedEtapes = new JScrollPane();
		scrollPaneAddedEtapes.setBounds(503, 51, 342, 189);
		EtapesPanel.add(scrollPaneAddedEtapes);
		
		tableAddedEtapes = new JTable(new EtapesTableModel(EtapesTableModel.EtatInit.VIDE));
		scrollPaneAddedEtapes.setViewportView(tableAddedEtapes);
		
		btnAddEtapeToTable = new JButton("+");
		btnAddEtapeToTable.setBounds(446, 131, 49, 25);
		EtapesPanel.add(btnAddEtapeToTable);
		
		btnCreateEtape = new JButton("Creer une etape");
		btnCreateEtape.setBounds(633, 264, 51, 25);
		EtapesPanel.add(btnCreateEtape);
		
		JPanel DocumentsPanel = new JPanel();
		tabbedPane.addTab("Documents", null, DocumentsPanel, null);
		DocumentsPanel.setLayout(null);
		
		JScrollPane scrollPaneAllDoc = new JScrollPane();
		scrollPaneAllDoc.setBounds(47, 55, 362, 187);
		DocumentsPanel.add(scrollPaneAllDoc);
		
		tableAllDoc = new JTable(new DocumentsTableModel(DocumentsTableModel.EtatInit.NON_VIDE));
		scrollPaneAllDoc.setViewportView(tableAllDoc);
		
		JScrollPane scrollPaneAddedDoc = new JScrollPane();
		scrollPaneAddedDoc.setBounds(531, 54, 337, 188);
		DocumentsPanel.add(scrollPaneAddedDoc);
		
		tableAddedDoc = new JTable(new DocumentsTableModel(DocumentsTableModel.EtatInit.VIDE));
		scrollPaneAddedDoc.setViewportView(tableAddedDoc);
		
		btnAddDocToTable = new JButton("+");
		btnAddDocToTable.setBounds(447, 134, 56, 25);
		DocumentsPanel.add(btnAddDocToTable);
		
		JLabel lblNomDoc = new JLabel("Nom");
		lblNomDoc.setBounds(58, 302, 56, 16);
		DocumentsPanel.add(lblNomDoc);
		
		JLabel lblTypeDoc = new JLabel("Type");
		lblTypeDoc.setBounds(58, 352, 56, 16);
		DocumentsPanel.add(lblTypeDoc);
		
		txtNomDoc = new JTextField();
		txtNomDoc.setBounds(244, 299, 200, 22);
		DocumentsPanel.add(txtNomDoc);
		txtNomDoc.setColumns(10);
		
		txtTypeDoc = new JTextField();
		txtTypeDoc.setBounds(244, 349, 200, 22);
		DocumentsPanel.add(txtTypeDoc);
		txtTypeDoc.setColumns(10);
		
		btnCreateDocument = new JButton("Cr\u00E9er Document");
		btnCreateDocument.setBounds(516, 323, 169, 25);
		DocumentsPanel.add(btnCreateDocument);
		
		btnSaveProc = new JButton("Enregistrer");
		btnSaveProc.setBounds(374, 471, 97, 25);
		getContentPane().add(btnSaveProc);
		
	}
	
	public void addButtonsListeners(String buttonName, ActionListener listener) {
		
		switch(buttonName) {
		case "btnCreateEtape" :
			btnCreateEtape.addActionListener(listener);
			break;
		case "btnCreateDocument" :
			btnCreateDocument.addActionListener(listener);
			break;
		case "btnAddDocToTable" :
			btnAddDocToTable.addActionListener(listener);
			break;
		case "btnAddEtapeToTable" :
			btnAddEtapeToTable.addActionListener(listener);
			break;
		case "btnSaveProc" :
			btnSaveProc.addActionListener(listener);
			break;
		default :
				break;
		}
	}
	
	
	public DataComboBox getChefComboBox() {
		return chefComboBox;
	}

	public JTextField getTxtNomProc() {
		return txtNomProc;
	}

	public JTextField getTxtServiceProc() {
		return txtServiceProc;
	}

	public JTable getAllEtapesTable() {
		return this.tableAllEtapes;
	}
	
	public JTable getAddedEtapesTable() {
		return this.tableAddedEtapes;
	}
	
	public JTable getAllDocTable() {
		return this.tableAllDoc;
	}
	
	public JTable getAddedDocTable() {
		return this.tableAddedDoc;
	}
	
	public JTextField getTxtNomDoc() {
		return txtNomDoc;
	}

	public JTextField getTxtTypeDoc() {
		return txtTypeDoc;
	}
}
