package movementOfSpecies;

import data.Position;

public class MovementPosition {

	public void MoveLeft(Position position) {
		int x=position.getX();
		x--;
		position.setX(x);
	}
	
	public void MoveRight(Position position) {
		int x=position.getX();
		x++;
		position.setX(x);
	}
	
	public void MoveTop(Position position) {
		int y=position.getY();
		y++;
		position.setY(y);
	}
	
	public void MoveBot(Position position) {
		int y=position.getY();
		y--;
		position.setY(y);
	}
}
