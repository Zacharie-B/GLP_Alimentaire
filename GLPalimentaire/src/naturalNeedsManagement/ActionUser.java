package naturalNeedsManagement;

import beingManagement.BeingCreator;
import data.Consumer;
import data.Producer;
import foodChains.IsDead;
import gui.OperationZone;

public class ActionUser {
	private BeingCreator animalsInSavana = BeingCreator.getInstance();
	private IsDead isDead= new IsDead();
	
	private void ForestFire(String name) {
		
		Producer[] producer = new Producer[animalsInSavana.getTable(name).length];
		producer=(Producer[]) animalsInSavana.getTable(name);
		
		for(int i=((animalsInSavana.getTable(name).length)/2); i<animalsInSavana.getTable(name).length;i++) {
			producer[i].sethp(0);
			isDead.SpeciesDead(producer[i]);
        }
		animalsInSavana.register(name, producer);
	}
	
	public void ForestFire() {
		switch (OperationZone.ecosystem) {
		case "Savanna":
			ForestFire("acacia");
			ForestFire("bush");
			ForestFire("grass");
		}
	}
	
	
	
	private void Sickness(String name) {
		
		Consumer[] consumer = new Consumer[animalsInSavana.getTable(name).length];
		consumer=(Consumer[]) animalsInSavana.getTable(name);
		
		for(int i=((animalsInSavana.getTable(name).length)/2); i<animalsInSavana.getTable(name).length;i++) {
			consumer[i].sethp(0);
			isDead.SpeciesDead(consumer[i]);
        }
		
		animalsInSavana.register(name, consumer);
	}
	public void Sickness() {
		switch (OperationZone.ecosystem) {
		case "Savanna":
			Sickness("hyena");
			Sickness("lion");
			Sickness("gazelle");
			Sickness("giraffe");
			Sickness("cheetah");
			Sickness("buffalo");
			Sickness("zebra");
			Sickness("warthog");
			break;
		}
	}
}
