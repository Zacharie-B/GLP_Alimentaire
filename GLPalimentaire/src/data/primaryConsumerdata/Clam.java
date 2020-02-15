package data.primaryConsumerdata;

import java.util.ArrayList;

import data.PrimaryConsumer;
import data.Point;

public class Clam extends PrimaryConsumer{

	public Clam(int hp, int organicMass, boolean isAlive, int populationDensity, int numberBirths, int timeBreeding, int calories, int timeExcreta, boolean sickness, Point cordinates) {
		super();
		setHp(hp);
		setOrganicMass(organicMass);
		setIsAlive(isAlive);
		setPopulationDensity(populationDensity);
		setNumberBirths(numberBirths);
		setTimeBreeding(timeBreeding);
		setCalories(calories);
		setTimeExcreta(timeExcreta);
		setSickness(sickness);
		setCordinates(cordinates);
		initializeEatenBy();
		initializeDiet();
	}
	@Override
	public void initializeDiet() {
		ArrayList <String> al = new ArrayList <String> ();
		al.add("Foam");
		setDiet(al);
	}
	
	public void initializeEatenBy() {
		ArrayList <String> al = new ArrayList <String> ();
		al.add("Phoque");
		setEatenBy(al);
	}

}
