package foodChains;

public class TestConsumerMovement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SavannaEcosystem consumermv = new SavannaEcosystem();
		//System.out.println(consumermv.toString());
		
		//System.out.println("\nDisplay of characteristics after being eaten");
		//consumermv.FirstChain();
		//consumermv.SecondChain();
		//System.out.println(consumermv.toString());
		
		SwampsEcosystem lakechain= new SwampsEcosystem();
		System.out.println(lakechain.toString());
		lakechain.FirstChain();
		lakechain.SecondChain();
		System.out.println("\nDisplay of characteristics after being eaten");
		System.out.println(lakechain.toString());
	}

}
