package producerdata;

import java.util.ArrayList;

import data.Producer;

public class Acacia extends Producer{
	boolean isalive ;
	int populationdensity;
	ArrayList<String> diet;
	int numberbirths;
	int timebreeding;
	int hp;
	ArrayList<String> eatenby;
	int organicmass;
	int ratemineral;
	
	public Acacia(int populationdensity, int numberbirths, int timebreeding,
			int hp, int organicmass, int ratemineral) {
		super();
		this.populationdensity = populationdensity;
		this.numberbirths = numberbirths;
		this.timebreeding = timebreeding;
		this.hp = hp;
		this.organicmass = organicmass;
		this.ratemineral = ratemineral;
	}

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setisAlive(boolean isalive) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getPopulationDensity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setPopulationDensity(int populationdensity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<String> getDiet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDiet(ArrayList<String> diet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getNumberBirths() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setNumberBirths(int numberbirths) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getTimeBreeding() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setTimeBreeding(int timebreeding) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getHP() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setHP(int hp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Producer> getEatenby() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setHP(ArrayList<String> eatenby) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getOrganicMass() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setOrganicMass(int organicmass) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getRateMineral() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setRateMineral(int ratemineral) {
		// TODO Auto-generated method stub
		
	}

}
