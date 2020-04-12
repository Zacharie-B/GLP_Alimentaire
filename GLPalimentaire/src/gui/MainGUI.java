package gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;

import org.jfree.chart.ChartPanel;

import ecosystemProcess.SavannaEcosystem;

public class MainGUI extends JFrame implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Dimension WINDOWS_DIMENSION = new Dimension(1380,700);
	private static final Dimension WINDOWS_INFORMATIONS_DIMENSION = new Dimension (700,700);
	private static final Dimension DIMENSION_OF_INFORMATION_TABLE = new Dimension (300,300);
	private Border lineborder = BorderFactory.createLineBorder(Color.black, 1);
	
	
	private OperationZone operationZone = new OperationZone();
	private InformationZone informationZone = new InformationZone();
	private Dashboard dashboard = new Dashboard();
	private SavannaEcosystem se= new SavannaEcosystem();
	
	private JPanel operationZonep = new JPanel();
	private JPanel informationZonep = new JPanel();
	private GridBagConstraints asidePanelGridBagConstraints = new GridBagConstraints();
	private GridBagConstraints gbConstraints = new GridBagConstraints();
	private JPanel statsInformation = new JPanel();
	
	//private ChartPanel populationEvolutionChart;
	private ChartPanel populationBar1;
	private ChartPanel trophicLevel;
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
				
				
				//JScrollPane jscroll1= new JScrollPane(InformationWindows());
				
				statsInformation.setLayout(new GridLayout(2,1));
				
				populationBar1 = new ChartPanel(informationZone.getPopulationBar1());
				trophicLevel = new ChartPanel(informationZone.getTypeCountPie());
						
				statsInformation.add(populationBar1);
				statsInformation.add(trophicLevel);
				
				JScrollPane jscroll1= new JScrollPane(statsInformation);
				gbConstraints.fill = GridBagConstraints.BOTH;
				gbConstraints.weighty = 0.80;
				gbConstraints.gridx = 0;
				gbConstraints.gridy = 1;
				informationZone.setBorder(lineborder);
				informationZonep.add(jscroll1, gbConstraints);
				
				
				JScrollPane jscroll2= new JScrollPane(informationZone.getjTable());
				gbConstraints.fill = GridBagConstraints.BOTH;
				gbConstraints.weighty = 0.16;
				gbConstraints.gridx = 0;
				gbConstraints.gridy = 2;
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
			}
			
		}
	}
	
	public void MovementOnMap() {
		se.ConsumerMovement();
		se.FirstChain();
		se.SecondChain();
		se.ThirdChain();
		se.AllSpeciesHpManagement();
		dashboard.repaint();
		}
	

	public static void main(String[] args) {
		new MainGUI();
	}

}
