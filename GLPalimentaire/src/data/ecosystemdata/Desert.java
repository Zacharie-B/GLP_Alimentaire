package data.ecosystemdata;

import data.Ecosystem;

public class Desert extends Ecosystem{

	public Desert(int temperature, float sizeX, float sizeY, boolean canBurn, int speciesMaxDensity) {
		setTemperature(temperature);
		setSizeX(sizeX);
		setSizeY(sizeY);
		setCanBurn(canBurn);
		setSpeciesMaxDensity(speciesMaxDensity);
	}

	@Override
	public String toString() {
		return "Desert [getTemperature()=" + getTemperature() + ", getSizeX()=" + getSizeX() + ", getSizeY()="
				+ getSizeY() + ", isCanBurn()=" + isCanBurn() + ", getSpeciesMaxDensity()=" + getSpeciesMaxDensity()
				+ "]";
	}
}
