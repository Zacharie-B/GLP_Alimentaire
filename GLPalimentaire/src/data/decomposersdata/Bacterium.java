package data.decomposersdata;

import data.Decomposer;
import data.Position;



public class Bacterium extends Decomposer{

	public Bacterium(String name, int organicmass, int populationDensity, Position cordinates) {
		super();
		setName(name);
		setOrganicMass(organicmass);
		setPopulationDensity(populationDensity);
		setCordinates(cordinates);
	}

	@Override
	public String toString() {
		return "Bacterium [getName()=" + getName() + ", getCordinates()=" + getCordinates() + ", getOrganicMass()="
				+ getOrganicMass() + ", getPopulationDensity()=" + getPopulationDensity() + "]";
	}
	
}
