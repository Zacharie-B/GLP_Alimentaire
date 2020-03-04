package movementOfSpecies;

import data.Position;
import data.Species;

public class InitialPosition {
	
	
	public Position[] initPosition;
	private static final int NBMAXSPECIES=500;
	
	
	
	public InitialPosition() {
		InitPosition();
	}



	public void InitPosition(){
		initPosition = new Position[NBMAXSPECIES];
		for(int i=0; i<NBMAXSPECIES; i++) {
			int randomcordinatesx=(int)(Math.random() *20);
			int randomcordinatesy=(int)(Math.random() *10);
			Position cordinates = new Position(randomcordinatesx,randomcordinatesy);
			initPosition[i]=cordinates;
		}
	}
	
}
