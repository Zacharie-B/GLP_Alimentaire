package movementOfSpecies;


import data.Consumer;
import data.Position;

public class CreateMovement extends MovementOnMap{
	
	public CreateMovement (){
		
	}
	
	public Position SavannaMouvement (Consumer consumer) {
		Position initPosition = consumer.getCordinates();
		if(consumer.getIsAlive()==true) {
		int c=0;
		Position position = consumer.getCordinates();
        // Pour obtenir une valeur entière non nulle, il faut multiplier le
        // nombre aléatoire avec un nombre supérieur 0 avant la conversion.
        // Par exemple, la multiplication par 5 donnera au final un nombre
        // entier égal à 0, 1, 2, 3.
        // génération d'un entier >= 0 et < 4
        int n = (int)(Math.random() * 4);
        
        switch(n) {
        case 0 :
        	c=SavannaMoveRight(consumer);
        	position.setX(c); 
        	return consumer.getCordinates();
        case 1 : 
        	c=SavannaMoveLeft(consumer);
        	position.setX(c); 
        	return consumer.getCordinates();
        case 2 : 
        	c=SavannaMoveTop(consumer);
        	position.setY(c); 
        	return consumer.getCordinates();
        case 3 :
        	c=SavannaMoveBot(consumer);
        	position.setY(c); 
        	return consumer.getCordinates();
        }
		}
        return initPosition;
	}
	
}
