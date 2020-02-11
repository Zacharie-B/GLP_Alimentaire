package data.ecosystemdata;

import data.Ecosystem;

public class Mountains extends Ecosystem{
	
	public static final String POSITION = "South East"

	@Override
	public String toString() {
		return "Mountains [getTemperature()=" + getTemperature() + ", getSizeX()=" + getSizeX() + ", getSizeY()="
				+ getSizeY() + ", isCanBurn()=" + isCanBurn() + ", getSpeciesMaxDensity()=" + getSpeciesMaxDensity()
				+ "]";
	}

	public Mountains(int temperature, float sizeX, float sizeY, boolean canBurn, int speciesMaxDensity) {
		setTemperature(temperature);
		setSizeX(sizeX);
		setSizeY(sizeY);
		setCanBurn(canBurn);
		setSpeciesMaxDensity(speciesMaxDensity);
	}

}
