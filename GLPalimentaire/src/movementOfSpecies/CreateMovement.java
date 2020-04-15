package movementOfSpecies;


import data.Consumer;
import data.Position;
import data.Species;

public class CreateMovement extends MovementOnMap{
	
	public CreateMovement (){
		
	}
	
	public Position SavannaMouvement (Species species) {
		Position initPosition = species.getCordinates();
		if(species.getIsAlive()==true) {
		int c=0;
		Position position = species.getCordinates();
        // Pour obtenir une valeur entière non nulle, il faut multiplier le
        // nombre aléatoire avec un nombre supérieur 0 avant la conversion.
        // Par exemple, la multiplication par 5 donnera au final un nombre
        // entier égal à 0, 1, 2, 3.
        // génération d'un entier >= 0 et < 4
        int n = (int)(Math.random() * 4);
        
        switch(n) {
        case 0 :
        	c=SavannaMoveRight(species);
        	position.setX(c); 
        	return species.getCordinates();
        case 1 : 
        	c=SavannaMoveLeft(species);
        	position.setX(c); 
        	return species.getCordinates();
        case 2 : 
        	c=SavannaMoveTop(species);
        	position.setY(c); 
        	return species.getCordinates();
        case 3 :
        	c=SavannaMoveBot(species);
        	position.setY(c); 
        	return species.getCordinates();
        }
		}
        return initPosition;
	}
	public Position HuntingMovement(Consumer predator,String management) {
		Position initposition = predator.getCordinates();
		int c=0;
		switch(management) {
        case "right" :
        	c=SavannaMoveRight(predator);
        	initposition.setX(c); 
        	return predator.getCordinates();
        case "left" : 
        	c=SavannaMoveLeft(predator);
        	initposition.setX(c); 
        	return predator.getCordinates();
        case "top" : 
        	c=SavannaMoveTop(predator);
        	initposition.setY(c); 
        	return predator.getCordinates();
        case "bot" :
        	c=SavannaMoveBot(predator);
        	initposition.setY(c); 
        	return predator.getCordinates();
        }
        return initposition;
	}
	
}
