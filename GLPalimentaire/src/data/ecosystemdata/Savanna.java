package data.ecosystemdata;

import data.Ecosystem;

public class Savanna extends Ecosystem{

	public Savanna(int temperature, float sizeX, float sizeY, boolean canBurn, int speciesMaxDensity) {
		setTemperature(temperature);
		setSizeX(sizeX);
		setSizeY(sizeY);
		setCanBurn(canBurn);
		setSpeciesMaxDensity(speciesMaxDensity);
	}

}
