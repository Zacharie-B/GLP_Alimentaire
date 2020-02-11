package data.ecosystemdata;

import data.Ecosystem;

public class Plain extends Ecosystem {
	
	public static final String POSITION = "Nort West";
	
	public Plain(int temperature, float sizeX, float sizeY, boolean canBurn, int speciesMaxDensity) {
		setTemperature(temperature);
		setSizeX(sizeX);
		setSizeY(sizeY);
		setCanBurn(canBurn);
		setSpeciesMaxDensity(speciesMaxDensity);
	}


	@Override
	public String toString() {
		return "Plain [getTemperature()=" + getTemperature() + ", getSizeX()=" + getSizeX() + ", getSizeY()="
				+ getSizeY() + ", isCanBurn()=" + isCanBurn() + ", getSpeciesMaxDensity()=" + getSpeciesMaxDensity()
				+ "]";
	}

	
}
