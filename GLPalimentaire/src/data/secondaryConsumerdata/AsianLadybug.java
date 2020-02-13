package data.secondaryConsumerdata;

import java.util.ArrayList;

import data.SecondaryConsumer;
import data.Point;

public class AsianLadybug extends SecondaryConsumer{

	public AsianLadybug(int hp, int organicMass, boolean isAlive, int populationDensity, int numberBirths,
			int timeBreeding, int calories, int timeExcreta, boolean sickness, Point point) {
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
	public void initializeEatenBy() {
		ArrayList <String> eatenBy = new ArrayList <String> ();
		eatenBy.add("Bramble");
		eatenBy.add("Woodpecker");
		setEatenBy(eatenBy);
	}

	@Override
	public void initializeDiet() {
		ArrayList <String> diet = new ArrayList <String> ();
		diet.add("Aphid");
		setDiet(diet);
	}
}
