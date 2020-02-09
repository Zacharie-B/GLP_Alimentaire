package data.decomposersdata;

import java.util.ArrayList;

import data.Decomposer;

public class Bacterium extends Decomposer{

	public Bacterium(ArrayList<String> diet, int organicmass, int populationDensity) {
		super();
		setDiet(diet);
		setOrganicMass(organicmass);
		setPopulationDensity(populationdensity);
		initializeDiet();
	}
	
	@Override
	public void initializeDiet() {
		// TODO Auto-generated method stub
		
	}
}
