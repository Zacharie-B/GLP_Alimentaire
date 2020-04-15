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
	public abstract boolean getIsAlive();
	public abstract int gethp();
	public abstract void sethp(int hp);
	public abstract void setIsAlive(boolean b);
	public abstract int getTimeBreeding();
}	

