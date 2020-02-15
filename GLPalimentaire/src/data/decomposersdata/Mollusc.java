package data.decomposersdata;

import data.Decomposer;
import data.Point;

public class Mollusc extends Decomposer{

	public Mollusc(int organicmass, int populationDensity, Point cordinates) {
		super();
		setOrganicMass(organicmass);
		setPopulationDensity(populationDensity);
		setCordinates(cordinates);
	}
}
