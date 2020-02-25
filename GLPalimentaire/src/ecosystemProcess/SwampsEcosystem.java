package ecosystemProcess;

import java.util.ArrayList;

import data.Position;
import data.primaryConsumerdata.Hippopotamus;
import data.primaryConsumerdata.Monkey;
import data.primaryConsumerdata.Turtle;
import data.producersdata.Bush;
import data.producersdata.FruitTree;
import data.producersdata.Reeds;
import data.secondaryConsumerdata.Anaconda;
import data.secondaryConsumerdata.Chimpanzee;
import data.secondaryConsumerdata.Python;
import data.tertiaryConsumerdata.BlackCaiman;
import data.tertiaryConsumerdata.Jaguar;
import data.tertiaryConsumerdata.SaltCrocodile;
import foodChains.FoodChainsProcess;

/**
 * 
 * @author Zacharie
 * represents the different food chains in the SwampsEcosystem
 */
public class SwampsEcosystem extends FoodChainsProcess{
	private Position position = new Position(8,8);
	private Reeds reeds = new Reeds("reeds",true,100,10,2,3,5,1,4,position);
	private Turtle turtle = new Turtle("turtle", 3, 100, true, 10, 100, 10, 10, 3, false, position);
	private Anaconda anaconda = new Anaconda ("anaconda",4, 150, true, 5, 15, 4, 30, 6, false, position);
	private BlackCaiman blackCaiman = new BlackCaiman ("blackCaiman",10, 1000, true, 1, 1, 50, 150, 6, false, position);
	private FruitTree fruitTree = new FruitTree("fruitTree",true,100,10,2,3,5,1,4,position);
	private Monkey monkey = new Monkey("monkey", 3, 100, true, 10, 100, 10, 10, 3, false, position);
	private Chimpanzee chimpanzee = new Chimpanzee("chimpanzee",4, 150, true, 5, 15, 4, 30, 6, false, position);
	private Jaguar jaguar = new Jaguar ("jaguar",10, 1000, true, 1, 1, 50, 150, 6, false, position);
	private Bush bush = new Bush("reeds",true,100,10,2,3,5,1,4,position);
	private Hippopotamus hippopotamus = new Hippopotamus("hippopotamus", 3, 100, true, 10, 100, 10, 10, 3, false, position);
	private Python python = new Python ("python",4, 150, true, 5, 15, 4, 30, 6, false, position);
	private SaltCrocodile saltCrocodile = new SaltCrocodile ("saltCrocodile",10, 1000, true, 1, 1, 50, 150, 6, false, position);
	private ArrayList <String> reedsEatenBy;
	private ArrayList <String> turtleEatenBy;
	private ArrayList <String> anacondaEatenBy;
	private ArrayList <String> fruitTreeEatenBy;
	private ArrayList <String> monkeyEatenBy;
	private ArrayList <String> chimpanzeeEatenBy;
	private ArrayList <String> bushEatenBy;
	private ArrayList <String> hippopotamusEatenBy;
	private ArrayList <String> pythonEatenBy;
	
	
	public FoodChainsProcess FirstChain() {
		FirstTrophicLevel(reeds, turtle, reedsEatenBy);
		SecondTrophicLevel(turtle, anaconda, turtleEatenBy);
		ThirdTrophicLevel(anaconda, blackCaiman, anacondaEatenBy);
		return null;	
	}
	
	public FoodChainsProcess SecondChain() {
		FirstTrophicLevel(fruitTree, monkey, fruitTreeEatenBy);
		SecondTrophicLevel(monkey, chimpanzee, monkeyEatenBy);
		SecondTrophicLevel(monkey, anaconda, monkeyEatenBy);
		ThirdTrophicLevel(chimpanzee, jaguar, chimpanzeeEatenBy);
		return null;
	}
	
	public FoodChainsProcess ThirdChain() {
		FirstTrophicLevel(bush, hippopotamus, bushEatenBy);
		FirstTrophicLevel(bush, turtle, bushEatenBy);
		SecondTrophicLevel(hippopotamus, python, hippopotamusEatenBy);
		ThirdTrophicLevel(python,saltCrocodile,pythonEatenBy);
		ThirdTrophicLevel(python, blackCaiman, pythonEatenBy);
		return null;
	}
	
	
	@Override
	public String toString() {
		String result = "species : (" +reeds.getName()+", "+ reeds.getHP() +"," +reeds.getIsAlive()+")";
		result += "\nspecies : (" +turtle.getName()+", "+ turtle.getHp() + "," +turtle.getIsAlive()+")";
		result += "\nspecies : (" +anaconda.getName()+", "+ anaconda.getHp() + "," +anaconda.getIsAlive()+")";
		result += "\nspecies : ("+blackCaiman.getName()+", "+ blackCaiman.getHp() +"," +blackCaiman.getIsAlive()+")";
		result += "\nspecies : (" +fruitTree.getName()+", "+ fruitTree.getHP() + "," +fruitTree.getIsAlive()+")";
		result += "\nspecies : (" +monkey.getName()+", "+ monkey.getHp() + "," +monkey.getIsAlive()+")";
		result += "\nspecies : ("+chimpanzee.getName()+", "+ chimpanzee.getHp() + "," +chimpanzee.getIsAlive()+")";
		result += "\nspecies : ("+jaguar.getName()+", "+ jaguar.getHp() +"," +jaguar.getIsAlive()+")";
		result += "\nspecies : (" +turtle.getName()+", "+ turtle.getHp() + "," +turtle.getIsAlive()+")";
		result += "\nspecies : (" +anaconda.getName()+", "+ anaconda.getHp() + "," +anaconda.getIsAlive()+")";
		result += "\nspecies : ("+blackCaiman.getName()+", "+ blackCaiman.getHp() +"," +blackCaiman.getIsAlive()+")";
		result += "\nspecies : (" +fruitTree.getName()+", "+ fruitTree.getHP() + "," +fruitTree.getIsAlive()+")";
		return result;
	}

}
