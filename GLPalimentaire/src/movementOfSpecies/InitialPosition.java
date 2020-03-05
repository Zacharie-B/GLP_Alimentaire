package movementOfSpecies;

import data.Position;

public class InitialPosition {
	
	
	public Position[] initPosition;
	private static final int NBMAXSPECIES=500;
	
	
	
	public InitialPosition() {
		InitPosition();
	}



	public void InitPosition(){
		initPosition = new Position[NBMAXSPECIES];
		for(int i=0; i<11; i++) {
			int randomcordinatesx=(int)(Math.random() *15);
			int randomcordinatesy=(int)(Math.random() *10);
			Position cordinates = new Position(randomcordinatesx,randomcordinatesy);
			initPosition[i]=cordinates;
		}
	}
	
}
