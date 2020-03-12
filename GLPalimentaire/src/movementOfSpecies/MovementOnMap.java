package movementOfSpecies;

import data.Consumer;

public class MovementOnMap extends MovementPosition{

	public static int SavannaMoveLeft(Consumer consumer) {
		int c;
		if (consumer.getCordinates().getX()==0) {
			c=MoveRight(consumer);
		}
		else {
			c=MoveLeft(consumer);
		}
		return c;
	}
	
	public static int SavannaMoveRight(Consumer consumer) {
		int c;
		if (consumer.getCordinates().getX()==29) {
			c=MoveLeft(consumer);
		}
		else {
			c=MoveRight(consumer);
		}
		return c;
	}
	
	public static int SavannaMoveTop(Consumer consumer) {
		int c;
		if (consumer.getCordinates().getY()==19) {
			c=MoveBot(consumer);
		}
		else {
			c=MoveTop(consumer);
		}
		return c;
	}
	
	public static int SavannaMoveBot(Consumer consumer) {
		int c;
		if (consumer.getCordinates().getY()==0) {
			c=MoveTop(consumer);
		}
		else {
			c=MoveBot(consumer);
		}
		return c;
	}
}
