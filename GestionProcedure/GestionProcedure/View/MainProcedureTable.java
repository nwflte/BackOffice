package GestionProcedure.View;

import javax.swing.JTable;

import GestionProcedure.Model.MainProcedureTableModel;

public class MainProcedureTable extends JTable {
	
	MainProcedureTableModel model;
	public MainProcedureTable(MainProcedureTableModel model) {
		
		super(model);
		this.model = model;
	}
}
