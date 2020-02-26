package ecosystemProcess;

import data.Position;
import data.secondaryConsumerdata.Cheetah;

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
		System.out.println("\nDisplay of characteristics after being eaten");
		System.out.println(lakechain.toString());
		System.out.println("\nDisplay of characteristics after being eaten");
		System.out.println(lakechain.toString());
		System.out.println("Position and diet of a cheetah : ");
		Cheetah ch = new Cheetah("cheetah",10, 100, true, 1, 1, 50, 150, 6, false, new Position (0,3));
		System.out.println(ch.getCordinates());
		System.out.println(ch.getDiet());
	}

}
