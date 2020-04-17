package ecosystemProcess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import beingManagement.BeingCreator;
import data.primaryConsumerdata.Giraffe;
import data.Consumer;
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
	 * allows us to position the different species and minerals on the map
	 */
	private Position[] positionsMineral;
	
	
	
	
	public static final int NUMBER_MAX_OF_ANIMALS_IN_A_SPECIES = 50;
	private static final int NUMBER_OF_ANIMALS_IN_A_SPECIES = 5;
	private int j=0;
	public static int a=0;
	
	private CreateMovement cm = new CreateMovement();
	private BeingCreator animalsInSavana = BeingCreator.getInstance();
	private MineralChange mineral = MineralChange.getInstance();
	
	
	public SavannaEcosystem(String legacy) {
		mineral.valuesInCase = new HashMap <Position,Integer>(BeingCreator.ALL_POINTS);
	}
	
	public SavannaEcosystem() {
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
				searchInArrayList(consumer[i]);
		}
		animalsInSavana.register(name, consumer);
	}
	
	public void ConsumerMovementSavanna() {
		ConsumerHunting("giraffe");
		ConsumerHunting("gazelle");
		ConsumerHunting("warthog");
		ConsumerHunting("buffalo");
		ConsumerHunting("zebra");
		ConsumerHunting("cheetah");
		ConsumerHunting("hyena");
		ConsumerHunting("lion");
	}
	
	public void AllPointsMap() {
		for(int i=0; i<18;i++) {
			for(int j=0; j<12;j++) {
				int x=0;
				positionsMineral = new Position[BeingCreator.ALL_POINTS];
				Position cordinates = new Position(i,j);
				positionsMineral[x]=cordinates;
				mineral.addMineral(positionsMineral[x],0);
				x++;
			}
		}
	}
	
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
		producer = new Producer[animalsInSavana.getTable(name1).length];
		producer=(Producer[]) animalsInSavana.getTable(name1);
		consumer = new Consumer[animalsInSavana.getTable(name2).length];
		consumer=(Consumer[]) animalsInSavana.getTable(name2);
		for(int i=0; i<animalsInSavana.getTable(name1).length;i++) {
			for(int k=0; k<animalsInSavana.getTable(name2).length;k++) {
				Producer p= producer[i];
				PrimaryConsumer c= (PrimaryConsumer) consumer[k];
				ArrayList <String> EatenBy = null;
				FirstTrophicLevel(p, c, EatenBy);
				producer[i].setPopulationDensity(p.getPopulationDensity());
				consumer[k].setPopulationDensity(c.getPopulationDensity());
			}
		}
		animalsInSavana.register(name1, producer);
		animalsInSavana.register(name2, consumer);
	}
	
	public void SecondFoodChain(Consumer[] consumer1, Consumer[] consumer2, String name1, String name2) {
		consumer1 = new Consumer[animalsInSavana.getTable(name1).length];
		consumer1=(Consumer[]) animalsInSavana.getTable(name1);
		consumer2 = new Consumer[animalsInSavana.getTable(name1).length];
		consumer2=(Consumer[]) animalsInSavana.getTable(name2);
		for(int i=0; i<animalsInSavana.getTable(name1).length;i++) {
			for(int k=0; k<animalsInSavana.getTable(name2).length;k++) {
				PrimaryConsumer pc=  (PrimaryConsumer) consumer1[i];
				SecondaryConsumer sc= (SecondaryConsumer) consumer2[k];
				ArrayList <String> EatenBy = null; 
				SecondTrophicLevel(pc, sc, EatenBy);
				consumer1[i].setPopulationDensity(pc.getPopulationDensity());
				consumer2[k].setPopulationDensity(sc.getPopulationDensity());
			}
		}
		animalsInSavana.register(name1, consumer1);
		animalsInSavana.register(name2, consumer2);
	}
	
	public void ThirdFoodChain(Consumer[] consumer1, Consumer[] consumer2, String name1, String name2) {
		consumer1 = new Consumer[animalsInSavana.getTable(name1).length];
		consumer1=(Consumer[]) animalsInSavana.getTable(name1);
		consumer2 = new Consumer[animalsInSavana.getTable(name1).length];
		consumer2=(Consumer[]) animalsInSavana.getTable(name2);
		for(int i=0; i<animalsInSavana.getTable(name1).length;i++) {
			for(int k=0; k<animalsInSavana.getTable(name2).length;k++) {
				SecondaryConsumer sc= (SecondaryConsumer) consumer1[i];
				TertiaryConsumer tc= (TertiaryConsumer) consumer2[k];
				ArrayList <String> EatenBy = null; 
				ThirdTrophicLevel(sc, tc, EatenBy);
				consumer1[i].setPopulationDensity(sc.getPopulationDensity());
				consumer2[k].setPopulationDensity(tc.getPopulationDensity());
			}
		}
		animalsInSavana.register(name1, consumer1);
		animalsInSavana.register(name2, consumer2);
	}
	
	public void HpManagement(Species[] producer, String name) {
		producer = new Species[animalsInSavana.getTable(name).length];
		producer=(Species[]) animalsInSavana.getTable(name);
		for(int i=0; i<animalsInSavana.getTable(name).length;i++) {
			if(producer[i] instanceof Producer) {
				AbsorptionMineral((Producer) producer[i]);
				DieOrHungry(producer[i]);
			}
			else {
				DieOrHungry(producer[i]);
			}
		}
		animalsInSavana.register(name, producer);
	}
	
	public void AllSpeciesHpManagement() {
		
		HpManagement(grassTable,"grass");
		HpManagement(bushTable,"bush");
		HpManagement(acaciaTable,"acacia");
		HpManagement(gazelleTable,"gazelle");
		HpManagement(giraffeTable,"giraffe");
		HpManagement(lionTable,"lion");
		HpManagement(hyenaTable,"hyena");
		HpManagement(zebraTable,"zebra");
		HpManagement(cheetahTable,"cheetah");
		HpManagement(warthogTable,"warthog");
		HpManagement(buffaloTable,"buffalo");
	}
	 
	private void DieOrHungry(Species producer) {
		if(producer.gethp()==0) {
			IsDead isDead= new IsDead();
			isDead.SpeciesDead(producer);
		}
		else{
			int hp= producer.gethp();
			hp--;
			producer.sethp(hp);
		}
	}
	
	/**
	 * Use of the Simple Factory pattern thanks to create the objects of our species, 
	 * we use the Singleton for stock the array of each species.
	 * @param name
	 */
	public void setAnimals(String name) {
		int i;
		int x=a;
		switch (name) {
		case "Grass" :
			grassTable = new Grass[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				grassTable[j] = new Grass("grass",true,10,10,4,50,25,0,4,pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("grass", grassTable);
			break;
		case "Gazelle" :
			gazelleTable = new Gazelle[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				gazelleTable[j] = new Gazelle("gazelle", 50, 100, true, 10, 1, 40, 100, 3, false, pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("gazelle", gazelleTable);
			break;
		case "Warthog" :
			warthogTable = new Warthog[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				warthogTable[j] = new Warthog ("warthog",50, 150, true, 10, 15, 40, 30, 6, false, pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("warthog", warthogTable);
			break;
		case "Cheetah" :
			cheetahTable = new Cheetah[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				cheetahTable[j] = new Cheetah ("cheetah",50, 100, true, 10, 1, 10, 150, 6, false, pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("cheetah", cheetahTable);
			break;
		case "Bush" :
			bushTable = new Bush[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				bushTable[j] = new Bush("bush",true,10,10,4,50,5,1,4,pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("bush", bushTable);
			break;
		case "Buffalo" :
			buffaloTable = new Buffalo[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				buffaloTable[j] = new Buffalo("buffalo", 50, 10, true, 10, 100, 40, 10, 3, false, pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("buffalo", buffaloTable);
			break;
		case "Zebra" :
			zebraTable = new Zebra[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				zebraTable[j] = new Zebra("zebra",50, 150, true, 10, 15, 40, 30, 6, false, pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("zebra", zebraTable);
			break;
		case "Hyena" :
			hyenaTable = new Hyena[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				hyenaTable[j] = new Hyena ("hyena",50, 300, true, 10, 1, 10, 150, 6, false, pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("hyena", hyenaTable);
			break;
		case "Acacia" :
			acaciaTable = new Acacia[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				acaciaTable[j] = new Acacia("acacia",true,10,10,4,50,5,1,4,pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("acacia", acaciaTable);
			break;
		case "Giraffe" :
			giraffeTable = new Giraffe[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				giraffeTable[j] = new Giraffe("giraffe", 50, 100, true, 10, 100, 40, 10, 3, false, pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("giraffe", giraffeTable);
			break;
		case "Lion" :
			lionTable = new Lion[NUMBER_OF_ANIMALS_IN_A_SPECIES];
			for(i=a ; i<NUMBER_OF_ANIMALS_IN_A_SPECIES+x; i++) {
				lionTable[j] = new Lion ("lion",50, 10, true, 10, 1, 50, 150, 6, false, pos.initPosition[i]);
				j++;
				a++;
			}
			animalsInSavana.register("lion", lionTable);
			break;
		}
		j=0;
	}
	
	/**
	 * We call the "setAnimals" method for each animal thanks to create the animals of all species.
	 */
	public void buildEcosys() {
		AllPointsMap();
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
	
	/**
	 * <p>All these methods are made to scroll :</p>
	 * <ul>
	 * 	<li>in a predator's diet,</li>
	 * 	<li>in the HashMap of a predator,</li>
	 * 	<li>in an array of a species</li>
	 * </ul>
	 * @param predator
	 * @return Position
	 * 
	 * <p>perhaps create a comparison methods...</p>
	 */
	
	/**
	 * Search the nearest prey and move towards it
	 * @param predator
	 * @return
	 */
	void searchInArrayList(Consumer predator){
		boolean loin=true;
		//the map get 18 points in X and 12 points in Y 
		Position impossible = new Position(100,100);
		ArrayList <String> dietList = predator.getDiet();
		Iterator<String> iterator = dietList.iterator();
		Position predatorPosition = predator.getCordinates();
		String name="";
		while (iterator.hasNext()&&(loin!=false)){
			name = iterator.next();
			//use searchInIHM for each prey of this predator
			impossible = searchInIHM(name, predatorPosition,impossible);
			
		}
		int x=impossible.getX();
		int y=impossible.getY();
		int distance= Math.abs(x)+Math.abs(y);
		if(10>distance) {
			if(Math.abs(x)>=Math.abs(y)) {
				if(x<0) {
					predator.setCordinates(cm.HuntingMovement(predator,"left"));
				}
				else {
					predator.setCordinates(cm.HuntingMovement(predator,"right"));
				}
			}
			else {
				if(y<0) {
					predator.setCordinates(cm.HuntingMovement(predator,"bot"));
				}
				else {
					predator.setCordinates(cm.HuntingMovement(predator,"top"));
				}
			}
		}
		else {
			predator.setCordinates(cm.SavannaMouvement(predator));
		}
	}

	private Position searchInIHM(String name, Position predatorPosition, Position currentPrey) {
		Species[] consumer = new Consumer[animalsInSavana.getTable(name).length];
		consumer=(Species[]) animalsInSavana.getTable(name);
		Position newPrey;
		for(int index=0; index<animalsInSavana.getTable(name).length;index++) {
			int x= consumer[index].getCordinates().getX()-predatorPosition.getX();
			int y= consumer[index].getCordinates().getY()-predatorPosition.getY();
			if(((Math.abs(x)+Math.abs(y))<10)&&consumer[index].getIsAlive()==true) {
				newPrey= new Position(x,y);
				if((Math.abs(x)+Math.abs(y))<Math.abs((currentPrey.getX()-predatorPosition.getX())+
						(currentPrey.getY()-predatorPosition.getY()))) {
					return newPrey;
				}
			}
		}
		return currentPrey;
	}
}
