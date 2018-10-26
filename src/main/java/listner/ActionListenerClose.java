package listner;
/**
 * ActionListenerClose class : a class to represent closing listener
 * The class implements ActionListener 
 * @author : Elsa da Silva - Lukas Ramus
 * @version: 10/11/2017 1.0
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;





public class ActionListenerClose implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		int result = JOptionPane.showConfirmDialog(null,("Quit the application?"));			    
		if(result==0)
			System.exit(0);
	}        		
}
