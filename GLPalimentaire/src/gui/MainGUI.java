package gui;


import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.border.Border;

import org.jfree.chart.ChartPanel;

import beingManagement.BeingCreator;
import data.Producer;
import ecosystemProcess.SavannaEcosystem;

public class MainGUI extends JFrame implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Dimension WINDOWS_DIMENSION = new Dimension(1300,700);
	private static final Dimension WINDOWS_INFORMATIONS_DIMENSION = new Dimension (500,700);
	private Border lineborder = BorderFactory.createLineBorder(Color.black, 1);
	
	
	private OperationZone operationZone = new OperationZone();
	private InformationZone informationZone = new InformationZone();
	private Dashboard dashboard = new Dashboard();
	private SavannaEcosystem se= new SavannaEcosystem();
	@SuppressWarnings("unused")
	private BeingCreator instance=BeingCreator.getInstance();
	
	private JPanel operationZonep = new JPanel();
	private JPanel informationZonep = new JPanel();
	private GridBagConstraints asidePanelGridBagConstraints = new GridBagConstraints();
	private GridBagConstraints gbConstraints = new GridBagConstraints();
	
	//private ChartPanel populationEvolutionChart;
	private ChartPanel populationBar1;
	private ChartPanel populationBar2;
	private int action=0;
	
	public MainGUI(){
		init();
		run();
	}
	
	private void CreateButtonOnIHM (JButton button){
		asidePanelGridBagConstraints.weighty = 0.10;
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
				
				CreateButtonOnIHM (operationZone.getButtonLeave());
				CreateButtonOnIHM (operationZone.getButtonDisaster());
				CreateButtonOnIHM (operationZone.getStopButton());
				
				
				gbConstraints.weightx = 1;
				gbConstraints.fill = GridBagConstraints.BOTH;
				gbConstraints.weighty = 0.06;
				gbConstraints.gridx = 0;
				gbConstraints.gridy = 0;
				informationZone.setBorder(lineborder);
				informationZonep.add(informationZone.getLabelInformation(), gbConstraints);
				
				InformationWindows();
				
				JScrollPane jscroll= new JScrollPane(informationZone.getInfosjt());
				gbConstraints.weightx = 1;
				gbConstraints.fill = GridBagConstraints.BOTH;
				gbConstraints.weighty = 0.14;
				gbConstraints.gridx = 0;
				gbConstraints.gridy = 3;
				informationZone.setBorder(lineborder);
				informationZonep.add(jscroll, gbConstraints);
				
				informationZonep.setPreferredSize(WINDOWS_INFORMATIONS_DIMENSION);
				//informationZonep.add(populationEvolutionChart);
				
				
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
	public void InformationWindows() {

		gbConstraints.weighty = 0.40;
		gbConstraints.gridx = 0;
		gbConstraints.gridy = 1;
		populationBar1 = new ChartPanel(informationZone.getPopulationBar1());
		informationZonep.add(populationBar1, gbConstraints);
		
		/*gbConstraints.weighty = 0.40;
		gbConstraints.gridx = 0;
		gbConstraints.gridy = 2;
		populationBar2 = new ChartPanel(informationZone.getPopulationBar2());
		informationZonep.add(populationBar2, gbConstraints);*/
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
			if(OperationZone.stop!=false) {
				MovementOnMap();
				se.AllSpeciesHpManagement();
				InformationWindows();
				repaint();
			}
		}
	}
	
	public void MovementOnMap() {
		se.ConsumerMovement();
		se.FirstChain();
		se.SecondChain();
		se.ThirdChain();
		Producer[] producer = new Producer[SavannaEcosystem.NUMBER_OF_ANIMALS_IN_A_SPECIES];
		producer=(Producer[]) instance.getTable("bush");
		for(int i=0; i<SavannaEcosystem.NUMBER_OF_ANIMALS_IN_A_SPECIES; i++) {
		if(producer[i].getIsAlive()==false) {
			System.out.println(producer[i].getPopulationDensity());
			}
		}
		System.out.println("\n");
		}
	

	public static void main(String[] args) {
		new MainGUI();
	}

}
