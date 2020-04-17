package ecosystemProcess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

import beingManagement.BeingCreator;
import data.Consumer;
import data.Position;
import data.primaryConsumerdata.Aphid;
import data.primaryConsumerdata.Herbivorousladybug;
import data.primaryConsumerdata.Aphid;
import data.primaryConsumerdata.Giraffe;
import data.primaryConsumerdata.HerbivorousLadybug;
import data.primaryConsumerdata.Asianladybug;
import data.primaryConsumerdata.Spider;
import data.producersdata.Acacia;
import data.producersdata.Ferns;
import data.producersdata.Ferns;
import data.producersdata.TreeLeaves;
import data.producersdata.TreeLeaves;
import data.secondaryConsumerdata.AsianLadybug;
import data.secondaryConsumerdata.Woodpecker;
import data.secondaryConsumerdata.Bramble;
import data.secondaryConsumerdata.Spider;
import data.tertiaryConsumerdata.Bramble;
import data.tertiaryConsumerdata.Lion;
import data.tertiaryConsumerdata.Woodpecker;
import foodChains.FoodChainsProcess;
import movementOfSpecies.CreateMovement;
import movementOfSpecies.InitialPosition;
import naturalNeedsManagement.MineralChange;

/**
 * 
 * @author HP
 * represents the different food chains in the PlainEcosystem
 */
public class PlainEcosystem extends FoodChainsProcess{
	
	/**
	 * initialization of all species present in FrostyEcosystem
	 */
	private static InitialPosition pos = new InitialPosition();
	public TreeLeaves [] TreeLeavesTable;
	public Acacia [] acaciaTable;
	public Ferns [] FernsTable;
	public Aphid [] AphidTable;
	public AsianLadybug [] AsianladybugTable;
	public Woodpecker [] WoodpeckerTable;
	public HerbivorousLadybug [] HerbivorousladybugTable;
	public Spider [] SpiderTable;
	public Bramble [] BrambleTable;
	public Giraffe [] giraffeTable;
	public Lion [] lionTable;
	
	/**
	 * allows us to position the different species and minerals on the map
	 */
	private Position[] positionsMineral;
	
	
	
	
	public static final int NUMBER_MAX_OF_ANIMALS_IN_A_SPECIES = 50;
	private static final int NUMBER_OF_ANIMALS_IN_A_SPECIES = 3;
	private int j=0;
	public static int a=0;
	
	private CreateMovement cm = new CreateMovement();
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

	public void ConsumerHunting(String name) {
		Consumer[] consumer = new Consumer[animalsInSavana.getTable(name).length];
		consumer=(Consumer[]) animalsInSavana.getTable(name);
		for(int i=0; i<animalsInSavana.getTable(name).length;i++) {
				se.searchInArrayList(consumer[i]);
		}
		animalsInSavana.register(name, consumer);
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
				TreeLeavesTable[j] = new TreeLeaves("treeLeaves",true,10,10,2,50,25,0,4,pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("treeLeaves", TreeLeavesTable);
			break;
		case "Aphid" :
			AphidTable = new Aphid[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				AphidTable[j] = new Aphid("aphid", 50, 100, true, 10, 1, 40, 100, 3, false, pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("aphid", AphidTable);
			break;
		case "Asianladybug" :
			AsianladybugTable = new AsianLadybug[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				AsianladybugTable[j] = new AsianLadybug ("Asianladybug",50, 150, true, 10, 15, 40, 30, 6, false, pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("asianladybug", AsianladybugTable);
			break;
		case "Woodpecker" :
			WoodpeckerTable = new Woodpecker[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				WoodpeckerTable[j] = new Woodpecker ("woodpecker",50, 100, true, 10, 1, 10, 150, 6, false, pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("woodpecker", WoodpeckerTable);
			break;
		case "Ferns" :
			FernsTable = new Ferns[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				FernsTable[j] = new Ferns("ferns",true,10,10,2,50,5,1,4,pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("ferns", FernsTable);
			break;
		case "Herbivorousladybug" :
			HerbivorousladybugTable = new HerbivorousLadybug[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				HerbivorousladybugTable[j] = new HerbivorousLadybug("herbivorousladybug", 50, 10, true, 10, 100, 40, 10, 3, false, pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("herbivorousladybug", HerbivorousladybugTable);
			break;
		case "Spider" :
			SpiderTable = new Spider[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				SpiderTable[j] = new Spider("spider",50, 150, true, 10, 15, 40, 30, 6, false, pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("spider", SpiderTable);
			break;
		case "Bramble" :
			BrambleTable = new Bramble[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				BrambleTable[j] = new Bramble ("bramble",50, 300, true, 10, 1, 10, 150, 6, false, pos.initPosition[i]);
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
