package naturalNeedsManagement;

import data.Consumer;
import data.Producer;

public class EnoughCalories{
	
	
	public void ProducerHungry(Producer producer, int mineralMass) {
		int mineralsNeeds = producer.getRateMineral();
		@SuppressWarnings("unused")
		int currentMineralRate=0;
		int i=0;
		if (mineralsNeeds > mineralMass) {
			if(mineralMass!=0) {
				currentMineralRate+=mineralMass;
			}
			else if(i==5) {
				int currentHP=producer.getHP();
				currentHP--;
				producer.setHP(currentHP);
				i=0;
			}
			else {
				i++;
			}
		}
		
	}
	
	@SuppressWarnings("unused")
	public void ConsumerHungry(Consumer consumer, int calories) {
		int caloriesNeeds = consumer.getCalories();
		int i=0, currentCalories=0;
		if(caloriesNeeds > calories) {
			if (calories!=0) {
				currentCalories+=calories;
			}
			else if(i==5) {
				int currentHP=consumer.getHp();
				currentHP--;
				consumer.setHp(currentHP);
			}
			else {
				i++;
			}
		}
	}
}