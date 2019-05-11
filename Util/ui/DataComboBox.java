package ui;

import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import Business.IDInterface;

public class DataComboBox extends JComboBox {
	
	private ArrayList<IDInterface> itemList;
	
	 public DataComboBox(ArrayList<IDInterface> itemList) {
	        super();
	        setBorder(BorderFactory.createEmptyBorder());
//			setModel(new SortedComboBoxModel());
	        AutoCompleteDecorator.decorate(this);
	        this.itemList = itemList;
	        init();
	    }
	 
	 public final void init() {       
	        this.removeAllItems();
	        for(IDInterface o : itemList) {
	        	this.addItem(new Item(o.getID(), o.getText().toUpperCase()));
	        }
	  }
	 
	 public final int getSelectedId() {
	        int index = this.getSelectedIndex();
	        if (index > 0 && itemList != null && itemList.size() > 0) {
	        	IDInterface item = itemList.get(index);
	            return item.getID();
	        }
	        return -1;
	    }
	 
	 class Item implements Comparable<Item> {
	        int id;
	        String text;

	        public Item(int id, String text) {
	            super();
	            this.id = id;
	            this.text = text;
	        }

	        public final int getId() {
	            return id;
	        }

	        public final void setId(int id) {
	            this.id = id;
	        }

	        public final String getText() {
	            return text;
	        }

	        public final void setText(String text) {
	            this.text = text;
	        }

	        @Override
	        public final String toString() {
	            // return String.format("%s : %s", id, text);
	            return String.format("%s", text);
	        }

	        public final int compareTo(Item o) {
	            Item it2 = o;
	            return this.text.compareToIgnoreCase(it2.text);

	        }

	    }
}
