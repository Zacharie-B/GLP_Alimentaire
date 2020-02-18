package naturalNeedsManagement;

public class Hungry {

	/*
	 * time : time since last lunch
	 * limitedTime : time limit before it loses HP
	 */
	public Consumer hungry(int time, int limitedTime, Consumer consumer) {
		if(time > limitedTime) {
			consumer.setHp(consumer.getHp()-1);
		}
		return consumer;
	}
}
