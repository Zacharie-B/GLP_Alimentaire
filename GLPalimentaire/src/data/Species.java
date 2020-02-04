/**
 * 
 */
package data;

import java.util.ArrayList;

/**
 * @author yassin
 * @author thibaut
 * @author zacharie
 *
 */
public interface Species {
	
	public abstract int getOrganicMass();
	
	public abstract int getRateMineral();

	public abstract int getHP();
	
	public abstract int getPopulationDensity();
	
	public abstract int getCalories();
	
	public abstract int getTimeExcreta();
	
	public abstract int getTimeBreeding();
	
	public abstract int getNumberBirths();
	
	public abstract ArrayList <Species> getDiet();
	
	public abstract ArrayList <Species> getEatenby();
	
	public abstract boolean isSick();
	
	public abstract boolean isAlive();
	
	
}
