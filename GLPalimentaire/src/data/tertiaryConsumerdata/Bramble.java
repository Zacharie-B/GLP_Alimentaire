package data.tertiaryConsumerdata;

import java.util.ArrayList;

import data.TertiaryConsumer;

public class Bramble extends TertiaryConsumer{

	public Bramble(int hp, int organicMass, boolean isAlive, int populationDensity, int numberBirths, int timeBreeding, int calories, int timeExcreta, boolean sickness) {
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
	public void initializeDiet() {
		ArrayList <String> al = new ArrayList <String> ();
		al.add("AsianLadyBug");
		al.add("Spider");
		setDiet(al);
	}

}
