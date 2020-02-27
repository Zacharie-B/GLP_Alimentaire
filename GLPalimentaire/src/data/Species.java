package data;


/**
 * @author yassin
 * @author thibaut
 * @author zacharie
 *
 */
public interface Species {
	
	/**
	 * 
	 * @return the population density 
	 */
	
	public abstract int getPopulationDensity();
	public abstract void setPopulationDensity(int populationDensity);	
	public abstract String getName();
	public abstract void setName(String name);
	public abstract Position getCordinates();
	public abstract void setCordinates(Position cordinate);
}	

