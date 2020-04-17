package beingManagement;

import org.apache.log4j.Logger;

import data.Species;
import data.primaryConsumerdata.Buffalo;
import data.primaryConsumerdata.Gazelle;
import data.primaryConsumerdata.Giraffe;
import data.primaryConsumerdata.Warthog;
import data.primaryConsumerdata.Zebra;
import data.producersdata.Acacia;
import data.producersdata.Bush;
import data.producersdata.Grass;
import data.secondaryConsumerdata.Cheetah;
import data.secondaryConsumerdata.Hyena;
import data.tertiaryConsumerdata.Lion;
import ecosystemProcess.SavannaEcosystem;
import movementOfSpecies.CreateMovement;
import movementOfSpecies.InitialPosition;
import tests.log4j.LoggerUtility;

public class Reproduct {
	
	private static Logger logger = LoggerUtility.getLogger(SavannaEcosystem.class, "text");
	private BeingCreator animalsInSavana = BeingCreator.getInstance();
	private static InitialPosition pos = new InitialPosition();
	private CreateMovement cm = new CreateMovement();
	
	public Reproduct(){
		
	}
	
	public void reproductOnSavanna(int simulationdays) {
		reproduct("giraffe", simulationdays);
		reproduct("lion", simulationdays);
		reproduct("gazelle", simulationdays);
		reproduct("zebra", simulationdays);
		reproduct("warthog", simulationdays);
		reproduct("cheetah", simulationdays);
		reproduct("buffalo", simulationdays);
		reproduct("hyena", simulationdays);
		reproduct("acacia",simulationdays);
		reproduct("grass",simulationdays);
		reproduct("bush",simulationdays);
	}
	
	public void reproductOnPlain(int simultiondays) {
		
	}
	
	public void reproduct(String name, int simulationDays){
		int numberofspecies=animalsInSavana.getTable(name).length;
		int lastbox;
		final int numberspecies=animalsInSavana.getTable(name).length;
		Species[] consumer = new Species[numberofspecies];
		consumer=(Species[]) animalsInSavana.getTable(name);
		for(int index=0;index<numberspecies;index++) {
		    if (Math.floorMod(simulationDays, consumer[index].getTimeBreeding()) == 0) {
		        if(index==(numberspecies-1)) {
		        	logger.info(numberofspecies);
		        	lastbox=numberofspecies;
		        	int newspecies=0;
		        	int speciescreat=0;
		        	
		        	
		        	switch (name) {
		        	case "giraffe":
		        		Giraffe[] giraffe = new Giraffe[lastbox];
		        		for(int ab=0;ab<lastbox;ab++) {
		        			int currentpopulation=consumer[ab].getPopulationDensity();
		    		    	currentpopulation+=currentpopulation/2;
		    		        consumer[ab].setPopulationDensity(currentpopulation);
		    		        if(consumer[ab].getPopulationDensity()>=12) {
			        			giraffe[ab]= new Giraffe ("giraffe", 20, 100, true,10, 0,40, 10, 3, false, pos.initPosition[SavannaEcosystem.a]);
			        			pos.initPosition[SavannaEcosystem.a].setX(consumer[ab].getCordinates().getX());
			        			pos.initPosition[SavannaEcosystem.a].setY(consumer[ab].getCordinates().getY());
			    				consumer[ab].setPopulationDensity(consumer[ab].getPopulationDensity()-10);
			    				giraffe[ab].setCordinates(cm.SavannaMouvement(giraffe[ab]));
		    		        	SavannaEcosystem.a++;
		    		        	newspecies++;
		    		        }
		        		}
		        		Giraffe[] giraffecreate = new Giraffe[newspecies];
		        		for(int ab=0;ab<lastbox;ab++) {
			        		if(giraffe[ab]!=null) {
			    		        if(giraffe[ab].getPopulationDensity()==10) {
			    		        	giraffecreate[speciescreat]=giraffe[ab];
			    		        	speciescreat++;
			    		        }
			        		}
		        		}
		        		Giraffe[] allgroups=new Giraffe[lastbox+newspecies];
		        		int length = allgroups.length;
	    				for(int i=0;i<lastbox;i++) {
	    					allgroups[i]=(Giraffe) consumer[i];
	    				}
	    				int ji;
	    				for(ji=lastbox;ji<length;ji++) {
	    					allgroups[ji]=giraffecreate[ji-lastbox];
	    				}
	    				
	    				
	    				for(int ia=0;ia<length;ia++) {
	    				}
		    			animalsInSavana.register(name, allgroups);		
		        		break;
		        		
		        	
		        	case "gazelle":
		        		Gazelle[] gazelle = new Gazelle[lastbox];
		        		for(int ab=0;ab<lastbox;ab++) {
		        			int currentpopulation=consumer[ab].getPopulationDensity();
		    		    	currentpopulation+=currentpopulation/2;
		    		        consumer[ab].setPopulationDensity(currentpopulation);
		    		        if(consumer[ab].getPopulationDensity()>=12) {
			        			gazelle[ab]= new Gazelle ("gazelle", 20, 100, true,10, 0,40, 10, 3, false, pos.initPosition[SavannaEcosystem.a]);
			        			pos.initPosition[SavannaEcosystem.a].setX(consumer[ab].getCordinates().getX());
			        			pos.initPosition[SavannaEcosystem.a].setY(consumer[ab].getCordinates().getY());
			    				consumer[ab].setPopulationDensity(consumer[ab].getPopulationDensity()-10);
			    				gazelle[ab].setCordinates(cm.SavannaMouvement(gazelle[ab]));
		    		        	SavannaEcosystem.a++;
		    		        	newspecies++;
		    		        }
		        		}
		        		Gazelle[] gazellecreate = new Gazelle[newspecies];
		        		for(int ab=0;ab<lastbox;ab++) {
			        		if(gazelle[ab]!=null) {
			    		        if(gazelle[ab].getPopulationDensity()==10) {
			    		        	gazellecreate[speciescreat]=gazelle[ab];
			    		        	speciescreat++;
			    		        }
			        		}
		        		}
		        		Gazelle[] allgroupsgazelle=new Gazelle[lastbox+newspecies];
		        		int lengthgazelle = allgroupsgazelle.length;
	    				for(int i=0;i<lastbox;i++) {
	    					allgroupsgazelle[i]=(Gazelle) consumer[i];
	    				}
	    				int jigazelle;
	    				for(jigazelle=lastbox;jigazelle<lengthgazelle;jigazelle++) {
	    					allgroupsgazelle[jigazelle]=gazellecreate[jigazelle-lastbox];
	    				}
	    			
	    				for(int ia=0;ia<lengthgazelle;ia++) {
	    				}
	    				animalsInSavana.register(name, allgroupsgazelle);
	        				
		        		break;
		        		
		        		
		        	case "grass":
		        		Grass[] Grass = new Grass[lastbox];
		        		for(int ab=0;ab<lastbox;ab++) {
		        			int currentpopulation=consumer[ab].getPopulationDensity();
		    		    	currentpopulation+=currentpopulation/2;
		    		        consumer[ab].setPopulationDensity(currentpopulation);
		    		        if(consumer[ab].getPopulationDensity()>=12) {
			        			Grass[ab]= new Grass ("grass",true,10,10,2,20,25,0,4, pos.initPosition[SavannaEcosystem.a]);
			        			pos.initPosition[SavannaEcosystem.a].setX(consumer[ab].getCordinates().getX());
			        			pos.initPosition[SavannaEcosystem.a].setY(consumer[ab].getCordinates().getY());
			    				consumer[ab].setPopulationDensity(consumer[ab].getPopulationDensity()-10);
			    				Grass[ab].setCordinates(cm.SavannaMouvement(Grass[ab]));
		    		        	SavannaEcosystem.a++;
		    		        	newspecies++;
		    		        }
		        		}
		        		Grass[] Grasscreate = new Grass[newspecies];
		        		for(int ab=0;ab<lastbox;ab++) {
			        		if(Grass[ab]!=null) {
			    		        if(Grass[ab].getPopulationDensity()==10) {
			    		        	Grasscreate[speciescreat]=Grass[ab];
			    		        	speciescreat++;
			    		        }
			        		}
		        		}
		        		Grass[] allgroupsGrass=new Grass[lastbox+newspecies];
		        		int lengthGrass = allgroupsGrass.length;
	    				for(int i=0;i<lastbox;i++) {
	    					allgroupsGrass[i]=(Grass) consumer[i];
	    				}
	    				int jiGrass;
	    				for(jiGrass=lastbox;jiGrass<lengthGrass;jiGrass++) {
	    					allgroupsGrass[jiGrass]=Grasscreate[jiGrass-lastbox];
	    				}
	    			
	    				for(int ia=0;ia<lengthGrass;ia++) {
	    				}
	    				animalsInSavana.register(name, allgroupsGrass);
	        				
		        		break;
		        		
		        		
		        	case "bush":
		        		Bush[] Bush = new Bush[lastbox];
		        		for(int ab=0;ab<lastbox;ab++) {
		        			int currentpopulation=consumer[ab].getPopulationDensity();
		    		    	currentpopulation+=currentpopulation/2;
		    		        consumer[ab].setPopulationDensity(currentpopulation);
		    		        if(consumer[ab].getPopulationDensity()>=12) {
			        			Bush[ab]= new Bush ("bush",true,10,10,5,20,25,0,4, pos.initPosition[SavannaEcosystem.a]);
			        			pos.initPosition[SavannaEcosystem.a].setX(consumer[ab].getCordinates().getX());
			        			pos.initPosition[SavannaEcosystem.a].setY(consumer[ab].getCordinates().getY());
			    				consumer[ab].setPopulationDensity(consumer[ab].getPopulationDensity()-10);
			    				Bush[ab].setCordinates(cm.SavannaMouvement(Bush[ab]));
		    		        	SavannaEcosystem.a++;
		    		        	newspecies++;
		    		        }
		        		}
		        		Bush[] Bushcreate = new Bush[newspecies];
		        		for(int ab=0;ab<lastbox;ab++) {
			        		if(Bush[ab]!=null) {
			    		        if(Bush[ab].getPopulationDensity()==10) {
			    		        	Bushcreate[speciescreat]=Bush[ab];
			    		        	speciescreat++;
			    		        }
			        		}
		        		}
		        		Bush[] allgroupsBush=new Bush[lastbox+newspecies];
		        		int lengthBush = allgroupsBush.length;
	    				for(int i=0;i<lastbox;i++) {
	    					allgroupsBush[i]=(Bush) consumer[i];
	    				}
	    				int jiBush;
	    				for(jiBush=lastbox;jiBush<lengthBush;jiBush++) {
	    					allgroupsBush[jiBush]=Bushcreate[jiBush-lastbox];
	    				}
	    			
	    				for(int ia=0;ia<lengthBush;ia++) {
	    				}
	    				animalsInSavana.register(name, allgroupsBush);
	        				
		        		break;
		        		
		        		
		        	case "hyena":
		        		Hyena[] Hyena = new Hyena[lastbox];
		        		for(int ab=0;ab<lastbox;ab++) {
		        			int currentpopulation=consumer[ab].getPopulationDensity();
		    		    	currentpopulation+=currentpopulation/2;
		    		        consumer[ab].setPopulationDensity(currentpopulation);
		    		        if(consumer[ab].getPopulationDensity()>=12) {
			        			Hyena[ab]= new Hyena ("hyena", 30, 100, true,10, 0,10, 10, 3, false, pos.initPosition[SavannaEcosystem.a]);
			        			pos.initPosition[SavannaEcosystem.a].setX(consumer[ab].getCordinates().getX());
			        			pos.initPosition[SavannaEcosystem.a].setY(consumer[ab].getCordinates().getY());
			    				consumer[ab].setPopulationDensity(consumer[ab].getPopulationDensity()-10);
			    				Hyena[ab].setCordinates(cm.SavannaMouvement(Hyena[ab]));
		    		        	SavannaEcosystem.a++;
		    		        	newspecies++;
		    		        }
		        		}
		        		Hyena[] Hyenacreate = new Hyena[newspecies];
		        		for(int ab=0;ab<lastbox;ab++) {
			        		if(Hyena[ab]!=null) {
			    		        if(Hyena[ab].getPopulationDensity()==10) {
			    		        	Hyenacreate[speciescreat]=Hyena[ab];
			    		        	speciescreat++;
			    		        }
			        		}
		        		}
		        		Hyena[] allgroupsHyena=new Hyena[lastbox+newspecies];
		        		int lengthHyena = allgroupsHyena.length;
	    				for(int i=0;i<lastbox;i++) {
	    					allgroupsHyena[i]=(Hyena) consumer[i];
	    				}
	    				int jiHyena;
	    				for(jiHyena=lastbox;jiHyena<lengthHyena;jiHyena++) {
	    					allgroupsHyena[jiHyena]=Hyenacreate[jiHyena-lastbox];
	    				}
	    			
	    				for(int ia=0;ia<lengthHyena;ia++) {
	    				}
	    				animalsInSavana.register(name, allgroupsHyena);
	        				
		        		break;
		        		
		        		
		        	case "cheetah":
		        		Cheetah[] Cheetah = new Cheetah[lastbox];
		        		for(int ab=0;ab<lastbox;ab++) {
		        			int currentpopulation=consumer[ab].getPopulationDensity();
		    		    	currentpopulation+=currentpopulation/2;
		    		        consumer[ab].setPopulationDensity(currentpopulation);
		    		        if(consumer[ab].getPopulationDensity()>=12) {
			        			Cheetah[ab]= new Cheetah ("cheetah", 30, 100, true,10, 0,10, 10, 3, false, pos.initPosition[SavannaEcosystem.a]);
			        			pos.initPosition[SavannaEcosystem.a].setX(consumer[ab].getCordinates().getX());
			        			pos.initPosition[SavannaEcosystem.a].setY(consumer[ab].getCordinates().getY());
			    				consumer[ab].setPopulationDensity(consumer[ab].getPopulationDensity()-10);
			    				Cheetah[ab].setCordinates(cm.SavannaMouvement(Cheetah[ab]));
		    		        	SavannaEcosystem.a++;
		    		        	newspecies++;
		    		        }
		        		}
		        		Cheetah[] Cheetahcreate = new Cheetah[newspecies];
		        		for(int ab=0;ab<lastbox;ab++) {
			        		if(Cheetah[ab]!=null) {
			    		        if(Cheetah[ab].getPopulationDensity()==10) {
			    		        	Cheetahcreate[speciescreat]=Cheetah[ab];
			    		        	speciescreat++;
			    		        }
			        		}
		        		}
		        		Cheetah[] allgroupsCheetah=new Cheetah[lastbox+newspecies];
		        		int lengthCheetah = allgroupsCheetah.length;
	    				for(int i=0;i<lastbox;i++) {
	    					allgroupsCheetah[i]=(Cheetah) consumer[i];
	    				}
	    				int jiCheetah;
	    				for(jiCheetah=lastbox;jiCheetah<lengthCheetah;jiCheetah++) {
	    					allgroupsCheetah[jiCheetah]=Cheetahcreate[jiCheetah-lastbox];
	    				}
	    			
	    				for(int ia=0;ia<lengthCheetah;ia++) {
	    				}
	    				animalsInSavana.register(name, allgroupsCheetah);
	        				
		        		break;
		        		
		        		
		        	case "lion":
		        		Lion[] Lion = new Lion[lastbox];
		        		for(int ab=0;ab<lastbox;ab++) {
		        			int currentpopulation=consumer[ab].getPopulationDensity();
		    		    	currentpopulation+=currentpopulation/2;
		    		        consumer[ab].setPopulationDensity(currentpopulation);
		    		        if(consumer[ab].getPopulationDensity()>=12) {
			        			Lion[ab]= new Lion ("lion", 20, 100, true,10, 0,50, 10, 3, false, pos.initPosition[SavannaEcosystem.a]);
			        			pos.initPosition[SavannaEcosystem.a].setX(consumer[ab].getCordinates().getX());
			        			pos.initPosition[SavannaEcosystem.a].setY(consumer[ab].getCordinates().getY());
			    				consumer[ab].setPopulationDensity(consumer[ab].getPopulationDensity()-10);
			    				Lion[ab].setCordinates(cm.SavannaMouvement(Lion[ab]));
		    		        	SavannaEcosystem.a++;
		    		        	newspecies++;
		    		        }
		        		}
		        		Lion[] Lioncreate = new Lion[newspecies];
		        		for(int ab=0;ab<lastbox;ab++) {
			        		if(Lion[ab]!=null) {
			    		        if(Lion[ab].getPopulationDensity()==10) {
			    		        	Lioncreate[speciescreat]=Lion[ab];
			    		        	speciescreat++;
			    		        }
			        		}
		        		}
		        		Lion[] allgroupsLion=new Lion[lastbox+newspecies];
		        		int lengthLion = allgroupsLion.length;
	    				for(int i=0;i<lastbox;i++) {
	    					allgroupsLion[i]=(Lion) consumer[i];
	    				}
	    				int jiLion;
	    				for(jiLion=lastbox;jiLion<lengthLion;jiLion++) {
	    					allgroupsLion[jiLion]=Lioncreate[jiLion-lastbox];
	    				}
	    			
	    				for(int ia=0;ia<lengthLion;ia++) {
	    				}
	    				animalsInSavana.register(name, allgroupsLion);
	        				
		        		break;
		        		
		        		
		        	case "zebra":
		        		Zebra[] Zebra = new Zebra[lastbox];
		        		for(int ab=0;ab<lastbox;ab++) {
		        			int currentpopulation=consumer[ab].getPopulationDensity();
		    		    	currentpopulation+=currentpopulation/2;
		    		        consumer[ab].setPopulationDensity(currentpopulation);
		    		        if(consumer[ab].getPopulationDensity()>=12) {
			        			Zebra[ab]= new Zebra ("zebra", 20, 100, true,10, 0,40, 10, 3, false, pos.initPosition[SavannaEcosystem.a]);
			        			pos.initPosition[SavannaEcosystem.a].setX(consumer[ab].getCordinates().getX());
			        			pos.initPosition[SavannaEcosystem.a].setY(consumer[ab].getCordinates().getY());
			    				consumer[ab].setPopulationDensity(consumer[ab].getPopulationDensity()-10);
			    				Zebra[ab].setCordinates(cm.SavannaMouvement(Zebra[ab]));
		    		        	SavannaEcosystem.a++;
		    		        	newspecies++;
		    		        }
		        		}
		        		Zebra[] Zebracreate = new Zebra[newspecies];
		        		for(int ab=0;ab<lastbox;ab++) {
			        		if(Zebra[ab]!=null) {
			    		        if(Zebra[ab].getPopulationDensity()==10) {
			    		        	Zebracreate[speciescreat]=Zebra[ab];
			    		        	speciescreat++;
			    		        }
			        		}
		        		}
		        		Zebra[] allgroupsZebra=new Zebra[lastbox+newspecies];
		        		int lengthZebra = allgroupsZebra.length;
	    				for(int i=0;i<lastbox;i++) {
	    					allgroupsZebra[i]=(Zebra) consumer[i];
	    				}
	    				int jiZebra;
	    				for(jiZebra=lastbox;jiZebra<lengthZebra;jiZebra++) {
	    					allgroupsZebra[jiZebra]=Zebracreate[jiZebra-lastbox];
	    				}
	    			
	    				for(int ia=0;ia<lengthZebra;ia++) {
	    				}
	    				animalsInSavana.register(name, allgroupsZebra);
	        				
		        		break;
		        		
		        		
		        	case "warthog":
		        		Warthog[] Warthog = new Warthog[lastbox];
		        		for(int ab=0;ab<lastbox;ab++) {
		        			int currentpopulation=consumer[ab].getPopulationDensity();
		    		    	currentpopulation+=currentpopulation/2;
		    		        consumer[ab].setPopulationDensity(currentpopulation);
		    		        if(consumer[ab].getPopulationDensity()>=12) {
			        			Warthog[ab]= new Warthog ("warthog", 20, 100, true,10, 0,40, 10, 3, false, pos.initPosition[SavannaEcosystem.a]);
			        			pos.initPosition[SavannaEcosystem.a].setX(consumer[ab].getCordinates().getX());
			        			pos.initPosition[SavannaEcosystem.a].setY(consumer[ab].getCordinates().getY());
			    				consumer[ab].setPopulationDensity(consumer[ab].getPopulationDensity()-10);
			    				Warthog[ab].setCordinates(cm.SavannaMouvement(Warthog[ab]));
		    		        	SavannaEcosystem.a++;
		    		        	newspecies++;
		    		        }
		        		}
		        		Warthog[] Warthogcreate = new Warthog[newspecies];
		        		for(int ab=0;ab<lastbox;ab++) {
			        		if(Warthog[ab]!=null) {
			    		        if(Warthog[ab].getPopulationDensity()==10) {
			    		        	Warthogcreate[speciescreat]=Warthog[ab];
			    		        	speciescreat++;
			    		        }
			        		}
		        		}
		        		Warthog[] allgroupsWarthog=new Warthog[lastbox+newspecies];
		        		int lengthWarthog = allgroupsWarthog.length;
	    				for(int i=0;i<lastbox;i++) {
	    					allgroupsWarthog[i]=(Warthog) consumer[i];
	    				}
	    				int jiWarthog;
	    				for(jiWarthog=lastbox;jiWarthog<lengthWarthog;jiWarthog++) {
	    					allgroupsWarthog[jiWarthog]=Warthogcreate[jiWarthog-lastbox];
	    				}
	    			
	    				for(int ia=0;ia<lengthWarthog;ia++) {
	    				}
	    				animalsInSavana.register(name, allgroupsWarthog);
	        				
		        		break;
		        		
		        		
		        	case "acacia":
		        		Acacia[] Acacia = new Acacia[lastbox];
		        		for(int ab=0;ab<lastbox;ab++) {
		        			int currentpopulation=consumer[ab].getPopulationDensity();
		    		    	currentpopulation+=currentpopulation/2;
		    		        consumer[ab].setPopulationDensity(currentpopulation);
		    		        if(consumer[ab].getPopulationDensity()>=12) {
			        			Acacia[ab]= new Acacia ("acacia",true,10,10,5,20,25,0,4, pos.initPosition[SavannaEcosystem.a]);
			        			pos.initPosition[SavannaEcosystem.a].setX(consumer[ab].getCordinates().getX());
			        			pos.initPosition[SavannaEcosystem.a].setY(consumer[ab].getCordinates().getY());
			    				consumer[ab].setPopulationDensity(consumer[ab].getPopulationDensity()-10);
			    				Acacia[ab].setCordinates(cm.SavannaMouvement(Acacia[ab]));
		    		        	SavannaEcosystem.a++;
		    		        	newspecies++;
		    		        }
		        		}
		        		Acacia[] Acaciacreate = new Acacia[newspecies];
		        		for(int ab=0;ab<lastbox;ab++) {
			        		if(Acacia[ab]!=null) {
			    		        if(Acacia[ab].getPopulationDensity()==10) {
			    		        	Acaciacreate[speciescreat]=Acacia[ab];
			    		        	speciescreat++;
			    		        }
			        		}
		        		}
		        		Acacia[] allgroupsAcacia=new Acacia[lastbox+newspecies];
		        		int lengthAcacia = allgroupsAcacia.length;
	    				for(int i=0;i<lastbox;i++) {
	    					allgroupsAcacia[i]=(Acacia) consumer[i];
	    				}
	    				int jiAcacia;
	    				for(jiAcacia=lastbox;jiAcacia<lengthAcacia;jiAcacia++) {
	    					allgroupsAcacia[jiAcacia]=Acaciacreate[jiAcacia-lastbox];
	    				}
	    			
	    				for(int ia=0;ia<lengthAcacia;ia++) {
	    				}
	    				animalsInSavana.register(name, allgroupsAcacia);
	        				
		        		break;
		        		
		        		
		        	case "buffalo":
		        		Buffalo[] Buffalo = new Buffalo[lastbox];
		        		for(int ab=0;ab<lastbox;ab++) {
		        			int currentpopulation=consumer[ab].getPopulationDensity();
		    		    	currentpopulation+=currentpopulation/2;
		    		        consumer[ab].setPopulationDensity(currentpopulation);
		    		        if(consumer[ab].getPopulationDensity()>=12) {
			        			Buffalo[ab]= new Buffalo ("buffalo", 20, 100, true,10, 0,40, 10, 3, false, pos.initPosition[SavannaEcosystem.a]);
			        			pos.initPosition[SavannaEcosystem.a].setX(consumer[ab].getCordinates().getX());
			        			pos.initPosition[SavannaEcosystem.a].setY(consumer[ab].getCordinates().getY());
			    				consumer[ab].setPopulationDensity(consumer[ab].getPopulationDensity()-10);
			    				Buffalo[ab].setCordinates(cm.SavannaMouvement(Buffalo[ab]));
		    		        	SavannaEcosystem.a++;
		    		        	newspecies++;
		    		        }
		        		}
		        		Buffalo[] Buffalocreate = new Buffalo[newspecies];
		        		for(int ab=0;ab<lastbox;ab++) {
			        		if(Buffalo[ab]!=null) {
			    		        if(Buffalo[ab].getPopulationDensity()==10) {
			    		        	Buffalocreate[speciescreat]=Buffalo[ab];
			    		        	speciescreat++;
			    		        }
			        		}
		        		}
		        		Buffalo[] allgroupsBuffalo=new Buffalo[lastbox+newspecies];
		        		int lengthBuffalo = allgroupsBuffalo.length;
	    				for(int i=0;i<lastbox;i++) {
	    					allgroupsBuffalo[i]=(Buffalo) consumer[i];
	    				}
	    				int jiBuffalo;
	    				for(jiBuffalo=lastbox;jiBuffalo<lengthBuffalo;jiBuffalo++) {
	    					allgroupsBuffalo[jiBuffalo]=Buffalocreate[jiBuffalo-lastbox];
	    				}
	    			
	    				for(int ia=0;ia<lengthBuffalo;ia++) {
	    				}
	    				animalsInSavana.register(name, allgroupsBuffalo);
	        				
		        		break;
		        			
		        	}
		        }
		    }
		}}
}
