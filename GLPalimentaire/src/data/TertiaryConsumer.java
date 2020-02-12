package data;

import java.util.ArrayList;

/**
 * 
 * @author Yassin
 * This section of data concerns Tertiary consumers with all their features
 */

public abstract class TertiaryConsumer extends Consumer {
	public void initializeEatenBy() {
		ArrayList <String> al = new ArrayList <String> ();
		al.add("Bacterium");
		setEatenBy(al);
	}

}
