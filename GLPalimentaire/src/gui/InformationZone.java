package gui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;


import beingManagement.BeingCreator;
import data.Consumer;
import data.Producer;
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

@SuppressWarnings("unused")
public class InformationZone extends JPanel{

	private static final long serialVersionUID = 1L;
	private static final int MAX_GROUP_ANIMALS = 3;
	
	//debut:test
	private JLabel labelInformation = new JLabel("     Informations sur les espèces de la Savane");
	private SavannaEcosystem se= new SavannaEcosystem();
	private static Font font = new Font(Font.MONOSPACED, Font.BOLD, 15);
	
	private BeingCreator animals = BeingCreator.getInstance();
	private JTextArea infosjt;
	
	public JTextArea getInfosjt() {
		return infosjt;
	}

	public JLabel getLabelInformation() {
		return labelInformation;
	}

	public void setLabelInformation(JLabel labelInformation) {
		this.labelInformation = labelInformation;
	}
	public InformationZone(){
		labelInformation.setFont(font);
		printFoodChains();
	}
	
	private int CounterInLifeProducer(String name) {
		Producer[] producer = new Producer[SavannaEcosystem.NUMBER_OF_ANIMALS_IN_A_SPECIES];
		producer=(Producer[]) animals.getTable(name);
		int number = 0;
			for(int index=0; index<SavannaEcosystem.NUMBER_OF_ANIMALS_IN_A_SPECIES;index++) {
				number+=producer[index].getPopulationDensity();
			}
		return number;
	}
	
	private int CounterInLifeConsumer(String name) {
		Consumer[] consumer = new Consumer[SavannaEcosystem.NUMBER_OF_ANIMALS_IN_A_SPECIES];
		consumer=(Consumer[]) animals.getTable(name);
		int number = 0;
			for(int index=0; index<SavannaEcosystem.NUMBER_OF_ANIMALS_IN_A_SPECIES;index++) {
				number+=consumer[index].getPopulationDensity();
			}
		return number;
	}
	
	private int CounterHPConsumer(String name) {
		Consumer[] consumer = new Consumer[SavannaEcosystem.NUMBER_OF_ANIMALS_IN_A_SPECIES];
		consumer=(Consumer[]) animals.getTable(name);
		int number = 0;
			for(int index=0; index<SavannaEcosystem.NUMBER_OF_ANIMALS_IN_A_SPECIES;index++) {
				number+=consumer[index].getHp();
			}
		return number;
	}
	
	public JFreeChart getPopulationBar1() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(CounterInLifeProducer("bush"), "producer", "bush");
		dataset.setValue(CounterInLifeProducer("acacia"), "producer", "acacia");
		dataset.setValue(CounterInLifeProducer("grass"), "producer", "grass");
		dataset.setValue(CounterInLifeConsumer("giraffe"), "primaryConsumer", "giraffe");
		dataset.setValue(CounterInLifeConsumer("zebra"), "primaryConsumer", "zebra");
		dataset.setValue(CounterInLifeConsumer("gazelle"), "primaryConsumer", "gazelle");

		return ChartFactory.createBarChart("", "Producer and Animals", "Number alive", dataset, PlotOrientation.VERTICAL, true, true, false);
	}
	public JFreeChart getPopulationBar2() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(CounterInLifeConsumer("warthog"), "primaryConsumer", "warthog");
		dataset.setValue(CounterInLifeConsumer("buffalo"), "primaryConsumer", "buffalo");
		dataset.setValue(CounterInLifeConsumer("cheetah"), "secondaryConsumer", "cheetah");
		dataset.setValue(CounterInLifeConsumer("hyena"), "secondaryConsumer", "hyena");
		dataset.setValue(CounterInLifeConsumer("lion"), "tertiaryConsumer", "lion");
	
		return ChartFactory.createBarChart("", "Animals",  "Number alive", dataset, PlotOrientation.VERTICAL, true, true, false);
	}
	   public void printFoodChains() {
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
	        String infos="";
	        infosjt = new JTextArea(2,1);
	        infos += grass.toString();
	        infos += "\n" + acacia.toString();
	        infos += "\n" + bush.toString();
	        infos += "\n" + gazelle.toString();
	        infos += "\n" + warthog.toString();
	        infos += "\n" + cheetah.toString();
	        infos += "\n" + buffalo.toString();
	        infos += "\n" + zebra.toString();
	        infos += "\n" + hyena.toString();
	        infos += "\n" + giraffe.toString();
	        infos += "\n" + lion.toString();
	        infosjt.setText(infos);        
	    }
	
}
