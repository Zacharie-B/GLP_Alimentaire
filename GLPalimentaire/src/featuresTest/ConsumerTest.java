package featuresTest;

import data.primaryConsumerdata.Aphid;
import data.tertiaryConsumerdata.Lion;

public class ConsumerTest {

	public static void main(String[] args) {
		Aphid aphid = new Aphid(5, 1500, true, 10, 2, 3, 100, 10, false);
		Lion lion = new Lion(5, 1500, true, 10, 2, 3, 100, 10, false);
		System.out.println(lion.toString());
		System.out.println(aphid.toString());
		

	}

}
