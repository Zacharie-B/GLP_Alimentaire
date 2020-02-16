package foodChains;

import java.util.ArrayList;

import data.Position;
import data.primaryConsumerdata.Aphid;
import data.primaryConsumerdata.HerbivorousLadybug;
import data.producersdata.Ferns;
import data.producersdata.TreeLeaves;
import data.secondaryConsumerdata.AsianLadybug;
import data.secondaryConsumerdata.Spider;
import data.tertiaryConsumerdata.Bramble;
import data.tertiaryConsumerdata.Woodpecker;

public class PlainEcosytem extends FoodChains{
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

			
		public PlainEcosytem() {
			treeleavesEatenBy = new ArrayList <String> ();
			aphidEatenBy = new ArrayList <String> ();
			asianLadybugEatenBy = new ArrayList <String> ();
			fernsEatenBy = new ArrayList <String> ();
			herbivorousLadybugEatenBy = new ArrayList <String> ();
			spiderEatenBy = new ArrayList <String> ();
		}
		
		public FoodChains FirstChain() {
			FirstTrophicLevel(treeLeaves, aphid, treeleavesEatenBy);
			FirstTrophicLevel(treeLeaves, herbivorousLadybug, treeleavesEatenBy);
			SecondTrophicLevel(aphid, asianLadybug, aphidEatenBy);
			ThirdTrophicLevel(asianLadybug, woodpecker, asianLadybugEatenBy);
			return null;	
		}
		
		public FoodChains SecondChain() {
			FirstTrophicLevel(ferns, herbivorousLadybug, fernsEatenBy);
			SecondTrophicLevel(herbivorousLadybug, spider, herbivorousLadybugEatenBy);
			ThirdTrophicLevel(asianLadybug,bramble,asianLadybugEatenBy);
			ThirdTrophicLevel(spider, bramble, spiderEatenBy);
			return null;
		}
		
		
		public String toString() {
			String result = "First species : (" + treeLeaves.toString() + ")\n";
			result += "\nSecond species : (" + aphid.toString() + ")\n";
			result += "\nThirsty species : ("+ asianLadybug.toString() + ")\n";
			result += "\nFourth species : ("+ woodpecker.toString() +")\n";
			return result;
		}
		
		
}
