package data.producersdata;

import data.Producer;

public class Ferns extends Producer{
	
	public Ferns(boolean isalive, int populationdensity, int numberbirths, int timebreeding,
			int hp, int organicmass, int organicprocessingspeed, int ratemineral) {
		super();
		setIsAlive(isalive);
		setPopulationDensity(populationdensity);
		setNumberBirths(numberbirths);
		setTimeBreeding(timebreeding);
		setHP(hp);
		setOrganicMass(organicmass);
		setOrganicprocessingspeed(organicprocessingspeed);
		setRateMineral(ratemineral);
		initializeEatenBy();
	}
}
