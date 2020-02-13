package data.primaryConsumerdata;

import java.util.ArrayList;

import data.Point;
import data.PrimaryConsumer;

public class Aphid extends PrimaryConsumer{

	

	@Override
	public String toString() {
		return "Aphid [getHp()=" + getHp() + ", getEatenBy()=" + getEatenBy()
				+ ", getDiet()=" + getDiet() + ", getCordinates()=" + getCordinates() + ", getOrganicMass()="
				+ getOrganicMass() + ", getIsAlive()=" + getIsAlive() + ", \ngetPopulationDensity()="
				+ getPopulationDensity() + ", getNumberBirths()=" + getNumberBirths() + ", getTimeBreeding()="
				+ getTimeBreeding() + ", getCalories()=" + getCalories() + ", getTimeExcreta()=" + getTimeExcreta()
				+ ", isSickness()=" + isSickness() + "]";
	}

	public Aphid(int hp, int organicMass, boolean isAlive, int populationDensity,
			int numberBirths, int timeBreeding, int calories, int timeExcreta, boolean sickness, Point cordinates) {
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

	public void initializeDiet() {
		ArrayList <String> al = new ArrayList <String> ();
		al.add("treeleaves");
		setDiet(al);
	}
	
	public void initializeEatenBy() {
		ArrayList <String> al = new ArrayList <String> ();
		al.add("asianladybug");
		setEatenBy(al);
	}

}
