package naturalNeedsManagement;

import data.Consumer;

public class EnoughCalories{
	
	
	public int ConsumerHungry(Consumer consumer, int calories, int currentCalories, int population) {
		int caloriesNeeds = consumer.getCalories();
		int alreadyEaten = consumer.getCaloriesAssimilation();
		if(population>=consumer.getPopulationDensity()) {
			if(caloriesNeeds <= (calories+alreadyEaten)) {
				int currentHP=consumer.getHp();
				currentHP+=10;
				consumer.setHp(currentHP);
				currentCalories=0;
				return currentCalories;
				}
			else if (caloriesNeeds > (calories+alreadyEaten)) {
				currentCalories+=calories;
				return currentCalories;
			}
		}
		else {
			float shareFood= population/consumer.getPopulationDensity();
			if(caloriesNeeds <= (calories+alreadyEaten)*shareFood) {
				int currentHP=consumer.getHp();
				currentHP+=10;
				consumer.setHp(currentHP);
				currentCalories=0;
				return currentCalories;
				}
			else if (caloriesNeeds > (calories+alreadyEaten)*shareFood) {
				currentCalories+=calories*shareFood;
				return currentCalories;
			}
		}
		return currentCalories;
	}
}