package ecosystemProcess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

import data.Position;
import data.primaryConsumerdata.Aphid;
import data.primaryConsumerdata.HerbivorousLadybug;
import data.producersdata.Ferns;
import data.producersdata.TreeLeaves;
import data.secondaryConsumerdata.AsianLadybug;
import data.secondaryConsumerdata.Spider;
import data.tertiaryConsumerdata.Bramble;
import data.tertiaryConsumerdata.Woodpecker;
import foodChains.FoodChainsProcess;

/**
 * 
 * @author HP
 * represents the different food chains in the PlainEcosystem
 */
public class PlainEcosytem extends FoodChainsProcess{
		private Position position = new Position(10,10);
		private TreeLeaves treeLeaves = new TreeLeaves("treeleaves",true,100,10,2,3,5,1,4,position);
		private Aphid aphid = new Aphid("aphid", 3, 100, true, 10, 100, 10, 10, 3, false, position);
		private AsianLadybug asianLadybug = new AsianLadybug ("asianladybug",4, 150, true, 5, 15, 4, 30, 6, false, position);
		private Woodpecker woodpecker = new Woodpecker ("woodpecker",10, 1000, true, 1, 1, 50, 150, 6, false, position);
		private Ferns ferns = new Ferns("ferns",true,100,10,2,3,5,1,4,position);
		private HerbivorousLadybug herbivorousLadybug = new HerbivorousLadybug("herbivorousLadybug", 3, 100, true, 10, 100, 10, 10, 3, false, position);
		private Spider spider = new Spider ("spider",4, 150, true, 5, 15, 4, 30, 6, false, position);
		private Bramble bramble = new Bramble ("blamble",10, 1000, true, 1, 1, 50, 150, 6, false, position);
		private ArrayList <String> treeleavesEatenBy;
		private ArrayList <String> aphidEatenBy;
		private ArrayList <String> asianLadybugEatenBy;
		private ArrayList <String> fernsEatenBy;
		private ArrayList <String> herbivorousLadybugEatenBy;
		private ArrayList <String> spiderEatenBy;
		
		@SuppressWarnings("unused")
		private Position[] positionsSpecies;
		private Position[] positionsMineral;
		@SuppressWarnings("unused")
		private Position[] positionsDecomposer;	
		private HashMap <Position,Integer> rateMineralPerCase;
		
		private static final int allPoints= 200;
		private static final int nbMaxSpecies=500;

			
		public PlainEcosytem() {
			treeleavesEatenBy = new ArrayList <String> ();
			aphidEatenBy = new ArrayList <String> ();
			asianLadybugEatenBy = new ArrayList <String> ();
			fernsEatenBy = new ArrayList <String> ();
			herbivorousLadybugEatenBy = new ArrayList <String> ();
			spiderEatenBy = new ArrayList <String> ();
		}
		
		public FoodChainsProcess FirstChain() {
			FirstTrophicLevel(treeLeaves, aphid, treeleavesEatenBy,rateMineralPerCase);
			FirstTrophicLevel(treeLeaves, herbivorousLadybug, treeleavesEatenBy,rateMineralPerCase);
			SecondTrophicLevel(aphid, asianLadybug, aphidEatenBy,rateMineralPerCase);
			ThirdTrophicLevel(asianLadybug, woodpecker, asianLadybugEatenBy,rateMineralPerCase);
			return null;	
		}
		
		public FoodChainsProcess SecondChain() {
			FirstTrophicLevel(ferns, herbivorousLadybug, fernsEatenBy,rateMineralPerCase);
			SecondTrophicLevel(herbivorousLadybug, spider, herbivorousLadybugEatenBy,rateMineralPerCase);
			ThirdTrophicLevel(asianLadybug,bramble,asianLadybugEatenBy,rateMineralPerCase);
			ThirdTrophicLevel(spider, bramble, spiderEatenBy,rateMineralPerCase);
			return null;
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
		
		
		public String toString() {
			String result = "First species : (" + treeLeaves.toString() + ")\n";
			result += "\nSecond species : (" + aphid.toString() + ")\n";
			result += "\nThirsty species : ("+ asianLadybug.toString() + ")\n";
			result += "\nFourth species : ("+ woodpecker.toString() +")\n";
			return result;
		}
		
		
}
