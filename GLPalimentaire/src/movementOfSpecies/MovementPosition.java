package movementOfSpecies;

import data.Position;

public class MovementPosition {

	public static int MoveLeft(Position position) {
		int x=position.getX();
		x--;
		return x;
	}
	
	public static int MoveRight(Position position) {
		int x=position.getX();
		x++;
		return x;
	}
	
	public static int MoveTop(Position position) {
		int y=position.getY();
		y++;
		return y;
	}
	
	public static int MoveBot(Position position) {
		int y=position.getY();
		y--;
		return y;
	}
	
	
}
