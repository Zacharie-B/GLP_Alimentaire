package data.decomposersdata;

import data.Decomposer;
import data.Point;



public class Bacterium extends Decomposer{

	public Bacterium(int organicmass, int populationDensity, Point cordinates) {
		super();
		setOrganicMass(organicmass);
		setPopulationDensity(populationDensity);
		setCordinates(cordinates);
	}
}
