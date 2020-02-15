package data.decomposersdata;

import data.Decomposer;
import data.Point;


public class Fly extends Decomposer{

	public Fly(String name, int organicmass, int populationDensity, Point cordinates) {
		super();
		setName(name);
		setOrganicMass(organicmass);
		setPopulationDensity(populationDensity);
		setCordinates(cordinates);
	}
	@Override
	public String toString() {
		return "Fly [getName()=" + getName() + ", getCordinates()=" + getCordinates() + ", getOrganicMass()="
				+ getOrganicMass() + ", getPopulationDensity()=" + getPopulationDensity() + "]";
	}
	
}
