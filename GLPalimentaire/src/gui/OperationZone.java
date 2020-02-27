package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class OperationZone extends JPanel{

	private static final long serialVersionUID = 1L;

	private static final Dimension IDEAL_MAIN_DIMENSION = new Dimension(800, 400);
	
	//debut:test
	private JLabel labelBoutton = new JLabel("Boutton");
	//fin:test
	
	private JButton leave = new JButton("Leave");
	private JButton info = new JButton("Information");
	private JButton disaster = new JButton("Disaster");
	
	private Border lineborder = BorderFactory.createLineBorder(Color.black, 1);
	
	public OperationZone(){
		//add(leave);
		//add(info);
		//add(disaster);
		add(labelBoutton);
		setBorder(lineborder);
	}
}
