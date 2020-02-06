package data;

import java.util.ArrayList;

public abstract class Producer implements Species{
	int hp;
	ArrayList<String> eatenBy;
	int organicMass;
	int organicProcessingSpeed;
	int rateMineral;
	boolean isAlive;
	int populationDensity;
	int numberBirths;
	int timeBreeding;
	
	/**
	 * 
	 * @return number of hit points
	 */
	public int getHP() {
		return hp;
	}
	public void setHP(int hp) {
		this.hp=hp;
	}
	
	/**
	 * 
	 * @return who can eat him
	 */
	public ArrayList <String> getEatenby(){
		return eatenBy;
	}
	public void setEatenBy(ArrayList <String> eatenby) {
		this.eatenBy=eatenby;
	}
	
	/**
	 * 
	 * @return the organic mass of this producer
	 */
	public int getOrganicMass() {
		return organicMass;
	}
	public void setOrganicMass(int organicmass) {
		this.organicMass=organicmass;
	}
	
	/**
	 * @return the time transforming minerals to organic
	 */
	
	public int getOrganicprocessingspeed() {
		return organicProcessingSpeed;
	}
	public void setOrganicprocessingspeed(int organicprocessingspeed) {
		this.organicProcessingSpeed = organicprocessingspeed;
	}
	
	/**
	 * @return the rate mineral necessary per day or per shift for not to lose health points
	 */
	public int getRateMineral() {
		return rateMineral;
	}
	
	public void setRateMineral(int ratemineral) {
		this.rateMineral=ratemineral;
	}
	
	public boolean getIsAlive() {
		return isAlive;
	}
	
	public void setIsAlive(boolean isalive) {
		this.isAlive = isalive;
	}
	
	public int getPopulationDensity() {
		return populationDensity;
	}
	
	public void setPopulationDensity(int populationdensity) {
		this.populationDensity = populationdensity;
	}
	
	public int getNumberBirths() {
		return numberBirths;
	}
	
	public void setNumberBirths(int numberbirths) {
		this.numberBirths = numberbirths;
	}
	
	public int getTimeBreeding() {
		return timeBreeding;
	}
	
	public void setTimeBreeding(int timebreeding) {
		this.timeBreeding = timebreeding;
	}
	
	/**
	 * these 2 abstract methods are used in inherited methods' constructors
	 */
	
	public abstract void initializeEatenBy();
	
}
