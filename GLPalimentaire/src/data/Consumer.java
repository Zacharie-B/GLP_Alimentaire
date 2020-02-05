package data;

import java.util.ArrayList;

public abstract class Consumer implements Species{
	
	/**
	 * 
	 * @return number of hit points
	 */
	public abstract int getHP();
	public abstract void setHP(int hp);
	
	/**
	 * @return number of calories necessary per day or per shift for not to lose health points
	 */
	public abstract int getCalories();
	public abstract void setCalories(int calories);
	
	/**
	 * 
	 * @return the time it takes to do one's natural needs
	 */
	public abstract int getTimeExcreta();
	public abstract void setTimeExcreta(int timeexcreta);
	
	/**
	 * 
	 * @return who can eat him
	 */
	public abstract ArrayList <String> getEatenby();
	public abstract void setEatenby(ArrayList <String> eatenby);
	
	/**
	 * 
	 * @return whether or not the pet is sick
	 */
	public abstract boolean isSick();
	public abstract void setisSick(boolean issick);
	
	/**
	 * 
	 * @return the organic mass of this pet
	 */
	public abstract int getOrganicMass();
	public abstract void setOrganicMass(int organicmass);
}

