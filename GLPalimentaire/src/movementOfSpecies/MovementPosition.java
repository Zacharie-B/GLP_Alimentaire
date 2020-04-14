package movementOfSpecies;

import data.Consumer;

public class MovementPosition {

	public int MoveLeft(Consumer consumer) {
		int x=consumer.getCordinates().getX();
		x--;
		return x;
	}
	
	public int MoveRight(Consumer consumer) {
		int x=consumer.getCordinates().getX();
		x++;
		return x;
	}
	
	public int MoveTop(Consumer consumer) {
		int y=consumer.getCordinates().getY();
		y++;
		return y;
	}
	
	public int MoveBot(Consumer consumer) {
		int y=consumer.getCordinates().getY();
		y--;
		return y;
	}
	
	
}
