package gui;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import beingManagement.BeingCreator;
import ecosystemProcess.SavannaEcosystem;

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
	@SuppressWarnings("unused")
	private BeingCreator instance=BeingCreator.getInstance();
	
	private JPanel operationZoneANDinformationZone = new JPanel(new GridBagLayout());
	
	private JPanel fenetre = new JPanel(new GridBagLayout());
	
	
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
	
	@Override
	public void run() {
		boolean finish = false;
		while (finish==false) {
			try {
				Thread.sleep(500);
			}
			catch (InterruptedException e){
				System.out.println(e.getMessage());
			}
			if(OperationZone.stop!=false) {
				MovementOnMap();
				se.AllSpeciesHpManagement();
				System.out.println(se.toString());
			}
		}
	}
	
	public void MovementOnMap() {
		/*for(int i=62; i<67; i++) {
			instance.allAnimals[i].setCordinates(CreateMovement.SavannaMouvement((Consumer) instance.allAnimals[i]));
		}*/
		se.ConsumerMovement();
		se.FirstChain();
		se.SecondChain();
		se.ThirdChain();
		repaint();
		}
	

	public static void main(String[] args) {
		new MainGUI();
	}

}
