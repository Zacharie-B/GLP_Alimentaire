package tests;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

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
 
/**
 * Fixer la taille des colonnes
 * http://www.fobec.com/java/991/fixer-largeur-une-colonne-jtable.html
 * @author Axel 2010
 */
public class TestJTable {
 
    /**
     * @param args the command line arguments
     */
	public TestJTable() {
		FoodChainsTable();
	}
    public static void main(String[] args) {
    	new TestJTable();
        /*JFrame frame = new JFrame("Exemple JTable");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 400);
 
        JTable jTable = new JTable();
        //Ajouter les données dans JTable
        String[] headers = new String[]{"Espèce", "Prédateur", "Proie"};
        Object rows[][] = {{"Apple", "iPhone", "M1"},
            {"Sony", "Xperia", "M2"},
            {"Microsoft", "Lumia", "M3"},
            {"Samsung", "Galaxy", "M4"}
        };
        DefaultTableModel tableModel = new DefaultTableModel(rows, headers);
        jTable.setModel(tableModel);
 
        Container container = frame.getContentPane();
        container.setLayout(new FlowLayout());
 
        //Bloquer le redimensionnement
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        /**
         * fixer la largeur de la première colonne à 100 pixels
         */
        /*TableColumn col = jTable.getColumnModel().getColumn(0);
        col.setPreferredWidth(100);
        /**
         * fixer la largeur de la troisième colonne à 100 pixels
         
         col = jTable.getColumnModel().getColumn(2);
        col.setPreferredWidth(100);
 
        GUI
        JScrollPane jscrollPane = new javax.swing.JScrollPane();
        jscrollPane.setViewportView(jTable);
        frame.getContentPane().add(jscrollPane);
        frame.setVisible(true);*/
        
        
    }
    public void FoodChainsTable() {
	  	JFrame frame = new JFrame("Exemple JTable");
	  	JTable jTable = new JTable();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 400);
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
        //Ajouter les données dans JTable
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
        
        JScrollPane jscrollPane = new javax.swing.JScrollPane();
        jscrollPane.setViewportView(jTable);
        frame.getContentPane().add(jscrollPane);
        frame.setVisible(true);
  }
    
}