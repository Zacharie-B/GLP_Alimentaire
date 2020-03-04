package naturalNeedsManagement;

import java.util.HashMap;

import data.Position;

public class MineralChange {
	/**
	 * This {@link HashMap} contains all registered variable values. The key is
	 * variable name (unique) and the value is the current variable's value.
	 */
	public HashMap<Position, Integer> valuesInCase;

	/**
	 * The unique instance of the class prepared in an eager way (object created
	 * at beginning).
	 */
	private static MineralChange instance = new MineralChange();

	/**
	 * Private constructor ensuring no access from outside of the class.
	 */
	private MineralChange() {

	}

	/**
	 * Static method allows users to get the unique instance of the class.
	 * 
	 * @return the unique instance of the class.
	 */
	public static MineralChange getInstance() {
		return instance;
	}

	/**
	 * To register the value for a variable, we specify the variable name and
	 * the expected current value for the variable. If there is already a
	 * registered value for the variable with this name, the old value will be
	 * replaced by the new one.
	 * 
	 * @param name
	 *            the name of the variable for which we wish to register the
	 *            (new) value
	 * @param value
	 *            the value for the variable
	 * @deprecated Use {@link #addMineral(Position,int)} instead
	 */
	public void register(Position cordinates, int value) {
		addMineral(cordinates, value);
	}

	/**
	 * To register the value for a variable, we specify the variable name and
	 * the expected current value for the variable. If there is already a
	 * registered value for the variable with this name, the old value will be
	 * replaced by the new one.
	 * 
	 * @param name
	 *            the name of the variable for which we wish to register the
	 *            (new) value
	 * @param value
	 *            the value for the variable
	 */
	public void addMineral(Position cordinates, int value) {
		valuesInCase.put(cordinates, value);
	}

	/**
	 * Gets the value for a registered variable. If the variable with the
	 * specified name does not exist in the repository, the method returns 0.
	 * 
	 * @param name
	 *            the name of the variable
	 * @return the current registered value for the variable
	 */
	public int getValue(Position cordinates) {
		if (valuesInCase.containsKey(cordinates)) {
			return valuesInCase.get(cordinates);
		} else {
			return 0;
		} 	
	}
}
