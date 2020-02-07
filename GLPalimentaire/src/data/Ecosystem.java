package data;

public abstract class Ecosystem {

	private int temperature;
	private float sizeX;
	private float sizeY;
	private boolean canBurn;
	private int speciesMaxDensity;
	
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public float getSizeX() {
		return sizeX;
	}
	public void setSizeX(float sizeX) {
		this.sizeX = sizeX;
	}
	public float getSizeY() {
		return sizeY;
	}
	public void setSizeY(float sizeY) {
		this.sizeY = sizeY;
	}
	public boolean isCanBurn() {
		return canBurn;
	}
	public void setCanBurn(boolean canBurn) {
		this.canBurn = canBurn;
	}
	public int getSpeciesMaxDensity() {
		return speciesMaxDensity;
	}
	public void setSpeciesMaxDensity(int speciesMaxDensity) {
		this.speciesMaxDensity = speciesMaxDensity;
	}
	
	

}
