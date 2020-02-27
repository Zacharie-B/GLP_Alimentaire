package movementOfSpecies;

import data.Position;

public class SavannaMovement extends MovementPosition{

	public static int SavannaMoveLeft(Position position) {
		int c;
		if (position.getX()==0) {
			c=MoveRight(position);
		}
		else {
			c=MoveLeft(position);
		}
		return c;
	}
	
	public static int SavannaMoveRight(Position position) {
		int c;
		if (position.getX()==19) {
			c=MoveLeft(position);
		}
		else {
			c=MoveRight(position);
		}
		return c;
	}
	
	public static int SavannaMoveTop(Position position) {
		int c;
		if (position.getY()==19) {
			c=MoveBot(position);
		}
		else {
			c=MoveTop(position);
		}
		return c;
	}
	
	public static int SavannaMoveBot(Position position) {
		int c;
		if (position.getY()==0) {
			c=MoveTop(position);
		}
		else {
			c=MoveBot(position);
		}
		return c;
	}
}
