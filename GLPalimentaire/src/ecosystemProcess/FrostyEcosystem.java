package ecosystemProcess;

import java.util.HashMap;

import beingManagement.BeingCreator;


import data.Position;
import data.primaryConsumerdata.MuskOx;

import data.primaryConsumerdata.Clam;
import data.producersdata.Foam;
import data.producersdata.Grass;
import data.secondaryConsumerdata.ArcticWolf;
import data.secondaryConsumerdata.Phoque;
import data.tertiaryConsumerdata.PolarBear;
import data.tertiaryConsumerdata.Inuit;
import foodChains.FoodChainsProcess;
import movementOfSpecies.InitialPosition;
import naturalNeedsManagement.MineralChange;

/**
 *
 * @author HP
 * represents the different food chains in the FrostyEcosystem
 */
public class FrostyEcosystem extends FoodChainsProcess{
	
	/**
	 * initialization of all species present in PlainEcosystem
	 */
	private static InitialPosition pos = new InitialPosition();
	private Grass [] grassFrostyTable;
	private Foam [] FoamTable;
	private MuskOx [] MuskOxTable;
	private ArcticWolf [] ArcticWolfTable;
	private Inuit [] InuitTable;
	private Clam [] ClamTable;
	private Phoque [] PhoqueTable;
	private PolarBear [] PolarBearTable;
	
	/**
	 * allows us to position the different species and minerals on the map
	 */
	
	private static final int NUMBER_OF_ANIMALS_IN_A_SPECIES = 5;
	private int j=0;
	private static int a=0;
	
	private SavannaEcosystem se = new SavannaEcosystem();
	private BeingCreator animalsInSavana = BeingCreator.getInstance();
	private MineralChange mineral = MineralChange.getInstance();
	
	
	public FrostyEcosystem(String legacy) {
		mineral.valuesInCase = new HashMap <Position,Integer>(BeingCreator.ALL_POINTS);
	}
	
	public FrostyEcosystem() {
		mineral.valuesInCase = new HashMap <Position,Integer>(BeingCreator.ALL_POINTS);
		buildEcosys();
	}
	
	/**
	 * 
	 */
	public void FirstChain() {
		se.FirstFoodChain(grassFrostyTable,MuskOxTable,"grassFrosty","muskox");
		se.SecondFoodChain(MuskOxTable,ArcticWolfTable,"muskox","arcticwolf");
		se.ThirdFoodChain(ArcticWolfTable, InuitTable,"arcticwolf","inuit");
	}
	
	public void SecondChain() {
		se.FirstFoodChain(FoamTable, ClamTable,"foam","clam");
		se.SecondFoodChain(ClamTable,PhoqueTable,"clam","phoque");
		se.ThirdFoodChain(PhoqueTable, PolarBearTable,"phoque","polarbear");
		se.ThirdFoodChain(PhoqueTable, InuitTable,"phoque","inuit");
	}
	
	public void AllSpeciesHpManagement() {
		
		se.HpManagement(grassFrostyTable,"grassFrosty");
		se.HpManagement(MuskOxTable,"muskox");
		se.HpManagement(ArcticWolfTable,"arcticwolf");
		se.HpManagement(InuitTable, "inuit");
		se.HpManagement(FoamTable,"foam");
		se.HpManagement(ClamTable,"clam");
		se.HpManagement(PhoqueTable,"phoque");
		se.HpManagement(PolarBearTable,"polarbear");
	}
	
	public void ConsumerMovementFrosty() {
		se.ConsumerHunting("muskox");
		se.ConsumerHunting("arcticwolf");
		se.ConsumerHunting("inuit");
		se.ConsumerHunting("clam");
		se.ConsumerHunting("phoque");
		se.ConsumerHunting("polarbear");
	}
	public void setAnimals(String name) {
		int i;
		int x=a;
		switch (name) {
		case "grassFrosty" :
			grassFrostyTable = new Grass[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				grassFrostyTable[j] = new Grass("grass",true,10,10,4,50,25,0,4,pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("grassFrosty", grassFrostyTable);
			break;
		case "muskox" :
			MuskOxTable = new MuskOx[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				MuskOxTable[j] = new MuskOx("muskox", 50, 100, true, 10, 1, 20, 100, 3, false, pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("muskox", MuskOxTable);
			break;
		case "arcticwolf" :
			ArcticWolfTable = new ArcticWolf[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				ArcticWolfTable[j] = new ArcticWolf ("arcticwolf",50, 150, true, 10, 15, 10, 30, 6, false, pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("arcticwolf", ArcticWolfTable);
			break;
		case "inuit" :
			InuitTable = new Inuit[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				InuitTable[j] = new Inuit ("inuit",50, 100, true, 10, 100, 40, 50, 6, false, pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("inuit", InuitTable);
			break;
		case "foam" :
			FoamTable = new Foam[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				FoamTable[j] = new Foam("foam",true,10,10,4,50,5,1,4,pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("foam", FoamTable);
			break;
		case "clam" :
			ClamTable = new Clam[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				ClamTable[j] = new Clam("clam", 50, 10, true, 10, 100, 20, 30, 3, false, pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("clam", ClamTable);
			break;
		case "phoque" :
			PhoqueTable = new Phoque[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				PhoqueTable[j] = new Phoque("phoque",50, 150, true, 10, 100, 10, 30, 6, false, pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("phoque", PhoqueTable);
			break;
		case "polarbear" :
			PolarBearTable = new PolarBear[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				PolarBearTable[j] = new PolarBear ("polarbear",50, 300, true, 10, 100, 40, 50, 6, false, pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("polarbear", PolarBearTable);
			break;
		}
		j=0;
	}
	
	/**
	 * We call the "setAnimals" method for each animal thanks to create the animals of all species.
	 */
	public void buildEcosys() {
		se.AllPointsMap();
		setAnimals("muskox");
		setAnimals("arcticwolf");
		setAnimals("inuit");
		setAnimals("grassFrosty");
		setAnimals("foam");
		setAnimals("clam");
		setAnimals("phoque");
		setAnimals("polarbear");
	}
	
}
