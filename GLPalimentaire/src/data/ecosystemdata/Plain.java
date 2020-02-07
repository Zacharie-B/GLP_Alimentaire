package data.ecosystemdata;

import data.Ecosystem;

public class Plain extends Ecosystem {

	private static final String POSITION = "Nort East";
	
	
	public Plain(int temperature, float sizeX, float sizeY, boolean canBurn, int speciesMaxDensity) {
		setTemperature(temperature);
		setSizeX(sizeX);
		setSizeY(sizeY);
		setCanBurn(canBurn);
		setSpeciesMaxDensity(speciesMaxDensity);
	}

}
