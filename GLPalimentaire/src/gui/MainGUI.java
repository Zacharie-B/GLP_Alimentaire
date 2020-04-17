package gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;

import org.jfree.chart.ChartPanel;

import beingManagement.Reproduct;
import ecosystemProcess.SavannaEcosystem;

public class MainGUI extends JFrame implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Dimension WINDOWS_DIMENSION = new Dimension(1380,700);
	private static final Dimension WINDOWS_INFORMATIONS_DIMENSION = new Dimension (700,700);
	private Border lineborder = BorderFactory.createLineBorder(Color.black, 1);
	
	
	private OperationZone operationZone = new OperationZone();
	
	private Dashboard dashboard = new Dashboard();
	private SavannaEcosystem se= new SavannaEcosystem();
	private Reproduct reproduct= new Reproduct();
	private InformationZone informationZone = new InformationZone();
	
	private JPanel operationZonep = new JPanel();
	private JPanel informationZonep = new JPanel();
	private GridBagConstraints asidePanelGridBagConstraints = new GridBagConstraints();
	private GridBagConstraints gbConstraints = new GridBagConstraints();
	
	private ChartPanel populationPie1;
	private JTable globalInformation;
	private int action=0;
	private int iteration=0;
	
	
	public MainGUI(){
		OperationZone.ecosystem="Savanna";
		init();
		informationZone.startPopulationSavanna();
		run();
	}
	
	private void CreateButtonOnIHM (JButton button){
		asidePanelGridBagConstraints.weighty = 0.20;
		asidePanelGridBagConstraints.gridx = action;
		asidePanelGridBagConstraints.gridy = 0;
		operationZone.setBorder(lineborder);
		operationZonep.add(button, asidePanelGridBagConstraints);
		action++;
	}
	
	private void init() {
				//d�but teste image de fond
				try {
					dashboard.setPicture();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				operationZonep.setLayout(new GridBagLayout());
				informationZonep.setLayout(new GridBagLayout());
				
				asidePanelGridBagConstraints.weightx = 1;
				asidePanelGridBagConstraints.fill = GridBagConstraints.BOTH;
				
				CreateButtonOnIHM (operationZone.getButtonBackMenu());
				CreateButtonOnIHM (operationZone.getButtonDisaster());
				CreateButtonOnIHM (operationZone.getFastReproductButton());
				CreateButtonOnIHM (operationZone.getSicknessButton());
				CreateButtonOnIHM (operationZone.getStopButton());
				
				
				gbConstraints.weightx = 1;
				gbConstraints.fill = GridBagConstraints.BOTH;
				gbConstraints.weighty = 0.05;
				gbConstraints.gridx = 0;
				gbConstraints.gridy = 0;
				informationZone.setBorder(lineborder);
				informationZonep.add(informationZone.getLabelInformation(), gbConstraints);
				
				
				gbConstraints.fill = GridBagConstraints.BOTH;
				gbConstraints.weighty = 0.50;
				gbConstraints.gridx = 0;
				gbConstraints.gridy = 1;
				informationZone.setBorder(lineborder);
				informationZonep.add(InformationPie(), gbConstraints);
				
				JScrollPane jscroll1= new JScrollPane(paintComponent());
				gbConstraints.fill = GridBagConstraints.BOTH;
				gbConstraints.weighty = 0.30;
				gbConstraints.gridx = 0;
				gbConstraints.gridy = 2;
				informationZone.setBorder(lineborder);
				informationZonep.add(jscroll1, gbConstraints);
				
				JScrollPane jscroll2= new JScrollPane(informationZone.getjTableFoodChains());
				gbConstraints.fill = GridBagConstraints.BOTH;
				gbConstraints.weighty = 0.15;
				gbConstraints.gridx = 0;
				gbConstraints.gridy = 3;
				informationZone.setBorder(lineborder);
				informationZonep.add(jscroll2, gbConstraints);
				
				informationZonep.setPreferredSize(WINDOWS_INFORMATIONS_DIMENSION);
				
				
				//fin : positionnement de operationZone et informationZone dans le JPanel operationZoneANDinformationZone 
				
				
				//d�but : positionnement de dashboard et operationZoneANDinformationZone dans le JPanel fenetre 
				Container contentPane = getContentPane();
				contentPane.setLayout(new BorderLayout());
				
				contentPane.add(BorderLayout.CENTER, dashboard);
				contentPane.add(BorderLayout.EAST,informationZonep);
				contentPane.add(BorderLayout.SOUTH,operationZonep);
				//fin : positionnement de dashboard et operationZoneANDinformationZone dans le JPanel fenetre 
				
				setTitle("Map");
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				pack();
				setSize(WINDOWS_DIMENSION);
				setVisible(true);
				setResizable(false);
	}

	private Component InformationPie() {
		if(OperationZone.stop!=false) {
			populationPie1 = new ChartPanel(informationZone.getTypeCountPieSavanna());
		}
		else {
			populationPie1 = new ChartPanel(informationZone.refreshTypeCountPieSavanna());
		}
		return populationPie1;
		// TODO Auto-generated method stub
	}
	
	private Component paintComponent() {
		globalInformation = informationZone.getjTableGlobalInformations();
		globalInformation.setVisible(true);
		return globalInformation;
		
	}

	@Override
	public void run() {
		boolean finish = false;
		while (finish==false) {
			try {
				Thread.sleep(800);
			}
			catch (InterruptedException e){
				System.out.println(e.getMessage());
			}
			iteration++;
			if(OperationZone.stop!=false) {
				MovementOnMap(OperationZone.ecosystem);
			}
			else {
				informationZone.currentPopulationSavanna();
			}
			
		}
	}

	private void MovementOnMap(String ecosystem) {
		
		switch (ecosystem) {
		case "Savanna":
			se.ConsumerMovementSavanna();
			se.FirstChain();
			se.SecondChain();
			se.ThirdChain();
			se.AllSpeciesHpManagement();
			reproduct.reproductOnSavanna(iteration);
			informationZone.refreshTableGlobalInformation();
			break;
		}
		dashboard.repaint();
}

	public static void main(String[] args) {
		new MainGUI();
	}

}
