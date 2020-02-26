package data.producersdata;

import java.util.ArrayList;

import data.Position;
import data.Producer;

public class Ferns extends Producer{
	
	public Ferns(String name,boolean isalive, int populationdensity, int numberbirths, int timebreeding,
			int hp, int organicmass, int mineralAssimilation, int ratemineral, Position cordinates) {
		super();
		setName(name);
		setIsAlive(isalive);
		setPopulationDensity(populationdensity);
		setNumberBirths(numberbirths);
		setTimeBreeding(timebreeding);
		setHP(hp);
		setOrganicMass(organicmass);
		setMineralAssimilation(mineralAssimilation);
		setRateMineral(ratemineral);
		setCordinates(cordinates);
		initializeEatenBy();
	}

	@Override
	public String toString() {
		return "Ferns [getHP()=" + getHP() + ", getEatenby()=" + getEatenBy() + ", getCordinates()=" + getCordinates()
				+ ", getOrganicMass()=" + getOrganicMass() + ", getMineralAssimilation()="
				+ getMineralAssimilation() + ", \ngetRateMineral()=" + getRateMineral() + ", getIsAlive()="
				+ getIsAlive() + ", getPopulationDensity()=" + getPopulationDensity() + ", getNumberBirths()="
				+ getNumberBirths() + ", getTimeBreeding()=" + getTimeBreeding() + "]";
	}
	
	public void initializeEatenBy(){
		ArrayList <String> al = new ArrayList <String> ();
		al.add("herbivorousLadybug");
		setEatenBy(al);
	}
}
