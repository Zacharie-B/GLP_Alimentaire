package hpManagement;

public class Counter{
	@SuppressWarnings("unused")
	private int value;

	public Counter(int value) {
		super();
		this.value = value;
	}
	
	public void increment(int value) {
		value++;
	}
	
	public void decrement(int value) {
		value--;
	}
	
}