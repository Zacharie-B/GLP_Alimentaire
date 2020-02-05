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
	 * @return if the species is alive
	 * Decomposer are all alive, but die after some time
	 */
	public abstract boolean isAlive();
	
	/**
	 * 
	 * @return the population density 
	 */
	public abstract int getPopulationDensity();
	
	/**
	 * 
	 * @return what each species feeds on
	 */
	public abstract ArrayList <Species> getDiet();
	
	/**
	 * @return number of Births for a litter
	 * always single birth for Decomposer
	 */
	public abstract int getNumberBirths();
	
	/**
	 * @return time of breeding
	 * very short time per breeding for Decomposer
	 */
	public abstract int getTimeBreeding();
}	

