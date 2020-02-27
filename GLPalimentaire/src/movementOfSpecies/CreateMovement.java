package movementOfSpecies;


import data.Consumer;
import data.Position;

public class CreateMovement extends SavannaMovement{
	
	public CreateMovement (){
		
	}
	
	public static void SavannaMouvement (Consumer consumer) {
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
        	c=SavannaMoveRight(consumer.getCordinates());
        	position.setX(c); 
        	consumer.setCordinates(position);
        	break; 
        case 1 : 
        	c=SavannaMoveLeft(consumer.getCordinates());
        	position.setX(c); 
        	consumer.setCordinates(position);
        	break;
        case 2 : 
        	c=SavannaMoveTop(consumer.getCordinates());
        	position.setY(c); 
        	consumer.setCordinates(position);
        	break;
        case 3 :
        	c=SavannaMoveBot(consumer.getCordinates());
        	position.setY(c); 
        	consumer.setCordinates(position);
        	break;
        }	
	}
}
