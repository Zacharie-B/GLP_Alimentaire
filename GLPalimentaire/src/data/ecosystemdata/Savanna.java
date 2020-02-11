package data.ecosystemdata;

import data.Ecosystem;

public class Savanna extends Ecosystem{
	
	public static final String POSITION = "Nort East";

	public Savanna(int temperature, float sizeX, float sizeY, boolean canBurn, int speciesMaxDensity) {
		setTemperature(temperature);
		setSizeX(sizeX);
		setSizeY(sizeY);
		setCanBurn(canBurn);
		setSpeciesMaxDensity(speciesMaxDensity);
	}

	@Override
	public String toString() {
		return "Savanna [getTemperature()=" + getTemperature() + ", getSizeX()=" + getSizeX() + ", getSizeY()="
				+ getSizeY() + ", isCanBurn()=" + isCanBurn() + ", getSpeciesMaxDensity()=" + getSpeciesMaxDensity()
				+ "]";
	}

}
