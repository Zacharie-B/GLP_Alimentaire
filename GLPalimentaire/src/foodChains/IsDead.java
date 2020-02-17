package foodChains;

import data.Consumer;
import data.Producer;

public class IsDead {
	
	public Producer ProducerDead(Producer producer) {
		if(producer.getHP()==0) {
			producer.setIsAlive(false);
		}
		return producer;
	}
	
	public Consumer ConsumerDead(Consumer consumer) {
		if(consumer.getHp()==0) {
			consumer.setIsAlive(false);
		}
		return consumer;
	}

}
