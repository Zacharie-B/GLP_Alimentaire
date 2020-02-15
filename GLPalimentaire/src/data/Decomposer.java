package data;

public abstract class Decomposer implements Species{
	private String name;
	private int organicMass;
	private int populationDensity;
	private Point cordinates;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Point getCordinates() {
		return cordinates;
	}
	public void setCordinates(Point cordinates) {
		this.cordinates = cordinates;
	}
	public int getOrganicMass() {
		return organicMass;
	}
	public void setOrganicMass(int organicMass) {
		this.organicMass = organicMass;
	}
	public int getPopulationDensity() {
		return populationDensity;
	}
	public void setPopulationDensity(int populationDensity) {
		this.populationDensity = populationDensity;
	}
}
