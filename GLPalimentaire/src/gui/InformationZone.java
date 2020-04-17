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
	public JTable refreshTableGlobalInformation() {
		GlobalInformationsTable();
		jTableFoodChains.repaint();
		return jTableFoodChains;
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
		GlobalInformationsTable();	}
	public void currentPopulationSavanna() {
		File file = new File("src/data/populationactuelle.png");
	    try { 
	      ChartUtilities.saveChartAsPNG(file, getTypeCountPieSavanna(), 800, 450); 
	    }
	     catch (IOException e) { 
	      e.printStackTrace(); 
	    }
	}
	
	private int CounterAnimalsGroupHungry(String name) {
		Species[] consumer = new Consumer[animals.getTable(name).length];
		consumer=(Species[]) animals.getTable(name);
		int number = 0;
		for(int index=0; index<animals.getTable(name).length;index++) {
			if(consumer[index].gethp()<10) {
				number++;
			}
		}
	return number;
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
	
	public JFreeChart refreshTypeCountPieSavanna() {
		dataset.remove("Producteur");
		dataset.remove("Consommateur Primaire");
		dataset.remove("Consommateur Secondaire");
		dataset.remove("Consommateur Tertiaire");
		return getTypeCountPieSavanna();
	}
	
	
	public void GlobalInformationsTable() {
        Object rows[][] = {{"acacia",CounterGroup("acacia"),CounterInLife("acacia"),CounterAnimalsGroupHungry("acacia"),"producteur"},
        		{"herbe",CounterGroup("grass"),CounterInLife("grass"),CounterAnimalsGroupHungry("grass"),"producteur"},
        		{"buisson",CounterGroup("bush"),CounterInLife("bush"),CounterAnimalsGroupHungry("bush"),"producteur"},
        		{"zèbre",CounterGroup("zebra"),CounterInLife("zebra"),CounterAnimalsGroupHungry("zebra"),"consommateur primaire"},
        		{"giraffe",CounterGroup("giraffe"),CounterInLife("giraffe"),CounterAnimalsGroupHungry("giraffe"),"consommateur primaire"},
        		{"phacochère",CounterGroup("warthog"),CounterInLife("warthog"),CounterAnimalsGroupHungry("warthog"),"consommateur primaire"},
        		{"buffle",CounterGroup("buffalo"),CounterInLife("buffalo"),CounterAnimalsGroupHungry("buffalo"),"consommateur primaire"},
        		{"gazelle",CounterGroup("gazelle"),CounterInLife("gazelle"),CounterAnimalsGroupHungry("gazelle"),"consommateur primaire"},
        		{"hyène",CounterGroup("hyena"),CounterInLife("hyena"),CounterAnimalsGroupHungry("hyena"),"consommateur secondaire"},
        		{"guépard",CounterGroup("cheetah"),CounterInLife("cheetah"),CounterAnimalsGroupHungry("cheetah"),"consommateur secondaire"},
        		{"lion",CounterGroup("lion"),CounterInLife("lion"),CounterAnimalsGroupHungry("lion"),"consommateur tertiaire"},
        		};
        Object[] title = new String[]{"Espèce", "Nombre de groupe (image(s))", "Population totale","nombre de groupe affamé","niveau trophique"};
        DefaultTableModel tableModel = new DefaultTableModel(rows, title);
        jTableGlobalInformations.setModel(tableModel);
        
        //Bloquer le redimensionnement
        jTableGlobalInformations.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumn col = jTableGlobalInformations.getColumnModel().getColumn(0);
        col.setPreferredWidth(70);
        col = jTableGlobalInformations.getColumnModel().getColumn(1);
        col.setPreferredWidth(180);
        col = jTableGlobalInformations.getColumnModel().getColumn(2);
        col.setPreferredWidth(120);
        col = jTableGlobalInformations.getColumnModel().getColumn(3);
        col.setPreferredWidth(160);
        col = jTableGlobalInformations.getColumnModel().getColumn(4);
        col.setPreferredWidth(150);
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
		  	Object[] headers = new String[]{"Espèce", "Prédateur de l'espèce", "Proie de l'espèce", "niveau trophique"};
	        Object rows[][] = {{"acacia",acacia.Prey(),neverPredator,"producteur"},
	            {"grass",grass.Prey(),neverPredator,"producteur"},
	            {"bush",bush.Prey(),neverPredator,"producteur"},
	            {"gazelle",gazelle.Prey(), gazelle.Predator(),"consommateur primaire"},
	            {"warthog",warthog.Prey(), warthog.Predator(),"consommateur primaire"},
	            {"buffalo",buffalo.Prey(), buffalo.Predator(),"consommateur primaire"},
	            {"giraffe",giraffe.Prey(), giraffe.Predator(),"consommateur primaire"},
	            {"zebra",zebra.Prey(), zebra.Predator(),"consommateur primaire"},
	            {"cheetah",cheetah.Prey(), cheetah.Predator(),"consommateur secondaire"},
	            {"hyena",hyena.Prey(), hyena.Predator(),"consommateur secondaire"},
	            {"lion",neverPrey,lion.Predator(),"consommateur tertiaire"},
	            
	        };
	        DefaultTableModel tableModel = new DefaultTableModel(rows, headers);
	        jTableFoodChains.setModel(tableModel);
	        
	        //Bloquer le redimensionnement
	        jTableFoodChains.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	        TableColumn col = jTableFoodChains.getColumnModel().getColumn(0);
	        col.setPreferredWidth(70);
	        col = jTableFoodChains.getColumnModel().getColumn(1);
	        col.setPreferredWidth(200);
	        col = jTableFoodChains.getColumnModel().getColumn(2);
	        col.setPreferredWidth(200);
	        col = jTableFoodChains.getColumnModel().getColumn(3);
	        col.setPreferredWidth(180);
	  }
	
}
