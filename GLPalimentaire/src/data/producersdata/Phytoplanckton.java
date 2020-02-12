package data.producersdata;

import java.util.ArrayList;

import data.Producer;

public class Phytoplanckton extends Producer{
	
	public Phytoplanckton(boolean isalive, int populationdensity, int numberbirths, int timebreeding,
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
	}

	public void initializeEatenBy() {
		ArrayList <String> al = new ArrayList <String> ();
		al.add("Mollusc");
		setEatenBy(al);
	}
}
