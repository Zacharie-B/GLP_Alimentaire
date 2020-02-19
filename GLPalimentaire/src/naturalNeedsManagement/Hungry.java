package naturalNeedsManagement;

import data.Consumer;

public class Hungry {

	
	public Hungry () {
		
	}
	/**
	 * 
	 * @param time : time since last lunch
	 * @param limitedTime : time limit before it loses HP
	 * @param consumer
	 * @return consumer
	 */
	public Consumer hungry(int time, int limitedTime, Consumer consumer) {
		if(time > limitedTime) {
			int c= consumer.getHp();
			c=c-1;
			consumer.setHp(c);
		}
		return consumer;
	}
}
