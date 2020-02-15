package data.decomposersdata;

import data.Decomposer;
import data.Point;

public class Mollusc extends Decomposer{

	public Mollusc(String name, int organicmass, int populationDensity, Point cordinates) {
		super();
		setName(name);
		setOrganicMass(organicmass);
		setPopulationDensity(populationDensity);
		setCordinates(cordinates);
	}
	
	@Override
	public String toString() {
		return "Mollusc [getName()=" + getName() + ", getCordinates()=" + getCordinates() + ", getOrganicMass()="
				+ getOrganicMass() + ", getPopulationDensity()=" + getPopulationDensity() + "]";
	}
	
}
