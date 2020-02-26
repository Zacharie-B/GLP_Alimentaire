package movementOfSpecies;

import data.Position;

public class MovementPosition {

	public MovementPosition(int size) {
	}

	public void moveleft(Position position) {
		int x=position.getX();
		x--;
		position.setX(x);
	}
	
	public void moveright(Position position) {
		int x=position.getX();
		x++;
		position.setX(x);
	}
	
	public void movetop(Position position) {
		int y=position.getY();
		y++;
		position.setY(y);
	}
	
	public void movebot(Position position) {
		int y=position.getY();
		y--;
		position.setY(y);
	}
}
