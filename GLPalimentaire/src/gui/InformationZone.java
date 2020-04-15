package gui;

import java.awt.Font;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;


import beingManagement.BeingCreator;
import data.Consumer;
import data.Producer;
import data.Species;
import data.primaryConsumerdata.Buffalo;
import data.primaryConsumerdata.Gazelle;
import data.primaryConsumerdata.Giraffe;
import data.primaryConsumerdata.Warthog;
import data.primaryConsumerdata.Zebra;
import data.producersdata.Acacia;
import data.producersdata.Bush;
import data.producersdata.Grass;
import data.secondaryConsumerdata.Cheetah;
import data.secondaryConsumerdata.Hyena;
import data.tertiaryConsumerdata.Lion;
import ecosystemProcess.SavannaEcosystem;
import movementOfSpecies.InitialPosition;


public class InformationZone extends JPanel{

	private static final long serialVersionUID = 1L;
	
	//debut:test
	private JLabel labelInformation = new JLabel("     Informations sur les espèces de la Savane");
	private static Font font = new Font(Font.MONOSPACED, Font.BOLD, 15);
	
	private BeingCreator animals = BeingCreator.getInstance();
	private JTable jTable = new JTable();
	
	public JTable getjTable() {
		return jTable;
	}


	public JLabel getLabelInformation() {
		return labelInformation;
	}

	public InformationZone(){
		labelInformation.setFont(font);
		FoodChainsTable();
		File file1 = new File("src/data/populationdedebut.png");
		try {
			ChartUtilities.saveChartAsPNG(file1, getPopulationBar1(), 600, 350);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void currentPopulation() {
		File file = new File("src/data/populationactuelle.png");
	    try { 
	      ChartUtilities.saveChartAsPNG(file, getPopulationBar1(), 600, 350); 
	    }
	     catch (IOException e) { 
	      e.printStackTrace(); 
	    }
	}

	private int CounterInLife(String name) {
		Species[] consumer = new Consumer[SavannaEcosystem.NUMBER_OF_ANIMALS_IN_A_SPECIES];
		consumer=(Species[]) animals.getTable(name);
		int number = 0;
			for(int index=0; index<SavannaEcosystem.NUMBER_OF_ANIMALS_IN_A_SPECIES;index++) {
				number+=consumer[index].getPopulationDensity();
			}
		return number;
	}

	
	
	
	public JFreeChart getPopulationBar1() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(CounterInLife("bush"), "producer", "bush");
		dataset.setValue(CounterInLife("acacia"), "producer", "acacia");
		dataset.setValue(CounterInLife("grass"), "producer", "grass");
		dataset.setValue(CounterInLife("giraffe"), "primaryConsumer", "giraffe");
		dataset.setValue(CounterInLife("zebra"), "primaryConsumer", "zebra");
		dataset.setValue(CounterInLife("gazelle"), "primaryConsumer", "gazelle");
		dataset.setValue(CounterInLife("warthog"), "primaryConsumer", "warthog");
		dataset.setValue(CounterInLife("buffalo"), "primaryConsumer", "buffalo");
		dataset.setValue(CounterInLife("cheetah"), "secondaryConsumer", "cheetah");
		dataset.setValue(CounterInLife("hyena"), "secondaryConsumer", "hyena");
		dataset.setValue(CounterInLife("lion"), "tertiaryConsumer", "lion");
		
		return ChartFactory.createBarChart("Evolution of animals in Life", "Producer and Animals", "Number alive", dataset, PlotOrientation.VERTICAL, true, true, false);
	}
	   
	   
	  public void FoodChainsTable() {
		  	InitialPosition pos = new InitialPosition();
	        Grass grass = new Grass("grass",true,10,10,2,30,25,0,4,pos.initPosition[0]);
	        Acacia acacia = new Acacia("acacia",true,10,10,2,30,5,1,4,pos.initPosition[0]);
	        Bush bush = new Bush("bush",true,10,10,2,30,5,1,4,pos.initPosition[0]);
	        Gazelle gazelle = new Gazelle("gazelle", 30, 100, true, 10, 1, 10, 100, 3, false, pos.initPosition[0]);
	        Warthog warthog = new Warthog ("warthog",40, 150, true, 5, 15, 4, 30, 6, false, pos.initPosition[0]);
	        Cheetah cheetah = new Cheetah ("cheetah",100, 100, true, 8, 1, 50, 150, 6, false, pos.initPosition[0]);
	        Buffalo buffalo = new Buffalo("buffalo", 30, 10, true, 10, 100, 10, 10, 3, false, pos.initPosition[0]);
	        Zebra zebra = new Zebra("zebra",40, 150, true, 5, 15, 4, 30, 6, false, pos.initPosition[0]);
	        Hyena hyena = new Hyena ("hyena",100, 300, true, 6, 1, 50, 150, 6, false, pos.initPosition[0]);
	        Giraffe giraffe = new Giraffe("giraffe", 30, 100, true, 10, 100, 10, 10, 3, false, pos.initPosition[0]);
	        Lion lion = new Lion ("lion",100, 10, true, 10, 1, 50, 150, 6, false, pos.initPosition[0]);
		  	String neverPredator="minéraux";
		  	String neverPrey="meure de viellesse";
		  	
	        //add data in JTable
		  	String[] headers = new String[]{"Espèce", "Prédateur de l'espèce", "Proie de l'espèce", "niveau trophique"};
	        Object rows[][] = {{"acacia",acacia.Prey(),neverPredator,"niveau 0"},
	            {"grass",grass.Prey(),neverPredator,"niveau 0"},
	            {"bush",bush.Prey(),neverPredator,"niveau 0"},
	            {"gazelle",gazelle.Prey(), gazelle.Predator(),"niveau 1"},
	            {"warthog",warthog.Prey(), warthog.Predator(),"niveau 1"},
	            {"buffalo",buffalo.Prey(), buffalo.Predator(),"niveau 1"},
	            {"giraffe",giraffe.Prey(), giraffe.Predator(),"niveau 1"},
	            {"zebra",zebra.Prey(), zebra.Predator(),"niveau 1"},
	            {"cheetah",cheetah.Prey(), cheetah.Predator(),"niveau 2"},
	            {"hyena",hyena.Prey(), hyena.Predator(),"niveau 2"},
	            {"lion",neverPrey,lion.Predator(),"niveau 3"},
	            
	        };
	        DefaultTableModel tableModel = new DefaultTableModel(rows, headers);
	        jTable.setModel(tableModel);
	        
	        //Bloquer le redimensionnement
	        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	        TableColumn col = jTable.getColumnModel().getColumn(0);
	        col.setPreferredWidth(50);
	        col = jTable.getColumnModel().getColumn(1);
	        col.setPreferredWidth(180);
	        col = jTable.getColumnModel().getColumn(2);
	        col.setPreferredWidth(190);
	        col = jTable.getColumnModel().getColumn(3);
	        col.setPreferredWidth(95);
	  }
	
}
