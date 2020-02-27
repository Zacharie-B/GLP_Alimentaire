package gui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class OperationZone extends JPanel{

	private static final long serialVersionUID = 1L;

	private static final Dimension IDEAL_MAIN_DIMENSION = new Dimension(800, 400);
	
	private JButton leave = new JButton("Leave");
	private JButton info = new JButton("Information");
	private JButton disaster = new JButton("Disaster");
	
	public OperationZone(){
		add(leave);
		add(info);
		add(disaster);
	}
}
