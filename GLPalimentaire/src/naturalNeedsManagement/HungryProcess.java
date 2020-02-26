package naturalNeedsManagement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

import data.Consumer;
import data.Position;
import data.Producer;

public class HungryProcess extends EnoughCalories{
	
	private static int currentCalories=0;
	private static int currentMineralRate=0;
	
	public HungryProcess(){
		
	}
	
	public void HungryProcessProducer(Producer producer, HashMap <Position,Integer> mineralMass, Position cordinates) {
		int mineralmass=0;
		boolean continueList=true;
		Set<Entry<Position, Integer>> setHm = mineralMass.entrySet();
			Iterator<Entry<Position, Integer>> it = setHm.iterator();
			while(it.hasNext()&&continueList!=false){
				Entry<Position, Integer> e = it.next();
				if(mineralMass.containsKey(cordinates)) {
					mineralmass =e.getValue();
					continueList=false;
				} 
		producer.setMineralAssimilation(ProducerHungry(producer, mineralmass , currentMineralRate));
	}
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
