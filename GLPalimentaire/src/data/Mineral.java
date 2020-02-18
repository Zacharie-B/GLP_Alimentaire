package data;


public class Mineral {
	private int mineralMass;
	private Position cordinates;
	
	public Mineral(int mineralMass, Position cordinates) {
		super();
		setCordinates(cordinates);
		setMineralMass(mineralMass);
	}

	public int getMineralMass() {
		return mineralMass;
	}

	public void setMineralMass(int mineralMass) {
		this.mineralMass = mineralMass;
	}
	public Position getCordinates() {
		return cordinates;
	}
	public void setCordinates(Position cordinate) {
		this.cordinates = cordinate;
	}
}
