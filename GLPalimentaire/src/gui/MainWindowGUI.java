package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainWindowGUI extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Dimension dimensionFenetre = new Dimension(600,300);
	
	private JLabel maintitre = new JLabel("Simulation Ecosystème");
	
	private JButton launchedDefault = new JButton("Simulation Rapide");
	private JButton launchedCustom = new JButton("Simulation Personnalisée");
	private JButton leave = new JButton("Quitter");
	
	private JPanel panel = new JPanel(new GridBagLayout());
	
	public MainWindowGUI(){
		
		launchedDefault.addActionListener(new LaunchedDefault());
		launchedCustom.addActionListener(new LaunchedCustom());
		leave.addActionListener(new Leave());
		
		maintitre.setFont(new java.awt.Font(Font.DIALOG,Font.BOLD,30));
		
		GridBagConstraints c1 = new GridBagConstraints();
		c1.insets = new Insets(10, 10, 10, 10);
		
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
		
<<<<<<< HEAD
		setTitle("Simulation d'écosystème");
		setLocationRelativeTo(null);
=======
		setTitle("Simulation d'ï¿½cosystï¿½me");
>>>>>>> refs/remotes/origin/yassin_zac
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setSize(dimensionFenetre);
		setVisible(true);
		setResizable(false);
	}
	
	

	public class LaunchedDefault implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			MainGUI simulationMovement = new MainGUI();
			simulationMovement.run();
			setVisible(false);	
			dispose();
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
	
	public static void main(String[] args) {
		new MainWindowGUI();
	}
}
