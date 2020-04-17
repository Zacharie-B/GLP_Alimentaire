package ecosystemProcess;

import java.util.HashMap;

import beingManagement.BeingCreator;
import data.Position;
import data.primaryConsumerdata.Turtle;
import data.primaryConsumerdata.Monkey;
import data.primaryConsumerdata.Hippopotamus;
import data.producersdata.Bush;
import data.producersdata.FruitTree;
import data.producersdata.Reeds;
import data.secondaryConsumerdata.Anaconda;
import data.secondaryConsumerdata.Chimpanzee;
import data.secondaryConsumerdata.Python;
import data.tertiaryConsumerdata.BlackCaiman;
import data.tertiaryConsumerdata.Jaguar;
import data.tertiaryConsumerdata.SaltCrocodile;
import foodChains.FoodChainsProcess;
import movementOfSpecies.InitialPosition;
import naturalNeedsManagement.MineralChange;

/**
 * 
 * @author Zacharie
 * represents the different food chains in the SwampsEcosystem
 */
public class SwampsEcosystem extends FoodChainsProcess{
	
	/**
	 * initialization of all species present in PlainEcosystem
	 */
	private static InitialPosition pos = new InitialPosition();
	private FruitTree [] fruittreeTable;
	private Reeds [] reedsTable;
	private Bush [] BushSwampsTable;
	private Turtle [] TurtleTable;
	private Anaconda [] AnacondaTable;
	private BlackCaiman [] BlackCaimanTable;
	private Monkey [] MonkeyTable;
	private Chimpanzee [] ChimpanzeeTable;
	private Jaguar [] JaguarTable;
	private Hippopotamus [] HippopotamusTable;
	private Python [] PythonTable;
	private SaltCrocodile [] SaltCrocodileTable;
	
	/**
	 * allows us to position the different species and minerals on the map
	 */
	
	private static final int NUMBER_OF_ANIMALS_IN_A_SPECIES = 5;
	private int j=0;
	public static int a=0;
	
	private SavannaEcosystem se = new SavannaEcosystem();
	private BeingCreator animalsInSavana = BeingCreator.getInstance();
	private MineralChange mineral = MineralChange.getInstance();
	
	
	public SwampsEcosystem(String legacy) {
		mineral.valuesInCase = new HashMap <Position,Integer>(BeingCreator.ALL_POINTS);
	}
	
	public SwampsEcosystem() {
		mineral.valuesInCase = new HashMap <Position,Integer>(BeingCreator.ALL_POINTS);
		buildEcosys();
	}
	
	/**
	 * 
	 */
	public void FirstChain() {
		se.FirstFoodChain(reedsTable,TurtleTable,"reeds","turtle");
		se.SecondFoodChain(TurtleTable,AnacondaTable,"turtle","anaconda");
		se.ThirdFoodChain(AnacondaTable, BlackCaimanTable,"anaconda","blackCaiman");
	}
	
	public void SecondChain() {
		se.FirstFoodChain(fruittreeTable, MonkeyTable,"fruittree","monkey");
		se.SecondFoodChain(MonkeyTable,ChimpanzeeTable,"monkey","chimpanzee");
		se.SecondFoodChain(MonkeyTable, AnacondaTable,"monkey","anaconda");
		se.ThirdFoodChain(ChimpanzeeTable, JaguarTable,"chimpanzee","jaguar");
	}
	
	public void ThirdChain() {
		se.FirstFoodChain(BushSwampsTable,TurtleTable ,"bushswamps","turtle");
		se.FirstFoodChain(BushSwampsTable,HippopotamusTable,"bushswamps","hippopotamus");
		se.SecondFoodChain(HippopotamusTable,PythonTable,"hippopotamus","python");
		se.ThirdFoodChain(PythonTable, SaltCrocodileTable,"python","saltcrocodile");
		se.ThirdFoodChain(PythonTable, BlackCaimanTable,"python","blackcaiman");
	}
	
public void AllSpeciesHpManagement() {
		se.HpManagement(fruittreeTable,"fruittree");
		se.HpManagement(reedsTable,"reeds");
		se.HpManagement(BushSwampsTable,"bushswamps");
		se.HpManagement(HippopotamusTable,"hippopotamus");
		se.HpManagement(PythonTable,"python");
		se.HpManagement(SaltCrocodileTable,"saltcrocodile");
		se.HpManagement(TurtleTable,"turtle");
		se.HpManagement(AnacondaTable,"anaconda");
		se.HpManagement(BlackCaimanTable, "blackCaiman");
		se.HpManagement(MonkeyTable,"monkey");
		se.HpManagement(ChimpanzeeTable,"chimpanzee");
		se.HpManagement(JaguarTable,"jaguar");
	}
	
	public void ConsumerMovementSwamps() {
		se.ConsumerHunting("turtle");
		se.ConsumerHunting("anaconda");
		se.ConsumerHunting("blackcaiman");
		se.ConsumerHunting("monkey");
		se.ConsumerHunting("chimpanzee");
		se.ConsumerHunting("jaguar");
		se.ConsumerHunting("hippopotamus");
		se.ConsumerHunting("python");
		se.ConsumerHunting("saltcrocodile");
	}
	public void setAnimals(String name) {
		int i;
		int x=a;
		switch (name) {
		case "fruittree" :
			fruittreeTable = new FruitTree[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				fruittreeTable[j] = new FruitTree("fruittree",true,10,10,4,50,25,0,4,pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("fruittree", fruittreeTable);
			break;
			
		case "bushswamps" :
			BushSwampsTable = new Bush[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				BushSwampsTable[j] = new Bush("bush",true,10,10,4,50,25,0,4,pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("bushswamps", BushSwampsTable);
			break;
			
		case "turtle" :
			TurtleTable = new Turtle[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				TurtleTable[j] = new Turtle("turtle", 50, 100, true, 10, 1, 20, 100, 3, false, pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("turtle", TurtleTable);
			break;
		case "anaconda" :
			AnacondaTable = new Anaconda[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				AnacondaTable[j] = new Anaconda ("anaconda",50, 150, true, 10, 15, 10, 30, 6, false, pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("anaconda", AnacondaTable);
			break;
		case "blackcaiman" :
			BlackCaimanTable = new BlackCaiman[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				BlackCaimanTable[j] = new BlackCaiman ("blackcaiman",50, 100, true, 10, 100, 40, 50, 6, false, pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("blackcaiman", BlackCaimanTable);
			break;
		case "reeds" :
			reedsTable = new Reeds[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				reedsTable[j] = new Reeds("reeds",true,10,10,4,50,5,1,4,pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("reeds", reedsTable);
			break;
		case "monkey" :
			MonkeyTable = new Monkey[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				MonkeyTable[j] = new Monkey("monkey", 50, 10, true, 10, 100, 20, 30, 3, false, pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("monkey", MonkeyTable);
			break;
		case "chimpanzee" :
			ChimpanzeeTable = new Chimpanzee[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				ChimpanzeeTable[j] = new Chimpanzee("chimpanzee",50, 150, true, 10, 100, 10, 30, 6, false, pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("chimpanzee", ChimpanzeeTable);
			break;
		case "jaguar" :
			JaguarTable = new Jaguar[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				JaguarTable[j] = new Jaguar ("jaguar",50, 300, true, 10, 100, 40, 50, 6, false, pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("jaguar", JaguarTable);
			break;
		case "hippopotamus" :
			HippopotamusTable = new Hippopotamus[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				HippopotamusTable[j] = new Hippopotamus("hippopotamus", 50, 10, true, 10, 100, 20, 30, 3, false, pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("hippopotamus", HippopotamusTable);
			break;
		case "python" :
			PythonTable = new Python[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				PythonTable[j] = new Python("python",50, 150, true, 10, 100, 10, 30, 6, false, pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("python", PythonTable);
			break;
		case "saltcrocodile" :
			SaltCrocodileTable = new SaltCrocodile[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				SaltCrocodileTable[j] = new SaltCrocodile ("saltcrocodile",50, 300, true, 10, 100, 40, 50, 6, false, pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("saltcrocodile", SaltCrocodileTable);
			break;	
		
		}
		j=0;
	}
	
	/**
	 * We call the "setAnimals" method for each animal thanks to create the animals of all species.
	 */
	public void buildEcosys() {
		se.AllPointsMap();
		setAnimals("fruittree");
		setAnimals("bushswamps");
		setAnimals("reeds");
		setAnimals("turtle");
		setAnimals("anaconda");
		setAnimals("blackcaiman");
		setAnimals("monkey");
		setAnimals("chimpanzee");
		setAnimals("jaguar");
		setAnimals("hippopotamus");
		setAnimals("python");
		setAnimals("saltcrocodile");
	}	
}