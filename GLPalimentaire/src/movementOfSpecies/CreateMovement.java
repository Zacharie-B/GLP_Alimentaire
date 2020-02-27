package movementOfSpecies;

import data.Position;

public class CreateMovement extends SavannaMovement{
	private Position cordinates = new Position(2,15);
	
	public CreateMovement (){
		
	}
	
	public void SavannaMouvement (Position cordinates) {
        // Pour obtenir une valeur entière non nulle, il faut multiplier le
        // nombre aléatoire avec un nombre supérieur 0 avant la conversion.
        // Par exemple, la multiplication par 5 donnera au final un nombre
        // entier égal à 0, 1, 2, 3.
        // génération d'un entier >= 0 et < 4
        int n = (int)(Math.random() * 4);
        
        switch(n) {
        case 0 :
        	SavannaMoveRight(cordinates);
        	break; 
        case 1 : 
        	SavannaMoveLeft(cordinates);
        	break;
        case 2 : 
        	SavannaMoveTop(cordinates);
        	break;
        case 3 :
        	SavannaMoveBot(cordinates);
        	break;
        }	
	}
}
