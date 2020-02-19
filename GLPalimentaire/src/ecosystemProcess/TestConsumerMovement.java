package ecosystemProcess;

public class TestConsumerMovement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SavannaEcosystem consumermv = new SavannaEcosystem();
		//System.out.println(consumermv.toString());
		
		//System.out.println("\nDisplay of characteristics after being eaten");
		//consumermv.FirstChain();
		//consumermv.SecondChain();
		//System.out.println(consumermv.toString());
		
		SavannaEcosystem lakechain= new SavannaEcosystem();
		System.out.println(lakechain.toString());
		lakechain.HungryConsumer();
		System.out.println("\nDisplay of characteristics after being eaten");
		System.out.println(lakechain.toString());
	}

}
