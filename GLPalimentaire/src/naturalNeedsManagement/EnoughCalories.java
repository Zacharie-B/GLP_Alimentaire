package naturalNeedsManagement;

import data.Consumer;

public class EnoughCalories{
	
	
	public int ConsumerHungry(Consumer consumer, int calories, int currentCalories) {
		int caloriesNeeds = consumer.getCalories();
		if(caloriesNeeds > calories) {
			int currentHP=consumer.getHp();
			currentHP+=6;
			consumer.setHp(currentHP);
			currentCalories+=calories;
			return currentCalories;
			}
		return currentCalories;
	}
}