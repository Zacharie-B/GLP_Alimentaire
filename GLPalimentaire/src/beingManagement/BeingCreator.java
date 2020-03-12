package beingManagement;

import java.util.HashMap;

import data.*;
import data.primaryConsumerdata.Buffalo;
import data.primaryConsumerdata.Gazelle;
import data.primaryConsumerdata.Giraffe;		
import data.primaryConsumerdata.Warthog;
import data.primaryConsumerdata.Zebra;
import data.producersdata.Acacia;
import data.producersdata.Bush;
import data.producersdata.Grass;
import data.secondaryConsumerdata.Cheetah;
import data.secondaryConsumerdata.Hyena;
import data.tertiaryConsumerdata.Lion;
import movementOfSpecies.InitialPosition;

public class BeingCreator {
	public static final int ALL_POINTS= 200;
	public Species [] allAnimals;	
	private HashMap <String, Species> animalsInEco;
	private InitialPosition pos = new InitialPosition();
	private static final int numberSpeciesInit = 67;
	
	public BeingCreator(String nameEco) {
		buildEcosys(nameEco);
	}
	
	public BeingCreator() {
		// TODO Auto-generated constructor stub
	}

	public void buildEcosys(String nameEco) {
		allAnimals= new Species[numberSpeciesInit];
		switch (nameEco) {
		case "Savanna" :
			for(int i = 11 ; i<numberSpeciesInit ; i++) {
				if (i<16) {
					allAnimals[i] = new  Grass("grass",true,100,10,2,10,25,0,4,pos.initPosition[i]);
				}
				else if (i>=16 && i<=21) {
					allAnimals[i] = new Gazelle("gazelle", 15, 100, true, 10, 1, 10, 100, 3, false, pos.initPosition[i]);
				}
				else if (i>21 && i<=26) {
					allAnimals[i] = new Warthog ("warthog",20, 150, true, 5, 15, 4, 30, 6, false, pos.initPosition[i]);
				}
				else if (i>26 && i<=31) {
					allAnimals[i] = new Cheetah ("cheetah",20, 100, true, 1, 1, 50, 150, 6, false, pos.initPosition[i]);
				}
				else if (i>31 && i <= 36) {
					allAnimals[i] = new Bush("bush",true,100,10,2,10,5,1,4,pos.initPosition[i]);
				}
				else if (i>36 && i<= 41) {
					allAnimals[i] = new Buffalo("buffalo", 15, 10, true, 10, 100, 10, 10, 3, false, pos.initPosition[i]);
				}
				else if (i>41 && i<= 46) {
					allAnimals[i] = new Zebra("zebra",20, 150, true, 5, 15, 4, 30, 6, false, pos.initPosition[i]);
				}
				else if (i>46 && i<= 51) {
					allAnimals[i] = new Hyena ("hyena",30, 300, true, 1, 1, 50, 150, 6, false, pos.initPosition[i]);
				}
				else if (i>51 && i<= 56) {
					allAnimals[i] = new Acacia("acacia",true,100,10,2,10,5,1,4,pos.initPosition[i]);
				}
				else if (i>56 && i<= 61) {
					allAnimals[i] = new Giraffe("giraffe", 15, 100, true, 10, 100, 10, 10, 3, false, pos.initPosition[i]);
				}
				else if (i>61 && i<= 66) {
					allAnimals[i] = new Lion ("lion",30, 10, true, 1, 1, 50, 150, 6, false, pos.initPosition[i]);
				}
			System.out.println(allAnimals[i].getName()+","+allAnimals[i].getCordinates());
			}
			break;
		default :
			break;
		}
		animalsInEco = new HashMap <String , Species>(numberSpeciesInit);
		
		
	}
	
	public static void add(/*T [] beingFamily, */int number) {
		
	}
	
	public static void suppr() {
		
	}

	public Species[] getAllAnimals() {
		return allAnimals;
	}

	public void setAllAnimals(Species[] allAnimals) {
		this.allAnimals = allAnimals;
	}
	public HashMap<String, Species> getAnimalsInEco() {
		return animalsInEco;
	}
	public void setAnimalsInEco(HashMap<String, Species> animalsInEco) {
		this.animalsInEco = animalsInEco;
	}
	public InitialPosition getPos() {
		return pos;
	}
	public void setPos(InitialPosition pos) {
		this.pos = pos;
	}
	public static Species[] initFamily() {
		// TODO Auto-generated method stub
		return null;
	}
}
