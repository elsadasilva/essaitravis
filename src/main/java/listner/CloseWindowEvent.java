package listner;
/**
 * CloseWindowEvent class : a class to represent closing Event
 * The class extends WindowAdapter 
 * @author : Elsa da Silva - Lukas Ramus
 * @version: 10/11/2017 1.0
 */
import java.awt.event.WindowAdapter;

public class CloseWindowEvent extends WindowAdapter {
	
	
	public void windowClosing(java.awt.event.WindowEvent e) {
		System.exit(0);
	}
}