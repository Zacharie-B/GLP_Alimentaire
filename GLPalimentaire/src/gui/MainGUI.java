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
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import data.Position;

import ecosystemProcess.SavannaEcosystem;
import movementOfSpecies.CreateMovement;

public class MainGUI extends JFrame implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Dimension WINDOWS_DIMENSION = new Dimension(1850,900);
	private Border lineborder = BorderFactory.createLineBorder(Color.black, 1);
	
	private OperationZone operationZone = new OperationZone();
	private InformationZone informationZone = new InformationZone();
	private Dashboard dashboard = new Dashboard();
	private SavannaEcosystem se= new SavannaEcosystem();
	
	private JPanel operationZoneANDinformationZone = new JPanel(new GridBagLayout());
	
	private JPanel fenetre = new JPanel(new GridBagLayout());
	
	private MainGUI instance = this;
	
	public MainGUI(){
		init();
		run();
	}
	
	private void init() {
				//d�but teste image de fond
				try {
					dashboard.setPicture();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//fin test image de fond
				
				setTitle("Map");
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				pack();
				setSize(WINDOWS_DIMENSION);
				setVisible(true);
				setResizable(false);
				//d�but : positionnement de operationZone et informationZone dans le JPanel operationZoneANDinformationZone 
				GridBagConstraints asidePanelGridBagConstraints = new GridBagConstraints();
				
				asidePanelGridBagConstraints.fill = GridBagConstraints.BOTH;
				asidePanelGridBagConstraints.weightx = 1;
				
				asidePanelGridBagConstraints.weighty = 0.2;
				asidePanelGridBagConstraints.gridx = 0;
				asidePanelGridBagConstraints.gridy = 0;
				operationZone.setBorder(lineborder);
				operationZoneANDinformationZone.add(operationZone, asidePanelGridBagConstraints);
				
				asidePanelGridBagConstraints.weighty = 0.8;
				asidePanelGridBagConstraints.gridx = 0;
				asidePanelGridBagConstraints.gridy = 1;
				informationZone.setBorder(lineborder);
				operationZoneANDinformationZone.add(informationZone, asidePanelGridBagConstraints);
				//fin : positionnement de operationZone et informationZone dans le JPanel operationZoneANDinformationZone 
				
				
				//d�but : positionnement de dashboard et operationZoneANDinformationZone dans le JPanel fenetre 
				GridBagConstraints MapPanelGridBagConstraints = new GridBagConstraints();
				
				MapPanelGridBagConstraints.fill = GridBagConstraints.BOTH;
				MapPanelGridBagConstraints.weighty = 1;

				MapPanelGridBagConstraints.weightx = 0.95;
				MapPanelGridBagConstraints.gridx = 0;
				MapPanelGridBagConstraints.gridy = 0;
				dashboard.setBorder(lineborder);
				fenetre.add(dashboard, MapPanelGridBagConstraints);

				MapPanelGridBagConstraints.weightx = 0.05;
				MapPanelGridBagConstraints.gridx = 1;
				MapPanelGridBagConstraints.gridy = 0;
				fenetre.add(operationZoneANDinformationZone, MapPanelGridBagConstraints);
				//fin : positionnement de dashboard et operationZoneANDinformationZone dans le JPanel fenetre 
				
				add(fenetre);
	}
	
	
	public MainGUI getInstance() {
		return instance;
	}

	public void setInstance(MainGUI instance) {
		this.instance = instance;
	}

	@Override
	public void run() {
		SavannaEcosystem savannaTest = new SavannaEcosystem();
		boolean finish = false;
		while (finish==false) {
			savannaTest.ConsumerMovement();
			System.out.println(savannaTest.toString());
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e){
				System.out.println(e.getMessage());
			}
		}
		
	}
	
	public void ConsumerMovement() {
		SavannaEcosystem.lion.setCordinates(CreateMovement.SavannaMouvement(SavannaEcosystem.lion));
		SavannaEcosystem.giraffe.setCordinates(CreateMovement.SavannaMouvement(SavannaEcosystem.giraffe));
		SavannaEcosystem.hyena.setCordinates(CreateMovement.SavannaMouvement(SavannaEcosystem.hyena));
		SavannaEcosystem.gazelle.setCordinates(CreateMovement.SavannaMouvement(SavannaEcosystem.gazelle));
		SavannaEcosystem.warthog.setCordinates(CreateMovement.SavannaMouvement(SavannaEcosystem.warthog));
		SavannaEcosystem.cheetah.setCordinates(CreateMovement.SavannaMouvement(SavannaEcosystem.cheetah));
		SavannaEcosystem.buffalo.setCordinates(CreateMovement.SavannaMouvement(SavannaEcosystem.buffalo));
		SavannaEcosystem.zebra.setCordinates(CreateMovement.SavannaMouvement(SavannaEcosystem.zebra));
		se.FirstChain();
		se.SecondChain();
		se.ThirdChain();	
		}

	/*public static void main(String[] args) {
		new MainGUI("Map");
	}*/

}
