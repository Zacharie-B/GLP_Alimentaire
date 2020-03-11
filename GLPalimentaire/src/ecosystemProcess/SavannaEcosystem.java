package ecosystemProcess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import beingManagement.BeingCreator;
import data.primaryConsumerdata.Giraffe;
import data.Consumer;
import data.Position;
import data.Producer;
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
import foodChains.IsDead;
import movementOfSpecies.InitialPosition;
import naturalNeedsManagement.MineralChange;

/**
 * 
 * @author HP
 * represents the different food chains in the SavannaEcosystem
 */
public class SavannaEcosystem extends FoodChainsProcess{
	
	/**
	 * initialization of all species present in FrostyEcosystem
	 */
	private static InitialPosition pos = new InitialPosition();
	public static Grass grass = new Grass("grass",true,100,10,2,150,25,0,4,pos.initPosition[0]);
	public static Gazelle gazelle = new Gazelle("gazelle", 150, 100, true, 10, 1, 10, 100, 3, false, pos.initPosition[1]);
	public static Warthog warthog = new Warthog ("warthog",200, 150, true, 5, 15, 4, 30, 6, false, pos.initPosition[2]);
	public static Cheetah cheetah = new Cheetah ("cheetah",200, 100, true, 1, 1, 50, 150, 6, false, pos.initPosition[3]);
	@SuppressWarnings("unused")
	private Species[] cheetahBeings = BeingCreator.initFamily();
	public static Bush bush = new Bush("bush",true,100,10,2,150,5,1,4,pos.initPosition[4]);
	public static Buffalo buffalo = new Buffalo("buffalo", 150, 10, true, 10, 100, 10, 10, 3, false, pos.initPosition[5]);
	public static Zebra zebra = new Zebra("zebra",200, 150, true, 5, 15, 4, 30, 6, false, pos.initPosition[6]);
	public static Hyena hyena = new Hyena ("hyena",300, 300, true, 1, 1, 50, 150, 6, false, pos.initPosition[7]);
	public static Acacia acacia = new Acacia("acacia",true,100,10,2,300,5,1,4,pos.initPosition[8]);
	public static Giraffe giraffe = new Giraffe("giraffe", 150, 100, true, 10, 100, 10, 10, 3, false, pos.initPosition[9]);
	public static  Lion lion = new Lion ("lion",300, 10, true, 1, 1, 50, 150, 6, false, pos.initPosition[10]);
	
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
	private Position[] positionsMineral;
	@SuppressWarnings("unused")
	private Position[] positionsDecomposer;	
	@SuppressWarnings("unused")
	private Species[] species;
	
	private static final int NBMAXSPECIES=500;
	private MineralChange mineral = MineralChange.getInstance();
	
	public SavannaEcosystem() {
		species = new Species[NBMAXSPECIES];
		mineral.valuesInCase = new HashMap <Position,Integer>(BeingCreator.ALL_POINTS);
		//DisplayAndScrollHashMap();
	}







	public void FirstChain() {
		FirstTrophicLevel(grass, gazelle, grassEatenBy);
		FirstTrophicLevel(grass, warthog, grassEatenBy);
		FirstTrophicLevel(bush, gazelle, bushEatenBy);
		FirstTrophicLevel(bush, warthog, bushEatenBy);
		SecondTrophicLevel(gazelle, cheetah, gazelleEatenBy);
		SecondTrophicLevel(warthog, cheetah, warthogEatenBy);
		ThirdTrophicLevel(cheetah,lion,cheetahEatenBy);	
	}
	
	public void SecondChain() {
		FirstTrophicLevel(grass, buffalo, grassEatenBy);
		FirstTrophicLevel(grass, zebra, grassEatenBy);
		FirstTrophicLevel(bush, buffalo, bushEatenBy);
		FirstTrophicLevel(bush, zebra, bushEatenBy);
		SecondTrophicLevel(buffalo, hyena, buffaloEatenBy);
		SecondTrophicLevel(gazelle, cheetah, gazelleEatenBy);
		SecondTrophicLevel(warthog, cheetah, warthogEatenBy);
		SecondTrophicLevel(zebra, hyena, zebraEatenBy);
		ThirdTrophicLevel(hyena,lion,hyenaEatenBy);
	}
	
	public void ThirdChain() {
		FirstTrophicLevel(acacia, giraffe, acaciaEatenBy);
		SecondTrophicLevel(giraffe, hyena, giraffeEatenBy);
		ThirdTrophicLevel(hyena,lion,hyenaEatenBy);
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
				mineral.valuesInCase.put(positionsMineral[x],0);
				x++;
			}
		}
	}
	
	public void DisplayAndScrollHashMap() {
		  Set<Entry<Position, Integer>> setHm = mineral.valuesInCase.entrySet();
	      Iterator<Entry<Position, Integer>> it = setHm.iterator();
	      while(it.hasNext()){
	         Entry<Position, Integer> e = it.next();
	         System.out.println(e.getKey() + " : " + e.getValue());
	      }
	}
	public void AllAnimalsHpManagement() {
		DieOrHungryProducer(grass);
		DieOrHungryProducer(bush);
		DieOrHungryProducer(acacia);
		DieOrHungryConsumer(gazelle);
		DieOrHungryConsumer(giraffe);
		DieOrHungryConsumer(lion);
		DieOrHungryConsumer(hyena);
		DieOrHungryConsumer(zebra);
		DieOrHungryConsumer(cheetah);
		DieOrHungryConsumer(warthog);
		DieOrHungryConsumer(buffalo);
	}
	 
	private void DieOrHungryProducer(Producer producer) {
		if(producer.getHP()==0) {
			IsDead isDead= new IsDead();
			isDead.ProducerDead(producer);
		}
		else{
			int hp= producer.getHP();
			hp--;
			producer.setHP(hp);
		}
	}
	
	private void DieOrHungryConsumer(Consumer consumer) {
		if(consumer.getHp()==0) {
			IsDead isDead= new IsDead();
			isDead.ConsumerDead(consumer);
		}
		else{
			int hp= consumer.getHp();
			hp--;
			consumer.setHp(hp);
		}
	}
	

	/**
	 * public void seeking(Species speciesSeeking, Species [] speciesSearched, int indOfSeeker) {
	 
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
	*/
	
	

	
	@Override
	public String toString() {
		String result ="\nspecies :" +grass.getName()+", "+ grass.getHP() +"," +grass.getIsAlive()+"," +grass.getCordinates()+")";
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
