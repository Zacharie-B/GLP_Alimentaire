package ecosystemProcess;

import java.util.ArrayList;

import data.primaryConsumerdata.Giraffe;
import data.Position;
import data.primaryConsumerdata.Buffalo;
import data.primaryConsumerdata.Gazelle;
import data.producersdata.Acacia;
import data.producersdata.Bush;
import data.producersdata.Grass;
import data.primaryConsumerdata.Warthog;
import data.primaryConsumerdata.Zebra;
import data.secondaryConsumerdata.Cheetah;
import data.secondaryConsumerdata.Hyena;
import data.tertiaryConsumerdata.Lion;
import foodChains.FoodChains;

/**
 * 
 * @author HP
 * represents the different food chains in the SavannaEcosystem
 */
public class SavannaEcosystem extends FoodChains{
	private Position position = new Position(8,8);
	private Grass grass = new Grass("grass",true,100,10,2,3,5,1,4,position);
	private Gazelle gazelle = new Gazelle("gazelle", 3, 100, true, 10, 1, 10, 100, 3, false, position);
	private Warthog warthog = new Warthog ("warthog",4, 150, true, 5, 15, 4, 30, 6, false, position);
	private Cheetah cheetah = new Cheetah ("cheetah",10, 1000, true, 1, 1, 50, 150, 6, false, position);
	private Bush bush = new Bush("bush",true,100,10,2,3,5,1,4,position);
	private Buffalo buffalo = new Buffalo("buffalo", 3, 100, true, 10, 100, 10, 10, 3, false, position);
	private Zebra zebra = new Zebra("zebra",4, 150, true, 5, 15, 4, 30, 6, false, position);
	private Hyena hyena = new Hyena ("hyena",10, 1000, true, 1, 1, 50, 150, 6, false, position);
	private Acacia acacia = new Acacia("grass",true,100,10,2,3,5,1,4,position);
	private Giraffe giraffe = new Giraffe("giraffe", 3, 100, true, 10, 100, 10, 10, 3, false, position);
	private Lion lion = new Lion ("lion",10, 1000, true, 1, 1, 50, 150, 6, false, position);
	private ArrayList <String> grassEatenBy;
	private ArrayList <String> gazelleEatenBy;
	private ArrayList <String> warthogEatenBy;
	private ArrayList <String> cheetahEatenBy;
	private ArrayList <String> bushEatenBy;
	private ArrayList <String> buffaloEatenBy;
	private ArrayList <String> zebraEatenBy;
	private ArrayList <String> hyenaEatenBy;
	private ArrayList <String> acaciaEatenBy;
	private ArrayList <String> giraffeEatenBy;
	
	
	
	
	public FoodChains FirstChain() {
		FirstTrophicLevel(grass, gazelle, grassEatenBy);
		FirstTrophicLevel(grass, warthog, grassEatenBy);
		FirstTrophicLevel(bush, gazelle, bushEatenBy);
		FirstTrophicLevel(bush, warthog, bushEatenBy);
		SecondTrophicLevel(gazelle, cheetah, gazelleEatenBy);
		SecondTrophicLevel(warthog, cheetah, warthogEatenBy);
		ThirdTrophicLevel(cheetah,lion,cheetahEatenBy);
		return null;	
	}
	
	public FoodChains SecondChain() {
		FirstTrophicLevel(grass, buffalo, grassEatenBy);
		FirstTrophicLevel(grass, zebra, grassEatenBy);
		FirstTrophicLevel(bush, buffalo, bushEatenBy);
		FirstTrophicLevel(bush, zebra, bushEatenBy);
		SecondTrophicLevel(buffalo, hyena, buffaloEatenBy);
		SecondTrophicLevel(gazelle, cheetah, gazelleEatenBy);
		SecondTrophicLevel(warthog, cheetah, warthogEatenBy);
		SecondTrophicLevel(zebra, hyena, zebraEatenBy);
		ThirdTrophicLevel(hyena,lion,hyenaEatenBy);
		return null;
	}
	
	public FoodChains ThirdChain() {
		FirstTrophicLevel(acacia, giraffe, acaciaEatenBy);
		SecondTrophicLevel(giraffe, hyena, giraffeEatenBy);
		ThirdTrophicLevel(hyena,lion,hyenaEatenBy);
		return null;
	}
	
	
	@Override
	public String toString() {
		String result = "species : (" +grass.getName()+", "+ grass.getHP() +"," +grass.getIsAlive()+")";
		result += "\nspecies : (" +gazelle.getName()+", "+ gazelle.getHp() + "," +gazelle.getIsAlive()+")";
		result += "\nspecies : (" +warthog.getName()+", "+ warthog.getHp() + "," +warthog.getIsAlive()+")";
		result += "\nspecies : ("+cheetah.getName()+", "+ cheetah.getHp() +"," +cheetah.getIsAlive()+")";
		result += "\nspecies : (" +bush.getName()+", "+ bush.getHP() + "," +bush.getIsAlive()+")";
		result += "\nspecies : (" +buffalo.getName()+", "+ buffalo.getHp() + "," +buffalo.getIsAlive()+")";
		result += "\nspecies : ("+zebra.getName()+", "+ zebra.getHp() + "," +zebra.getIsAlive()+")";
		result += "\nspecies : ("+hyena.getName()+", "+ hyena.getHp() +"," +hyena.getIsAlive()+")";
		result += "\nspecies : (" +gazelle.getName()+", "+ gazelle.getHp() + "," +gazelle.getIsAlive()+")";
		result += "\nspecies : (" +warthog.getName()+", "+ warthog.getHp() + "," +warthog.getIsAlive()+")";
		result += "\nspecies : ("+cheetah.getName()+", "+ cheetah.getHp() +"," +cheetah.getIsAlive()+")";
		result += "\nspecies : (" +acacia.getName()+", "+ acacia.getHP() + "," +acacia.getIsAlive()+")";
		return result;
	}

}
