package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JMenuItem;
import java.awt.Component;

public class ActionMenuItem extends JMenuItem {
	
	private final String dialogClass;

    public ActionMenuItem(String text, String fileFullName, String dialogClass) {

        super(text, ResourceManager.getImageIcon(fileFullName));
        this.dialogClass = dialogClass;
        initListner();
    }

    public static ActionMenuItem create(String text, String fileName, String dialogClass) {
        String fullFileName = fileName + "-menu.png";
        return new ActionMenuItem(text, fullFileName, dialogClass);
    }

    protected final void initListner() {
        addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Component dialog = (Component) Class.forName(dialogClass).newInstance();
					dialog.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				} 
				
			}
        	
        });
    }


}
