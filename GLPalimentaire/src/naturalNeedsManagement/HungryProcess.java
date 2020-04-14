package naturalNeedsManagement;

import data.Consumer;
import data.Producer;

public class HungryProcess extends EnoughCalories{
	
	private static int currentCalories=0;
	
	public HungryProcess(){
		
	}
	
	public void HungryProcessConsumerWithProducer(Consumer consumer, Producer producer) {
		int eatCalories=producer.getOrganicMass();
		int populationp= producer.getPopulationDensity();
		consumer.setCaloriesAssimilation(ConsumerHungry(consumer, eatCalories , currentCalories, populationp));
	}
	
	public void HungryProcessConsumerWithConsumer(Consumer consumer1, Consumer consumer2) {
		int eatCalories=consumer2.getOrganicMass();
		int population2=consumer2.getPopulationDensity();
		consumer1.setCaloriesAssimilation(ConsumerHungry(consumer1, eatCalories , currentCalories, population2));
	}
}
