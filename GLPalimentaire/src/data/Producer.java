package data;

import java.util.ArrayList;

public abstract class Producer implements Species{
	boolean isalive;
	int populationdensity;
	ArrayList<String> diet;
	int numberbirths;
	int timebreeding;
	int hp;
	ArrayList<String> eatenby;
	int organicmass;
	int ratemineral;
	
	/**
	 * 
	 * @return number of hit points
	 */
	public abstract int getHP();
	public abstract void setHP(int hp);
	
	/**
	 * 
	 * @return who can eat him
	 */
	public abstract ArrayList <Producer> getEatenby();
	public abstract void setHP(ArrayList <String> eatenby);
	
	/**
	 * 
	 * @return the organic mass of this producer
	 */
	public abstract int getOrganicMass();
	public abstract void setOrganicMass(int organicmass);
	
	/**
	 * @return the rate mineral necessary per day or per shift for not to lose health points
	 */
	public abstract int getRateMineral();
	public abstract void setRateMineral(int ratemineral);
}
