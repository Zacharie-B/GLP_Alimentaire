package movementOfSpecies;

import data.Species;

public class MovementPosition {

	public int MoveLeft(Species species) {
		int x=species.getCordinates().getX();
		x--;
		return x;
	}
	
	public int MoveRight(Species species) {
		int x=species.getCordinates().getX();
		x++;
		return x;
	}
	
	public int MoveTop(Species species) {
		int y=species.getCordinates().getY();
		y++;
		return y;
	}
	
	public int MoveBot(Species species) {
		int y=species.getCordinates().getY();
		y--;
		return y;
	}
	
	
}
