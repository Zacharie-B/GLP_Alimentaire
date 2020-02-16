package foodChains;

import java.util.ArrayList;

import data.Position;
import data.primaryConsumerdata.Clam;
import data.primaryConsumerdata.MuskOx;
import data.producersdata.Foam;
import data.producersdata.Grass;
import data.secondaryConsumerdata.ArcticWolf;
import data.secondaryConsumerdata.Phoque;
import data.tertiaryConsumerdata.Inuit;
import data.tertiaryConsumerdata.PolarBear;

public class FrostyEcosystem extends FoodChains{
	private Position position = new Position(8,8);
	private Grass grass = new Grass("grass",true,100,10,2,3,5,1,4,position);
	private MuskOx muskOx = new MuskOx("muskOx", 3, 100, true, 10, 100, 10, 10, 3, false, position);
	private ArcticWolf arcticWolf = new ArcticWolf ("arcticWolf",4, 150, true, 5, 15, 4, 30, 6, false, position);
	private Inuit inuit = new Inuit ("inuit",10, 1000, true, 1, 1, 50, 150, 6, false, position);
	private Foam foam = new Foam("foam",true,100,10,2,3,5,1,4,position);
	private Clam clam = new Clam("clam", 3, 100, true, 10, 100, 10, 10, 3, false, position);
	private Phoque phoque = new Phoque("phoque",4, 150, true, 5, 15, 4, 30, 6, false, position);
	private PolarBear polarBear = new PolarBear ("polarBear",10, 1000, true, 1, 1, 50, 150, 6, false, position);
	private ArrayList <String> grassEatenBy;
	private ArrayList <String> muskOxEatenBy;
	private ArrayList <String> arcticWolfEatenBy;
	private ArrayList <String> foamEatenBy;
	private ArrayList <String> clamEatenBy;
	private ArrayList <String> phoqueEatenBy;
	
	
	
	public FoodChains FirstChain() {
		FirstTrophicLevel(grass, muskOx, grassEatenBy);
		SecondTrophicLevel(muskOx, arcticWolf, muskOxEatenBy);
		ThirdTrophicLevel(arcticWolf, inuit, arcticWolfEatenBy);
		return null;	
	}
	
	public FoodChains SecondChain() {
		FirstTrophicLevel(foam, clam, foamEatenBy);
		SecondTrophicLevel(clam, phoque, clamEatenBy);
		ThirdTrophicLevel(arcticWolf,inuit,arcticWolfEatenBy);
		ThirdTrophicLevel(phoque, polarBear, phoqueEatenBy);
		return null;
	}
	@Override
	public String toString() {
		String result = "species : (" +grass.getName()+", "+ grass.getHP() +"," +grass.getIsAlive()+")";
		result += "\nspecies : (" +muskOx.getName()+", "+ muskOx.getHp() + "," +muskOx.getIsAlive()+")";
		result += "\nspecies : (" +arcticWolf.getName()+", "+ arcticWolf.getHp() + "," +arcticWolf.getIsAlive()+")";
		result += "\nspecies : ("+inuit.getName()+", "+ inuit.getHp() +"," +inuit.getIsAlive()+")";
		result += "\nspecies : (" +foam.getName()+", "+ foam.getHP() + "," +foam.getIsAlive()+")";
		result += "\nspecies : (" +clam.getName()+", "+ clam.getHp() + "," +clam.getIsAlive()+")";
		result += "\nspecies : ("+phoque.getName()+", "+ phoque.getHp() + "," +phoque.getIsAlive()+")";
		result += "\nspecies : ("+polarBear.getName()+", "+ polarBear.getHp() +"," +polarBear.getIsAlive()+")";
		return result;
	}
}
