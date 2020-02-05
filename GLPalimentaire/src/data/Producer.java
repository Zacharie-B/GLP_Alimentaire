package data;

import java.util.ArrayList;

public abstract class Producer implements Species{
	int hp;
	ArrayList<String> eatenby;
	int organicmass;
	int organicprocessingspeed;
	int ratemineral;
	boolean isalive;
	int populationdensity;
	int numberbirths;
	int timebreeding;
	
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
		return eatenby;
	}
	public void setEatenBy(ArrayList <String> eatenby) {
		this.eatenby=eatenby;
	}
	
	/**
	 * 
	 * @return the organic mass of this producer
	 */
	public int getOrganicMass() {
		return organicmass;
	}
	public void setOrganicMass(int organicmass) {
		this.organicmass=organicmass;
	}
	
	/**
	 * @return the time transforming minerals to organic
	 */
	
	public int getOrganicprocessingspeed() {
		return organicprocessingspeed;
	}
	public void setOrganicprocessingspeed(int organicprocessingspeed) {
		this.organicprocessingspeed = organicprocessingspeed;
	}
	
	/**
	 * @return the rate mineral necessary per day or per shift for not to lose health points
	 */
	public int getRateMineral() {
		return ratemineral;
	}
	
	public void setRateMineral(int ratemineral) {
		this.ratemineral=ratemineral;
	}
	
	public boolean getIsIsalive() {
		return isalive;
	}
	
	public void setIsalive(boolean isalive) {
		this.isalive = isalive;
	}
	
	public int getPopulationdensity() {
		return populationdensity;
	}
	
	public void setPopulationdensity(int populationdensity) {
		this.populationdensity = populationdensity;
	}
	
	public int getNumberbirths() {
		return numberbirths;
	}
	
	public void setNumberbirths(int numberbirths) {
		this.numberbirths = numberbirths;
	}
	
	public int getTimebreeding() {
		return timebreeding;
	}
	
	public void setTimebreeding(int timebreeding) {
		this.timebreeding = timebreeding;
	}
	
	/**
	 * these 2 abstract methods are used in inherited methods' constructors
	 */
	
	public abstract void initializeEatenBy();
	
}
