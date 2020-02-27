package movementOfSpecies;

import data.Position;
import data.Species;

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
	
	public Species getAssociatedBeing(Position position, Species being) {		
		return being;
	}
	
}
