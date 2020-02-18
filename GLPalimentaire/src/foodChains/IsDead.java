package foodChains;

import data.Consumer;
import data.Producer;

public class IsDead extends BacteriumAction{
	/**
	 * 
	 * @param producer
	 * @return the producer is dead if its "hp" are equal to 0
	 */
	
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
}

