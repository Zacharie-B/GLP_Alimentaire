package foodChains;

import java.util.ArrayList;
import java.util.Iterator;

import data.Position;
import data.PrimaryConsumer;
import data.Producer;
import data.SecondaryConsumer;
import data.TertiaryConsumer;
import data.decomposersdata.Bacterium;
import naturalNeedsManagement.HungryProcess;
import naturalNeedsManagement.MineralChange;

public class FoodChainsProcess{
	
	private  MineralChange mineralChange = MineralChange.getInstance();
	private  HungryProcess hp = new HungryProcess();
	private  Bacterium bacterium = new Bacterium("bacterium",100);
	
	/**
	 * 
	 * @param producer
	 * @param primaryConsumer
	 * @param proeatenby
	 * treats the first trophic level of the food chain
	 */
	
	public void FirstTrophicLevel(Producer producer, PrimaryConsumer primaryConsumer, 
		ArrayList<String> proeatenby) {
		proeatenby= producer.getEatenBy();
		boolean continueList=true;
		Iterator<String> iterator1 = proeatenby.iterator();
		while (iterator1.hasNext()&&continueList!=false) {
			String producerit = iterator1.next();
			if(producerit.equals(primaryConsumer.getName())&&equals(producer.getCordinates(),primaryConsumer.getCordinates())
					&&producer.getIsAlive()==true) {
				hp.HungryProcessConsumerWithProducer(primaryConsumer, producer);
				if(producer.getPopulationDensity()<primaryConsumer.getPopulationDensity()) {
					producer.sethp(0);
					IsDead isDead= new IsDead();
					isDead.SpeciesDead(producer);
					addMineralRessources(producer.getCordinates(),producer.getOrganicMass()*producer.getPopulationDensity());
					producer.setPopulationDensity(0);
				}
				else if (producer.getPopulationDensity()==primaryConsumer.getPopulationDensity()) {
					producer.sethp(0);
					IsDead isDead= new IsDead();
					isDead.SpeciesDead(producer);
					addMineralRessources(producer.getCordinates(),producer.getOrganicMass()*producer.getPopulationDensity());
					producer.setPopulationDensity(0);
				}
				else {
					addMineralRessources(producer.getCordinates(),producer.getOrganicMass()*primaryConsumer.getPopulationDensity());
					producer.setPopulationDensity(producer.getPopulationDensity()-primaryConsumer.getPopulationDensity());
				}
				continueList =false;			
			}
		}
	}

	/**
	 * 
	 * @param primaryConsumer
	 * @param secondaryConsumer
	 * @param pceatenby
	 * treats the second trophic level of the food chain
	 */
	public void SecondTrophicLevel(PrimaryConsumer primaryConsumer, SecondaryConsumer secondaryConsumer, 
			ArrayList<String> pceatenby) {
		pceatenby= primaryConsumer.getEatenBy();
		boolean continueList=true;
		Iterator<String> iterator = pceatenby.iterator();
		while (iterator.hasNext()&&continueList!=false) {
			String pcit = iterator.next();
			if(pcit.equals(secondaryConsumer.getName())&&equals(primaryConsumer.getCordinates(),secondaryConsumer.getCordinates())
					&&primaryConsumer.getIsAlive()==true) {
				hp.HungryProcessConsumerWithConsumer(secondaryConsumer, primaryConsumer);
				if(primaryConsumer.getPopulationDensity()<=secondaryConsumer.getPopulationDensity()) {
					primaryConsumer.sethp(0);
					IsDead isDead= new IsDead();
					isDead.SpeciesDead(primaryConsumer);
					addMineralRessources(primaryConsumer.getCordinates(),
					primaryConsumer.getOrganicMass()*primaryConsumer.getPopulationDensity());
					primaryConsumer.setPopulationDensity(0);
				}
				else {
					addMineralRessources(primaryConsumer.getCordinates(),primaryConsumer.getOrganicMass()*secondaryConsumer.getPopulationDensity());
					primaryConsumer.setPopulationDensity(primaryConsumer.getPopulationDensity()-secondaryConsumer.getPopulationDensity());
				}
					continueList=false;
			}
		}
	}
	
	/**
	 * 
	 * @param secondaryConsumer
	 * @param tertiaryConsumer
	 * @param sceatenby
	 * treats the third trophic level of the food chain
	 */
	public void ThirdTrophicLevel (SecondaryConsumer secondaryConsumer, TertiaryConsumer tertiaryConsumer, 
			ArrayList<String> sceatenby) {
		sceatenby= secondaryConsumer.getEatenBy();
		boolean continueList=true;
		Iterator<String> iterator = sceatenby.iterator();
		while (iterator.hasNext()&&continueList!=false) {
			String scit = iterator.next();
			if(scit.equals(tertiaryConsumer.getName())&&equals(secondaryConsumer.getCordinates(),tertiaryConsumer.getCordinates())
					&&secondaryConsumer.getIsAlive()==true) {
				hp.HungryProcessConsumerWithConsumer(tertiaryConsumer, secondaryConsumer);
				if(secondaryConsumer.getPopulationDensity()<=tertiaryConsumer.getPopulationDensity()) {
					secondaryConsumer.sethp(0);
					IsDead isDead= new IsDead();
					isDead.SpeciesDead(secondaryConsumer);
					addMineralRessources(secondaryConsumer.getCordinates(),
					secondaryConsumer.getOrganicMass()*secondaryConsumer.getPopulationDensity());
					secondaryConsumer.setPopulationDensity(0);
				}
				else {
					addMineralRessources(secondaryConsumer.getCordinates(),
							secondaryConsumer.getOrganicMass()*tertiaryConsumer.getPopulationDensity());
					secondaryConsumer.setPopulationDensity(secondaryConsumer.getPopulationDensity()-tertiaryConsumer.getPopulationDensity());
				}
					continueList=false;
			}
		}
	}
	
	public boolean equals(Object obj, Position pos) {
	      return (obj instanceof Position) && 
		  ((Position)obj).getX()==pos.getX() && 
		  ((Position)obj).getY()==pos.getY();
	    }
	
	/**
	 * Decomposer transform the organic mass to mineral mass
	 * @param cordinates
	 * @param rateMineral
	 */
	public void addMineralRessources(Position cordinates, int rateMineral) {					 
				int organicmass =mineralChange.getValue(cordinates);
				if(bacterium.getPopulationDensity()>organicmass) {
					rateMineral += organicmass;
				}
				else {
					rateMineral +=bacterium.getPopulationDensity();
				}
				mineralChange.addMineral(cordinates, rateMineral);
	}
	
	/**
	 * The producer eat itself with the mineral on the floor
	 * @param producer
	 */
	public void AbsorptionMineral(Producer producer) {
			int mineralMass = mineralChange.getValue(producer.getCordinates());
			if(mineralMass>producer.getRateMineral()&&producer.getIsAlive()==true) {
				mineralMass-=producer.getRateMineral();
				int hp= producer.gethp();
				hp+=2;
				producer.sethp(hp);
			}
			mineralChange.addMineral(producer.getCordinates(), mineralMass);
	}
	
	
	
	
}
	