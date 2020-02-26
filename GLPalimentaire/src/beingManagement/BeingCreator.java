package beingManagement;
import java.rmi.activation.Activator;

import data.*;
import data.tertiaryConsumerdata.Inuit;

public class BeingCreator<T> {
	
	private T [] beingFamily;

	public BeingCreator(String species, int number) {

	}
	
	public void initFamily(String species, T [] beingFamily, int number) {
		Class<?> species = Class.forName(species);
	}
	
	public static void add(/*T [] beingFamily, */int number) {
		
	}
	
	public static void suppr() {
		
	}

}
