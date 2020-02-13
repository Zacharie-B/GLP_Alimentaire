package hpManagement;

import data.primaryConsumerdata.Aphid;
import data.secondaryConsumerdata.AsianLadybug;

public class ConsumerMovement  {
		private Point point = new Point(10,10);
		private Aphid aphid = new Aphid(3, 100, true, 10, 100, 10, 10, 3, false, point);
		private AsianLadybug asianladybug = new AsianLadybug (4, 150, true, 5, 15, 4, 30, 6, false, point);
		private Point[] points;
		private int currentSize = 0;

		public ConsumerMovement() {
			
		}
		
		
		public String toString() {
			String result = "Coordonnées : ";
			for (int index = 0; index < currentSize; index++) {
				Point point = points[index];
				result += "(" + point.toString() + ") ";
				
			}
			return result;
		}
		
		
}
