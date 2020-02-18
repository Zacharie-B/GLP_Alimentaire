package foodChains;

import data.Position;
import data.decomposersdata.Bacterium;

public class BacteriumAction{
	
	private Position position = new Position(8,8);
	private Bacterium bacterium = new Bacterium ("bacterium",1,1000,position);
	
	public int IfSpeciesDead (int organicMass) {
		int mineralizationRate = bacterium.getPopulationDensity();
		int mineralMass=0;
		while(organicMass!=0) {
			if(organicMass>0) {
				organicMass -=mineralizationRate;
				if(organicMass<0) {
					mineralMass+=organicMass+mineralizationRate;
					organicMass=0;
					continue;
				}
				mineralMass+=mineralizationRate;
			}
		}
		return mineralMass;	
	}
}