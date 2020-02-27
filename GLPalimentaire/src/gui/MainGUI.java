package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class MainGUI extends JFrame implements Runnable{
	public static final Dimension IDEAL_MAIN_DIMENSION = new Dimension(800, 400);
	
	private OperationZone operationZone = new OperationZone();
	private InformationZone informationZone = new InformationZone();
	
	private GridLayout gridLayout_1X2 = new GridLayout(1, 2);
	private GridLayout gridLayout_2X1 = new GridLayout(2, 1);
	
	private Border lineborder = BorderFactory.createLineBorder(Color.black, 1);
	
	public MainGUI(String title){
		super(title);
		init();
		
	}
	
	private void init() {
		
		
		getContentPane().setLayout(gridLayout_1X2);
		JLabel labelMap = new JLabel("Map");
		labelMap.setHorizontalTextPosition(JLabel.RIGHT);
		add(labelMap);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(gridLayout_2X1);
		panel1.add(operationZone);
		panel1.add(informationZone);
		panel1.setBorder(lineborder);
		add(panel1);
		panel1.setBorder(lineborder);
		
		/*
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		operationZone.setPreferredSize(IDEAL_MAIN_DIMENSION);
		contentPane.add(BorderLayout.CENTER, operationZone);
		*/
		//getContentPane().add(new JButton("bonjour..."));
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//pack();
		setSize(1000,500);
		setVisible(true);
		//setPreferredSize(IDEAL_MAIN_DIMENSION);
		setResizable(false);
	}
	
	public void run() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		new MainGUI("Map");
	}
}
