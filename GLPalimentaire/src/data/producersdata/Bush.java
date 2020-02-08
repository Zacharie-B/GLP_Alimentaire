package data.producersdata;

import java.util.ArrayList;

import data.Producer;

public class Bush extends Producer{
	
	public Bush(boolean isalive, int populationdensity, ArrayList<String> eatenBy, int numberbirths, int timebreeding, int hp, int organicmass, int organicprocessingspeed, int ratemineral) {
		super();
		setIsAlive(isalive);
		setPopulationDensity(populationdensity);
		setNumberBirths(numberbirths);
		setTimeBreeding(timebreeding);
		setHP(hp);
		setEatenBy(eatenBy);
		setOrganicMass(organicmass);
		setOrganicprocessingspeed(organicprocessingspeed);
		setRateMineral(ratemineral);
		initializeEatenBy();
	}

	
	@Override
	public void initializeEatenBy() {
		// TODO Auto-generated method stub
		
	}

}
