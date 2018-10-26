package graphic;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JMenu;

public class Newjmenu extends JMenu{

	public Newjmenu(String s) {
		super(s);
		Font font = new Font("Serial", Font.BOLD, 25);	
		this.setFont(font);
		this.setPreferredSize(new Dimension(300,50)); 
	}

}
