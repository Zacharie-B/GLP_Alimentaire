package data.secondaryConsumerdata;

import java.util.ArrayList;

import data.Position;
import data.SecondaryConsumer;

public class Python extends SecondaryConsumer{

	public Python(String name, int hp, int organicMass, boolean isAlive, int populationDensity,
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
	public String toString() {
		return "Python [getHp()=" + getHp() + ", getEatenBy()=" + getEatenBy()
				+ ", getDiet()=" + getDiet() + ", getCordinates()=" + getCordinates() + ", getOrganicMass()="
				+ getOrganicMass() + ", getIsAlive()=" + getIsAlive() + ", \ngetPopulationDensity()="
				+ getPopulationDensity() + ", getNumberBirths()=" + getCaloriesAssimilation() + ", getTimeBreeding()="
				+ getTimeBreeding() + ", getCalories()=" + getCalories() + ", getTimeExcreta()=" + getTimeExcreta()
				+ ", isSickness()=" + isSickness() + "]";
	}
	
	@Override
	public void initializeEatenBy() {
		ArrayList <String> eatenBy = new ArrayList <String> ();
		eatenBy.add("blackCaiman");
		eatenBy.add("saltCrocodile");
		setEatenBy(eatenBy);
	}

	@Override
	public void initializeDiet() {
		ArrayList <String> diet = new ArrayList <String> ();
		diet.add("hippopotamus");
		setDiet(diet);
	}
}
