package beingManagement;
import java.rmi.activation.Activator;

import data.*;
import data.decomposersdata.Bacterium;
import data.secondaryConsumerdata.Cheetah;
import data.tertiaryConsumerdata.Inuit;

public class BeingCreator {
	public static final int ALL_POINTS= 200;

	public BeingCreator(String species, int number) {

	}

	public static Species[] initFamily() {
		
		Cheetah [] beingFamily = new Cheetah [ALL_POINTS];
		for(int i=0 ; i<ALL_POINTS ; i++) {
			beingFamily [i] = new Cheetah("cheetah",10, 100, true, 1, 1, 50, 150, 6, false, new Position(5,5));
		}
		return beingFamily;
	}
	
	public static void add(/*T [] beingFamily, */int number) {
		
	}
	
	public static void suppr() {
		
	}

}
