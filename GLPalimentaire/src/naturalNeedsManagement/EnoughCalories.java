package naturalNeedsManagement;

import data.Consumer;
import data.Producer;

public class EnoughCalories{
	
	
	public int ProducerHungry(Producer producer, int mineralMass, int currentMineralRate) {
		int mineralsNeeds = producer.getRateMineral();
		if(mineralsNeeds > mineralMass) {
			int currentHP=producer.getHP();
			currentHP+=5;
			producer.setHP(currentHP);
			currentMineralRate+=mineralMass;
			return currentMineralRate;
			}
			
		return currentMineralRate;
	}
	
	public int ConsumerHungry(Consumer consumer, int calories, int currentCalories) {
		int caloriesNeeds = consumer.getCalories();
		if(caloriesNeeds > calories) {
			int currentHP=consumer.getHp();
			currentHP+=5;
			consumer.setHp(currentHP);
			currentCalories+=calories;
			return currentCalories;
			}
		return currentCalories;
	}
}