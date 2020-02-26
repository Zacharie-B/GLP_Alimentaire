package data.primaryConsumerdata;

import java.util.ArrayList;

import data.Position;
import data.PrimaryConsumer;

public class Zooplanckton extends PrimaryConsumer{

	public Zooplanckton(String name, int hp, int organicMass, boolean isAlive, int populationDensity, int numberBirths, 
			int timeBreeding, int calories, int timeExcreta, boolean sickness, Position cordinates) {
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
		return "Zooplanckton [getName()=" + getName() + ", getHp()=" + getHp() + ", getEatenBy()=" + getEatenBy()
				+ ", getDiet()=" + getDiet() + ", getCordinates()=" + getCordinates() + ", getOrganicMass()="
				+ getOrganicMass() + ", getIsAlive()=" + getIsAlive() + ", \ngetPopulationDensity()="
				+ getPopulationDensity() + ", getNumberBirths()=" + getCaloriesAssimilation() + ", getTimeBreeding()="
				+ getTimeBreeding() + ", getCalories()=" + getCalories() + ", getTimeExcreta()=" + getTimeExcreta()
				+ ", isSickness()=" + isSickness() + "]";
	}
	@Override
	public void initializeDiet() {
		ArrayList <String> al = new ArrayList <String> ();
		al.add("phytoplanckton");
		setDiet(al);
	}

	public void initializeEatenBy() {
		ArrayList <String> al = new ArrayList <String> ();
		al.add("cyprinid");
		setEatenBy(al);
	}
}
