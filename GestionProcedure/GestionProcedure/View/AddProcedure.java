package GestionProcedure.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import Business.GestionChef;
import Business.IDInterface;
import ui.DataComboBox;

public class AddProcedure extends JDialog {

		private final JPanel contentPanel = new JPanel();
		JPanel formPanel = null;
		private JTabbedPane tabbedPane;
	    private JPanel upperPane;
	    private JPanel lowerPane;
	    private JPanel specPanelHolder;
	    
	    private JLabel lblNomProc;
	    private JLabel lblServiceNom;
	    private JTextField txtPanaNumber;
	    private JLabel lblItemName;
	    private JTextField txtItemname;
	    private JSplitPane lowerPanel;
	    private JPanel panel_1;
	    private JPanel cartPanel;
	    private JLabel lblSentDate;
	    private JLabel lblReceiver;
	    private JButton btnSend;
	    private JButton btnAddItem;
	    private JButton btnSave;
	    private JPanel addToCartPanel;
	    private JButton btnDelete;
	    private JPanel panel_3;
	    private JLabel lblNiksasaPanaNumber;
	    private JLabel lblRequestNumber;
	    private JTextField txtTransferpananumber;
	    private JTextField txtRequestnumber;
	    private JButton btnReset;
	    private JLabel lblKhataNumber;
	    private JLabel lblDakhilaNumber;
	    private JTextField txtKhatanumber;
	    private JTextField txtDakhilanumber;
	    private JLabel lblFrom;
	    private JLabel lblTo;
		private DataComboBox cmbCategory;

	/**
	 * Launch the application.
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			
			AddProcedure dialog = new AddProcedure();
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddProcedure() {
		 setBounds(100, 100, 450, 300);
	        setLayout(new BorderLayout());
	        //setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		 JSplitPane splitPane = new JSplitPane();
	        splitPane.setContinuousLayout(false);
	        splitPane.setResizeWeight(0.1);
	        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
	        add(splitPane, BorderLayout.CENTER);
	       splitPane.setLeftComponent(getUpperSplitPane());
	       
	       splitPane.setRightComponent(getLowerPanel());
	}
	
	private JPanel getUpperSplitPane() {
        if (upperPane == null) {
            upperPane = new JPanel();
            GridBagLayout gbl_upperPane = new GridBagLayout();
            gbl_upperPane.columnWidths = new int[]{728, 0};
            gbl_upperPane.rowHeights = new int[]{194, 0};
            gbl_upperPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
            gbl_upperPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
            upperPane.setLayout(gbl_upperPane);
            GridBagConstraints gbc_formPanel = new GridBagConstraints();
            gbc_formPanel.anchor = GridBagConstraints.NORTH;
            gbc_formPanel.fill = GridBagConstraints.HORIZONTAL;
            gbc_formPanel.gridx = 0;
            gbc_formPanel.gridy = 0;
            upperPane.add(getUpperFormPanel(), gbc_formPanel);
        }
        return upperPane;
    }
	
	private JPanel getUpperFormPanel() {
        if (formPanel == null) {
            formPanel = new JPanel();

            formPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Search Inventory", TitledBorder.LEADING,
                    TitledBorder.TOP, null, null));
            formPanel.setBounds(10, 49, 474, 135);
            formPanel.setLayout(new FormLayout(new ColumnSpec[]{FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC, FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("left:max(115dlu;default)"), FormFactory.RELATED_GAP_COLSPEC,
                    ColumnSpec.decode("left:default"), FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC, FormFactory.RELATED_GAP_COLSPEC,
                    FormFactory.DEFAULT_COLSPEC, FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("max(125dlu;default)"),
                    FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC, FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"),}, new RowSpec[]{FormFactory.RELATED_GAP_ROWSPEC,
                    FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC,
                    RowSpec.decode("max(51dlu;default)"), FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
                    FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,}));

            lblItemName = new JLabel("Item Name");
            formPanel.add(lblItemName, "4, 2");

            txtItemname = new JTextField();
            formPanel.add(txtItemname, "8, 2, fill, default");
            txtItemname.setColumns(10);

            lblNomProc = new JLabel("Item Pana Number");
            formPanel.add(lblNomProc, "12, 2");

            txtPanaNumber = new JTextField();
            formPanel.add(txtPanaNumber, "16, 2, fill, default");
            txtPanaNumber.setColumns(10);

            JLabel lblN = new JLabel("Category");
            formPanel.add(lblN, "4, 4");

            cmbCategory = new DataComboBox(new ArrayList<IDInterface>(GestionChef.getAllChefs()));
            formPanel.add(cmbCategory, "8, 4, fill, default");
            
            lblServiceNom = new JLabel("Vendor");
            formPanel.add(lblServiceNom, "12, 4");


            specPanelHolder = new JPanel();
            formPanel.add(specPanelHolder, "4, 6, 19, 1, fill, fill");
            specPanelHolder.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

            btnSave = new JButton("Search");


            lblKhataNumber = new JLabel("Khata Number");
            formPanel.add(lblKhataNumber, "4, 8");

            txtKhatanumber = new JTextField();
            formPanel.add(txtKhatanumber, "8, 8, fill, default");
            txtKhatanumber.setColumns(10);

            lblDakhilaNumber = new JLabel("Dakhila Number");
            formPanel.add(lblDakhilaNumber, "12, 8");

            txtDakhilanumber = new JTextField();
            formPanel.add(txtDakhilanumber, "16, 8, fill, default");
            txtDakhilanumber.setColumns(10);

            formPanel.add(btnSave, "18, 8, left, default");

            btnReset = new JButton("Reset");

            formPanel.add(btnReset, "20, 8");

            lblFrom = new JLabel("From");
            formPanel.add(lblFrom, "4, 10");

            lblTo = new JLabel("To");
            formPanel.add(lblTo, "12, 10");



        }
        return formPanel;
    }
	
	private JPanel getLowerSplitPane() {
        if (lowerPane == null) {
            lowerPane = new JPanel();
            lowerPane.setLayout(new BorderLayout());
            //dataModel = new EasyTableModel(header);

            //itemDetailTable = new BetterJTable(dataModel);
            //itemDetailTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            //JScrollPane sp = new JScrollPane(itemDetailTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

            //lowerPane.add(sp, BorderLayout.CENTER);
        }
        return lowerPane;
    }
	
	private JSplitPane getLowerPanel() {
        if (lowerPanel == null) {
            lowerPanel = new JSplitPane();
            lowerPanel.setContinuousLayout(true);
            lowerPanel.setResizeWeight(0.5);
            lowerPanel.setOrientation(JSplitPane.VERTICAL_SPLIT);

            lowerPanel.setLeftComponent(getLowerSplitPane());

            panel_1 = new JPanel();
            lowerPanel.setRightComponent(panel_1);
            panel_1.setLayout(new BorderLayout(0, 0));

            cartPanel = new JPanel();
            cartPanel.setBorder(new TitledBorder(null, "Transfer Entry", TitledBorder.LEADING, TitledBorder.TOP, null, null));
            panel_1.add(cartPanel, BorderLayout.CENTER);
            cartPanel.setLayout(new FormLayout(new ColumnSpec[]{FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
                    FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("max(45dlu;default)"), FormFactory.RELATED_GAP_COLSPEC,
                    ColumnSpec.decode("left:max(27dlu;default)"), FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("max(15dlu;default)"),
                    FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("max(24dlu;default)"), FormFactory.RELATED_GAP_COLSPEC,
                    ColumnSpec.decode("max(9dlu;default)"), FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("max(124dlu;default)"),
                    FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("max(59dlu;default)"),}, new RowSpec[]{FormFactory.RELATED_GAP_ROWSPEC,
                    RowSpec.decode("top:max(31dlu;default)"), FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("top:max(23dlu;default)"),
                    FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,}));

            panel_3 = new JPanel();
            cartPanel.add(panel_3, "2, 2, fill, fill");
            panel_3.setLayout(new FormLayout(new ColumnSpec[]{FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,}, new RowSpec[]{
                    FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,}));

            btnAddItem = new JButton("Add Item");
            panel_3.add(btnAddItem, "2, 2");

            btnDelete = new JButton("Remove");
           
            panel_3.add(btnDelete, "2, 4");
            

            //cartPanel.add(getAddToCartPane(), "4, 2, 13, 1, fill, top");

            lblReceiver = new JLabel("Receiver:");
            cartPanel.add(lblReceiver, "4, 4");


            lblSentDate = new JLabel("Date");
            cartPanel.add(lblSentDate, "10, 4, default, bottom");


            btnSend = new JButton("Send");

            cartPanel.add(btnSend, "16, 4, default, bottom");

            lblNiksasaPanaNumber = new JLabel("Niksasa Pana Number");
            cartPanel.add(lblNiksasaPanaNumber, "4, 6, left, default");

            txtTransferpananumber = new JTextField();
            cartPanel.add(txtTransferpananumber, "6, 6, fill, default");
            txtTransferpananumber.setColumns(10);

            lblRequestNumber = new JLabel("Request Number");
            cartPanel.add(lblRequestNumber, "4, 8, left, default");

            txtRequestnumber = new JTextField();
            cartPanel.add(txtRequestnumber, "6, 8, fill, default");
            txtRequestnumber.setColumns(10);
        }

        return lowerPanel;
    }
	
}
