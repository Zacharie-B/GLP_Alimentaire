package foodChains;

import java.util.ArrayList;
import java.util.Iterator;

import data.PrimaryConsumer;
import data.Producer;
import data.SecondaryConsumer;
import data.TertiaryConsumer;

public class FoodChains extends IsDead{

	/**
	 * 
	 * @param producer
	 * @param primaryConsumer
	 * @param proeatenby
	 * treats the first trophic level of the food chain
	 */
	public void FirstTrophicLevel(Producer producer, PrimaryConsumer primaryConsumer, ArrayList<String> proeatenby) {
		proeatenby= producer.getEatenBy();
		Iterator<String> iterator1 = proeatenby.iterator();
		while (iterator1.hasNext()) {
			String producerit = iterator1.next();
			if(producerit.equals(primaryConsumer.getName())&&producer.getCordinates().equals(primaryConsumer.getCordinates())) {
					producer.setHP(0);
					ProducerDead(producer);
					break;
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
	public void SecondTrophicLevel(PrimaryConsumer primaryConsumer, SecondaryConsumer secondaryConsumer, ArrayList<String> pceatenby) {
		pceatenby= primaryConsumer.getEatenBy();
		Iterator<String> iterator = pceatenby.iterator();
		while (iterator.hasNext()) {
			String pcit = iterator.next();
			if(pcit.equals(secondaryConsumer.getName())&&primaryConsumer.getCordinates().equals(secondaryConsumer.getCordinates())) {
					primaryConsumer.setHp(0);
					ConsumerDead(primaryConsumer);
					break;
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
	public void ThirdTrophicLevel (SecondaryConsumer secondaryConsumer, TertiaryConsumer tertiaryConsumer, ArrayList<String> sceatenby) {
		sceatenby= secondaryConsumer.getEatenBy();
		Iterator<String> iterator = sceatenby.iterator();
		while (iterator.hasNext()) {
			String scit = iterator.next();
			if(scit.equals(tertiaryConsumer.getName())&&secondaryConsumer.getCordinates().equals(tertiaryConsumer.getCordinates())) {
					secondaryConsumer.setHp(0);
					ConsumerDead(secondaryConsumer);
					break;
			}
		}
	}
	
	
}
	