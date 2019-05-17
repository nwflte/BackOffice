package GestionProcedure.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Business.Document;
import Business.Etape;
import Business.GestionDocument;

public class DocumentsTableModel extends AbstractTableModel {
	
	private ArrayList<Document> listDocument;
	private String[] columnsName = {"Nom", "Type"};
	private Class[] columnsClass = {String.class, String.class};
	
	public DocumentsTableModel(boolean isVide) {
		if(isVide) listDocument = new ArrayList<Document>();
		else listDocument = GestionDocument.getAllDocuments();
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
		return this.listDocument.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Document row = this.listDocument.get(rowIndex);
		switch (columnIndex) {
			case 0 : return row.getDocument_nom();
			case 1 : return row.getDocument_type();
			default : return null;
		}
	}
	
	public void addRow(Document document) {
		this.listDocument.add(document);
		this.fireTableRowsInserted(listDocument.size()-1, listDocument.size()-1);
	}
}
