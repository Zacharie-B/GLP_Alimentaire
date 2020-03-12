package naturalNeedsManagement;

import data.Consumer;
import data.Producer;

public class HungryProcess extends EnoughCalories{
	
	private static int currentCalories=0;
	
	public HungryProcess(){
		
	}
	
	public void HungryProcessConsumerWithProducer(Consumer consumer, Producer producer) {
		int eatCalories=producer.getOrganicMass();
		consumer.setCaloriesAssimilation(ConsumerHungry(consumer, eatCalories , currentCalories));
	}
	
	public void HungryProcessConsumerWithConsumer(Consumer consumer1, Consumer consumer2) {
		int eatCalories=consumer2.getOrganicMass();
		consumer1.setCaloriesAssimilation(ConsumerHungry(consumer1, eatCalories , currentCalories));
	}
}
