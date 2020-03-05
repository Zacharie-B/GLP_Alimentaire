package tests;

import ecosystemProcess.*;



public class ManagementTest{
	public static void main(String[] args) {
				//SavannaEcosystem consumermv = new SavannaEcosystem();
				//System.out.println(consumermv.toString());
				//System.out.println("\nDisplay of characteristics after being eaten");
				//consumermv.FirstChain();
				//consumermv.SecondChain();
				//System.out.println(consumermv.toString());
				
				
				SavannaEcosystem lakechain= new SavannaEcosystem();
				System.out.println("\nDisplay of characteristics after movement");
				System.out.println(lakechain.toString());
				
				boolean finish = false;
				while (finish==false) {
					lakechain.ConsumerMovement();
					System.out.println(lakechain.toString());
					try {
						Thread.sleep(500);
					}
					catch (InterruptedException e){
						System.out.println(e.getMessage());
					}
				}
	}

}
