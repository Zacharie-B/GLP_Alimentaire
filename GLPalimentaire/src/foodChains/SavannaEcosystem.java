package foodChains;

import java.util.ArrayList;

import data.Point;
import data.primaryConsumerdata.Aphid;
import data.producersdata.TreeLeaves;
import data.secondaryConsumerdata.AsianLadybug;
import data.tertiaryConsumerdata.Woodpecker;

public class SavannaEcosystem extends FoodChains{
		private Point position = new Point(10,10);
		private TreeLeaves treeLeaves = new TreeLeaves("treeleaves",true,100,10,2,3,5,1,4,position);
		private ArrayList <String> treeleavesEatenBy;
		private Aphid aphid = new Aphid("aphid", 3, 100, true, 10, 100, 10, 10, 3, false, position);
		private ArrayList <String> aphidEatenBy;
		private AsianLadybug asianLadybug = new AsianLadybug ("asianladybug",4, 150, true, 5, 15, 4, 30, 6, false, position);
		private ArrayList <String> asianLadybugEatenBy;
		private Woodpecker woodpecker = new Woodpecker ("woodpecker",10, 1000, true, 1, 1, 50, 150, 6, false, position);
		
		public SavannaEcosystem() {
			treeleavesEatenBy = new ArrayList <String> ();
			aphidEatenBy = new ArrayList <String> ();
			asianLadybugEatenBy = new ArrayList <String> ();
		}
		
		public FoodChains FirstChain() {
			FirstTrophicLevel(treeLeaves, aphid, treeleavesEatenBy);
			SecondTrophicLevel(aphid, asianLadybug, aphidEatenBy);
			ThirdTrophicLevel(asianLadybug, woodpecker, asianLadybugEatenBy);
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
