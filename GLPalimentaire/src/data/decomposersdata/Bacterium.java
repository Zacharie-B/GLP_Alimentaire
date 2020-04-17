package data.decomposersdata;

import data.Decomposer;



public class Bacterium extends Decomposer{

	public Bacterium(String name,int populationDensity) {
		super();
		setName(name);
		setPopulationDensity(populationDensity);
	}

	@Override
	public String toString() {
		return "Bacterium [getName()=" + getName() + ", getCordinates()=" + getCordinates() + ", getOrganicMass()="
				+ getOrganicMass() + ", getPopulationDensity()=" + getPopulationDensity() + "]";
	}

	@Override
	public boolean getIsAlive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int gethp() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void sethp(int hp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setIsAlive(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getTimeBreeding() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
