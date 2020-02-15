package foodChains;

import java.util.ArrayList;
import java.util.Iterator;

import data.PrimaryConsumer;
import data.Producer;
import data.SecondaryConsumer;
import data.TertiaryConsumer;

public class FoodChains {
	


	public void FirstTrophicLevel(Producer producer, PrimaryConsumer primaryConsumer, ArrayList<String> proeatenby) {
		proeatenby= producer.getEatenBy();
		Iterator<String> iterator1 = proeatenby.iterator();
		while (iterator1.hasNext()) {
			String producerit = iterator1.next();
			if(producerit.equals(primaryConsumer.getName())&&producer.getCordinates().equals(primaryConsumer.getCordinates())) {
					producer.setHP(0);
					producer.setIsAlive(false);
					break;
			}	
		}
	}
	
	public void SecondTrophicLevel(PrimaryConsumer primaryConsumer, SecondaryConsumer secondaryConsumer, ArrayList<String> pceatenby) {
		pceatenby= primaryConsumer.getEatenBy();
		Iterator<String> iterator1 = pceatenby.iterator();
		while (iterator1.hasNext()) {
			String producerit = iterator1.next();
			if(producerit.equals(secondaryConsumer.getName())&&primaryConsumer.getCordinates().equals(secondaryConsumer.getCordinates())) {
					primaryConsumer.setHp(0);
					primaryConsumer.setIsAlive(false);
					break;
			}
		}
	}
	
	public void ThirdTrophicLevel (SecondaryConsumer secondaryConsumer, TertiaryConsumer tertiaryConsumer, ArrayList<String> sceatenby) {
		sceatenby= secondaryConsumer.getEatenBy();
		Iterator<String> iterator1 = sceatenby.iterator();
		while (iterator1.hasNext()) {
			String producerit = iterator1.next();
			if(producerit.equals(tertiaryConsumer.getName())&&secondaryConsumer.getCordinates().equals(tertiaryConsumer.getCordinates())) {
					secondaryConsumer.setHp(0);
					secondaryConsumer.setIsAlive(false);
					break;
			}
		}
	}
	
	
}
	