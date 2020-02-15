package data;

import java.util.ArrayList;

public abstract class Consumer implements Species{

	private String name;
	private int hp;
	private ArrayList<String> eatenBy;
	private ArrayList<String> diet;
	public Point cordinates;
	private int organicMass;
	private boolean isAlive;
	private int populationDensity;
	private int numberBirths;
	private int timeBreeding;
	private int calories;
	private int timeExcreta;
	private boolean sickness;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public ArrayList<String> getEatenBy() {
		return eatenBy;
	}
	public void setEatenBy(ArrayList<String> eatenBy) {
		this.eatenBy = eatenBy;
	}
	public ArrayList<String> getDiet() {
		return diet;
	}
	public void setDiet(ArrayList<String> diet) {
		this.diet = diet;
	}
	public Point getCordinates() {
		return cordinates;
	}
	public void setCordinates(Point cordinate) {
		this.cordinates = cordinate;
	}
	public int getOrganicMass() {
		return organicMass;
	}
	public void setOrganicMass(int organicMass) {
		this.organicMass = organicMass;
	}
	public boolean getIsAlive() {
		return isAlive;
	}
	public void setIsAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	public int getPopulationDensity() {
		return populationDensity;
	}
	public void setPopulationDensity(int populationDensity) {
		this.populationDensity = populationDensity;
	}
	public int getNumberBirths() {
		return numberBirths;
	}
	public void setNumberBirths(int numberBirths) {
		this.numberBirths = numberBirths;
	}
	public int getTimeBreeding() {
		return timeBreeding;
	}
	public void setTimeBreeding(int timeBreeding) {
		this.timeBreeding = timeBreeding;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public int getTimeExcreta() {
		return timeExcreta;
	}
	public void setTimeExcreta(int timeExcreta) {
		this.timeExcreta = timeExcreta;
	}
	public boolean isSickness() {
		return sickness;
	}
	public void setSickness(boolean sickness) {
		this.sickness = sickness;
	}
	
	public abstract void initializeEatenBy();
	
	public abstract void initializeDiet();
}

