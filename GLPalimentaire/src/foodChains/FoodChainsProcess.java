package foodChains;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

import data.Position;
import data.PrimaryConsumer;
import data.Producer;
import data.SecondaryConsumer;
import data.TertiaryConsumer;

public class FoodChainsProcess{
	
	/**
	 * 
	 * @param producer
	 * @param primaryConsumer
	 * @param proeatenby
	 * treats the first trophic level of the food chain
	 */
	public void FirstTrophicLevel(Producer producer, PrimaryConsumer primaryConsumer, 
			ArrayList<String> proeatenby, HashMap<Position,Integer> mineral) {
		proeatenby= producer.getEatenBy();
		boolean continueList=true;
		Iterator<String> iterator1 = proeatenby.iterator();
		while (iterator1.hasNext()&&continueList!=false) {
			String producerit = iterator1.next();
			if(producerit.equals(primaryConsumer.getName())&&producer.getCordinates().equals(primaryConsumer.getCordinates())
					&&producer.getIsAlive()==true) {
				producer.setHP(0);
				IsDead isDead= new IsDead();
				isDead.ProducerDead(producer);
				addMineralResources(producer.getCordinates(),mineral,producer.getOrganicMass());
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
			ArrayList<String> pceatenby, HashMap<Position,Integer> mineral) {
		pceatenby= primaryConsumer.getEatenBy();
		boolean continueList=true;
		Iterator<String> iterator = pceatenby.iterator();
		while (iterator.hasNext()&&continueList!=false) {
			String pcit = iterator.next();
			if(pcit.equals(secondaryConsumer.getName())&&primaryConsumer.getCordinates().equals(secondaryConsumer.getCordinates())
					&&primaryConsumer.getIsAlive()==true) {
					primaryConsumer.setHp(0);
					IsDead isDead= new IsDead();
					isDead.ConsumerDead(primaryConsumer);
					addMineralResources(primaryConsumer.getCordinates(),mineral,primaryConsumer.getOrganicMass());
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
			ArrayList<String> sceatenby, HashMap<Position,Integer> mineral) {
		sceatenby= secondaryConsumer.getEatenBy();
		boolean continueList=true;
		Iterator<String> iterator = sceatenby.iterator();
		while (iterator.hasNext()&&continueList!=false) {
			String scit = iterator.next();
			if(scit.equals(tertiaryConsumer.getName())&&secondaryConsumer.getCordinates().equals(tertiaryConsumer.getCordinates())
					&&secondaryConsumer.getIsAlive()==true) {
					secondaryConsumer.setHp(0);
					IsDead isDead = new IsDead();
					isDead.ConsumerDead(secondaryConsumer);
					addMineralResources(secondaryConsumer.getCordinates(),mineral,secondaryConsumer.getOrganicMass());
					continueList=false;
			}
		}
	}
	
	public void addMineralResources(Position cordinates, HashMap <Position,Integer> basicMineralRate, int rateMineral) {
		/*
		 * Pas accès à la première ou la dernière entrée
		 */
		
			boolean continueList=true;
			Set<Entry<Position, Integer>> setHm = basicMineralRate.entrySet();
				Iterator<Entry<Position, Integer>> it = setHm.iterator();
				while(it.hasNext()&&continueList!=false){
					Entry<Position, Integer> e = it.next();
					if(basicMineralRate.containsKey(cordinates)) {
						int organicmass =e.getValue();
						rateMineral += organicmass;
						
					}
					else {
						continueList=false;
					}
	      }
	 		 basicMineralRate.put(cordinates,rateMineral);
	}
}
	