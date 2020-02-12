package data.primaryConsumerdata;

import java.util.ArrayList;

import data.PrimaryConsumer;

public class Turtle extends PrimaryConsumer{

	public Turtle(int hp, ArrayList<String> eatenBy, ArrayList<String> diet, int organicMass, boolean isAlive, int populationDensity, int numberBirths, int timeBreeding, int calories, int timeExcreta, boolean sickness) {
		super();
		setHp(hp);
		setEatenBy(eatenBy);
		setDiet(diet);
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
		al.add("Bush");
		al.add("Reeds");
		setDiet(al);
	}

	public void initializeEatenBy() {
		ArrayList <String> al = new ArrayList <String> ();
		al.add("Anaconda");
		setEatenBy(al);
	}
}
