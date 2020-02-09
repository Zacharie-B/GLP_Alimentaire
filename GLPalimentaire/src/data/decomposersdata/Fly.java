package data.decomposersdata;

import java.util.ArrayList;

import data.Decomposer;

public class Fly extends Decomposer{

	public Fly(ArrayList<String> diet, int organicmass, int populationDensity) {
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
