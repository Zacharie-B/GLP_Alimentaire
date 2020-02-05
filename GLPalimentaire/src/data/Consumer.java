package data;

import java.util.ArrayList;

public abstract class Consumer implements Species{
	
	/**
	 * 
	 * @return number of hit points
	 */
	public abstract int getHP();
	
	/**
	 * @return number of calories necessary per day or per shift for not to lose health points
	 */
	public abstract int getCalories();
	
	/**
	 * 
	 * @return the time it takes to do one's natural needs
	 */
	public abstract int getTimeExcreta();
	
	/**
	 * 
	 * @return who can eat him
	 */
	public abstract ArrayList <Consumer> getEatenby();
	
	/**
	 * 
	 * @return whether or not the pet is sick
	 */
	public abstract boolean isSick();
	
	/**
	 * 
	 * @return the organic mass of this pet
	 */
	public abstract int getOrganicMass();

}

