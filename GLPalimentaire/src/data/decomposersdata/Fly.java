package data.decomposersdata;

import data.Decomposer;
import data.Point;


public class Fly extends Decomposer{

	public Fly(int organicmass, int populationDensity, Point cordinates) {
		super();
		setOrganicMass(organicmass);
		setPopulationDensity(populationDensity);
		setCordinates(cordinates);
	}
}
