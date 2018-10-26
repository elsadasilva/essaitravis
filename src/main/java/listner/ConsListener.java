package listner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hopital.Services;

public class ConsListener implements ActionListener {
private Services ser;
	
	public ConsListener(Services s) {
		this.ser=s;
	}
	
	public void actionPerformed(ActionEvent arg0) {		
		this.ser.consultationBis();			
		}

}
