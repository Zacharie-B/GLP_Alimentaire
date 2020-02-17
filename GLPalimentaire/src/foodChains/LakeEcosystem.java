package foodChains;

import java.util.ArrayList;

import data.producersdata.Phytoplanckton;
import data.primaryConsumerdata.Zooplanckton;
import data.Position;
import data.primaryConsumerdata.Crustacean;
import data.secondaryConsumerdata.Cyprinid;
import data.tertiaryConsumerdata.Pike;
import data.tertiaryConsumerdata.Sheatfish;

/**
 * 
 * @author HP
 * represents the different food chains in the LakeEcosystem
 */
public class LakeEcosystem extends FoodChains{
	private Position position = new Position(2,5);
	private Phytoplanckton phytoplanckton = new Phytoplanckton("phytoplanckton",true,1000,100,1,3,2,1,1,position);
	private Zooplanckton zooplanckton = new Zooplanckton("zooplanckton",4,5,true,500,100,1,5,1,false,position); 
	private Crustacean crustacean = new Crustacean("crustacean",6,20,true,50,10,3,20,2,false,position); 
	private Cyprinid cyprinid = new Cyprinid("cyprinid",8,100,true,3,10,8,100,4,false,position); 
	private Pike pike = new Pike("pike",10,200,true,2,10,10,200,5,false,position); 
	private Sheatfish sheatfish = new Sheatfish("sheatfish",10,250,true,1,10,10,250,5,false,position); 
	private ArrayList <String> phytoplancktonEatenBy;
	private ArrayList <String> zooplancktonEatenBy;
	private ArrayList <String> crustaceanEatenBy;
	private ArrayList <String> cyprinidEatenBy;
	
	public LakeEcosystem(){
		phytoplancktonEatenBy= new ArrayList <String> ();
		zooplancktonEatenBy= new ArrayList <String> ();
		crustaceanEatenBy= new ArrayList <String> ();
		cyprinidEatenBy= new ArrayList <String> ();
	}
	
	public FoodChains FirstChain() {
		FirstTrophicLevel(phytoplanckton, zooplanckton, phytoplancktonEatenBy);
		FirstTrophicLevel(phytoplanckton, crustacean, phytoplancktonEatenBy);
		SecondTrophicLevel(zooplanckton, cyprinid, zooplancktonEatenBy);
		SecondTrophicLevel(crustacean, cyprinid, crustaceanEatenBy);
		ThirdTrophicLevel(cyprinid, pike, cyprinidEatenBy);
		ThirdTrophicLevel(cyprinid, sheatfish, cyprinidEatenBy);
		return null;	
	}

	@Override
	public String toString() {
		return "LakeEcosystem [position=" + position + ", \nphytoplanckton=" + phytoplanckton.getHP() + ", \nzooplanckton="
				+ zooplanckton.getHp() + ", \ncrustacean=" + crustacean.getHp() + ", \ncyprinid=" + cyprinid.getHp() + ", \npike=" 
				+ pike.getHp() + ", \nsheatfish=" + sheatfish.getHp() +"]";
	}
	
}
