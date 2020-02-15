package data.secondaryConsumerdata;

import java.util.ArrayList;

import data.SecondaryConsumer;
import data.Point;

public class Spider extends SecondaryConsumer{

	public Spider(int hp, int organicMass, boolean isAlive, int populationDensity, int numberBirths, 
			int timeBreeding, int calories, int timeExcreta, boolean sickness, Point cordinates) {
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
	public String toString() {
		return "Spider [getHp()=" + getHp() + ", getEatenBy()=" + getEatenBy() + ", getDiet()=" + getDiet()
				+ ", getCordinates()=" + getCordinates() + ", getOrganicMass()=" + getOrganicMass() + ", getIsAlive()="
				+ getIsAlive() + ", getPopulationDensity()=" + getPopulationDensity() + ", getNumberBirths()="
				+ getNumberBirths() + ", getTimeBreeding()=" + getTimeBreeding() + ", getCalories()=" + getCalories()
				+ ", getTimeExcreta()=" + getTimeExcreta() + ", isSickness()=" + isSickness() + "]";
	}
	
	@Override
	public void initializeEatenBy() {
		ArrayList <String> eatenBy = new ArrayList <String> ();
		eatenBy.add("bramble");
		setEatenBy(eatenBy);
	}

	@Override
	public void initializeDiet() {
		ArrayList <String> diet = new ArrayList <String> ();
		diet.add("herbivorousLadybug");
		setDiet(diet);
	}
}
