package gui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class OperationZone extends JPanel{

	private static final long serialVersionUID = 1L;

	private static final Dimension IDEAL_MAIN_DIMENSION = new Dimension(800, 400);
	
	private JButton buttonLeave = new JButton("Leave");
	private JButton buttonStop = new JButton("Stop");
	private JButton buttonDisaster = new JButton("Disaster");
	
	public OperationZone(){
		add(buttonDisaster);
		add(buttonStop);
		add(buttonLeave);
	}
}
