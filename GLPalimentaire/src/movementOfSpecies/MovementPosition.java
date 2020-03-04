package movementOfSpecies;

import data.Consumer;

public class MovementPosition {

	public static int MoveLeft(Consumer consumer) {
		int x=consumer.getCordinates().getX();
		x--;
		return x;
	}
	
	public static int MoveRight(Consumer consumer) {
		int x=consumer.getCordinates().getX();
		x++;
		return x;
	}
	
	public static int MoveTop(Consumer consumer) {
		int y=consumer.getCordinates().getY();
		y++;
		return y;
	}
	
	public static int MoveBot(Consumer consumer) {
		int y=consumer.getCordinates().getY();
		y--;
		return y;
	}
	
	
}
