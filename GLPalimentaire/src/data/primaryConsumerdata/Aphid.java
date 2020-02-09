package data.primaryConsumerdata;

import java.util.ArrayList;

import data.PrimaryConsumer;

@SuppressWarnings("unused")
public class Aphid extends PrimaryConsumer{

	@Override
	public String toString() {
		return "Aphid [getHp()=" + getHp() + ", getOrganicMass()=" + getOrganicMass() + ", getIsAlive()=" + getIsAlive()
				+ ", getPopulationDensity()=" + getPopulationDensity() + ",\ngetNumberBirths()=" + getNumberBirths()
				+ ", getTimeBreeding()=" + getTimeBreeding() + ", getCalories()=" + getCalories()
				+ ", getTimeExcreta()=" + getTimeExcreta() + ", isSickness()=" + isSickness() + "]";
	}
	
	public Aphid(int hp, int organicMass, boolean isAlive, int populationDensity, int numberBirths, int timeBreeding, int calories, int timeExcreta, boolean sickness) {
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
	public void initializeEatenBy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initializeDiet() {
		// TODO Auto-generated method stub
		
	}

}
