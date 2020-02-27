package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InformationZone extends JPanel{

	private static final long serialVersionUID = 1L;
	
	//debut:test
	private JLabel labelInformation = new JLabel("Information");
	//fin:test
	
	private JTextField textFieldInformation = new JTextField();
	
	public InformationZone(){
		add(labelInformation);
	}
}
