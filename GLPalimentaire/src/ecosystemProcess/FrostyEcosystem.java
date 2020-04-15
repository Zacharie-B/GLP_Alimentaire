package ecosystemProcess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import data.Position;
import data.primaryConsumerdata.Clam;
import data.primaryConsumerdata.MuskOx;
import data.producersdata.Foam;
import data.producersdata.Grass;
import data.secondaryConsumerdata.ArcticWolf;
import data.secondaryConsumerdata.Phoque;
import data.tertiaryConsumerdata.Inuit;
import data.tertiaryConsumerdata.PolarBear;
import foodChains.FoodChainsProcess;

/**
 *
 * @author HP
 * represents the different food chains in the FrostyEcosystem
 */
public class FrostyEcosystem extends FoodChainsProcess{
	
	/**
	 * initialization of all species present in FrostyEcosystem
	 */
	private Position position = new Position(8,8);
	private Grass grass = new Grass("grass",true,100,10,2,3,5,1,4,position);
	private MuskOx muskOx = new MuskOx("muskOx", 3, 100, true, 10, 100, 10, 10, 3, false, position);
	private ArcticWolf arcticWolf = new ArcticWolf ("arcticWolf",4, 150, true, 5, 15, 4, 30, 6, false, position);
	private Inuit inuit = new Inuit ("inuit",10, 1000, true, 1, 1, 50, 150, 6, false, position);
	private Foam foam = new Foam("foam",true,100,10,2,3,5,1,4,position);
	private Clam clam = new Clam("clam", 3, 100, true, 10, 100, 10, 10, 3, false, position);
	private Phoque phoque = new Phoque("phoque",4, 150, true, 5, 15, 4, 30, 6, false, position);
	private PolarBear polarBear = new PolarBear ("polarBear",10, 1000, true, 1, 1, 50, 150, 6, false, position);
	
	/**
	 * Lists that allow us to know the predator of each species except the Third Consumer
	 */
	private ArrayList <String> grassEatenBy;
	private ArrayList <String> muskOxEatenBy;
	private ArrayList <String> arcticWolfEatenBy;
	private ArrayList <String> foamEatenBy;
	private ArrayList <String> clamEatenBy;
	private ArrayList <String> phoqueEatenBy;
	
	/**
	 * allows us to position the different species and minerals on the map
	 */
	@SuppressWarnings("unused")
	private Position[] positionsSpecies;
	private Position[] positionsMineral;
	@SuppressWarnings("unused")
	private Position[] positionsDecomposer;	
	private HashMap <Position,Integer> rateMineralPerCase;
	
	private static final int allPoints= 200;
	private static final int nbMaxSpecies=500;
	
	public FrostyEcosystem() {
		positionsSpecies = new Position[nbMaxSpecies];
		rateMineralPerCase = new HashMap <Position,Integer>(200);
		AllPointsMap();
		FirstChain();
		SecondChain();
		DisplayAndScrollHashMap();
	}
	
	public FoodChainsProcess FirstChain() {
		FirstTrophicLevel(grass, muskOx, grassEatenBy,rateMineralPerCase);
		SecondTrophicLevel(muskOx, arcticWolf, muskOxEatenBy,rateMineralPerCase);
		ThirdTrophicLevel(arcticWolf, inuit, arcticWolfEatenBy,rateMineralPerCase);
		return null;
	}
	
	public FoodChainsProcess SecondChain() {
		FirstTrophicLevel(foam, clam, foamEatenBy,rateMineralPerCase);
		SecondTrophicLevel(clam, phoque, clamEatenBy,rateMineralPerCase);
		ThirdTrophicLevel(arcticWolf,inuit,arcticWolfEatenBy,rateMineralPerCase);
		ThirdTrophicLevel(phoque, polarBear, phoqueEatenBy,rateMineralPerCase);
		return null;
	}

	public void HungryConsumer() {
		//for(int time;)
	}

	public void AllPointsMap() {
		for(int i=0; i<20;i++) {
			for(int j=0; j<10;j++) {
				int x=0;
				positionsMineral = new Position[allPoints];
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
	
	@Override
	public String toString() {
		String result = "species : (" +grass.getName()+", "+ grass.gethp() +"," +grass.getIsAlive()+")";
		result += "\nspecies : (" +muskOx.getName()+", "+ muskOx.getHp() + "," +muskOx.getIsAlive()+")";
		result += "\nspecies : (" +arcticWolf.getName()+", "+ arcticWolf.getHp() + "," +arcticWolf.getIsAlive()+")";
		result += "\nspecies : ("+inuit.getName()+", "+ inuit.getHp() +"," +inuit.getIsAlive()+")";
		result += "\nspecies : (" +foam.getName()+", "+ foam.gethp() + "," +foam.getIsAlive()+")";
		result += "\nspecies : (" +clam.getName()+", "+ clam.getHp() + "," +clam.getIsAlive()+")";
		result += "\nspecies : ("+phoque.getName()+", "+ phoque.getHp() + "," +phoque.getIsAlive()+")";
		result += "\nspecies : ("+polarBear.getName()+", "+ polarBear.getHp() +"," +polarBear.getIsAlive()+")";
		return result;
	}
}
