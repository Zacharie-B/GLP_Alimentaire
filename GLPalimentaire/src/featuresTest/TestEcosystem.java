package featuresTest;

import data.ecosystemdata.Desert;
import data.ecosystemdata.Lake;
import data.ecosystemdata.Mountains;
import data.ecosystemdata.Plain;
import data.ecosystemdata.Savanna;

public class TestEcosystem {
	public static void main(String[] args) {
		Desert desert = new Desert(50, 10, 20, true, 10);
		Lake lake = new Lake (20, 10, 10, false, 100);
		Mountains mountains = new Mountains (10, 10, 20, false, 100);
		Plain plain = new Plain (30, 10, 10, true, 100);
		Savanna savanna = new Savanna (40, 10, 20, true, 60);
		
		System.out.println(desert.toString());
		System.out.println(lake.toString());
		System.out.println(mountains.toString());
		System.out.println(plain.toString());
		System.out.println(savanna.toString());
	}
}
