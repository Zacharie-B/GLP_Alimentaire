package data;

public abstract class Decomposer implements Species{
	
	/** 
	 * @return the rate of transformation of organic matter into mineral matter
	 */
	public abstract int getMineralProcessingSpeed();
	public abstract void setMineralProcessingSpeed(int mineralprocessingspeed);	
	
	/**
	 * @return the time life of a decomposer
	 */
	public abstract int getTimeLife();
	public abstract void setTimeLife(int timelife);	
}
