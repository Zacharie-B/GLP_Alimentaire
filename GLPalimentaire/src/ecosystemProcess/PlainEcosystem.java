package ecosystemProcess;


import java.util.HashMap;

import beingManagement.BeingCreator;
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
import movementOfSpecies.InitialPosition;
import naturalNeedsManagement.MineralChange;

/**
 * 
 * @author HP
 * represents the different food chains in the PlainEcosystem
 */
public class PlainEcosystem extends FoodChainsProcess{
	
	/**
	 * initialization of all species present in PlainEcosystem
	 */
	private static InitialPosition pos = new InitialPosition();
	public TreeLeaves [] TreeLeavesTable;
	public Ferns [] FernsTable;
	public Aphid [] AphidTable;
	public AsianLadybug [] AsianladybugTable;
	public Woodpecker [] WoodpeckerTable;
	public HerbivorousLadybug [] HerbivorousladybugTable;
	public Spider [] SpiderTable;
	public Bramble [] BrambleTable;
	
	/**
	 * allows us to position the different species and minerals on the map
	 */
	
	private static final int NUMBER_OF_ANIMALS_IN_A_SPECIES = 5;
	private int j=0;
	public static int a=0;
	
	private SavannaEcosystem se = new SavannaEcosystem();
	private BeingCreator animalsInSavana = BeingCreator.getInstance();
	private MineralChange mineral = MineralChange.getInstance();
	
	
	public PlainEcosystem(String legacy) {
		mineral.valuesInCase = new HashMap <Position,Integer>(BeingCreator.ALL_POINTS);
	}
	
	public PlainEcosystem() {
		mineral.valuesInCase = new HashMap <Position,Integer>(BeingCreator.ALL_POINTS);
		buildEcosys();
	}
	
	/**
	 * 
	 */
	public void FirstChain() {
		se.FirstFoodChain(TreeLeavesTable,AphidTable,"treeleaves","aphid");
		se.FirstFoodChain(TreeLeavesTable,HerbivorousladybugTable,"treeleaves","herbivorousladybug");
		se.SecondFoodChain(AphidTable,AsianladybugTable,"aphid","asianladybug");
		se.ThirdFoodChain(AsianladybugTable, BrambleTable,"asianladybug","bramble");
		se.ThirdFoodChain(AsianladybugTable, WoodpeckerTable,"asianladybug","woodpecker");
	}
	
	public void SecondChain() {
		se.FirstFoodChain(FernsTable, HerbivorousladybugTable,"ferns","herbivorousladybug");
		se.SecondFoodChain(HerbivorousladybugTable,SpiderTable,"herbivorousladybug","spider");
		se.ThirdFoodChain(SpiderTable, BrambleTable,"spider","bramble");
	}
	
public void AllSpeciesHpManagement() {
		
		se.HpManagement(TreeLeavesTable,"treeleaves");
		se.HpManagement(AphidTable,"aphid");
		se.HpManagement(AsianladybugTable,"asianladybug");
		se.HpManagement(WoodpeckerTable, "woodpecker");
		se.HpManagement(FernsTable,"ferns");
		se.HpManagement(HerbivorousladybugTable,"herbivorousladybug");
		se.HpManagement(SpiderTable,"spider");
		se.HpManagement(BrambleTable,"bramble");
	}
	
	public void ConsumerMovementPlain() {
		se.ConsumerHunting("aphid");
		se.ConsumerHunting("asianladybug");
		se.ConsumerHunting("woodpecker");
		se.ConsumerHunting("herbivorousladybug");
		se.ConsumerHunting("spider");
		se.ConsumerHunting("bramble");
	}
	public void setAnimals(String name) {
		int i;
		int x=a;
		switch (name) {
		case "TreeLeaves" :
			TreeLeavesTable = new TreeLeaves[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				TreeLeavesTable[j] = new TreeLeaves("treeleaves",true,10,10,4,50,25,0,4,pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("treeleaves", TreeLeavesTable);
			break;
		case "Aphid" :
			AphidTable = new Aphid[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				AphidTable[j] = new Aphid("aphid", 50, 100, true, 10, 1, 20, 100, 3, false, pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("aphid", AphidTable);
			break;
		case "Asianladybug" :
			AsianladybugTable = new AsianLadybug[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				AsianladybugTable[j] = new AsianLadybug ("asianladybug",50, 150, true, 10, 15, 10, 30, 6, false, pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("asianladybug", AsianladybugTable);
			break;
		case "Woodpecker" :
			WoodpeckerTable = new Woodpecker[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				WoodpeckerTable[j] = new Woodpecker ("woodpecker",50, 100, true, 10, 100, 40, 50, 6, false, pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("woodpecker", WoodpeckerTable);
			break;
		case "Ferns" :
			FernsTable = new Ferns[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				FernsTable[j] = new Ferns("ferns",true,10,10,4,50,5,1,4,pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("ferns", FernsTable);
			break;
		case "Herbivorousladybug" :
			HerbivorousladybugTable = new HerbivorousLadybug[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				HerbivorousladybugTable[j] = new HerbivorousLadybug("herbivorousladybug", 50, 10, true, 10, 100, 20, 30, 3, false, pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("herbivorousladybug", HerbivorousladybugTable);
			break;
		case "Spider" :
			SpiderTable = new Spider[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				SpiderTable[j] = new Spider("spider",50, 150, true, 10, 100, 10, 30, 6, false, pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("spider", SpiderTable);
			break;
		case "Bramble" :
			BrambleTable = new Bramble[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				BrambleTable[j] = new Bramble ("bramble",50, 300, true, 10, 100, 40, 50, 6, false, pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("bramble", BrambleTable);
			break;
		}
		j=0;
	}
	
	/**
	 * We call the "setAnimals" method for each animal thanks to create the animals of all species.
	 */
	public void buildEcosys() {
		se.AllPointsMap();
		setAnimals("Aphid");
		setAnimals("Asianladybug");
		setAnimals("Woodpecker");
		setAnimals("Treeleaves");
		setAnimals("Ferns");
		setAnimals("Herbivorousladybug");
		setAnimals("Spider");
		setAnimals("Bramble");
	}	
	
		
		
}
