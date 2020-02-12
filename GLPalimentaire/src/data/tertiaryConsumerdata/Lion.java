package data.tertiaryConsumerdata;

import java.util.ArrayList;

import data.TertiaryConsumer;

public class Lion extends TertiaryConsumer{

	@Override
	public String toString() {
		return "Lion [getHp()=" + getHp() + ", getEatenBy()=" + getEatenBy() + ", getDiet()=" + getDiet()
				+ ", getOrganicMass()=" + getOrganicMass() + ", getIsAlive()=" + getIsAlive()
				+ ",\ngetPopulationDensity()=" + getPopulationDensity() + ", getNumberBirths()=" + getNumberBirths()
				+ ", getTimeBreeding()=" + getTimeBreeding() + ", getCalories()=" + getCalories()
				+ ", getTimeExcreta()=" + getTimeExcreta() + ", isSickness()=" + isSickness() + "]";
	}

	public Lion(int hp, int organicMass, boolean isAlive, int populationDensity, int numberBirths, int timeBreeding, int calories, int timeExcreta, boolean sickness) {
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
		al.add("Cheetah");
		al.add("Hyena");
		al.add("Giraffe");
		setDiet(al);
	}

}
