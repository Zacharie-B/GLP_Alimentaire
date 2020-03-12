package beingManagement;

import java.util.HashMap;

import data.*;


public class BeingCreator {
	public static final int ALL_POINTS= 200;
	private static BeingCreator instance = new BeingCreator();
	private HashMap <String,Species[]> animalsInThisEcosystem = new HashMap <String,Species[]>();
	
	public static BeingCreator getInstance() {
		return instance;
	}
	
	public void register(String species, Species[] speciesTable) {
		animalsInThisEcosystem.put(species, speciesTable);
	}
	private BeingCreator() {
	
	}
	
	public Species[] getTable(String name) {
		if (animalsInThisEcosystem.containsKey(name)) {
			return animalsInThisEcosystem.get(name);
		} else {
			return null;
		}
	}
}
