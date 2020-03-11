package foodChains;

import java.util.ArrayList;
import java.util.Iterator;

import data.Position;
import data.PrimaryConsumer;
import data.Producer;
import data.SecondaryConsumer;
import data.TertiaryConsumer;
import naturalNeedsManagement.HungryProcess;
import naturalNeedsManagement.MineralChange;

public class FoodChainsProcess{
	
	/**
	 * 
	 * @param producer
	 * @param primaryConsumer
	 * @param proeatenby
	 * treats the first trophic level of the food chain
	 */
	
	private  MineralChange mineralChange = MineralChange.getInstance();
	private  HungryProcess hp= new HungryProcess();
	
	public void FirstTrophicLevel(Producer producer, PrimaryConsumer primaryConsumer, 
			ArrayList<String> proeatenby) {
		proeatenby= producer.getEatenBy();
		boolean continueList=true;
		Iterator<String> iterator1 = proeatenby.iterator();
		while (iterator1.hasNext()&&continueList!=false) {
			String producerit = iterator1.next();
			if(producerit.equals(primaryConsumer.getName())&&equals(producer.getCordinates(),primaryConsumer.getCordinates())
					&&producer.getIsAlive()==true) {
				producer.setHP(0);
				IsDead isDead= new IsDead();
				isDead.ProducerDead(producer);
				addMineralResources(producer.getCordinates(),producer.getOrganicMass());
				hp.HungryProcessConsumerWithProducer(primaryConsumer, producer);
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
					primaryConsumer.setHp(0);
					IsDead isDead= new IsDead();
					isDead.ConsumerDead(primaryConsumer);
					addMineralResources(primaryConsumer.getCordinates(),primaryConsumer.getOrganicMass());
					hp.HungryProcessConsumerWithConsumer(secondaryConsumer, primaryConsumer);
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
					secondaryConsumer.setHp(0);
					IsDead isDead = new IsDead();
					isDead.ConsumerDead(secondaryConsumer);
					addMineralResources(secondaryConsumer.getCordinates(),secondaryConsumer.getOrganicMass());
					hp.HungryProcessConsumerWithConsumer(tertiaryConsumer, secondaryConsumer);
					continueList=false;
			}
		}
	}
	
	public boolean equals(Object obj, Position pos) {
	      return (obj instanceof Position) && 
		  ((Position)obj).getX()==pos.getX() && 
		  ((Position)obj).getY()==pos.getY();
	    }
	
	public void addMineralResources(Position cordinates, int rateMineral) {					 
				int organicmass =mineralChange.getValue(cordinates);
				rateMineral += organicmass;
				mineralChange.addMineral(cordinates, rateMineral);
	}
}
	