package gui;

import java.awt.Font;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;


import beingManagement.BeingCreator;
import data.Consumer;
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
import movementOfSpecies.InitialPosition;


public class InformationZone extends JPanel{

	private static final long serialVersionUID = 1L;
	
	//debut:test
	private JLabel labelInformation = new JLabel("     Informations sur les espèces de la Savane");
	private DefaultPieDataset dataset = new DefaultPieDataset();
	private static Font font = new Font(Font.MONOSPACED, Font.BOLD, 15);
	
	
	private BeingCreator animals = BeingCreator.getInstance();
	private JTable jTableFoodChains = new JTable();
	private JTable jTableGlobalInformations = new JTable();
	
	public JTable getjTableGlobalInformations() {
		return jTableGlobalInformations;
	}


	public JTable getjTableFoodChains() {
		return jTableFoodChains;
	}


	public JLabel getLabelInformation() {
		return labelInformation;
	}

	public InformationZone(){
		labelInformation.setFont(font);
		FoodChainsTable();
	}
	public void currentPopulationSavanna() {
		File file = new File("src/data/populationactuelle.png");
	    try { 
	      ChartUtilities.saveChartAsPNG(file, getTypeCountPieSavanna(), 800, 450); 
	    }
	     catch (IOException e) { 
	      e.printStackTrace(); 
	    }
	}

	private int CounterInLife(String name) {
		Species[] consumer = new Consumer[animals.getTable(name).length];
		consumer=(Species[]) animals.getTable(name);
		int number = 0;
			for(int index=0; index<animals.getTable(name).length;index++) {
				number+=consumer[index].getPopulationDensity();
			}
		return number;
	}
	
	private int CounterGroup(String name) {
		int length = animals.getTable(name).length;
		return length;
	}

	public int getProducerNumberSavanna() {
		int total=CounterInLife("bush");
		total+=CounterInLife("acacia");
		total+=CounterInLife("grass");
		return total;
	}
	
	public int getPrimaryConsumerNumberSavanna() {
		int total=CounterInLife("giraffe");
		total+=CounterInLife("warthog");
		total+=CounterInLife("zebra");
		total+=CounterInLife("gazelle");
		total+=CounterInLife("buffalo");
		return total;
	}
	
	public int getSecondaryConsumerNumberSavanna() {
		int total=CounterInLife("cheetah");
		total+=CounterInLife("hyena");
		return total;
	}
	
	/**
	 * Generates the node type pie chart.
	 * 
	 * @return the pie chart
	 */
	public JFreeChart getTypeCountPieSavanna() {
		
		dataset.setValue("Producteur", getProducerNumberSavanna());
		dataset.setValue("Consommateur Primaire", getPrimaryConsumerNumberSavanna());
		dataset.setValue("Consommateur Secondaire", getSecondaryConsumerNumberSavanna());
		dataset.setValue("Consommateur Tertiaire", CounterInLife("lion"));
		
		return ChartFactory.createPieChart("Nombre d'individus en vie"
				+ " triés par groupes de niveau trophique", dataset, true, true, false);
	}
	
	public void refreshTypeCountPieSavanna() {
		dataset.remove("Producteur");
		dataset.remove("Consommateur Primaire");
		dataset.remove("Consommateur Secondaire");
		dataset.remove("Consommateur Tertiaire");
	}
	
	
	public void GlobalInformationsTable() {
		String[] headers = new String[]{"Espèce", "Nombre de groupe (image(s))", "Population totale", "niveau trophique"};
        Object rows[][] = {{"acacia",CounterGroup("acacia"),CounterInLife("acacia"),"producteur"},
        		{"herbe",CounterGroup("grass"),CounterInLife("grass"),"producteur"},
        		{"buisson",CounterGroup("bush"),CounterInLife("bush"),"producteur"},
        		{"zèbre",CounterGroup("zebra"),CounterInLife("zebra"),"consommateur primaire"},
        		{"giraffe",CounterGroup("giraffe"),CounterInLife("giraffe"),"consommateur primaire"},
        		{"phacochère",CounterGroup("warthog"),CounterInLife("warthog"),"consommateur primaire"},
        		{"buffle",CounterGroup("buffalo"),CounterInLife("buffalo"),"consommateur primaire"},
        		{"gazelle",CounterGroup("gazelle"),CounterInLife("gazelle"),"consommateur primaire"},
        		{"hyène",CounterGroup("hyena"),CounterInLife("hyena"),"consommateur secondaire"},
        		{"guépard",CounterGroup("cheetah"),CounterInLife("cheetah"),"consommateur secondaire"},
        		{"lion",CounterGroup("lion"),CounterInLife("lion"),"consommateur tertiaire"},
        		};
        		
        DefaultTableModel tableModel = new DefaultTableModel(rows, headers);
        jTableGlobalInformations.setModel(tableModel);
        
        //Bloquer le redimensionnement
        jTableGlobalInformations.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumn col = jTableGlobalInformations.getColumnModel().getColumn(0);
        col.setPreferredWidth(50);
        col = jTableGlobalInformations.getColumnModel().getColumn(1);
        col.setPreferredWidth(180);
        col = jTableGlobalInformations.getColumnModel().getColumn(2);
        col.setPreferredWidth(190);
        col = jTableGlobalInformations.getColumnModel().getColumn(3);
        col.setPreferredWidth(95);
	}
	
	
	/**
	 * Display all FoodChains of SavannaEcosystem in a table
	 */
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
	        jTableFoodChains.setModel(tableModel);
	        
	        //Bloquer le redimensionnement
	        jTableFoodChains.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	        TableColumn col = jTableFoodChains.getColumnModel().getColumn(0);
	        col.setPreferredWidth(50);
	        col = jTableFoodChains.getColumnModel().getColumn(1);
	        col.setPreferredWidth(180);
	        col = jTableFoodChains.getColumnModel().getColumn(2);
	        col.setPreferredWidth(190);
	        col = jTableFoodChains.getColumnModel().getColumn(3);
	        col.setPreferredWidth(95);
	  }
	
}
