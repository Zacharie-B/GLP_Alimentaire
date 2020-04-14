package foodChains;

import data.Consumer;
import data.Producer;

public class IsDead{
	
	public IsDead () {
	}
	
	/**
	 * 
	 * @param producer
	 * @return the producer is dead if its "hp" are equal to 0
	 */
	
	public void ProducerDead(Producer producer) {
		if(producer.getHP()==0) {
			producer.setIsAlive(false);
			producer.setPopulationDensity(0);
		}
	}
	
	/**
	 * 
	 * @param consumer
	 * @return the consumer is dead if its "hp" are equal to 0
	 */
	public void ConsumerDead(Consumer consumer) {
		if(consumer.getHp()==0) {
			consumer.setIsAlive(false);	
			consumer.setPopulationDensity(0);
		}
	}
}

