package GestionProcedure.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Business.Chef;
import Business.Document;
import Business.Etape;
import Business.GestionChef;
import Business.GestionDocument;
import GestionProcedure.Model.DocumentsTableModel;
import GestionProcedure.Model.EtapesTableModel;
import GestionProcedure.View.AddEtape;
import GestionProcedure.View.AddProcedure;
import util.Validation;

public class AddProcedureController {
	AddProcedure addProcedureWindow;
	
	
	public AddProcedureController() {
		addProcedureWindow =  new AddProcedure();
		addProcedureWindow.pack();
		addProcedureWindow.validate();
		addProcedureWindow.setVisible(true);
		addListeners();
	}
	
	private void addListeners() {
		addProcedureWindow.addButtonsListeners("btnCreateEtape", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				AddEtape addEtapeDialog = new AddEtape();
				addEtapeDialog.setAlwaysOnTop(true);
				addEtapeDialog.setVisible(true);
				
			}
			
		});
		
		addProcedureWindow.addButtonsListeners("btnCreateDocument", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nom = addProcedureWindow.getTxtNomDoc().getText();
				String type = addProcedureWindow.getTxtTypeDoc().getText();
				if(Validation.isValidString(nom) && Validation.isValidString(type)) {
					Document newDoc = new Document();
					newDoc.setDocument_nom(nom); newDoc.setDocument_type(type);
					if(GestionDocument.addDocument(newDoc))
						addProcedureWindow.getAllDocTable().setModel(new DocumentsTableModel(DocumentsTableModel.EtatInit.NON_VIDE));
					
						
				}
				
			}
			
		});
		
		addProcedureWindow.addButtonsListeners("btnAddDocToTable", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int rowIndex = addProcedureWindow.getAllDocTable().getSelectedRow();
				Document doc = ((DocumentsTableModel) addProcedureWindow.getAllDocTable().getModel()).getDocumentAtRow(rowIndex);
				((DocumentsTableModel) addProcedureWindow.getAddedDocTable().getModel()).addRow(doc);
			}
			
		});
		
		addProcedureWindow.addButtonsListeners("btnAddEtapeToTable", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int rowIndex = addProcedureWindow.getAllEtapesTable().getSelectedRow();
				Etape etape = ((EtapesTableModel) addProcedureWindow.getAllEtapesTable().getModel()).getEtapeAtRow(rowIndex);
				((EtapesTableModel) addProcedureWindow.getAddedEtapesTable().getModel()).addRow(etape);
			}
			
		});
		
		addProcedureWindow.addButtonsListeners("btnSaveProc", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nom = addProcedureWindow.getTxtNomProc().getText();
				String service = addProcedureWindow.getTxtServiceProc().getText();
				int chefId = addProcedureWindow.getChefComboBox().getSelectedId();
				Chef chef = GestionChef.getChef(chefId);
				if(Validation.isValidString(nom) && Validation.isValidString(service) && chef != null) {
					
				}
			}
			
		});
	}
	
	
	public static void main(String[] args) {
		AddProcedureController controller = new AddProcedureController();
	}
}
