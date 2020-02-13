package hpManagement;

public class TestConsumerMovement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConsumerMovement consumermv = new ConsumerMovement();
		System.out.println(consumermv.toString());
		
		System.out.println("Affichage des caractéristiques de l'animal après s'être faite mangé");
		consumermv.EatIfPossible();
		System.out.println(consumermv.toString());
		
	}

}
