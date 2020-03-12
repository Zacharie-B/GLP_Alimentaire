package ecosystemProcess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import beingManagement.BeingCreator;
import data.primaryConsumerdata.Giraffe;
import data.Consumer;
import data.Ecosystem;
import data.Position;
import data.PrimaryConsumer;
import data.Producer;
import data.SecondaryConsumer;
import data.Species;
import data.TertiaryConsumer;
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
import movementOfSpecies.CreateMovement;
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
	/*public static Grass grass = new Grass("grass",true,100,10,2,150,25,0,4,pos.initPosition[0]);
	public static Gazelle gazelle = new Gazelle("gazelle", 150, 100, true, 10, 1, 10, 100, 3, false, pos.initPosition[1]);
	public static Warthog warthog = new Warthog ("warthog",200, 150, true, 5, 15, 4, 30, 6, false, pos.initPosition[2]);
	public static Cheetah cheetah = new Cheetah ("cheetah",200, 100, true, 1, 1, 50, 150, 6, false, pos.initPosition[3]);
	public static Bush bush = new Bush("bush",true,100,10,2,150,5,0,4,pos.initPosition[4]);
	public static Buffalo buffalo = new Buffalo("buffalo", 150, 10, true, 10, 100, 10, 10, 3, false, pos.initPosition[5]);
	public static Zebra zebra = new Zebra("zebra",200, 150, true, 5, 15, 4, 30, 6, false, pos.initPosition[6]);
	public static Hyena hyena = new Hyena ("hyena",300, 300, true, 1, 1, 50, 150, 6, false, pos.initPosition[7]);
	public static Acacia acacia = new Acacia("acacia",true,100,10,2,300,5,0,4,pos.initPosition[8]);
	public static Giraffe giraffe = new Giraffe("giraffe", 150, 100, true, 10, 100, 10, 10, 3, false, pos.initPosition[9]);
	public static  Lion lion = new Lion ("lion",300, 10, true, 1, 1, 50, 150, 6, false, pos.initPosition[10]);*/
	public Grass [] grassTable;
	public Acacia [] acaciaTable;
	public Bush [] bushTable;
	public Gazelle [] gazelleTable;
	public Warthog [] warthogTable;
	public Cheetah [] cheetahTable;
	public Buffalo [] buffaloTable;
	public Zebra [] zebraTable;
	public Hyena [] hyenaTable;
	public Giraffe [] giraffeTable;
	public Lion [] lionTable;
	
	
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
	private int a=0;
	private int j;
	
	public static final int NUMBER_OF_ANIMALS_IN_A_SPECIES = 10;
	private static final int NBMAXSPECIES=500;
	private CreateMovement cm = new CreateMovement ();
	private BeingCreator animalsInSavana = BeingCreator.getInstance();
	private MineralChange mineral = MineralChange.getInstance();
	
	public SavannaEcosystem() {
		species = new Species[NBMAXSPECIES];
		mineral.valuesInCase = new HashMap <Position,Integer>(BeingCreator.ALL_POINTS);
		AllPointsMap();
		buildEcosys();
	}



	/*public void FirstChain() {
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
	*/
	
	public void ConsumerTeamMovement(Consumer[] consumer, String name) {
		consumer = new Consumer[NUMBER_OF_ANIMALS_IN_A_SPECIES];
		consumer=(Consumer[]) animalsInSavana.getTable(name);
		for(int i=0; i<NUMBER_OF_ANIMALS_IN_A_SPECIES;i++) {
			(consumer[i]).setCordinates(cm.SavannaMouvement(consumer[i]));
			System.out.println((consumer[i]).getCordinates());
		}
	}
	
	public void ConsumerMovement() {
		ConsumerTeamMovement(gazelleTable, "gazelle");
		ConsumerTeamMovement(warthogTable, "warthog");
		ConsumerTeamMovement(cheetahTable, "cheetah");
		ConsumerTeamMovement(buffaloTable, "buffalo");
		ConsumerTeamMovement(zebraTable, "zebra");
		ConsumerTeamMovement(hyenaTable, "hyena");
		ConsumerTeamMovement(giraffeTable, "giraffe");
		ConsumerTeamMovement(lionTable, "lion");
	}
	
	public void AllPointsMap() {
		for(int i=0; i<30;i++) {
			for(int j=0; j<20;j++) {
				int x=0;
				positionsMineral = new Position[BeingCreator.ALL_POINTS];
				Position cordinates = new Position(i,j);
				positionsMineral[x]=cordinates;
				mineral.valuesInCase.put(positionsMineral[x],100);
				x++;
			}
		}
	}
	
	/*public void DisplayAndScrollHashMap(Producer producer) {
		  Set<Entry<Position, Integer>> setHm = mineral.valuesInCase.entrySet();
	      Iterator<Entry<Position, Integer>> it = setHm.iterator();
	      while(it.hasNext()){
	         Entry<Position, Integer> e = it.next();
	         System.out.println(e.getKey() + " : " + e.getValue());
	      }
	}*/
	
	public void FirstChain() {
		FirstFoodChain(grassTable, gazelleTable,"grass","gazelle");
		FirstFoodChain(grassTable, warthogTable,"grass","warthog");
		FirstFoodChain(bushTable, gazelleTable,"bush","gazelle");
		FirstFoodChain(bushTable, warthogTable,"bush","warthog");
		SecondFoodChain(gazelleTable, cheetahTable,"gazelle","cheetah");
		SecondFoodChain(warthogTable, cheetahTable,"warthog","cheetah");
		ThirdFoodChain(cheetahTable, lionTable,"cheetah","lion");
	}
	
	public void SecondChain() {
		FirstFoodChain(grassTable, buffaloTable,"grass","gazelle");
		FirstFoodChain(grassTable, zebraTable,"grass","gazelle");
		FirstFoodChain(bushTable, buffaloTable,"bush","buffalo");
		FirstFoodChain(bushTable, zebraTable,"bush","zebra");
		SecondFoodChain(buffaloTable, hyenaTable,"buffalo","hyena");
		SecondFoodChain(gazelleTable, cheetahTable,"gazelle","cheetah");
		SecondFoodChain(warthogTable, cheetahTable,"warthog","cheetah");
		SecondFoodChain(zebraTable, hyenaTable,"zebra","hyena");
		ThirdFoodChain(hyenaTable, lionTable,"hyena","lion");
	}
	
	public void ThirdChain() {
		FirstFoodChain(acaciaTable, giraffeTable,"acacia","giraffe");
		SecondFoodChain(giraffeTable, hyenaTable,"giraffe","hyena");
		ThirdFoodChain(hyenaTable, lionTable,"hyena","lion");
	}
	
	public void FirstFoodChain(Producer[] producer, Consumer[] consumer, String name1, String name2) {
		producer = new Producer[NUMBER_OF_ANIMALS_IN_A_SPECIES];
		producer=(Producer[]) animalsInSavana.getTable(name1);
		consumer = new Consumer[NUMBER_OF_ANIMALS_IN_A_SPECIES];
		consumer=(Consumer[]) animalsInSavana.getTable(name2);
		PrimaryConsumer c= (PrimaryConsumer) consumer[0];
		for(int i=0; i<NUMBER_OF_ANIMALS_IN_A_SPECIES;i++) {
			Producer p= producer[i];
			ArrayList <String> EatenBy = null;
			FirstTrophicLevel(p, c, EatenBy);
			
		}
	}
	public void SecondFoodChain(Consumer[] consumer1, Consumer[] consumer2, String name1, String name2) {
		consumer1 = new Consumer[NUMBER_OF_ANIMALS_IN_A_SPECIES];
		consumer1=(Consumer[]) animalsInSavana.getTable(name2);
		consumer2 = new Consumer[NUMBER_OF_ANIMALS_IN_A_SPECIES];
		consumer2=(Consumer[]) animalsInSavana.getTable(name2);
		SecondaryConsumer sc= (SecondaryConsumer) consumer2[0];
		for(int i=0; i<NUMBER_OF_ANIMALS_IN_A_SPECIES;i++) {
			PrimaryConsumer pc=  (PrimaryConsumer) consumer1[i];
			ArrayList <String> EatenBy = null; 
			SecondTrophicLevel(pc, sc, EatenBy);
			
		}
	}
	public void ThirdFoodChain(Consumer[] consumer1, Consumer[] consumer2, String name1, String name2) {
		consumer1 = new Consumer[NUMBER_OF_ANIMALS_IN_A_SPECIES];
		consumer1=(Consumer[]) animalsInSavana.getTable(name2);
		consumer2 = new Consumer[NUMBER_OF_ANIMALS_IN_A_SPECIES];
		consumer2=(Consumer[]) animalsInSavana.getTable(name2);
		TertiaryConsumer tc= (TertiaryConsumer) consumer2[0];
		for(int i=0; i<NUMBER_OF_ANIMALS_IN_A_SPECIES;i++) {
			SecondaryConsumer sc= (SecondaryConsumer) consumer1[i];
			ArrayList <String> EatenBy = null; 
			ThirdTrophicLevel(sc, tc, EatenBy);
			
		}
	}
	
	public void HpManagementProducer(Producer[] producer, String name) {
		producer = new Producer[NUMBER_OF_ANIMALS_IN_A_SPECIES];
		producer=(Producer[]) animalsInSavana.getTable(name);
		for(int i=0; i<NUMBER_OF_ANIMALS_IN_A_SPECIES;i++) {
			AbsorptionMineral(producer[i]);
			DieOrHungryProducer(producer[i]);
		}
	}
	public void HpManagementConsumer(Consumer[] consumer, String name) {
		consumer = new Consumer[NUMBER_OF_ANIMALS_IN_A_SPECIES];
		consumer=(Consumer[]) animalsInSavana.getTable(name);
		for(int i=0; i<NUMBER_OF_ANIMALS_IN_A_SPECIES;i++) {
			DieOrHungryConsumer(consumer[i]);
		}
	}
	
	public void AllSpeciesHpManagement() {
		
		HpManagementProducer(grassTable,"grass");
		HpManagementProducer(bushTable,"bush");
		HpManagementProducer(acaciaTable,"acacia");
		HpManagementConsumer(gazelleTable,"gazelle");
		HpManagementConsumer(giraffeTable,"giraffe");
		HpManagementConsumer(lionTable,"lion");
		HpManagementConsumer(hyenaTable,"hyena");
		HpManagementConsumer(zebraTable,"zebra");
		HpManagementConsumer(cheetahTable,"cheetah");
		HpManagementConsumer(warthogTable,"warthog");
		HpManagementConsumer(buffaloTable,"buffalo");
		
		/*DieOrHungryProducer(grass);
		DieOrHungryProducer(bush);
		DieOrHungryProducer(acacia);
		DieOrHungryConsumer(gazelle);
		DieOrHungryConsumer(giraffe);
		DieOrHungryConsumer(lion);
		DieOrHungryConsumer(hyena);
		DieOrHungryConsumer(zebra);
		DieOrHungryConsumer(cheetah);
		DieOrHungryConsumer(warthog);
		DieOrHungryConsumer(buffalo);*/
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
	
	public void setAnimals(String name) {
		int i;
		switch (name) {
		case "Grass" :
			grassTable = new Grass[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<a+10; i++) {
				grassTable[i] = new Grass("grass",true,100,10,2,3,25,0,4,pos.initPosition[i]);
			}
			animalsInSavana.register("grass", grassTable);
			break;
		case "Gazelle" :
			gazelleTable = new Gazelle[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<j; i++) {
				gazelleTable[i] = new Gazelle("gazelle", 3, 100, true, 10, 1, 10, 100, 3, false, pos.initPosition[i]);
			}
			animalsInSavana.register("gazelle", gazelleTable);
			break;
		case "Warthog" :
			warthogTable = new Warthog[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<j; i++) {
				warthogTable[i] = new Warthog ("warthog",4, 150, true, 5, 15, 4, 30, 6, false, pos.initPosition[i]);
			}
			animalsInSavana.register("warthog", warthogTable);
			break;
		case "Cheetah" :
			cheetahTable = new Cheetah[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<j; i++) {
				cheetahTable[i] = new Cheetah ("cheetah",10, 100, true, 1, 1, 50, 150, 6, false, pos.initPosition[i]);
			}
			animalsInSavana.register("cheetah", cheetahTable);
			break;
		case "Bush" :
			bushTable = new Bush[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<j; i++) {
				bushTable[i] = new Bush("bush",true,100,10,2,3,5,1,4,pos.initPosition[i]);
			}
			animalsInSavana.register("bush", bushTable);
			break;
		case "Buffalo" :
			buffaloTable = new Buffalo[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<j; i++) {
				buffaloTable[i] = new Buffalo("buffalo", 3, 10, true, 10, 100, 10, 10, 3, false, pos.initPosition[i]);
			}
			animalsInSavana.register("buffalo", buffaloTable);
			break;
		case "Zebra" :
			zebraTable = new Zebra[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<j; i++) {
				zebraTable[i] = new Zebra("zebra",4, 150, true, 5, 15, 4, 30, 6, false, pos.initPosition[i]);
			}
			animalsInSavana.register("zebra", zebraTable);
			break;
		case "Hyena" :
			hyenaTable = new Hyena[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<a+10; i++) {
				hyenaTable[i] = new Hyena ("hyena",10, 300, true, 1, 1, 50, 150, 6, false, pos.initPosition[i]);
			}
			animalsInSavana.register("hyena", hyenaTable);
			break;
		case "Acacia" :
			acaciaTable = new Acacia[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<j; i++) {
				acaciaTable[i] = new Acacia("acacia",true,100,10,2,3,5,1,4,pos.initPosition[i]);
			}
			animalsInSavana.register("acacia", acaciaTable);
			break;
		case "Giraffe" :
			giraffeTable = new Giraffe[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<j; i++) {
				giraffeTable[i] = new Giraffe("giraffe", 3, 100, true, 10, 100, 10, 10, 3, false, pos.initPosition[i]);
			}
			animalsInSavana.register("giraffe", giraffeTable);
			break;
		case "Lion" :
			lionTable = new Lion[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<j; i++) {
				lionTable[i] = new Lion ("lion",10, 10, true, 1, 1, 50, 150, 6, false, pos.initPosition[i]);
			}
			animalsInSavana.register("lion", lionTable);
			break;
		}
		
	}
	
	public void buildEcosys() {
		setAnimals("Grass");
		setAnimals("Hyena");
		setAnimals("Giraffe");
		setAnimals("Lion");
		setAnimals("Gazelle");
		setAnimals("Cheetah");
		setAnimals("Warthog");
		setAnimals("Buffalo");
		setAnimals("Acacia");
		setAnimals("Bush");
		setAnimals("Zebra");
	}
	

	/*public String toString() {
		String result ="\nspecies : (" +grass.getName()+", "+ grass.getHP() +"," +grass.getIsAlive()+"," +grass.getCordinates()+")";
		result += "\nspecies : (" +bush.getName()+", "+ bush.getHP() + "," +bush.getIsAlive()+"," +bush.getCordinates()+")";
		result += "\nspecies : (" +acacia.getName()+", "+ acacia.getHP() + "," +acacia.getIsAlive()+"," +acacia.getCordinates()+")";
		result += "\nspecies : (" +mineral.getValue(bush.getCordinates())+","+mineral.getValue(grass.getCordinates())+","
				+mineral.getValue(acacia.getCordinates())+")";
		return result;
	}*/
}
