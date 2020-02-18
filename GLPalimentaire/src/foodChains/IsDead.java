package foodChains;

import data.Consumer;
import data.Position;
import data.Producer;
import data.decomposersdata.Bacterium;

public class IsDead {
	/**
	 * 
	 * @param producer
	 * @return the producer is dead if its "hp" are equal to 0
	 */
	private Position position = new Position(8,8);
	private Bacterium bacterium = new Bacterium ("bacterium",1,1000,position);
	
	public Producer ProducerDead(Producer producer) {
		if(producer.getHP()==0) {
			producer.setIsAlive(false);
		}
		return producer;
	}
	
	/**
	 * 
	 * @param consumer
	 * @return the consumer is dead if its "hp" are equal to 0
	 */
	public Consumer ConsumerDead(Consumer consumer) {
		if(consumer.getHp()==0) {
			consumer.setIsAlive(false);	
		}
		return consumer;
	}
	
	public int IfSpeciesDead (int organicMass) {
		int mineralizationRate = bacterium.getPopulationDensity();
		int mineralMass=0;
		while(organicMass!=0) {
			if(organicMass>0) {
				organicMass -=mineralizationRate;
				if(organicMass<0) {
					mineralMass+=organicMass+mineralizationRate;
					organicMass=0;
					continue;
				}
				mineralMass+=mineralizationRate;
			}
		}
		return mineralMass;	
	}
}

