package foodChains;

import java.util.HashMap;

import data.Position;
import data.decomposersdata.Bacterium;

public class BacteriumAction{
	
	protected BacteriumAction(){
		
	}
	public void addMineralResources(Position cordinates, HashMap <Position,Integer> basicMineralRate, int rateMineral) {
		int currentMineralRate = basicMineralRate.get(cordinates);
		rateMineral+=currentMineralRate;
		basicMineralRate.put(cordinates,rateMineral);
	}

}