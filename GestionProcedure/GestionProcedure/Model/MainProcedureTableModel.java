package GestionProcedure.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import Business.Chef;
import Business.Procedure;
import Business.GestionProcedure;
import Business.GestionChef;


/**
 * Model pour la fenetre principale (d'autres models vont etre ajoutes pour d'autres fenetres ou dialogs)
 * @author naouf
 *
 */
public class MainProcedureTableModel extends AbstractTableModel {
	
	ArrayList<Procedure> listeProcedure;
	ArrayList<Chef> listeChef ;
	
	public MainProcedureTableModel() {
		this.listeProcedure = GestionProcedure.getAllProcedures();
		this.listeChef = GestionChef.getAllChefs();
	}
	
	public MainProcedureTableModel(ArrayList<Procedure> listeProcedure) {
		super();
		this.listeProcedure = listeProcedure;
	}
	
	
	String[] columnsName = {"id", "Chef", "Nom", "Service", "Date Creation"
							, "Date Modification", "Archivée", "Nbr Documents", "Nbr Etapes"};
	
	Class[] columnsClass = {Integer.class, String.class, String.class, String.class
							, LocalDateTime.class, LocalDateTime.class, Boolean.class, Integer.class, Integer.class};
	
	@Override
	public int getColumnCount() {
		
		return Procedure.class.getDeclaredFields().length - 2;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.listeProcedure.size();
	}
	
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Procedure row = this.listeProcedure.get(rowIndex);
		switch (columnIndex) {
			case 0 : return row.getProcedure_id(); 
			case 1 : return row.getChef().getEmploye().getNom(); 
			case 2 : return row.getProcedure_nom();
			case 3 : return row.getService_nom();
			case 4 : return row.getDate_creation();
			case 5 : return row.getDate_modification();
			case 6 : return row.isArchived();
			case 7 : return row.getNbr_documents();
			case 8 : return row.getNbr_etapes();
			default : return null;
		}
		
	}
	
	@Override
	public void setValueAt(Object a, int rowIndex, int columnIndex) {
		Procedure row = this.listeProcedure.get(rowIndex);
		switch (columnIndex){
			default: break;
		}
        fireTableRowsUpdated(rowIndex, rowIndex);
        
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return this.columnsName[columnIndex];
	}
	@Override
	public Class getColumnClass(int columnIndex) {
		return this.columnsClass[columnIndex];
	}
	
	public void addRow(Procedure Procedure) {
		this.listeProcedure.add(Procedure);
		this.fireTableRowsInserted(listeProcedure.size()-1, listeProcedure.size()-1);
	}
	
}
