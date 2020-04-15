package ecosystemProcess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import data.producersdata.Phytoplanckton;
import data.primaryConsumerdata.Zooplanckton;
import data.Position;
import data.primaryConsumerdata.Crustacean;
import data.secondaryConsumerdata.Cyprinid;
import data.tertiaryConsumerdata.Pike;
import data.tertiaryConsumerdata.Sheatfish;
import foodChains.FoodChainsProcess;

/**
 * 
 * @author HP
 * represents the different food chains in the LakeEcosystem
 */
public class LakeEcosystem extends FoodChainsProcess{
	private Position position = new Position(2,5);
	private Phytoplanckton phytoplanckton = new Phytoplanckton("phytoplanckton",true,1000,100,1,3,2,1,1,position);
	private Zooplanckton zooplanckton = new Zooplanckton("zooplanckton",4,5,true,500,100,1,5,1,false,position); 
	private Crustacean crustacean = new Crustacean("crustacean",6,20,true,50,10,3,20,2,false,position); 
	private Cyprinid cyprinid = new Cyprinid("cyprinid",8,100,true,3,10,8,100,4,false,position); 
	private Pike pike = new Pike("pike",10,200,true,2,10,10,200,5,false,position); 
	private Sheatfish sheatfish = new Sheatfish("sheatfish",10,250,true,1,10,10,250,5,false,position); 
	private ArrayList <String> phytoplancktonEatenBy;
	private ArrayList <String> zooplancktonEatenBy;
	private ArrayList <String> crustaceanEatenBy;
	private ArrayList <String> cyprinidEatenBy;
	
	@SuppressWarnings("unused")
	private Position[] positionsSpecies;
	private Position[] positionsMineral;
	@SuppressWarnings("unused")
	private Position[] positionsDecomposer;	
	private HashMap <Position,Integer> rateMineralPerCase;
	
	private static final int allPoints= 200;
	@SuppressWarnings("unused")
	private static final int nbMaxSpecies=500;
	
	
	
	public LakeEcosystem(){
		phytoplancktonEatenBy= new ArrayList <String> ();
		zooplancktonEatenBy= new ArrayList <String> ();
		crustaceanEatenBy= new ArrayList <String> ();
		cyprinidEatenBy= new ArrayList <String> ();
	}
	
	public void FirstChain() {
		FirstTrophicLevel(phytoplanckton, zooplanckton, phytoplancktonEatenBy,rateMineralPerCase);
		FirstTrophicLevel(phytoplanckton, crustacean, phytoplancktonEatenBy,rateMineralPerCase);
		SecondTrophicLevel(zooplanckton, cyprinid, zooplancktonEatenBy,rateMineralPerCase);
		SecondTrophicLevel(crustacean, cyprinid, crustaceanEatenBy,rateMineralPerCase);
		ThirdTrophicLevel(cyprinid, pike, cyprinidEatenBy,rateMineralPerCase);
		ThirdTrophicLevel(cyprinid, sheatfish, cyprinidEatenBy,rateMineralPerCase);	
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
		return "LakeEcosystem [position=" + position + ", \nphytoplanckton=" + phytoplanckton.gethp() + ", \nzooplanckton="
				+ zooplanckton.getHp() + ", \ncrustacean=" + crustacean.getHp() + ", \ncyprinid=" + cyprinid.getHp() + ", \npike=" 
				+ pike.getHp() + ", \nsheatfish=" + sheatfish.getHp() +"]";
	}
	
}
