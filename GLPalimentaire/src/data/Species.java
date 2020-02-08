package data;


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
	public abstract boolean getIsAlive();
	public abstract void setIsAlive(boolean isalive);
	
	/**
	 * 
	 * @return the population density 
	 */
	
	public abstract int getPopulationDensity();
	public abstract void setPopulationDensity(int populationdensity);	
	
}	

