package data.decomposersdata;

import java.util.ArrayList;

import data.Decomposer;

@SuppressWarnings("unused")

public class Mollusc extends Decomposer{

	public Mollusc(int organicmass, int populationDensity) {
		super();
		setOrganicMass(organicmass);
		setPopulationDensity(populationDensity);
		initializeDiet();
	}
	
	@Override
	public void initializeDiet() {
		// TODO Auto-generated method stub
		
	}
}
