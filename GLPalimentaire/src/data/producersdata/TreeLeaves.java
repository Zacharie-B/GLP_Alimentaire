package data.producersdata;

import java.util.ArrayList;

import data.Point;
import data.Producer;

public class TreeLeaves extends Producer{
	
	public TreeLeaves(String name,boolean isalive, int populationdensity, int numberbirths, int timebreeding,
			int hp, int organicmass, int organicprocessingspeed, int ratemineral, Point cordinates) {
		super();
		setName(name);
		setIsAlive(isalive);
		setPopulationDensity(populationdensity);
		setNumberBirths(numberbirths);
		setTimeBreeding(timebreeding);
		setHP(hp);
		setOrganicMass(organicmass);
		setOrganicprocessingspeed(organicprocessingspeed);
		setRateMineral(ratemineral);
		setCordinates(cordinates);
		initializeEatenBy();
	}

	@Override
	public String toString() {
		return "TreeLeaves [getHP()=" + getHP() + ", getEatenby()=" + getEatenBy() + ", getCordinates()=" + getCordinates()
				+ ", getOrganicMass()=" + getOrganicMass() + ", getOrganicprocessingspeed()="
				+ getOrganicprocessingspeed() + ", \ngetRateMineral()=" + getRateMineral() + ", getIsAlive()="
				+ getIsAlive() + ", getPopulationDensity()=" + getPopulationDensity() + ", getNumberBirths()="
				+ getNumberBirths() + ", getTimeBreeding()=" + getTimeBreeding() + "]";
	}
	
	public void initializeEatenBy(){
		ArrayList <String> al = new ArrayList <String> ();
		al.add("aphid");
		al.add("herbivorousLadybug");
		setEatenBy(al);
	}
}
