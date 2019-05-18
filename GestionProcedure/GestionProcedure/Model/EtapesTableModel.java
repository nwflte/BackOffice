package GestionProcedure.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import Business.Employe;
import Business.Etape;
import Business.GestionEmploye;
import Business.GestionEtape;

public class EtapesTableModel extends AbstractTableModel implements TableModel  {
	
	private ArrayList<Etape> listeEtapes;
	private ArrayList<Employe> listeEmployes;
	
	private String[] columnsName = {"Nom", "Employe", "Date Creation", "Nombre Documents"};
	private Class[] columnsClass = {String.class, String.class, LocalDateTime.class, Integer.class};
	
	public enum EtatInit { VIDE, NON_VIDE };
	
	public EtapesTableModel(EtatInit etat) {
		if(etat == EtatInit.VIDE) {
			this.listeEmployes = new ArrayList<Employe>();
			this.listeEtapes = new ArrayList<Etape>();
		} else {
			this.listeEtapes = GestionEtape.getAllEtapes();
			this.listeEmployes = GestionEmploye.getAllEmployes();
		}
	}
	 
	@Override
	public int getColumnCount() {
		return columnsName.length;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return this.columnsName[columnIndex];
	}
	
	@Override
	public Class getColumnClass(int columnIndex) {
		return this.columnsClass[columnIndex];
	}
	
	@Override
	public int getRowCount() {
		return listeEtapes.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Etape row = this.listeEtapes.get(rowIndex);
		switch (columnIndex) {
		case 0 : return row.getEtape_nom();
		case 1 : return row.getEmploye().getNom();
		case 2 : return row.getDate_creation();
		case 3 : return row.getNbr_documents();
		default : return null;
		}
	}
	
	public boolean addRow(Etape etape) {
		if(etape == null || listeEtapes.contains(etape)) return false;
		this.listeEtapes.add(etape);
		this.fireTableRowsInserted(listeEtapes.size()-1, listeEtapes.size()-1);
		return true;
	}
	
	public Etape getEtapeAtRow(int rowIndex) {
		return this.listeEtapes.get(rowIndex);
	}

}
