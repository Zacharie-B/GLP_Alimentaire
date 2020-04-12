package data.secondaryConsumerdata;

import java.util.ArrayList;

import data.Position;
import data.SecondaryConsumer;

public class AsianLadybug extends SecondaryConsumer{

	public AsianLadybug(String name, int hp, int organicMass, boolean isAlive, int populationDensity,
			int numberBirths, int timeBreeding, int calories, int timeExcreta, boolean sickness, Position cordinates) {
		super();
		setName(name);
		setHp(hp);
		setOrganicMass(organicMass);
		setIsAlive(isAlive);
		setPopulationDensity(populationDensity);
		setCaloriesAssimilation(numberBirths);
		setTimeBreeding(timeBreeding);
		setCalories(calories);
		setTimeExcreta(timeExcreta);
		setSickness(sickness);
		setCordinates(cordinates);
		initializeEatenBy();
		initializeDiet();
	}
	@Override
	public String Prey() {
		ArrayList<String> animals=getEatenBy();
		return ""+animals;
	}
	public String Predator() {
		ArrayList<String> animals=getDiet();
		return ""+animals;
	}

	@Override
	public void initializeEatenBy() {
		ArrayList <String> eatenBy = new ArrayList <String> ();
		eatenBy.add("bramble");
		eatenBy.add("woodpecker");
		setEatenBy(eatenBy);
	}

	@Override
	public void initializeDiet() {
		ArrayList <String> diet = new ArrayList <String> ();
		diet.add("aphid");
		setDiet(diet);
	}
}
