package data;

public abstract class Decomposer {
	
	/**
	 * 
	 * @return the rate of transformation of organic matter into mineral matter
	 */
	public abstract int getMineralProcessingSpeed();
	
	/**
	 * 
	 * @return the time life of a decomposer
	 */
	public abstract int getTimeLife();

}
