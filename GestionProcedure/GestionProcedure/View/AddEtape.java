package GestionProcedure.View;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class AddEtape extends JDialog {
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JSeparator separator;
	private JTable table;
	private JScrollPane scrollPane;
	private JTable table_1;
	private JScrollPane scrollPane_1;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField textField_4;
	private JTextField textField_5;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEtape dialog = new AddEtape();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public AddEtape() {
		setBounds(100, 100, 914, 554);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setBounds(35, 40, 56, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Employe");
		lblNewLabel_1.setBounds(35, 91, 56, 16);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(35, 152, 56, 16);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(35, 218, 56, 16);
		getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(164, 37, 116, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(164, 149, 116, 22);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(164, 215, 116, 22);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(425, 13, 8, 481);
		getContentPane().add(separator);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(485, 129, 399, 163);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(485, 331, 399, 163);
		getContentPane().add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		lblNewLabel_4 = new JLabel("Nom du Document");
		lblNewLabel_4.setBounds(485, 24, 56, 16);
		getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Type du Document");
		lblNewLabel_5.setBounds(485, 74, 56, 16);
		getContentPane().add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setBounds(644, 21, 116, 22);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(644, 71, 116, 22);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		btnNewButton = new JButton("Creer Document");
		btnNewButton.setBounds(787, 40, 97, 25);
		getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("+");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(644, 304, 87, 25);
		getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("X");
		btnNewButton_2.setBounds(437, 399, 39, 25);
		getContentPane().add(btnNewButton_2);
		
		comboBox = new JComboBox();
		comboBox.setBounds(164, 88, 116, 22);
		getContentPane().add(comboBox);

	}

}
