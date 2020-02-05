package data;

import java.util.ArrayList;

public abstract class Producer implements Species{
	
	/**
	 * 
	 * @return number of hit points
	 */
	public abstract int getHP();
	
	/**
	 * 
	 * @return who can eat him
	 */
	public abstract ArrayList <Producer> getEatenby();
	
	/**
	 * 
	 * @return the organic mass of this producer
	 */
	public abstract int getOrganicMass();
	
	/**
	 * @return the rate mineral necessary per day or per shift for not to lose health points
	 */
	public abstract int getRateMineral();
}
