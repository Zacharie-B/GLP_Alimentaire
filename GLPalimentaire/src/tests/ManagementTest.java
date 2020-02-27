package tests;
import data.Position;
import data.primaryConsumerdata.Zebra;
import ecosystemProcess.*;
import movementOfSpecies.CreateMovement;
import movementOfSpecies.MovementPosition;


public class ManagementTest {
	public static void main(String[] args) {
				//SavannaEcosystem consumermv = new SavannaEcosystem();
				//System.out.println(consumermv.toString());
				
				//System.out.println("\nDisplay of characteristics after being eaten");
				//consumermv.FirstChain();
				//consumermv.SecondChain();
				//System.out.println(consumermv.toString());
				Zebra zebra = new Zebra("zebra",4, 150, true, 5, 15, 4, 30, 6, false, new Position(5,8));
				
				SavannaEcosystem lakechain= new SavannaEcosystem();
				System.out.println("\nDisplay of characteristics after movement");
				System.out.println(lakechain.toString());
				System.out.println("Diet of zebra : \n");
				System.out.println(zebra.getDiet());
				System.out.println("Position :\n");
				System.out.println(zebra.getCordinates());
				System.out.println("Move right :\n");
				zebra.getCordinates().setX(MovementPosition.MoveRight(zebra.getCordinates()));
				System.out.println(zebra.getCordinates());
	}

}
