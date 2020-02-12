package data.producersdata;

import data.Producer;

public class Acacia extends Producer{
	
	public Acacia(boolean isalive, int populationdensity, int numberbirths, int timebreeding,
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

	@Override
	public String toString() {
		return "Acacia [getHP()=" + getHP() + ", getEatenby()=" + getEatenby() + ", getOrganicMass()="
				+ getOrganicMass() + ", getOrganicprocessingspeed()=" + getOrganicprocessingspeed()
				+ ", getRateMineral()=" + getRateMineral() + ", getIsAlive()=" + getIsAlive()
				+ ", getPopulationDensity()=" + getPopulationDensity() + ", getNumberBirths()=" + getNumberBirths()
				+ ", getTimeBreeding()=" + getTimeBreeding() + "]";
	}
}
