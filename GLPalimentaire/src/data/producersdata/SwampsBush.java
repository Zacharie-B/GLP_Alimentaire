package data.producersdata;

import java.util.ArrayList;

import data.Position;
import data.Producer;

public class SwampsBush extends Producer{
	
	public SwampsBush(String name,boolean isalive, int populationdensity, int numberbirths, int timebreeding,
			int hp, int organicmass, int mineralAssimilation, int ratemineral, Position cordinates) {
		super();
		setName(name);
		setIsAlive(isalive);
		setPopulationDensity(populationdensity);
		setNumberBirths(numberbirths);
		setTimeBreeding(timebreeding);
		sethp(hp);
		setOrganicMass(organicmass);
		setMineralAssimilation(mineralAssimilation);
		setRateMineral(ratemineral);
		setCordinates(cordinates);
		initializeEatenBy();
	}
	public SwampsBush() {
		
	}
	@Override
	public String Prey() {
		ArrayList<String> animals=getEatenBy();
		return ""+animals;
	}

	
	public void initializeEatenBy(){
		ArrayList <String> al = new ArrayList <String> ();
		al.add("turtle");
		al.add("hippopotamus");
		setEatenBy(al);
	}

}
