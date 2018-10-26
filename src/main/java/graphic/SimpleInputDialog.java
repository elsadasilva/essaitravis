/**
 * 
 */
package graphic;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class SimpleInputDialog extends JDialog implements ActionListener
{

	/** */
	private JButton okJButton;

	/** */
	private JTextField valueJTextField;

	/** */
	private String result;

	/**
	 * Return the value of JTextField.
	 * 
	 * @return
	 */
	public String getResult()
	{
		return result;
	}

	/**
	 * Simple constructor.
	 * 
	 * @param frame
	 * @param modal
	 * @param message
	 */
	public SimpleInputDialog(JFrame frame, boolean modal, String message)
	{
		super(frame, modal);

		// Instanciate components
		valueJTextField = new JTextField();
		okJButton = new JButton("Ok");
		okJButton.addActionListener(this);
		this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
		// Dispose on main component
		JLabel label1 = new JLabel(message);
		Font f= new Font("Serial", 25,20);	

		label1.setFont(f);
		getContentPane().add(label1, BorderLayout.NORTH);
		getContentPane().add(valueJTextField, BorderLayout.CENTER);
		getContentPane().add(okJButton, BorderLayout.EAST);

		valueJTextField.setFont(f);
		pack();


		setMinimumSize(new Dimension(400,120));
		setPreferredSize(new Dimension(400,120));
		setLocationRelativeTo(frame);
		setVisible(true);
	}

	/**
	 * 
	 */
	public void actionPerformed(ActionEvent e)
	{
		result = valueJTextField.getText();
		setVisible(false);
	}

}