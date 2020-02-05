package data;

import java.util.ArrayList;

/**
 * @author yassin
 * @author thibaut
 * @author zacharie
 *
 */
public interface Species {

	/**
	 * @return if the individual is alive
	 * Decomposers are all alive, but die after some time
	 */
	public abstract boolean isAlive();
	public abstract void setisAlive(boolean isalive);
	
	/**
	 * 
	 * @return the population density 
	 */
	
	public abstract int getPopulationDensity();
	public abstract void setPopulationDensity(int populationdensity);
	
	/**
	 * @return number of Births for a litter
	 * always single birth for Decomposers
	 */
	
	public abstract int getNumberBirths();
	public abstract void setNumberBirths(int numberbirths);	
	
	/**
	 * @return time of breeding
	 * very short time per breeding for Decomposers
	 */
	
	public abstract int getTimeBreeding();
	public abstract void setTimeBreeding(int timebreeding);	
	
}	

