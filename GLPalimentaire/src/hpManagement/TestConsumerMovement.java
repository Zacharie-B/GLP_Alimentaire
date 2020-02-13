package hpManagement;

public class TestConsumerMovement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConsumerMovement consumermv = new ConsumerMovement();
		System.out.println(consumermv.toString());
		
		System.out.println("\nDisplay of characteristics after being eaten");
		consumermv.EatIfPossible();
		System.out.println(consumermv.toString());
		
	}

}
