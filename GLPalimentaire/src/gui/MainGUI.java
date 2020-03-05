package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import data.Position;

import ecosystemProcess.SavannaEcosystem;

public class MainGUI extends JFrame implements Runnable{

	private Dimension dimensionFenetre = new Dimension(1850,900);
	private Border lineborder = BorderFactory.createLineBorder(Color.black, 1);
	
	private OperationZone operationZone = new OperationZone();
	private InformationZone informationZone = new InformationZone();
	private Dashboard dashboard = new Dashboard();
	
	private JPanel operationZoneANDinformationZone = new JPanel(new GridBagLayout());
	
	private JPanel fenetre = new JPanel(new GridBagLayout());
	
	public MainGUI(String title){
		
		//début teste image de fond
		try {
			dashboard.setImage("src/misc/Orange.jpg");
			dashboard.setLion("src/misc/lion.jpg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//fin test image de fond
		
		//début : positionnement de operationZone et informationZone dans le JPanel operationZoneANDinformationZone 
		GridBagConstraints c1 = new GridBagConstraints();
		
		c1.fill = GridBagConstraints.BOTH;
		c1.weightx = 1;
		
		c1.weighty = 0.2;
		c1.gridx = 0;
		c1.gridy = 0;
		operationZone.setBorder(lineborder);
		operationZoneANDinformationZone.add(operationZone, c1);
		
		c1.weighty = 0.8;
		c1.gridx = 0;
		c1.gridy = 1;
		informationZone.setBorder(lineborder);
		operationZoneANDinformationZone.add(informationZone, c1);
		//fin : positionnement de operationZone et informationZone dans le JPanel operationZoneANDinformationZone 
		
		
		//début : positionnement de dashboard et operationZoneANDinformationZone dans le JPanel fenetre 
		GridBagConstraints c2 = new GridBagConstraints();
		
		c2.fill = GridBagConstraints.BOTH;
		c2.weighty = 1;

		c2.weightx = 0.95;
		c2.gridx = 0;
		c2.gridy = 0;
		dashboard.setBorder(lineborder);
		fenetre.add(dashboard, c2);

		c2.weightx = 0.05;
		c2.gridx = 1;
		c2.gridy = 0;
		fenetre.add(operationZoneANDinformationZone, c2);
		//fin : positionnement de dashboard et operationZoneANDinformationZone dans le JPanel fenetre 
		
		add(fenetre);
		
		setTitle(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setSize(dimensionFenetre);
		setVisible(true);
		setResizable(false);
	}
	
	private void init() {
		
	}
	@Override
	public void run() {
		SavannaEcosystem savannaTest = new SavannaEcosystem();
		boolean finish = false;
		while (finish==false) {
			@SuppressWarnings("unused")
			Position animalPos = savannaTest.ConsumerMovement();
			dashboard.repaint();
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e){
				System.out.println(e.getMessage());
			}
		}
		
	}

	/*public static void main(String[] args) {
		new MainGUI("Map");
	}*/

}
