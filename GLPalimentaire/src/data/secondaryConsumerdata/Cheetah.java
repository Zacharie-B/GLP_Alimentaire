package data.secondaryConsumerdata;

import java.util.ArrayList;

import data.SecondaryConsumer;

public class Cheetah extends SecondaryConsumer{

	public Cheetah(int hp, int organicMass, boolean isAlive, int populationDensity, int numberBirths, int timeBreeding, int calories, int timeExcreta, boolean sickness) {
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
		initializeEatenBy();
		initializeDiet();
	}
	
	@Override
	public void initializeEatenBy() {
		ArrayList <String> eatenBy = new ArrayList <String> ();
		eatenBy.add("Lion");
		setEatenBy(eatenBy);
	}

	@Override
	public void initializeDiet() {
		ArrayList <String> diet = new ArrayList <String> ();
		diet.add("Gazelle");
		diet.add("Warthog");
		setDiet(diet);
	}
}
