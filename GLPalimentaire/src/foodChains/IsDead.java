package foodChains;

import data.Species;

public class IsDead{
	
	public IsDead () {
	}
	
	/**
	 * 
	 * @param producer
	 * @return the producer or consumer is dead if its "hp" are equal to 0
	 */
	
	public void SpeciesDead(Species producer) {
		if(producer.gethp()==0) {
			producer.setIsAlive(false);
			producer.setPopulationDensity(0);
		}
	}
}

