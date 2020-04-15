package movementOfSpecies;

import data.Species;

public class MovementOnMap extends MovementPosition{

	public int SavannaMoveLeft(Species species) {
		int c;
		if (species.getCordinates().getX()==0) {
			c=MoveRight(species);
		}
		else {
			c=MoveLeft(species);
		}
		return c;
	}
	
	public int SavannaMoveRight(Species species) {
		int c;
		if (species.getCordinates().getX()==17) {
			c=MoveLeft(species);
		}
		else {
			c=MoveRight(species);
		}
		return c;
	}
	
	public int SavannaMoveTop(Species species) {
		int c;
		if (species.getCordinates().getY()==11) {
			c=MoveBot(species);
		}
		else {
			c=MoveTop(species);
		}
		return c;
	}
	
	public int SavannaMoveBot(Species species) {
		int c;
		if (species.getCordinates().getY()==0) {
			c=MoveTop(species);
		}
		else {
			c=MoveBot(species);
		}
		return c;
	}
}
