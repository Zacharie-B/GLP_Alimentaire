package movementOfSpecies;

import data.Position;

public class InitialPosition {
	
	
	public Position[] initPosition;
	private static final int NBMAXSPECIES=1000;
	
	
	
	public InitialPosition() {
		InitPosition();
	}



	public void InitPosition(){
		initPosition = new Position[NBMAXSPECIES];
		for(int i=0; i<NBMAXSPECIES; i++) {
			int randomcordinatesx=(int)(Math.random() *18);
			int randomcordinatesy=(int)(Math.random() *12);
			Position cordinates = new Position(randomcordinatesx,randomcordinatesy);
			initPosition[i]=cordinates;
		}
	}
	
}
