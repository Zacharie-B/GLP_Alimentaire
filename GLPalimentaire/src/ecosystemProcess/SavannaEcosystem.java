package ecosystemProcess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import beingManagement.BeingCreator;
import data.primaryConsumerdata.Giraffe;
import data.Position;
import data.Species;
import data.primaryConsumerdata.Buffalo;
import data.primaryConsumerdata.Gazelle;
import data.producersdata.Acacia;
import data.producersdata.Bush;
import data.producersdata.Grass;
import data.primaryConsumerdata.Warthog;
import data.primaryConsumerdata.Zebra;
import data.secondaryConsumerdata.Cheetah;
import data.secondaryConsumerdata.Hyena;
import data.tertiaryConsumerdata.Lion;
import foodChains.FoodChainsProcess;
import movementOfSpecies.CreateMovement;

/**
 * 
 * @author HP
 * represents the different food chains in the SavannaEcosystem
 */
public class SavannaEcosystem extends FoodChainsProcess{
	
	/**
	 * initialization of all species present in FrostyEcosystem
	 */
	private Position position = new Position(8,8);
	private Grass grass = new Grass("grass",true,100,10,2,3,25,0,4,position);
	private Gazelle gazelle = new Gazelle("gazelle", 3, 100, true, 10, 1, 10, 100, 3, false, position);
	private Warthog warthog = new Warthog ("warthog",4, 150, true, 5, 15, 4, 30, 6, false, position);
	private Cheetah cheetah = new Cheetah ("cheetah",10, 100, true, 1, 1, 50, 150, 6, false, position);
	Species[] cheetahBeings = BeingCreator.initFamily();
	private Bush bush = new Bush("bush",true,100,10,2,3,5,1,4,position);
	private Buffalo buffalo = new Buffalo("buffalo", 3, 100, true, 10, 100, 10, 10, 3, false, position);
	private Zebra zebra = new Zebra("zebra",4, 150, true, 5, 15, 4, 30, 6, false, position);
	private Hyena hyena = new Hyena ("hyena",10, 300, true, 1, 1, 50, 150, 6, false, position);
	private Acacia acacia = new Acacia("acacia",true,100,10,2,3,5,1,4,position);
	private Giraffe giraffe = new Giraffe("giraffe", 3, 100, true, 10, 100, 10, 10, 3, false, position);
	private Lion lion = new Lion ("lion",10, 10, true, 1, 1, 50, 150, 6, false, position);
	
	/**
	 * Lists that allow us to know the predator of each species except the Third Consumer
	 */
	private ArrayList <String> grassEatenBy;
	private ArrayList <String> gazelleEatenBy;
	private ArrayList <String> warthogEatenBy;
	private ArrayList <String> cheetahEatenBy;
	private ArrayList <String> bushEatenBy;
	private ArrayList <String> buffaloEatenBy;
	private ArrayList <String> zebraEatenBy;
	private ArrayList <String> hyenaEatenBy;
	private ArrayList <String> acaciaEatenBy;
	private ArrayList <String> giraffeEatenBy;
	
	/**
	 * allows us to position the different species and minerals on the map
	 */
	@SuppressWarnings("unused")
	private Position[] positionsSpecies;
	private Position[] positionsMineral;
	@SuppressWarnings("unused")
	private Position[] positionsDecomposer;	
	private HashMap <Position,Integer> rateMineralPerCase;
	
	private static final int NBMAXSPECIES=500;
	
	
	public SavannaEcosystem() {
		positionsSpecies = new Position[NBMAXSPECIES];
		rateMineralPerCase = new HashMap <Position,Integer>(BeingCreator.ALL_POINTS);
		AllPointsMap();
		ConsumerMovement();
		FirstChain();
		SecondChain();
		ThirdChain();
	}

	private void ConsumerMovement() {
				CreateMovement cm = new CreateMovement();
				cm.SavannaMouvement(lion.getCordinates());
				cm.SavannaMouvement(giraffe.getCordinates());
				cm.SavannaMouvement(hyena.getCordinates());
				cm.SavannaMouvement(gazelle.getCordinates());
				cm.SavannaMouvement(warthog.getCordinates());
				cm.SavannaMouvement(cheetah.getCordinates());
				cm.SavannaMouvement(buffalo.getCordinates());
				cm.SavannaMouvement(zebra.getCordinates());
				
				
				
				
		}


	public void FirstChain() {
		FirstTrophicLevel(grass, gazelle, grassEatenBy,rateMineralPerCase);
		FirstTrophicLevel(grass, warthog, grassEatenBy,rateMineralPerCase);
		FirstTrophicLevel(bush, gazelle, bushEatenBy,rateMineralPerCase);
		FirstTrophicLevel(bush, warthog, bushEatenBy,rateMineralPerCase);
		SecondTrophicLevel(gazelle, cheetah, gazelleEatenBy,rateMineralPerCase);
		SecondTrophicLevel(warthog, cheetah, warthogEatenBy,rateMineralPerCase);
		ThirdTrophicLevel(cheetah,lion,cheetahEatenBy,rateMineralPerCase);	
	}
	
	public void SecondChain() {
		FirstTrophicLevel(grass, buffalo, grassEatenBy,rateMineralPerCase);
		FirstTrophicLevel(grass, zebra, grassEatenBy,rateMineralPerCase);
		FirstTrophicLevel(bush, buffalo, bushEatenBy,rateMineralPerCase);
		FirstTrophicLevel(bush, zebra, bushEatenBy,rateMineralPerCase);
		SecondTrophicLevel(buffalo, hyena, buffaloEatenBy,rateMineralPerCase);
		SecondTrophicLevel(gazelle, cheetah, gazelleEatenBy,rateMineralPerCase);
		SecondTrophicLevel(warthog, cheetah, warthogEatenBy,rateMineralPerCase);
		SecondTrophicLevel(zebra, hyena, zebraEatenBy,rateMineralPerCase);
		ThirdTrophicLevel(hyena,lion,hyenaEatenBy,rateMineralPerCase);
	}
	
	public void ThirdChain() {
		FirstTrophicLevel(acacia, giraffe, acaciaEatenBy,rateMineralPerCase);
		SecondTrophicLevel(giraffe, hyena, giraffeEatenBy,rateMineralPerCase);
		ThirdTrophicLevel(hyena,lion,hyenaEatenBy,rateMineralPerCase);
	}
	
	public void HungryConsumer() {
		//for(int time;)
	}
	
	public void AllPointsMap() {
		for(int i=0; i<20;i++) {
			for(int j=0; j<10;j++) {
				int x=0;
				positionsMineral = new Position[BeingCreator.ALL_POINTS];
				Position cordinates = new Position(i,j);
				positionsMineral[x]=cordinates;
				rateMineralPerCase.put(positionsMineral[x],100);
				x++;
			}
		}
	}
	
	public void DisplayAndScrollHashMap() {
		  Set<Entry<Position, Integer>> setHm = rateMineralPerCase.entrySet();
	      Iterator<Entry<Position, Integer>> it = setHm.iterator();
	      while(it.hasNext()){
	         Entry<Position, Integer> e = it.next();
	         System.out.println(e.getKey() + " : " + e.getValue());
	      }
	}
	

	public void seeking(Species speciesSeeking, Species [] speciesSearched, int indOfSeeker) {
		//double fort de -size � size
		// formule (x - center_x)^2 + (y - center_y)^2 < radius^2
		int memberOne;
		int memberTwo;
		int distance;
		int minDistance;
		memberOne = (int) Math.pow(speciesSeeking.getCordinates().getX() - speciesSearched[0].getCordinates().getX(), 2);
		memberTwo = (int) Math.pow(speciesSeeking.getCordinates().getY() - speciesSearched[0].getCordinates().getY(), 2);
		distance = (int) Math.sqrt(memberOne+memberTwo);
		minDistance = distance;
		for(int i=1; i<BeingCreator.ALL_POINTS; i++) {
			memberOne = (int) Math.pow(speciesSeeking.getCordinates().getX() - speciesSearched[i].getCordinates().getX(), 2);
			memberTwo = (int) Math.pow(speciesSeeking.getCordinates().getY() - speciesSearched[i].getCordinates().getY(), 2);
			distance = (int) Math.sqrt(memberOne+memberTwo);
			if (distance<minDistance && i!=indOfSeeker) {
				minDistance=distance;
			}
		}
		
	}

	
	@Override
	public String toString() {
		String result = "species : (" +grass.getName()+", "+ grass.getHP() +"," +grass.getIsAlive()+"," +grass.getCordinates()+")";
		result += "\nspecies : (" +gazelle.getName()+", "+ gazelle.getHp() + "," +gazelle.getIsAlive()+"," +gazelle.getCordinates()+")";
		result += "\nspecies : (" +warthog.getName()+", "+ warthog.getHp() + "," +warthog.getIsAlive()+"," +warthog.getCordinates()+")";
		result += "\nspecies : ("+cheetah.getName()+", "+ cheetah.getHp() +"," +cheetah.getIsAlive()+"," +cheetah.getCordinates()+")";
		result += "\nspecies : (" +bush.getName()+", "+ bush.getHP() + "," +bush.getIsAlive()+"," +bush.getCordinates()+")";
		result += "\nspecies : (" +buffalo.getName()+", "+ buffalo.getHp() + "," +buffalo.getIsAlive()+"," +buffalo.getCordinates()+")";
		result += "\nspecies : ("+zebra.getName()+", "+ zebra.getHp() + "," +zebra.getIsAlive()+"," +zebra.getCordinates()+")";
		result += "\nspecies : ("+hyena.getName()+", "+ hyena.getHp() +"," +hyena.getIsAlive()+"," +hyena.getCordinates()+")";
		result += "\nspecies : (" +acacia.getName()+", "+ acacia.getHP() + "," +acacia.getIsAlive()+"," +acacia.getCordinates()+")";
		result += "\nspecies : (" +giraffe.getName()+", "+ giraffe.getHp() + "," +giraffe.getIsAlive()+"," +giraffe.getCordinates()+")";
		result += "\nspecies : ("+lion.getName()+", "+ lion.getHp() +"," +lion.getIsAlive()+"," +lion.getCordinates()+")";
		return result;
	}
}
