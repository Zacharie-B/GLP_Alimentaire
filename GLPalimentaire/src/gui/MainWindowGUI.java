package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainWindowGUI extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Dimension dimensionFenetre = new Dimension(600,200);
	
	private JLabel maintitre = new JLabel("Simulation Ecosyst√®me");
	
	private JButton launchedDefault = new JButton("Simulation Rapide");
	private JButton launchedCustom = new JButton("Simulation Personnalis√©e");
	private JButton leave = new JButton("Quitter");
	
	private JPanel panel = new JPanel(new GridBagLayout());
	
	public MainWindowGUI(){
		launchedDefault.addActionListener(new LaunchedDefault());
		
		launchedCustom.addActionListener(new LaunchedCustom());
		
		leave.addActionListener(new Leave());
		
		GridBagConstraints c1 = new GridBagConstraints();
		
		c1.gridx = 0;
		c1.gridy = 0;
		panel.add(maintitre, c1);
		
		c1.gridx = 0;
		c1.gridy = 1;
		panel.add(launchedDefault, c1);
		
		c1.gridx = 0;
		c1.gridy = 2;
		panel.add(launchedCustom, c1);
		
		c1.gridx = 0;
		c1.gridy = 3;
		panel.add(leave, c1);
		
		add(panel);
		
		setTitle("Simulation d'ÈcosystËme");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setSize(dimensionFenetre);
		setVisible(true);
		setResizable(false);
	}
	
	/*public static void main(String[] args) {
		new MainWindowGUI();
	}*/

	public class LaunchedDefault implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);	
			dispose();
			MainGUI simulationWindow = new MainGUI();
			simulationWindow.run();
		}
		
	}
	
	public class LaunchedCustom implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
		
	}
	
	public void run() {

	}
	
	public class Leave implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	
	}
}
