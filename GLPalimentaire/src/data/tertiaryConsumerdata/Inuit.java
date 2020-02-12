package data.tertiaryConsumerdata;

import java.util.ArrayList;

import data.TertiaryConsumer;

public class Inuit extends TertiaryConsumer{

	public Inuit(int hp, int organicMass, boolean isAlive, int populationDensity, int numberBirths, int timeBreeding, int calories, int timeExcreta, boolean sickness) {
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
		al.add("ArcticWolf");
		al.add("Phoque");
		setDiet(al);
	}

}
