package graphic;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JMenuItem;

public class Jitem extends JMenuItem {

	public Jitem(String s) {
		super(s);
		Font font1 = new Font("Serial", 25,20);	
		this.setFont(font1);
		this.setPreferredSize(new Dimension(300,50)); 
	}

}
