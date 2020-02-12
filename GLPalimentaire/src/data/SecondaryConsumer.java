package data;

import java.util.ArrayList;

public abstract class SecondaryConsumer extends Consumer{
	public void initializeEatenBy() {
		ArrayList <String> al = new ArrayList <String> ();
		al.add("Bacterium");
		setEatenBy(al);
	}
}
