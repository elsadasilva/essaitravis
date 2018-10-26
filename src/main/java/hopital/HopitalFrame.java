package hopital;

import java.awt.Dimension;

import java.awt.Font;
import java.io.IOException;
import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import graphic.Jitem;
import graphic.Newjmenu;
import graphic.TextAreaOutputStream;
import listner.ActionListenerClose;
import listner.CloseWindowEvent;
import listner.ConsListener;
import listner.OpenFileListener;
import listner.SorListener;
import listner.VisuListener;

public class HopitalFrame {
	public static JFrame frmQuestionnaire;
	public static JMenu files;
	private static JMenu mnNewMenu;
	private static JMenu mnNewMenu_1;
	private static JMenu mnNewMenu3;
	private static JMenu mnNewMenu4;
	private static JTextArea myField;
	private static Services serv;
	private static JScrollPane scrollbar;


	/**
	 * Constructor
	 * @throws IOException is not a good answer
	 */
	public HopitalFrame() throws IOException {
		this.serv=new Services();
		initialize();
		HopitalFrame.frmQuestionnaire.setVisible(true);
	}	

	/**
	 * Initialize the contents of the frame.
	 */
	public  void initialize() {
		frmQuestionnaire = new JFrame();
		frmQuestionnaire.setResizable(false);
		frmQuestionnaire.setTitle("Hopital - MiageCorp");
		frmQuestionnaire.setBounds(200, 100, 1400,700);
		frmQuestionnaire.addWindowListener(new CloseWindowEvent());
		JMenuBar menuBar = new JMenuBar();
		frmQuestionnaire.setJMenuBar(menuBar);
		menuBar.setPreferredSize(new Dimension(1000,100));                
		Newjmenu files = new Newjmenu("Patient");
		menuBar.add(files);               
		Jitem newFile=new Jitem("Entrée patient");
		files.add(newFile);                
		newFile.addActionListener(new OpenFileListener(this.serv));
		mnNewMenu = new Newjmenu("Visualisation");
		menuBar.add(mnNewMenu);
		Jitem visu=new Jitem("Fiche de séjour");
		mnNewMenu.add(visu);
		visu.addActionListener(new VisuListener(this.serv));
		mnNewMenu_1 = new Newjmenu("Consultation");
		menuBar.add(mnNewMenu_1);
		Jitem cons=new Jitem("Consultation patient");
		mnNewMenu_1.add(cons);
		cons.addActionListener(new ConsListener(this.serv));
		mnNewMenu3 = new Newjmenu("Sortie");
		menuBar.add(mnNewMenu3);
		Jitem sor=new Jitem("Sortie d'un patient");
		mnNewMenu3.add(sor);
		sor.addActionListener(new SorListener(this.serv));
		mnNewMenu4 = new Newjmenu("Quitter application");
		menuBar.add(mnNewMenu4);
		Jitem exitFile=new Jitem("Exit");
		mnNewMenu4.add(exitFile);
		exitFile.addActionListener(new ActionListenerClose());
		myField= new JTextArea();
		scrollbar = new JScrollPane(myField);
		scrollbar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		frmQuestionnaire.getContentPane().add(scrollbar);
		Font f= new Font("Serial", 25,20);	
		myField.setFont(f);
		PrintStream out = new PrintStream( new TextAreaOutputStream( myField ) );
		System.setOut( out );
	}


	/**
	 * getter de myfield
	 * @return textArea
	 */
	public static JTextArea getMyField() {
		return myField;
	}




	/**
	 * setter myfield
	 * @param myField texte a afficher
	 */
	public static void setMyField(JTextArea myField) {
		HopitalFrame.myField = myField;
	}




	public static void main(String [] args) throws IOException{
		new HopitalFrame();
	}


}
