package gui;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private GridBagConstraints asidePanelGridBagConstraints = new GridBagConstraints();
	private int i=0;
	
	public MainGUI(){
		init();
		run();
	}
	
	private void CreateButtonOnIHM (JButton button){
		asidePanelGridBagConstraints.weighty = 0.03;
		asidePanelGridBagConstraints.gridx = 0;
		asidePanelGridBagConstraints.gridy = i;
		operationZone.setBorder(lineborder);
		operationZoneANDinformationZone.add(button, asidePanelGridBagConstraints);
		i++;
	}
	
	private void CreateLabelIHM(JLabel labelInformation) {
		// TODO Auto-generated method stub
		asidePanelGridBagConstraints.weighty = 0.18;
		asidePanelGridBagConstraints.gridx = 0;
		asidePanelGridBagConstraints.gridy = i;
		informationZone.setBorder(lineborder);
		operationZoneANDinformationZone.add(labelInformation, asidePanelGridBagConstraints);
		i++;
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
				
				asidePanelGridBagConstraints.weightx = 1;
				asidePanelGridBagConstraints.fill = GridBagConstraints.BOTH;
				
				CreateButtonOnIHM (operationZone.getButtonLeave());
				CreateButtonOnIHM (operationZone.getButtonDisaster());
				CreateButtonOnIHM (operationZone.getStopButton());
				
				CreateLabelIHM (informationZone.getLabelInformation());
				CreateLabelIHM (informationZone.getLabeltopleft());
				CreateLabelIHM (informationZone.getLabeltopright());
				CreateLabelIHM (informationZone.getLabelbottomleft());
				CreateLabelIHM (informationZone.getLabelbottomright());
				/*asidePanelGridBagConstraints.weighty = 0.80;
				asidePanelGridBagConstraints.gridx = 0;
				asidePanelGridBagConstraints.gridy = i;
				informationZone.setBorder(lineborder);
				operationZoneANDinformationZone.add(informationZone, asidePanelGridBagConstraints);*/
				
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
				informationZone.CounterSpecies();
			}
		}
	}
	
	public void MovementOnMap() {
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
