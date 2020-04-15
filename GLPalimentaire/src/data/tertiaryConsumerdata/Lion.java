package data.tertiaryConsumerdata;

import java.util.ArrayList;

import data.Position;
import data.TertiaryConsumer;

public class Lion extends TertiaryConsumer{

	public Lion(String name, int hp, int organicMass, boolean isAlive, int populationDensity,
			int caloriesAssimilation, int timeBreeding, int calories, int timeExcreta, boolean sickness, Position cordinates) {
		super();
		setName(name);
		setHp(hp);
		setOrganicMass(organicMass);
		setIsAlive(isAlive);
		setPopulationDensity(populationDensity);
		setCaloriesAssimilation(caloriesAssimilation);
		setTimeBreeding(timeBreeding);
		setCalories(calories);
		setTimeExcreta(timeExcreta);
		setSickness(sickness);
		setCordinates(cordinates);
		initializeEatenBy();
		initializeDiet();
	}
	
	public Lion() {
		// TODO Auto-generated constructor stub
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
	public void initializeDiet() {
		ArrayList <String> al = new ArrayList <String> ();
		al.add("cheetah");
		al.add("hyena");
		setDiet(al);
	}

}
