package data.producersdata;

import java.util.ArrayList;

import data.Producer;

public class Acacia extends Producer{
	
	public Acacia(boolean isalive, int populationdensity, ArrayList<String> eatenBy, int numberbirths, int timebreeding,
			int hp, int organicmass, int organicprocessingspeed, int ratemineral) {
		super();
		setIsAlive(isalive);
		setPopulationDensity(populationdensity);
		setEatenBy(eatenBy);
		setNumberBirths(numberbirths);
		setTimeBreeding(timebreeding);
		setHP(hp);
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
