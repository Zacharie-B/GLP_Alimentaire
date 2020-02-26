package naturalNeedsManagement;

import data.Consumer;
import data.Producer;

public class EnoughCalories{
	
	
	public int ProducerHungry(Producer producer, int mineralMass, int currentMineralRate) {
		int mineralsNeeds = producer.getRateMineral();
		int i=0;
		while ((mineralsNeeds > mineralMass)) {
			if(mineralMass!=0) {
				currentMineralRate+=mineralMass;
				return currentMineralRate;
			}
			else if(i==5) {
				int currentHP=producer.getHP();
				currentHP--;
				producer.setHP(currentHP);
				i=0;
				currentMineralRate=0;
				return currentMineralRate;
			}
			else {
				i++;
			}
		}
		return currentMineralRate;
		
	}
	
	public int ConsumerHungry(Consumer consumer, int calories, int currentCalories) {
		int caloriesNeeds = consumer.getCalories();
		int i=0;
		while ((caloriesNeeds > calories)) {
			if (calories!=0) {
				currentCalories+=calories;
				return currentCalories;
			}
			else if(i==5) {
				i=0;
				int currentHP=consumer.getHp();
				currentHP--;
				consumer.setHp(currentHP);
				currentCalories=0;
				return currentCalories;
			}
			else {
				i++;
			}
		}
		
		return currentCalories;
	}
}