package movementOfSpecies;

import data.Position;

public class SavannaMovement extends MovementPosition{

	public void SavannaMoveLeft(Position position) {
		if (position.getX()==0) {
			MoveRight(position);
		}
		else {
			MoveLeft(position);
		}
	}
	
	public void SavannaMoveRight(Position position) {
		if (position.getX()==19) {
			MoveLeft(position);
		}
		else {
			MoveRight(position);
		}
	}
	
	public void SavannaMoveTop(Position position) {
		if (position.getY()==19) {
			MoveBot(position);
		}
		else {
			MoveTop(position);
		}
	}
	
	public void SavannaMoveBot(Position position) {
		if (position.getY()==0) {
			MoveTop(position);
		}
		else {
			MoveBot(position);
		}
	}
}
