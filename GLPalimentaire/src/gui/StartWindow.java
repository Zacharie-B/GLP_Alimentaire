package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class StartWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private static final Dimension WINDOWS_DIMENSION = new Dimension(800,600);
	private static Font font = new Font(Font.MONOSPACED, Font.BOLD, 20);
	
	private GridBagConstraints gbConstraints = new GridBagConstraints();
	private Panel panel= new Panel();
	private JTextArea jlabel = new JTextArea(2,1);
	private JButton buttonSavanna = new JButton("écosystème de la savane");
	private JButton buttonPlain= new JButton("écosystème de la plaine");
	private JButton buttonSwamps= new JButton("écosystème du marécage");
	private JButton buttonFrosty= new JButton("écosystème glacial");

	
	public StartWindow() {
		buttonSavanna.setFont(font);
		buttonSavanna.setBackground(Color.black);
		buttonSavanna.setForeground(Color.white);
		buttonSavanna.addActionListener(new SavannaAccess());
		buttonSwamps.setFont(font);
		buttonSwamps.setBackground(Color.black);
		buttonSwamps.setForeground(Color.white);
		buttonSwamps.addActionListener(new SwampsAccess());
		buttonPlain.setFont(font);
		buttonPlain.setBackground(Color.black);
		buttonPlain.setForeground(Color.white);
		buttonPlain.addActionListener(new PlainAccess());
		buttonFrosty.setFont(font);
		buttonFrosty.setBackground(Color.black);
		buttonFrosty.setForeground(Color.white);
		buttonFrosty.addActionListener(new FrostyAccess());
		jlabel.setFont(font);
		jlabel.setText("\n          Veuillez appuyer sur un bouton correspondant"); 
		jlabel.append("\n       à l'écosystème dont vous voulez voir la simulation");
		
		panel.setLayout(new GridLayout(2,2));
		panel.add(buttonSavanna);
		panel.add(buttonPlain);
		panel.add(buttonSwamps);
		panel.add(buttonFrosty);
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new GridBagLayout());
		gbConstraints.weightx = 1;
		gbConstraints.fill = GridBagConstraints.BOTH;
		gbConstraints.weighty = 0.20;
		gbConstraints.gridx = 0;
		gbConstraints.gridy = 0;
		contentPane.add(jlabel, gbConstraints);
		gbConstraints.fill = GridBagConstraints.BOTH;
		gbConstraints.weighty = 0.80;
		gbConstraints.gridx = 0;
		gbConstraints.gridy = 1;
		contentPane.add(panel, gbConstraints);
		
		setTitle("Fenêtre de démarrage du logiciel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setSize(WINDOWS_DIMENSION);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
	}
	

	
	private class SavannaAccess implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			OperationZone.ecosystem="Savanna";
			setVisible(false);
		}
	}
	private class SwampsAccess implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			OperationZone.ecosystem="Swamps";
			setVisible(false);
		}
	}
	private class PlainAccess implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			OperationZone.ecosystem="Plain";
			setVisible(false);
		}
	}
	private class FrostyAccess implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			OperationZone.ecosystem="Frsty";
			setVisible(false);
		}
	}
}
