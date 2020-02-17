package movementOfSpecies;

import data.Position;

public class MovementPosition {
	public Position[] positions;
	private int currentSize = 0;

	public MovementPosition(int size) {
		positions = new Position[size];
	}

	public void add(Position position) {
		if (currentSize != positions.length) {
			positions[currentSize] = position;
			currentSize++;
		}
	}

	/**public void move(int dx, int dy) {
		*for (int index = 0; index < currentSize; index++) {
		*	position osition = Positions[index];
		*	position.move(dx, dy);
		*}
	*}
	*/
	
	public String toString() {
		String result = "Plan :";
		for (int index = 0; index < currentSize; index++) {
			Position position = positions[index];
			result += "(" + position.toString() + ") ";
		}
		return result;
	}
}
