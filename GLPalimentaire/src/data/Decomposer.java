package data;

import java.util.ArrayList;

public abstract class Decomposer implements Species{
	private ArrayList<String> diet;
	private int organicMass;
	private int populationDensity;
	
	public ArrayList<String> getDiet() {
		return diet;
	}
	public void setDiet(ArrayList<String> diet) {
		this.diet = diet;
	}
	public int getOrganicMass() {
		return organicMass;
	}
	public void setOrganicMass(int organicMass) {
		this.organicMass = organicMass;
	}
	public int getPopulationDensity() {
		return populationDensity;
	}
	public void setPopulationDensity(int populationDensity) {
		this.populationDensity = populationDensity;
	}
	
	public abstract void initializeDiet();
	
	
	
}
