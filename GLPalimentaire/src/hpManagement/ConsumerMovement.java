package hpManagement;

import java.util.ArrayList;
import java.util.Iterator;

import data.Point;
import data.primaryConsumerdata.Aphid;
import data.secondaryConsumerdata.AsianLadybug;
import data.tertiaryConsumerdata.Woodpecker;

public class ConsumerMovement  {
		private Point point = new Point(10,10);
		private Aphid aphid = new Aphid(3, 100, true, 10, 100, 10, 10, 3, false, point);
		private ArrayList <String> aphidEatenBy = new ArrayList <String> ();
		private AsianLadybug asianladybug = new AsianLadybug (4, 150, true, 5, 15, 4, 30, 6, false, point);
		private ArrayList <String> asianLadybugEatenBy = new ArrayList <String> ();
		private Woodpecker woodpecker = new Woodpecker (10, 1000, true, 1, 1, 50, 150, 6, false, point);
		
		public ConsumerMovement() {
		}
		
		public void EatIfPossible() {
			aphidEatenBy = aphid.getEatenBy();
			asianLadybugEatenBy = asianladybug.getEatenBy();
			
			Iterator<String> iterator1 = aphidEatenBy.iterator();
			while (iterator1.hasNext()) {
				String aphidEatenBy = iterator1.next();
				if(aphidEatenBy.equals("asianladybug")) {
					aphid.setHp(0);
					aphid.setIsAlive(false);
					break;
				}
			}
			Iterator<String> iterator2 = asianLadybugEatenBy.iterator();
			while (iterator2.hasNext()) {
				String asianLadybugEatenBy = iterator2.next();
				if(asianLadybugEatenBy.equals("woodpecker")) {
					asianladybug.setHp(0);
					asianladybug.setIsAlive(false);
					break;
				}
			}
		}
		
		public String toString() {
			String result = "First species : (" + aphid.toString() + ") ";
			result += "\nSecond species : (" + asianladybug.toString() + ")";
			result += "\nThirsty species : ("+ woodpecker.toString() + ")";
			return result;
		}
		
		
}
