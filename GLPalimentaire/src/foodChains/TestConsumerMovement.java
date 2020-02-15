package foodChains;

public class TestConsumerMovement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SavannaEcosystem consumermv = new SavannaEcosystem();
		System.out.println(consumermv.toString());
		
		System.out.println("\nDisplay of characteristics after being eaten");
		consumermv.FirstChain();
		System.out.println(consumermv.toString());
		
	}

}
