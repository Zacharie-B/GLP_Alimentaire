package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InformationZone extends JPanel{

	private static final long serialVersionUID = 1L;
	
	//debut:test
	private JLabel labelInformation = new JLabel("Information");
	private JLabel labeltopleft  = new JLabel("tl");
	private JLabel labeltopright  = new JLabel("tr");
	private JLabel labelbottomleft  = new JLabel("bl");
	private JLabel labelbottomright  = new JLabel("br");
	
	//fin:test
	
	@SuppressWarnings("unused")
	private JTextField textFieldInformation = new JTextField();
	
	public InformationZone(){
		add(labelInformation);
		add(labeltopleft);
		add(labeltopright);
		add(labelbottomleft);
		add(labelbottomright);
	}
}
