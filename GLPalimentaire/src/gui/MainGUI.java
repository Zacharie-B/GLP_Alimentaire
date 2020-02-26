package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainGUI extends JFrame implements Runnable{

	private static final Dimension IDEAL_MAIN_DIMENSION = new Dimension(800, 400);
	
	public MainGUI(String title){
		super(title);
		init();
		
	}
	
	private void init() {
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		contentPane.add(BorderLayout.NORTH, new OperationZone());
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setPreferredSize(IDEAL_MAIN_DIMENSION);
		setResizable(false);
	}
	
	public void run() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		new MainGUI("Map");
	}
}
