package beingManagement;

import org.apache.log4j.Logger;

import data.Species;
import data.primaryConsumerdata.Aphid;
import data.primaryConsumerdata.Buffalo;
import data.primaryConsumerdata.Clam;
import data.primaryConsumerdata.Gazelle;
import data.primaryConsumerdata.Giraffe;
import data.primaryConsumerdata.Turtle;
import data.primaryConsumerdata.HerbivorousLadybug;
import data.primaryConsumerdata.Hippopotamus;
import data.primaryConsumerdata.Monkey;
import data.primaryConsumerdata.MuskOx;
import data.primaryConsumerdata.Warthog;
import data.primaryConsumerdata.Zebra;
import data.producersdata.Acacia;
import data.producersdata.Bush;
import data.producersdata.Ferns;
import data.producersdata.Foam;
import data.producersdata.FruitTree;
import data.producersdata.Grass;
import data.producersdata.Reeds;
import data.producersdata.TreeLeaves;
import data.secondaryConsumerdata.Anaconda;
import data.secondaryConsumerdata.ArcticWolf;
import data.secondaryConsumerdata.AsianLadybug;
import data.secondaryConsumerdata.Cheetah;
import data.secondaryConsumerdata.Chimpanzee;
import data.secondaryConsumerdata.Hyena;
import data.secondaryConsumerdata.Phoque;
import data.secondaryConsumerdata.Python;
import data.secondaryConsumerdata.Spider;
import data.tertiaryConsumerdata.BlackCaiman;
import data.tertiaryConsumerdata.Bramble;
import data.tertiaryConsumerdata.Inuit;
import data.tertiaryConsumerdata.Jaguar;
import data.tertiaryConsumerdata.Lion;
import data.tertiaryConsumerdata.PolarBear;
import data.tertiaryConsumerdata.SaltCrocodile;
import data.tertiaryConsumerdata.Woodpecker;
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
	
	public void reproductOnFrosty(int simulationdays) {
		reproduct("muskox", simulationdays);
		reproduct("arcticwolf", simulationdays);
		reproduct("inuit", simulationdays);
		reproduct("grassFrosty", simulationdays);
		reproduct("foam", simulationdays);
		reproduct("clam", simulationdays);
		reproduct("phoque", simulationdays);
		reproduct("polarbear", simulationdays);
		logger.info("reproduction dans l'écosystème glacial");
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
		logger.info("reproduction dans l'écosystème savane");
	}
	
	public void reproductOnPlain(int simulationdays) {
		reproduct("treeleaves", simulationdays);
		reproduct("aphid", simulationdays);
		reproduct("asianladybug", simulationdays);
		reproduct("woodpecker", simulationdays);
		reproduct("ferns", simulationdays);
		reproduct("herbivorousladybug", simulationdays);
		reproduct("spider", simulationdays);
		reproduct("bramble", simulationdays);
		logger.info("reproduction dans l'écosystème plaines");
	}
	
	public void reproductOnSwamps(int simulationdays) {
		reproduct("reeds", simulationdays);
		reproduct("fruittree", simulationdays);
		reproduct("bushswamps", simulationdays);
		reproduct("turtle", simulationdays);
		reproduct("monkey", simulationdays);
		reproduct("hippopotamus", simulationdays);
		reproduct("anaconda", simulationdays);
		reproduct("chimpanzee", simulationdays);
		reproduct("python",simulationdays);
		reproduct("blackcaiman",simulationdays);
		reproduct("jaguar",simulationdays);
		reproduct("saltcrocodile",simulationdays);
		logger.info("reproduction dans l'écosystème marécages");
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
		        	
		        	
		        	/**
		        	 * Part for reproduction in Savanna Ecosystem, the reproductions of following ecosystem are line 566
		        	 */
		        	case "giraffe":
		        		Giraffe[] Giraffe = new Giraffe[lastbox];
		        		for(int ab=0;ab<lastbox;ab++) {
		        			int currentpopulation=consumer[ab].getPopulationDensity();
		    		    	currentpopulation+=currentpopulation/2;
		    		        consumer[ab].setPopulationDensity(currentpopulation);
		    		        if(consumer[ab].getPopulationDensity()>=12) {
			        			Giraffe[ab]= new Giraffe ("giraffe", 20, 100, true,10, 0,40, 10, 3, false, pos.initPosition[SavannaEcosystem.a]);
			        			pos.initPosition[SavannaEcosystem.a].setX(consumer[ab].getCordinates().getX());
			        			pos.initPosition[SavannaEcosystem.a].setY(consumer[ab].getCordinates().getY());
			    				consumer[ab].setPopulationDensity(consumer[ab].getPopulationDensity()-10);
			    				Giraffe[ab].setCordinates(cm.SavannaMouvement(Giraffe[ab]));
		    		        	SavannaEcosystem.a++;
		    		        	newspecies++;
		    		        }
		        		}
		        		Giraffe[] Giraffecreate = new Giraffe[newspecies];
		        		for(int ab=0;ab<lastbox;ab++) {
			        		if(Giraffe[ab]!=null) {
			    		        if(Giraffe[ab].getPopulationDensity()==10) {
			    		        	Giraffecreate[speciescreat]=Giraffe[ab];
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
	    					allgroups[ji]=Giraffecreate[ji-lastbox];
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
			        			Grass[ab]= new Grass ("grass",true,10,10,4,20,25,0,4, pos.initPosition[SavannaEcosystem.a]);
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
			        			Bush[ab]= new Bush ("bush",true,10,10,4,20,25,0,4, pos.initPosition[SavannaEcosystem.a]);
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
			        			Acacia[ab]= new Acacia ("acacia",true,10,10,4,20,25,0,4, pos.initPosition[SavannaEcosystem.a]);
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
		        	
		        	
		        	/**
		        	 * Part for reproduction in Plain Ecosystem, the reproductions of following ecosystem are line 896
		        	 */
		        	case "treeleaves":
		        		TreeLeaves[] TreeLeaves1 = new TreeLeaves[lastbox];
		        		for(int ab=0;ab<lastbox;ab++) {
		        			int currentpopulation=consumer[ab].getPopulationDensity();
		    		    	currentpopulation+=currentpopulation/2;
		    		        consumer[ab].setPopulationDensity(currentpopulation);
		    		        if(consumer[ab].getPopulationDensity()>=12) {
			        			TreeLeaves1[ab]= new TreeLeaves ("treeleaves",true,10,10,4,20,25,0,4, pos.initPosition[SavannaEcosystem.a]);
			        			pos.initPosition[SavannaEcosystem.a].setX(consumer[ab].getCordinates().getX());
			        			pos.initPosition[SavannaEcosystem.a].setY(consumer[ab].getCordinates().getY());
			    				consumer[ab].setPopulationDensity(consumer[ab].getPopulationDensity()-10);
			    				TreeLeaves1[ab].setCordinates(cm.SavannaMouvement(TreeLeaves1[ab]));
		    		        	SavannaEcosystem.a++;
		    		        	newspecies++;
		    		        }
		        		}
		        		TreeLeaves[] TreeLeavescreate1 = new TreeLeaves[newspecies];
		        		for(int ab=0;ab<lastbox;ab++) {
			        		if(TreeLeaves1[ab]!=null) {
			    		        if(TreeLeaves1[ab].getPopulationDensity()==10) {
			    		        	TreeLeavescreate1[speciescreat]=TreeLeaves1[ab];
			    		        	speciescreat++;
			    		        }
			        		}
		        		}
		        		TreeLeaves[] allgroupsTreeLeaves1=new TreeLeaves[lastbox+newspecies];
		        		int lengthTreeLeaves1 = allgroupsTreeLeaves1.length;
	    				for(int i=0;i<lastbox;i++) {
	    					allgroupsTreeLeaves1[i]=(TreeLeaves) consumer[i];
	    				}
	    				int jiTreeLeaves1;
	    				for(jiTreeLeaves1=lastbox;jiTreeLeaves1<lengthTreeLeaves1;jiTreeLeaves1++) {
	    					allgroupsTreeLeaves1[jiTreeLeaves1]=TreeLeavescreate1[jiTreeLeaves1-lastbox];
	    				}
	    			
	    				for(int ia=0;ia<lengthTreeLeaves1;ia++) {
	    				}
	    				animalsInSavana.register(name, allgroupsTreeLeaves1);
	        				
		        		break;
		        		
		        	case "ferns":
		        		Ferns[] Ferns = new Ferns[lastbox];
		        		for(int ab=0;ab<lastbox;ab++) {
		        			int currentpopulation=consumer[ab].getPopulationDensity();
		    		    	currentpopulation+=currentpopulation/2;
		    		        consumer[ab].setPopulationDensity(currentpopulation);
		    		        if(consumer[ab].getPopulationDensity()>=12) {
			        			Ferns[ab]= new Ferns ("ferns",true,10,10,4,20,25,0,4, pos.initPosition[SavannaEcosystem.a]);
			        			pos.initPosition[SavannaEcosystem.a].setX(consumer[ab].getCordinates().getX());
			        			pos.initPosition[SavannaEcosystem.a].setY(consumer[ab].getCordinates().getY());
			    				consumer[ab].setPopulationDensity(consumer[ab].getPopulationDensity()-10);
			    				Ferns[ab].setCordinates(cm.SavannaMouvement(Ferns[ab]));
		    		        	SavannaEcosystem.a++;
		    		        	newspecies++;
		    		        }
		        		}
		        		Ferns[] Fernscreate = new Ferns[newspecies];
		        		for(int ab=0;ab<lastbox;ab++) {
			        		if(Ferns[ab]!=null) {
			    		        if(Ferns[ab].getPopulationDensity()==10) {
			    		        	Fernscreate[speciescreat]=Ferns[ab];
			    		        	speciescreat++;
			    		        }
			        		}
		        		}
		        		Ferns[] allgroupsFerns=new Ferns[lastbox+newspecies];
		        		int lengthFerns = allgroupsFerns.length;
	    				for(int i=0;i<lastbox;i++) {
	    					allgroupsFerns[i]=(Ferns) consumer[i];
	    				}
	    				int jiFerns;
	    				for(jiFerns=lastbox;jiFerns<lengthFerns;jiFerns++) {
	    					allgroupsFerns[jiFerns]=Fernscreate[jiFerns-lastbox];
	    				}
	    			
	    				for(int ia=0;ia<lengthFerns;ia++) {
	    				}
	    				animalsInSavana.register(name, allgroupsFerns);
	        				
		        		break;
		        	case "aphid":
		        		Aphid[] Aphid = new Aphid[lastbox];
		        		for(int ab=0;ab<lastbox;ab++) {
		        			int currentpopulation=consumer[ab].getPopulationDensity();
		    		    	currentpopulation+=currentpopulation/2;
		    		        consumer[ab].setPopulationDensity(currentpopulation);
		    		        if(consumer[ab].getPopulationDensity()>=12) {
			        			Aphid[ab]= new Aphid ("aphid", 20, 100, true,10, 0,40, 10, 3, false, pos.initPosition[SavannaEcosystem.a]);
			        			pos.initPosition[SavannaEcosystem.a].setX(consumer[ab].getCordinates().getX());
			        			pos.initPosition[SavannaEcosystem.a].setY(consumer[ab].getCordinates().getY());
			    				consumer[ab].setPopulationDensity(consumer[ab].getPopulationDensity()-10);
			    				Aphid[ab].setCordinates(cm.SavannaMouvement(Aphid[ab]));
		    		        	SavannaEcosystem.a++;
		    		        	newspecies++;
		    		        }
		        		}
		        		Aphid[] Aphidcreate = new Aphid[newspecies];
		        		for(int ab=0;ab<lastbox;ab++) {
			        		if(Aphid[ab]!=null) {
			    		        if(Aphid[ab].getPopulationDensity()==10) {
			    		        	Aphidcreate[speciescreat]=Aphid[ab];
			    		        	speciescreat++;
			    		        }
			        		}
		        		}
		        		Aphid[] allgroupsAphid=new Aphid[lastbox+newspecies];
		        		int lengthAphid = allgroupsAphid.length;
	    				for(int i=0;i<lastbox;i++) {
	    					allgroupsAphid[i]=(Aphid) consumer[i];
	    				}
	    				int jiAphid;
	    				for(jiAphid=lastbox;jiAphid<lengthAphid;jiAphid++) {
	    					allgroupsAphid[jiAphid]=Aphidcreate[jiAphid-lastbox];
	    				}
	    			
	    				for(int ia=0;ia<lengthAphid;ia++) {
	    				}
	    				animalsInSavana.register(name, allgroupsAphid);
	        				
		        		break;
		        	case "herbivorousladybug":
		        		HerbivorousLadybug[] HerbivorousLadybug = new HerbivorousLadybug[lastbox];
		        		for(int ab=0;ab<lastbox;ab++) {
		        			int currentpopulation=consumer[ab].getPopulationDensity();
		    		    	currentpopulation+=currentpopulation/2;
		    		        consumer[ab].setPopulationDensity(currentpopulation);
		    		        if(consumer[ab].getPopulationDensity()>=12) {
			        			HerbivorousLadybug[ab]= new HerbivorousLadybug ("herbivorousladybug", 20, 100, true,10, 0,40, 10, 3, false, pos.initPosition[SavannaEcosystem.a]);
			        			pos.initPosition[SavannaEcosystem.a].setX(consumer[ab].getCordinates().getX());
			        			pos.initPosition[SavannaEcosystem.a].setY(consumer[ab].getCordinates().getY());
			    				consumer[ab].setPopulationDensity(consumer[ab].getPopulationDensity()-10);
			    				HerbivorousLadybug[ab].setCordinates(cm.SavannaMouvement(HerbivorousLadybug[ab]));
		    		        	SavannaEcosystem.a++;
		    		        	newspecies++;
		    		        }
		        		}
		        		HerbivorousLadybug[] HerbivorousLadybugcreate = new HerbivorousLadybug[newspecies];
		        		for(int ab=0;ab<lastbox;ab++) {
			        		if(HerbivorousLadybug[ab]!=null) {
			    		        if(HerbivorousLadybug[ab].getPopulationDensity()==10) {
			    		        	HerbivorousLadybugcreate[speciescreat]=HerbivorousLadybug[ab];
			    		        	speciescreat++;
			    		        }
			        		}
		        		}
		        		HerbivorousLadybug[] allgroupsHerbivorousLadybug=new HerbivorousLadybug[lastbox+newspecies];
		        		int lengthHerbivorousLadybug = allgroupsHerbivorousLadybug.length;
	    				for(int i=0;i<lastbox;i++) {
	    					allgroupsHerbivorousLadybug[i]=(HerbivorousLadybug) consumer[i];
	    				}
	    				int jiHerbivorousLadybug;
	    				for(jiHerbivorousLadybug=lastbox;jiHerbivorousLadybug<lengthHerbivorousLadybug;jiHerbivorousLadybug++) {
	    					allgroupsHerbivorousLadybug[jiHerbivorousLadybug]=HerbivorousLadybugcreate[jiHerbivorousLadybug-lastbox];
	    				}
	    			
	    				for(int ia=0;ia<lengthHerbivorousLadybug;ia++) {
	    				}
	    				animalsInSavana.register(name, allgroupsHerbivorousLadybug);
	        				
		        		break;
		        		
		        	case "spider":
		        		Spider[] Spider = new Spider[lastbox];
		        		for(int ab=0;ab<lastbox;ab++) {
		        			int currentpopulation=consumer[ab].getPopulationDensity();
		    		    	currentpopulation+=currentpopulation/2;
		    		        consumer[ab].setPopulationDensity(currentpopulation);
		    		        if(consumer[ab].getPopulationDensity()>=12) {
			        			Spider[ab]= new Spider ("spider", 20, 100, true,10, 0,40, 10, 3, false, pos.initPosition[SavannaEcosystem.a]);
			        			pos.initPosition[SavannaEcosystem.a].setX(consumer[ab].getCordinates().getX());
			        			pos.initPosition[SavannaEcosystem.a].setY(consumer[ab].getCordinates().getY());
			    				consumer[ab].setPopulationDensity(consumer[ab].getPopulationDensity()-10);
			    				Spider[ab].setCordinates(cm.SavannaMouvement(Spider[ab]));
		    		        	SavannaEcosystem.a++;
		    		        	newspecies++;
		    		        }
		        		}
		        		Spider[] Spidercreate = new Spider[newspecies];
		        		for(int ab=0;ab<lastbox;ab++) {
			        		if(Spider[ab]!=null) {
			    		        if(Spider[ab].getPopulationDensity()==10) {
			    		        	Spidercreate[speciescreat]=Spider[ab];
			    		        	speciescreat++;
			    		        }
			        		}
		        		}
		        		Spider[] allgroupsSpider=new Spider[lastbox+newspecies];
		        		int lengthSpider = allgroupsSpider.length;
	    				for(int i=0;i<lastbox;i++) {
	    					allgroupsSpider[i]=(Spider) consumer[i];
	    				}
	    				int jiSpider;
	    				for(jiSpider=lastbox;jiSpider<lengthSpider;jiSpider++) {
	    					allgroupsSpider[jiSpider]=Spidercreate[jiSpider-lastbox];
	    				}
	    			
	    				for(int ia=0;ia<lengthSpider;ia++) {
	    				}
	    				animalsInSavana.register(name, allgroupsSpider);
	        				
		        		break;
		        		
		        	case "bramble":
		        		Bramble[] Bramble = new Bramble[lastbox];
		        		for(int ab=0;ab<lastbox;ab++) {
		        			int currentpopulation=consumer[ab].getPopulationDensity();
		    		    	currentpopulation+=currentpopulation/2;
		    		        consumer[ab].setPopulationDensity(currentpopulation);
		    		        if(consumer[ab].getPopulationDensity()>=12) {
			        			Bramble[ab]= new Bramble ("bramble", 20, 100, true,10, 0,40, 10, 3, false, pos.initPosition[SavannaEcosystem.a]);
			        			pos.initPosition[SavannaEcosystem.a].setX(consumer[ab].getCordinates().getX());
			        			pos.initPosition[SavannaEcosystem.a].setY(consumer[ab].getCordinates().getY());
			    				consumer[ab].setPopulationDensity(consumer[ab].getPopulationDensity()-10);
			    				Bramble[ab].setCordinates(cm.SavannaMouvement(Bramble[ab]));
		    		        	SavannaEcosystem.a++;
		    		        	newspecies++;
		    		        }
		        		}
		        		Bramble[] Bramblecreate = new Bramble[newspecies];
		        		for(int ab=0;ab<lastbox;ab++) {
			        		if(Bramble[ab]!=null) {
			    		        if(Bramble[ab].getPopulationDensity()==10) {
			    		        	Bramblecreate[speciescreat]=Bramble[ab];
			    		        	speciescreat++;
			    		        }
			        		}
		        		}
		        		Bramble[] allgroupsBramble=new Bramble[lastbox+newspecies];
		        		int lengthBramble = allgroupsBramble.length;
	    				for(int i=0;i<lastbox;i++) {
	    					allgroupsBramble[i]=(Bramble) consumer[i];
	    				}
	    				int jiBramble;
	    				for(jiBramble=lastbox;jiBramble<lengthBramble;jiBramble++) {
	    					allgroupsBramble[jiBramble]=Bramblecreate[jiBramble-lastbox];
	    				}
	    			
	    				for(int ia=0;ia<lengthBramble;ia++) {
	    				}
	    				animalsInSavana.register(name, allgroupsBramble);
	        				
		        		break;
		        		
		        	case "woodpecker":
		        		Woodpecker[] Woodpecker = new Woodpecker[lastbox];
		        		for(int ab=0;ab<lastbox;ab++) {
		        			int currentpopulation=consumer[ab].getPopulationDensity();
		    		    	currentpopulation+=currentpopulation/2;
		    		        consumer[ab].setPopulationDensity(currentpopulation);
		    		        if(consumer[ab].getPopulationDensity()>=12) {
			        			Woodpecker[ab]= new Woodpecker ("woodpecker", 20, 100, true,10, 0,40, 10, 3, false, pos.initPosition[SavannaEcosystem.a]);
			        			pos.initPosition[SavannaEcosystem.a].setX(consumer[ab].getCordinates().getX());
			        			pos.initPosition[SavannaEcosystem.a].setY(consumer[ab].getCordinates().getY());
			    				consumer[ab].setPopulationDensity(consumer[ab].getPopulationDensity()-10);
			    				Woodpecker[ab].setCordinates(cm.SavannaMouvement(Woodpecker[ab]));
		    		        	SavannaEcosystem.a++;
		    		        	newspecies++;
		    		        }
		        		}
		        		Woodpecker[] Woodpeckercreate = new Woodpecker[newspecies];
		        		for(int ab=0;ab<lastbox;ab++) {
			        		if(Woodpecker[ab]!=null) {
			    		        if(Woodpecker[ab].getPopulationDensity()==10) {
			    		        	Woodpeckercreate[speciescreat]=Woodpecker[ab];
			    		        	speciescreat++;
			    		        }
			        		}
		        		}
		        		Woodpecker[] allgroupsWoodpecker=new Woodpecker[lastbox+newspecies];
		        		int lengthWoodpecker = allgroupsWoodpecker.length;
	    				for(int i=0;i<lastbox;i++) {
	    					allgroupsWoodpecker[i]=(Woodpecker) consumer[i];
	    				}
	    				int jiWoodpecker;
	    				for(jiWoodpecker=lastbox;jiWoodpecker<lengthWoodpecker;jiWoodpecker++) {
	    					allgroupsWoodpecker[jiWoodpecker]=Woodpeckercreate[jiWoodpecker-lastbox];
	    				}
	    			
	    				for(int ia=0;ia<lengthWoodpecker;ia++) {
	    				}
	    				animalsInSavana.register(name, allgroupsWoodpecker);
	        				
		        		break;
		        		
		        	case "asianLadybug":
		        		AsianLadybug[] AsianLadybug = new AsianLadybug[lastbox];
		        		for(int ab=0;ab<lastbox;ab++) {
		        			int currentpopulation=consumer[ab].getPopulationDensity();
		    		    	currentpopulation+=currentpopulation/2;
		    		        consumer[ab].setPopulationDensity(currentpopulation);
		    		        if(consumer[ab].getPopulationDensity()>=12) {
			        			AsianLadybug[ab]= new AsianLadybug ("asianladybug", 20, 100, true,10, 0,40, 10, 3, false, pos.initPosition[SavannaEcosystem.a]);
			        			pos.initPosition[SavannaEcosystem.a].setX(consumer[ab].getCordinates().getX());
			        			pos.initPosition[SavannaEcosystem.a].setY(consumer[ab].getCordinates().getY());
			    				consumer[ab].setPopulationDensity(consumer[ab].getPopulationDensity()-10);
			    				AsianLadybug[ab].setCordinates(cm.SavannaMouvement(AsianLadybug[ab]));
		    		        	SavannaEcosystem.a++;
		    		        	newspecies++;
		    		        }
		        		}
		        		AsianLadybug[] AsianLadybugcreate = new AsianLadybug[newspecies];
		        		for(int ab=0;ab<lastbox;ab++) {
			        		if(AsianLadybug[ab]!=null) {
			    		        if(AsianLadybug[ab].getPopulationDensity()==10) {
			    		        	AsianLadybugcreate[speciescreat]=AsianLadybug[ab];
			    		        	speciescreat++;
			    		        }
			        		}
		        		}
		        		AsianLadybug[] allgroupsAsianLadybug=new AsianLadybug[lastbox+newspecies];
		        		int lengthAsianLadybug = allgroupsAsianLadybug.length;
	    				for(int i=0;i<lastbox;i++) {
	    					allgroupsAsianLadybug[i]=(AsianLadybug) consumer[i];
	    				}
	    				int jiAsianLadybug;
	    				for(jiAsianLadybug=lastbox;jiAsianLadybug<lengthAsianLadybug;jiAsianLadybug++) {
	    					allgroupsAsianLadybug[jiAsianLadybug]=AsianLadybugcreate[jiAsianLadybug-lastbox];
	    				}
	    			
	    				for(int ia=0;ia<lengthAsianLadybug;ia++) {
	    				}
	    				animalsInSavana.register(name, allgroupsAsianLadybug);
	        				
		        		break;
		        	
		        		
		        	/**
		        	 * 	Part for reproduction in Frosty Ecosystem, the reproductions of following ecosystem are line 1226
		        	 */
		        	case "grassFrosty":
		        		Grass[] GrassFrosty = new Grass[lastbox];
		        		for(int ab=0;ab<lastbox;ab++) {
		        			int currentpopulation=consumer[ab].getPopulationDensity();
		    		    	currentpopulation+=currentpopulation/2;
		    		        consumer[ab].setPopulationDensity(currentpopulation);
		    		        if(consumer[ab].getPopulationDensity()>=12) {
			        			GrassFrosty[ab]= new Grass ("grass",true,10,10,4,20,25,0,4, pos.initPosition[SavannaEcosystem.a]);
			        			pos.initPosition[SavannaEcosystem.a].setX(consumer[ab].getCordinates().getX());
			        			pos.initPosition[SavannaEcosystem.a].setY(consumer[ab].getCordinates().getY());
			    				consumer[ab].setPopulationDensity(consumer[ab].getPopulationDensity()-10);
			    				GrassFrosty[ab].setCordinates(cm.SavannaMouvement(GrassFrosty[ab]));
		    		        	SavannaEcosystem.a++;
		    		        	newspecies++;
		    		        }
		        		}
		        		Grass[] GrasscreateFrosty = new Grass[newspecies];
		        		for(int ab=0;ab<lastbox;ab++) {
			        		if(GrassFrosty[ab]!=null) {
			    		        if(GrassFrosty[ab].getPopulationDensity()==10) {
			    		        	GrasscreateFrosty[speciescreat]=GrassFrosty[ab];
			    		        	speciescreat++;
			    		        }
			        		}
		        		}
		        		Grass[] allgroupsGrassFrosty=new Grass[lastbox+newspecies];
		        		int lengthGrassFrosty = allgroupsGrassFrosty.length;
	    				for(int i=0;i<lastbox;i++) {
	    					allgroupsGrassFrosty[i]=(Grass) consumer[i];
	    				}
	    				int jiGrassFrosty;
	    				for(jiGrassFrosty=lastbox;jiGrassFrosty<lengthGrassFrosty;jiGrassFrosty++) {
	    					allgroupsGrassFrosty[jiGrassFrosty]=GrasscreateFrosty[jiGrassFrosty-lastbox];
	    				}
	    			
	    				for(int ia=0;ia<lengthGrassFrosty;ia++) {
	    				}
	    				animalsInSavana.register(name, allgroupsGrassFrosty);
	        				
		        		break;
		        		
		        	case "foam":
		        		Foam[] Foam = new Foam[lastbox];
		        		for(int ab=0;ab<lastbox;ab++) {
		        			int currentpopulation=consumer[ab].getPopulationDensity();
		    		    	currentpopulation+=currentpopulation/2;
		    		        consumer[ab].setPopulationDensity(currentpopulation);
		    		        if(consumer[ab].getPopulationDensity()>=12) {
			        			Foam[ab]= new Foam ("foam",true,10,10,4,20,25,0,4, pos.initPosition[SavannaEcosystem.a]);
			        			pos.initPosition[SavannaEcosystem.a].setX(consumer[ab].getCordinates().getX());
			        			pos.initPosition[SavannaEcosystem.a].setY(consumer[ab].getCordinates().getY());
			    				consumer[ab].setPopulationDensity(consumer[ab].getPopulationDensity()-10);
			    				Foam[ab].setCordinates(cm.SavannaMouvement(Foam[ab]));
		    		        	SavannaEcosystem.a++;
		    		        	newspecies++;
		    		        }
		        		}
		        		Foam[] Foamcreate = new Foam[newspecies];
		        		for(int ab=0;ab<lastbox;ab++) {
			        		if(Foam[ab]!=null) {
			    		        if(Foam[ab].getPopulationDensity()==10) {
			    		        	Foamcreate[speciescreat]=Foam[ab];
			    		        	speciescreat++;
			    		        }
			        		}
		        		}
		        		Foam[] allgroupsFoam=new Foam[lastbox+newspecies];
		        		int lengthFoam = allgroupsFoam.length;
	    				for(int i=0;i<lastbox;i++) {
	    					allgroupsFoam[i]=(Foam) consumer[i];
	    				}
	    				int jiFoam;
	    				for(jiFoam=lastbox;jiFoam<lengthFoam;jiFoam++) {
	    					allgroupsFoam[jiFoam]=Foamcreate[jiFoam-lastbox];
	    				}
	    			
	    				for(int ia=0;ia<lengthFoam;ia++) {
	    				}
	    				animalsInSavana.register(name, allgroupsFoam);
	        				
		        		break;
		        	case "muskox":
		        		MuskOx[] MuskOx = new MuskOx[lastbox];
		        		for(int ab=0;ab<lastbox;ab++) {
		        			int currentpopulation=consumer[ab].getPopulationDensity();
		    		    	currentpopulation+=currentpopulation/2;
		    		        consumer[ab].setPopulationDensity(currentpopulation);
		    		        if(consumer[ab].getPopulationDensity()>=12) {
			        			MuskOx[ab]= new MuskOx ("muskox", 20, 100, true,10, 0,40, 10, 3, false, pos.initPosition[SavannaEcosystem.a]);
			        			pos.initPosition[SavannaEcosystem.a].setX(consumer[ab].getCordinates().getX());
			        			pos.initPosition[SavannaEcosystem.a].setY(consumer[ab].getCordinates().getY());
			    				consumer[ab].setPopulationDensity(consumer[ab].getPopulationDensity()-10);
			    				MuskOx[ab].setCordinates(cm.SavannaMouvement(MuskOx[ab]));
		    		        	SavannaEcosystem.a++;
		    		        	newspecies++;
		    		        }
		        		}
		        		MuskOx[] MuskOxcreate = new MuskOx[newspecies];
		        		for(int ab=0;ab<lastbox;ab++) {
			        		if(MuskOx[ab]!=null) {
			    		        if(MuskOx[ab].getPopulationDensity()==10) {
			    		        	MuskOxcreate[speciescreat]=MuskOx[ab];
			    		        	speciescreat++;
			    		        }
			        		}
		        		}
		        		MuskOx[] allgroupsMuskOx=new MuskOx[lastbox+newspecies];
		        		int lengthMuskOx = allgroupsMuskOx.length;
	    				for(int i=0;i<lastbox;i++) {
	    					allgroupsMuskOx[i]=(MuskOx) consumer[i];
	    				}
	    				int jiMuskOx;
	    				for(jiMuskOx=lastbox;jiMuskOx<lengthMuskOx;jiMuskOx++) {
	    					allgroupsMuskOx[jiMuskOx]=MuskOxcreate[jiMuskOx-lastbox];
	    				}
	    			
	    				for(int ia=0;ia<lengthMuskOx;ia++) {
	    				}
	    				animalsInSavana.register(name, allgroupsMuskOx);
	        				
		        		break;
		        	case "clam":
		        		Clam[] Clam = new Clam[lastbox];
		        		for(int ab=0;ab<lastbox;ab++) {
		        			int currentpopulation=consumer[ab].getPopulationDensity();
		    		    	currentpopulation+=currentpopulation/2;
		    		        consumer[ab].setPopulationDensity(currentpopulation);
		    		        if(consumer[ab].getPopulationDensity()>=12) {
			        			Clam[ab]= new Clam ("clam", 20, 100, true,10, 0,40, 10, 3, false, pos.initPosition[SavannaEcosystem.a]);
			        			pos.initPosition[SavannaEcosystem.a].setX(consumer[ab].getCordinates().getX());
			        			pos.initPosition[SavannaEcosystem.a].setY(consumer[ab].getCordinates().getY());
			    				consumer[ab].setPopulationDensity(consumer[ab].getPopulationDensity()-10);
			    				Clam[ab].setCordinates(cm.SavannaMouvement(Clam[ab]));
		    		        	SavannaEcosystem.a++;
		    		        	newspecies++;
		    		        }
		        		}
		        		Clam[] Clamcreate = new Clam[newspecies];
		        		for(int ab=0;ab<lastbox;ab++) {
			        		if(Clam[ab]!=null) {
			    		        if(Clam[ab].getPopulationDensity()==10) {
			    		        	Clamcreate[speciescreat]=Clam[ab];
			    		        	speciescreat++;
			    		        }
			        		}
		        		}
		        		Clam[] allgroupsClam=new Clam[lastbox+newspecies];
		        		int lengthClam = allgroupsClam.length;
	    				for(int i=0;i<lastbox;i++) {
	    					allgroupsClam[i]=(Clam) consumer[i];
	    				}
	    				int jiClam;
	    				for(jiClam=lastbox;jiClam<lengthClam;jiClam++) {
	    					allgroupsClam[jiClam]=Clamcreate[jiClam-lastbox];
	    				}
	    			
	    				for(int ia=0;ia<lengthClam;ia++) {
	    				}
	    				animalsInSavana.register(name, allgroupsClam);
	        				
		        		break;
		        		
		        	case "arcticwolf":
		        		ArcticWolf[] ArcticWolf = new ArcticWolf[lastbox];
		        		for(int ab=0;ab<lastbox;ab++) {
		        			int currentpopulation=consumer[ab].getPopulationDensity();
		    		    	currentpopulation+=currentpopulation/2;
		    		        consumer[ab].setPopulationDensity(currentpopulation);
		    		        if(consumer[ab].getPopulationDensity()>=12) {
			        			ArcticWolf[ab]= new ArcticWolf ("arcticwolf", 20, 100, true,10, 0,40, 10, 3, false, pos.initPosition[SavannaEcosystem.a]);
			        			pos.initPosition[SavannaEcosystem.a].setX(consumer[ab].getCordinates().getX());
			        			pos.initPosition[SavannaEcosystem.a].setY(consumer[ab].getCordinates().getY());
			    				consumer[ab].setPopulationDensity(consumer[ab].getPopulationDensity()-10);
			    				ArcticWolf[ab].setCordinates(cm.SavannaMouvement(ArcticWolf[ab]));
		    		        	SavannaEcosystem.a++;
		    		        	newspecies++;
		    		        }
		        		}
		        		ArcticWolf[] ArcticWolfcreate = new ArcticWolf[newspecies];
		        		for(int ab=0;ab<lastbox;ab++) {
			        		if(ArcticWolf[ab]!=null) {
			    		        if(ArcticWolf[ab].getPopulationDensity()==10) {
			    		        	ArcticWolfcreate[speciescreat]=ArcticWolf[ab];
			    		        	speciescreat++;
			    		        }
			        		}
		        		}
		        		ArcticWolf[] allgroupsArcticWolf=new ArcticWolf[lastbox+newspecies];
		        		int lengthArcticWolf = allgroupsArcticWolf.length;
	    				for(int i=0;i<lastbox;i++) {
	    					allgroupsArcticWolf[i]=(ArcticWolf) consumer[i];
	    				}
	    				int jiArcticWolf;
	    				for(jiArcticWolf=lastbox;jiArcticWolf<lengthArcticWolf;jiArcticWolf++) {
	    					allgroupsArcticWolf[jiArcticWolf]=ArcticWolfcreate[jiArcticWolf-lastbox];
	    				}
	    			
	    				for(int ia=0;ia<lengthArcticWolf;ia++) {
	    				}
	    				animalsInSavana.register(name, allgroupsArcticWolf);
	        				
		        		break;
		        		
		        	case "inuit":
		        		Inuit[] Inuit = new Inuit[lastbox];
		        		for(int ab=0;ab<lastbox;ab++) {
		        			int currentpopulation=consumer[ab].getPopulationDensity();
		    		    	currentpopulation+=currentpopulation/2;
		    		        consumer[ab].setPopulationDensity(currentpopulation);
		    		        if(consumer[ab].getPopulationDensity()>=12) {
			        			Inuit[ab]= new Inuit ("inuit", 20, 100, true,10, 0,40, 10, 3, false, pos.initPosition[SavannaEcosystem.a]);
			        			pos.initPosition[SavannaEcosystem.a].setX(consumer[ab].getCordinates().getX());
			        			pos.initPosition[SavannaEcosystem.a].setY(consumer[ab].getCordinates().getY());
			    				consumer[ab].setPopulationDensity(consumer[ab].getPopulationDensity()-10);
			    				Inuit[ab].setCordinates(cm.SavannaMouvement(Inuit[ab]));
		    		        	SavannaEcosystem.a++;
		    		        	newspecies++;
		    		        }
		        		}
		        		Inuit[] Inuitcreate = new Inuit[newspecies];
		        		for(int ab=0;ab<lastbox;ab++) {
			        		if(Inuit[ab]!=null) {
			    		        if(Inuit[ab].getPopulationDensity()==10) {
			    		        	Inuitcreate[speciescreat]=Inuit[ab];
			    		        	speciescreat++;
			    		        }
			        		}
		        		}
		        		Inuit[] allgroupsInuit=new Inuit[lastbox+newspecies];
		        		int lengthInuit = allgroupsInuit.length;
	    				for(int i=0;i<lastbox;i++) {
	    					allgroupsInuit[i]=(Inuit) consumer[i];
	    				}
	    				int jiInuit;
	    				for(jiInuit=lastbox;jiInuit<lengthInuit;jiInuit++) {
	    					allgroupsInuit[jiInuit]=Inuitcreate[jiInuit-lastbox];
	    				}
	    			
	    				for(int ia=0;ia<lengthInuit;ia++) {
	    				}
	    				animalsInSavana.register(name, allgroupsInuit);
	        				
		        		break;
		        		
		        	case "polarbear":
		        		PolarBear[] PolarBear = new PolarBear[lastbox];
		        		for(int ab=0;ab<lastbox;ab++) {
		        			int currentpopulation=consumer[ab].getPopulationDensity();
		    		    	currentpopulation+=currentpopulation/2;
		    		        consumer[ab].setPopulationDensity(currentpopulation);
		    		        if(consumer[ab].getPopulationDensity()>=12) {
			        			PolarBear[ab]= new PolarBear ("polarbear", 20, 100, true,10, 0,40, 10, 3, false, pos.initPosition[SavannaEcosystem.a]);
			        			pos.initPosition[SavannaEcosystem.a].setX(consumer[ab].getCordinates().getX());
			        			pos.initPosition[SavannaEcosystem.a].setY(consumer[ab].getCordinates().getY());
			    				consumer[ab].setPopulationDensity(consumer[ab].getPopulationDensity()-10);
			    				PolarBear[ab].setCordinates(cm.SavannaMouvement(PolarBear[ab]));
		    		        	SavannaEcosystem.a++;
		    		        	newspecies++;
		    		        }
		        		}
		        		PolarBear[] PolarBearcreate = new PolarBear[newspecies];
		        		for(int ab=0;ab<lastbox;ab++) {
			        		if(PolarBear[ab]!=null) {
			    		        if(PolarBear[ab].getPopulationDensity()==10) {
			    		        	PolarBearcreate[speciescreat]=PolarBear[ab];
			    		        	speciescreat++;
			    		        }
			        		}
		        		}
		        		PolarBear[] allgroupsPolarBear=new PolarBear[lastbox+newspecies];
		        		int lengthPolarBear = allgroupsPolarBear.length;
	    				for(int i=0;i<lastbox;i++) {
	    					allgroupsPolarBear[i]=(PolarBear) consumer[i];
	    				}
	    				int jiPolarBear;
	    				for(jiPolarBear=lastbox;jiPolarBear<lengthPolarBear;jiPolarBear++) {
	    					allgroupsPolarBear[jiPolarBear]=PolarBearcreate[jiPolarBear-lastbox];
	    				}
	    			
	    				for(int ia=0;ia<lengthPolarBear;ia++) {
	    				}
	    				animalsInSavana.register(name, allgroupsPolarBear);
	        				
		        		break;
		        		
		        	case "phoque":
		        		Phoque[] Phoque = new Phoque[lastbox];
		        		for(int ab=0;ab<lastbox;ab++) {
		        			int currentpopulation=consumer[ab].getPopulationDensity();
		    		    	currentpopulation+=currentpopulation/2;
		    		        consumer[ab].setPopulationDensity(currentpopulation);
		    		        if(consumer[ab].getPopulationDensity()>=12) {
			        			Phoque[ab]= new Phoque ("phoque", 20, 100, true,10, 0,40, 10, 3, false, pos.initPosition[SavannaEcosystem.a]);
			        			pos.initPosition[SavannaEcosystem.a].setX(consumer[ab].getCordinates().getX());
			        			pos.initPosition[SavannaEcosystem.a].setY(consumer[ab].getCordinates().getY());
			    				consumer[ab].setPopulationDensity(consumer[ab].getPopulationDensity()-10);
			    				Phoque[ab].setCordinates(cm.SavannaMouvement(Phoque[ab]));
		    		        	SavannaEcosystem.a++;
		    		        	newspecies++;
		    		        }
		        		}
		        		Phoque[] Phoquecreate = new Phoque[newspecies];
		        		for(int ab=0;ab<lastbox;ab++) {
			        		if(Phoque[ab]!=null) {
			    		        if(Phoque[ab].getPopulationDensity()==10) {
			    		        	Phoquecreate[speciescreat]=Phoque[ab];
			    		        	speciescreat++;
			    		        }
			        		}
		        		}
		        		Phoque[] allgroupsPhoque=new Phoque[lastbox+newspecies];
		        		int lengthPhoque = allgroupsPhoque.length;
	    				for(int i=0;i<lastbox;i++) {
	    					allgroupsPhoque[i]=(Phoque) consumer[i];
	    				}
	    				int jiPhoque;
	    				for(jiPhoque=lastbox;jiPhoque<lengthPhoque;jiPhoque++) {
	    					allgroupsPhoque[jiPhoque]=Phoquecreate[jiPhoque-lastbox];
	    				}
	    			
	    				for(int ia=0;ia<lengthPhoque;ia++) {
	    				}
	    				animalsInSavana.register(name, allgroupsPhoque);
	        				
		        		break;
		        	
		        	
		        	/**
		        	 * Part for reproduction in Swamps Ecosystem
		        	 */
		        	case "turtle":
		        		Turtle[] Turtle1 = new Turtle[lastbox];
		        		for(int ab=0;ab<lastbox;ab++) {
		        			int currentpopulation=consumer[ab].getPopulationDensity();
		    		    	currentpopulation+=currentpopulation/2;
		    		        consumer[ab].setPopulationDensity(currentpopulation);
		    		        if(consumer[ab].getPopulationDensity()>=12) {
			        			Turtle1[ab]= new Turtle ("turtle", 20, 100, true,10, 0,40, 10, 3, false, pos.initPosition[SavannaEcosystem.a]);
			        			pos.initPosition[SavannaEcosystem.a].setX(consumer[ab].getCordinates().getX());
			        			pos.initPosition[SavannaEcosystem.a].setY(consumer[ab].getCordinates().getY());
			    				consumer[ab].setPopulationDensity(consumer[ab].getPopulationDensity()-10);
			    				Turtle1[ab].setCordinates(cm.SavannaMouvement(Turtle1[ab]));
		    		        	SavannaEcosystem.a++;
		    		        	newspecies++;
		    		        }
		        		}
		        		Turtle[] Turtlecreate1 = new Turtle[newspecies];
		        		for(int ab=0;ab<lastbox;ab++) {
			        		if(Turtle1[ab]!=null) {
			    		        if(Turtle1[ab].getPopulationDensity()==10) {
			    		        	Turtlecreate1[speciescreat]=Turtle1[ab];
			    		        	speciescreat++;
			    		        }
			        		}
		        		}
		        		Turtle[] allgroups1=new Turtle[lastbox+newspecies];
		        		int length1 = allgroups1.length;
	    				for(int i=0;i<lastbox;i++) {
	    					allgroups1[i]=(Turtle) consumer[i];
	    				}
	    				int ji1;
	    				for(ji1=lastbox;ji1<length1;ji1++) {
	    					allgroups1[ji1]=Turtlecreate1[ji1-lastbox];
	    				}
	    				
	    				
	    				for(int ia=0;ia<length1;ia++) {
	    				}
		    			animalsInSavana.register(name, allgroups1);		
		        		break;
		        		
		        	
		        	case "monkey":
		        		Monkey[] Monkey = new Monkey[lastbox];
		        		for(int ab=0;ab<lastbox;ab++) {
		        			int currentpopulation=consumer[ab].getPopulationDensity();
		    		    	currentpopulation+=currentpopulation/2;
		    		        consumer[ab].setPopulationDensity(currentpopulation);
		    		        if(consumer[ab].getPopulationDensity()>=12) {
			        			Monkey[ab]= new Monkey ("monkey", 20, 100, true,10, 0,40, 10, 3, false, pos.initPosition[SavannaEcosystem.a]);
			        			pos.initPosition[SavannaEcosystem.a].setX(consumer[ab].getCordinates().getX());
			        			pos.initPosition[SavannaEcosystem.a].setY(consumer[ab].getCordinates().getY());
			    				consumer[ab].setPopulationDensity(consumer[ab].getPopulationDensity()-10);
			    				Monkey[ab].setCordinates(cm.SavannaMouvement(Monkey[ab]));
		    		        	SavannaEcosystem.a++;
		    		        	newspecies++;
		    		        }
		        		}
		        		Monkey[] Monkeycreate = new Monkey[newspecies];
		        		for(int ab=0;ab<lastbox;ab++) {
			        		if(Monkey[ab]!=null) {
			    		        if(Monkey[ab].getPopulationDensity()==10) {
			    		        	Monkeycreate[speciescreat]=Monkey[ab];
			    		        	speciescreat++;
			    		        }
			        		}
		        		}
		        		Monkey[] allgroupsMonkey=new Monkey[lastbox+newspecies];
		        		int lengthMonkey = allgroupsMonkey.length;
	    				for(int i=0;i<lastbox;i++) {
	    					allgroupsMonkey[i]=(Monkey) consumer[i];
	    				}
	    				int jiMonkey;
	    				for(jiMonkey=lastbox;jiMonkey<lengthMonkey;jiMonkey++) {
	    					allgroupsMonkey[jiMonkey]=Monkeycreate[jiMonkey-lastbox];
	    				}
	    			
	    				for(int ia=0;ia<lengthMonkey;ia++) {
	    				}
	    				animalsInSavana.register(name, allgroupsMonkey);
	        				
		        		break;
		        		
		        		
		        	case "fruittree":
		        		FruitTree[] FruitTree = new FruitTree[lastbox];
		        		for(int ab=0;ab<lastbox;ab++) {
		        			int currentpopulation=consumer[ab].getPopulationDensity();
		    		    	currentpopulation+=currentpopulation/2;
		    		        consumer[ab].setPopulationDensity(currentpopulation);
		    		        if(consumer[ab].getPopulationDensity()>=12) {
			        			FruitTree[ab]= new FruitTree ("fruittree",true,10,10,4,20,25,0,4, pos.initPosition[SavannaEcosystem.a]);
			        			pos.initPosition[SavannaEcosystem.a].setX(consumer[ab].getCordinates().getX());
			        			pos.initPosition[SavannaEcosystem.a].setY(consumer[ab].getCordinates().getY());
			    				consumer[ab].setPopulationDensity(consumer[ab].getPopulationDensity()-10);
			    				FruitTree[ab].setCordinates(cm.SavannaMouvement(FruitTree[ab]));
		    		        	SavannaEcosystem.a++;
		    		        	newspecies++;
		    		        }
		        		}
		        		FruitTree[] FruitTreecreate = new FruitTree[newspecies];
		        		for(int ab=0;ab<lastbox;ab++) {
			        		if(FruitTree[ab]!=null) {
			    		        if(FruitTree[ab].getPopulationDensity()==10) {
			    		        	FruitTreecreate[speciescreat]=FruitTree[ab];
			    		        	speciescreat++;
			    		        }
			        		}
		        		}
		        		FruitTree[] allgroupsFruitTree=new FruitTree[lastbox+newspecies];
		        		int lengthFruitTree = allgroupsFruitTree.length;
	    				for(int i=0;i<lastbox;i++) {
	    					allgroupsFruitTree[i]=(FruitTree) consumer[i];
	    				}
	    				int jiFruitTree;
	    				for(jiFruitTree=lastbox;jiFruitTree<lengthFruitTree;jiFruitTree++) {
	    					allgroupsFruitTree[jiFruitTree]=FruitTreecreate[jiFruitTree-lastbox];
	    				}
	    			
	    				for(int ia=0;ia<lengthFruitTree;ia++) {
	    				}
	    				animalsInSavana.register(name, allgroupsFruitTree);
	        				
		        		break;
		        		
		        	case "reeds":
		        		Reeds[] Reeds = new Reeds[lastbox];
		        		for(int ab=0;ab<lastbox;ab++) {
		        			int currentpopulation=consumer[ab].getPopulationDensity();
		    		    	currentpopulation+=currentpopulation/2;
		    		        consumer[ab].setPopulationDensity(currentpopulation);
		    		        if(consumer[ab].getPopulationDensity()>=12) {
			        			Reeds[ab]= new Reeds ("reeds",true,10,10,4,20,25,0,4, pos.initPosition[SavannaEcosystem.a]);
			        			pos.initPosition[SavannaEcosystem.a].setX(consumer[ab].getCordinates().getX());
			        			pos.initPosition[SavannaEcosystem.a].setY(consumer[ab].getCordinates().getY());
			    				consumer[ab].setPopulationDensity(consumer[ab].getPopulationDensity()-10);
			    				Reeds[ab].setCordinates(cm.SavannaMouvement(Reeds[ab]));
		    		        	SavannaEcosystem.a++;
		    		        	newspecies++;
		    		        }
		        		}
		        		Reeds[] Reedscreate = new Reeds[newspecies];
		        		for(int ab=0;ab<lastbox;ab++) {
			        		if(Reeds[ab]!=null) {
			    		        if(Reeds[ab].getPopulationDensity()==10) {
			    		        	Reedscreate[speciescreat]=Reeds[ab];
			    		        	speciescreat++;
			    		        }
			        		}
		        		}
		        		Reeds[] allgroupsReeds=new Reeds[lastbox+newspecies];
		        		int lengthReeds = allgroupsReeds.length;
	    				for(int i=0;i<lastbox;i++) {
	    					allgroupsReeds[i]=(Reeds) consumer[i];
	    				}
	    				int jiReeds;
	    				for(jiReeds=lastbox;jiReeds<lengthReeds;jiReeds++) {
	    					allgroupsReeds[jiReeds]=Reedscreate[jiReeds-lastbox];
	    				}
	    			
	    				for(int ia=0;ia<lengthReeds;ia++) {
	    				}
	    				animalsInSavana.register(name, allgroupsReeds);
	        				
		        		break;
		        		
		        	case "bushswamps":
		        		Bush[] Bush1 = new Bush[lastbox];
		        		for(int ab=0;ab<lastbox;ab++) {
		        			int currentpopulation=consumer[ab].getPopulationDensity();
		    		    	currentpopulation+=currentpopulation/2;
		    		        consumer[ab].setPopulationDensity(currentpopulation);
		    		        if(consumer[ab].getPopulationDensity()>=12) {
			        			Bush1[ab]= new Bush ("bush",true,10,10,4,20,25,0,4, pos.initPosition[SavannaEcosystem.a]);
			        			pos.initPosition[SavannaEcosystem.a].setX(consumer[ab].getCordinates().getX());
			        			pos.initPosition[SavannaEcosystem.a].setY(consumer[ab].getCordinates().getY());
			    				consumer[ab].setPopulationDensity(consumer[ab].getPopulationDensity()-10);
			    				Bush1[ab].setCordinates(cm.SavannaMouvement(Bush1[ab]));
		    		        	SavannaEcosystem.a++;
		    		        	newspecies++;
		    		        }
		        		}
		        		Bush[] Bushcreate1 = new Bush[newspecies];
		        		for(int ab=0;ab<lastbox;ab++) {
			        		if(Bush1[ab]!=null) {
			    		        if(Bush1[ab].getPopulationDensity()==10) {
			    		        	Bushcreate1[speciescreat]=Bush1[ab];
			    		        	speciescreat++;
			    		        }
			        		}
		        		}
		        		Bush[] allgroupsBush1=new Bush[lastbox+newspecies];
		        		int lengthBush1 = allgroupsBush1.length;
	    				for(int i=0;i<lastbox;i++) {
	    					allgroupsBush1[i]=(Bush) consumer[i];
	    				}
	    				int jiBush1;
	    				for(jiBush1=lastbox;jiBush1<lengthBush1;jiBush1++) {
	    					allgroupsBush1[jiBush1]=Bushcreate1[jiBush1-lastbox];
	    				}
	    			
	    				for(int ia=0;ia<lengthBush1;ia++) {
	    				}
	    				animalsInSavana.register(name, allgroupsBush1);
	        				
		        		break;
		        		
		        		
		        	case "python":
		        		Python[] Python = new Python[lastbox];
		        		for(int ab=0;ab<lastbox;ab++) {
		        			int currentpopulation=consumer[ab].getPopulationDensity();
		    		    	currentpopulation+=currentpopulation/2;
		    		        consumer[ab].setPopulationDensity(currentpopulation);
		    		        if(consumer[ab].getPopulationDensity()>=12) {
			        			Python[ab]= new Python ("python", 30, 100, true,10, 0,10, 10, 3, false, pos.initPosition[SavannaEcosystem.a]);
			        			pos.initPosition[SavannaEcosystem.a].setX(consumer[ab].getCordinates().getX());
			        			pos.initPosition[SavannaEcosystem.a].setY(consumer[ab].getCordinates().getY());
			    				consumer[ab].setPopulationDensity(consumer[ab].getPopulationDensity()-10);
			    				Python[ab].setCordinates(cm.SavannaMouvement(Python[ab]));
		    		        	SavannaEcosystem.a++;
		    		        	newspecies++;
		    		        }
		        		}
		        		Python[] Pythoncreate = new Python[newspecies];
		        		for(int ab=0;ab<lastbox;ab++) {
			        		if(Python[ab]!=null) {
			    		        if(Python[ab].getPopulationDensity()==10) {
			    		        	Pythoncreate[speciescreat]=Python[ab];
			    		        	speciescreat++;
			    		        }
			        		}
		        		}
		        		Python[] allgroupsPython=new Python[lastbox+newspecies];
		        		int lengthPython = allgroupsPython.length;
	    				for(int i=0;i<lastbox;i++) {
	    					allgroupsPython[i]=(Python) consumer[i];
	    				}
	    				int jiPython;
	    				for(jiPython=lastbox;jiPython<lengthPython;jiPython++) {
	    					allgroupsPython[jiPython]=Pythoncreate[jiPython-lastbox];
	    				}
	    			
	    				for(int ia=0;ia<lengthPython;ia++) {
	    				}
	    				animalsInSavana.register(name, allgroupsPython);
	        				
		        		break;
		        		
		        		
		        	case "chimpanzee":
		        		Chimpanzee[] Chimpanzee = new Chimpanzee[lastbox];
		        		for(int ab=0;ab<lastbox;ab++) {
		        			int currentpopulation=consumer[ab].getPopulationDensity();
		    		    	currentpopulation+=currentpopulation/2;
		    		        consumer[ab].setPopulationDensity(currentpopulation);
		    		        if(consumer[ab].getPopulationDensity()>=12) {
			        			Chimpanzee[ab]= new Chimpanzee ("chimpanzee", 30, 100, true,10, 0,10, 10, 3, false, pos.initPosition[SavannaEcosystem.a]);
			        			pos.initPosition[SavannaEcosystem.a].setX(consumer[ab].getCordinates().getX());
			        			pos.initPosition[SavannaEcosystem.a].setY(consumer[ab].getCordinates().getY());
			    				consumer[ab].setPopulationDensity(consumer[ab].getPopulationDensity()-10);
			    				Chimpanzee[ab].setCordinates(cm.SavannaMouvement(Chimpanzee[ab]));
		    		        	SavannaEcosystem.a++;
		    		        	newspecies++;
		    		        }
		        		}
		        		Chimpanzee[] Chimpanzeecreate = new Chimpanzee[newspecies];
		        		for(int ab=0;ab<lastbox;ab++) {
			        		if(Chimpanzee[ab]!=null) {
			    		        if(Chimpanzee[ab].getPopulationDensity()==10) {
			    		        	Chimpanzeecreate[speciescreat]=Chimpanzee[ab];
			    		        	speciescreat++;
			    		        }
			        		}
		        		}
		        		Chimpanzee[] allgroupsChimpanzee=new Chimpanzee[lastbox+newspecies];
		        		int lengthChimpanzee = allgroupsChimpanzee.length;
	    				for(int i=0;i<lastbox;i++) {
	    					allgroupsChimpanzee[i]=(Chimpanzee) consumer[i];
	    				}
	    				int jiChimpanzee;
	    				for(jiChimpanzee=lastbox;jiChimpanzee<lengthChimpanzee;jiChimpanzee++) {
	    					allgroupsChimpanzee[jiChimpanzee]=Chimpanzeecreate[jiChimpanzee-lastbox];
	    				}
	    			
	    				for(int ia=0;ia<lengthChimpanzee;ia++) {
	    				}
	    				animalsInSavana.register(name, allgroupsChimpanzee);
	        				
		        		break;
		        		
		        		
		        	case "anaconda":
		        		Anaconda[] Anaconda = new Anaconda[lastbox];
		        		for(int ab=0;ab<lastbox;ab++) {
		        			int currentpopulation=consumer[ab].getPopulationDensity();
		    		    	currentpopulation+=currentpopulation/2;
		    		        consumer[ab].setPopulationDensity(currentpopulation);
		    		        if(consumer[ab].getPopulationDensity()>=12) {
			        			Anaconda[ab]= new Anaconda ("anaconda", 30, 100, true,10, 0,10, 10, 3, false, pos.initPosition[SavannaEcosystem.a]);
			        			pos.initPosition[SavannaEcosystem.a].setX(consumer[ab].getCordinates().getX());
			        			pos.initPosition[SavannaEcosystem.a].setY(consumer[ab].getCordinates().getY());
			    				consumer[ab].setPopulationDensity(consumer[ab].getPopulationDensity()-10);
			    				Anaconda[ab].setCordinates(cm.SavannaMouvement(Anaconda[ab]));
		    		        	SavannaEcosystem.a++;
		    		        	newspecies++;
		    		        }
		        		}
		        		Anaconda[] Anacondacreate = new Anaconda[newspecies];
		        		for(int ab=0;ab<lastbox;ab++) {
			        		if(Anaconda[ab]!=null) {
			    		        if(Anaconda[ab].getPopulationDensity()==10) {
			    		        	Anacondacreate[speciescreat]=Anaconda[ab];
			    		        	speciescreat++;
			    		        }
			        		}
		        		}
		        		Anaconda[] allgroupsAnaconda=new Anaconda[lastbox+newspecies];
		        		int lengthAnaconda = allgroupsAnaconda.length;
	    				for(int i=0;i<lastbox;i++) {
	    					allgroupsAnaconda[i]=(Anaconda) consumer[i];
	    				}
	    				int jiAnaconda;
	    				for(jiAnaconda=lastbox;jiAnaconda<lengthAnaconda;jiAnaconda++) {
	    					allgroupsAnaconda[jiAnaconda]=Anacondacreate[jiAnaconda-lastbox];
	    				}
	    			
	    				for(int ia=0;ia<lengthAnaconda;ia++) {
	    				}
	    				animalsInSavana.register(name, allgroupsAnaconda);
	        				
		        		break;
		        		
		        		
		        	case "blackcaiman":
		        		BlackCaiman[] BlackCaiman = new BlackCaiman[lastbox];
		        		for(int ab=0;ab<lastbox;ab++) {
		        			int currentpopulation=consumer[ab].getPopulationDensity();
		    		    	currentpopulation+=currentpopulation/2;
		    		        consumer[ab].setPopulationDensity(currentpopulation);
		    		        if(consumer[ab].getPopulationDensity()>=12) {
			        			BlackCaiman[ab]= new BlackCaiman ("blackcaiman", 20, 100, true,10, 0,50, 10, 3, false, pos.initPosition[SavannaEcosystem.a]);
			        			pos.initPosition[SavannaEcosystem.a].setX(consumer[ab].getCordinates().getX());
			        			pos.initPosition[SavannaEcosystem.a].setY(consumer[ab].getCordinates().getY());
			    				consumer[ab].setPopulationDensity(consumer[ab].getPopulationDensity()-10);
			    				BlackCaiman[ab].setCordinates(cm.SavannaMouvement(BlackCaiman[ab]));
		    		        	SavannaEcosystem.a++;
		    		        	newspecies++;
		    		        }
		        		}
		        		BlackCaiman[] BlackCaimancreate = new BlackCaiman[newspecies];
		        		for(int ab=0;ab<lastbox;ab++) {
			        		if(BlackCaiman[ab]!=null) {
			    		        if(BlackCaiman[ab].getPopulationDensity()==10) {
			    		        	BlackCaimancreate[speciescreat]=BlackCaiman[ab];
			    		        	speciescreat++;
			    		        }
			        		}
		        		}
		        		BlackCaiman[] allgroupsBlackCaiman=new BlackCaiman[lastbox+newspecies];
		        		int lengthBlackCaiman = allgroupsBlackCaiman.length;
	    				for(int i=0;i<lastbox;i++) {
	    					allgroupsBlackCaiman[i]=(BlackCaiman) consumer[i];
	    				}
	    				int jiBlackCaiman;
	    				for(jiBlackCaiman=lastbox;jiBlackCaiman<lengthBlackCaiman;jiBlackCaiman++) {
	    					allgroupsBlackCaiman[jiBlackCaiman]=BlackCaimancreate[jiBlackCaiman-lastbox];
	    				}
	    			
	    				for(int ia=0;ia<lengthBlackCaiman;ia++) {
	    				}
	    				animalsInSavana.register(name, allgroupsBlackCaiman);
	        				
		        		break;
		        		
		        		
		        	case "jaguar":
		        		Jaguar[] Jaguar = new Jaguar[lastbox];
		        		for(int ab=0;ab<lastbox;ab++) {
		        			int currentpopulation=consumer[ab].getPopulationDensity();
		    		    	currentpopulation+=currentpopulation/2;
		    		        consumer[ab].setPopulationDensity(currentpopulation);
		    		        if(consumer[ab].getPopulationDensity()>=12) {
			        			Jaguar[ab]= new Jaguar ("jaguar", 20, 100, true,10, 0,50, 10, 3, false, pos.initPosition[SavannaEcosystem.a]);
			        			pos.initPosition[SavannaEcosystem.a].setX(consumer[ab].getCordinates().getX());
			        			pos.initPosition[SavannaEcosystem.a].setY(consumer[ab].getCordinates().getY());
			    				consumer[ab].setPopulationDensity(consumer[ab].getPopulationDensity()-10);
			    				Jaguar[ab].setCordinates(cm.SavannaMouvement(Jaguar[ab]));
		    		        	SavannaEcosystem.a++;
		    		        	newspecies++;
		    		        }
		        		}
		        		Jaguar[] Jaguarcreate = new Jaguar[newspecies];
		        		for(int ab=0;ab<lastbox;ab++) {
			        		if(Jaguar[ab]!=null) {
			    		        if(Jaguar[ab].getPopulationDensity()==10) {
			    		        	Jaguarcreate[speciescreat]=Jaguar[ab];
			    		        	speciescreat++;
			    		        }
			        		}
		        		}
		        		Jaguar[] allgroupsJaguar=new Jaguar[lastbox+newspecies];
		        		int lengthJaguar = allgroupsJaguar.length;
	    				for(int i=0;i<lastbox;i++) {
	    					allgroupsJaguar[i]=(Jaguar) consumer[i];
	    				}
	    				int jiJaguar;
	    				for(jiJaguar=lastbox;jiJaguar<lengthJaguar;jiJaguar++) {
	    					allgroupsJaguar[jiJaguar]=Jaguarcreate[jiJaguar-lastbox];
	    				}
	    			
	    				for(int ia=0;ia<lengthJaguar;ia++) {
	    				}
	    				animalsInSavana.register(name, allgroupsJaguar);
	        				
		        		break;
		        		
		        	
		        	case "saltcrocodile":
		        		SaltCrocodile[] SaltCrocodile = new SaltCrocodile[lastbox];
		        		for(int ab=0;ab<lastbox;ab++) {
		        			int currentpopulation=consumer[ab].getPopulationDensity();
		    		    	currentpopulation+=currentpopulation/2;
		    		        consumer[ab].setPopulationDensity(currentpopulation);
		    		        if(consumer[ab].getPopulationDensity()>=12) {
			        			SaltCrocodile[ab]= new SaltCrocodile ("saltcrocodile", 20, 100, true,10, 0,50, 10, 3, false, pos.initPosition[SavannaEcosystem.a]);
			        			pos.initPosition[SavannaEcosystem.a].setX(consumer[ab].getCordinates().getX());
			        			pos.initPosition[SavannaEcosystem.a].setY(consumer[ab].getCordinates().getY());
			    				consumer[ab].setPopulationDensity(consumer[ab].getPopulationDensity()-10);
			    				SaltCrocodile[ab].setCordinates(cm.SavannaMouvement(SaltCrocodile[ab]));
		    		        	SavannaEcosystem.a++;
		    		        	newspecies++;
		    		        }
		        		}
		        		SaltCrocodile[] SaltCrocodilecreate = new SaltCrocodile[newspecies];
		        		for(int ab=0;ab<lastbox;ab++) {
			        		if(SaltCrocodile[ab]!=null) {
			    		        if(SaltCrocodile[ab].getPopulationDensity()==10) {
			    		        	SaltCrocodilecreate[speciescreat]=SaltCrocodile[ab];
			    		        	speciescreat++;
			    		        }
			        		}
		        		}
		        		SaltCrocodile[] allgroupsSaltCrocodile=new SaltCrocodile[lastbox+newspecies];
		        		int lengthSaltCrocodile = allgroupsSaltCrocodile.length;
	    				for(int i=0;i<lastbox;i++) {
	    					allgroupsSaltCrocodile[i]=(SaltCrocodile) consumer[i];
	    				}
	    				int jiSaltCrocodile;
	    				for(jiSaltCrocodile=lastbox;jiSaltCrocodile<lengthSaltCrocodile;jiSaltCrocodile++) {
	    					allgroupsSaltCrocodile[jiSaltCrocodile]=SaltCrocodilecreate[jiSaltCrocodile-lastbox];
	    				}
	    			
	    				for(int ia=0;ia<lengthSaltCrocodile;ia++) {
	    				}
	    				animalsInSavana.register(name, allgroupsSaltCrocodile);
	        				
		        		break;
		        		
		        		
		        	case "hippopotamus":
		        		Hippopotamus[] Hippopotamus = new Hippopotamus[lastbox];
		        		for(int ab=0;ab<lastbox;ab++) {
		        			int currentpopulation=consumer[ab].getPopulationDensity();
		    		    	currentpopulation+=currentpopulation/2;
		    		        consumer[ab].setPopulationDensity(currentpopulation);
		    		        if(consumer[ab].getPopulationDensity()>=12) {
			        			Hippopotamus[ab]= new Hippopotamus ("hippopotamus", 20, 100, true,10, 0,40, 10, 3, false, pos.initPosition[SavannaEcosystem.a]);
			        			pos.initPosition[SavannaEcosystem.a].setX(consumer[ab].getCordinates().getX());
			        			pos.initPosition[SavannaEcosystem.a].setY(consumer[ab].getCordinates().getY());
			    				consumer[ab].setPopulationDensity(consumer[ab].getPopulationDensity()-10);
			    				Hippopotamus[ab].setCordinates(cm.SavannaMouvement(Hippopotamus[ab]));
		    		        	SavannaEcosystem.a++;
		    		        	newspecies++;
		    		        }
		        		}
		        		Hippopotamus[] Hippopotamuscreate = new Hippopotamus[newspecies];
		        		for(int ab=0;ab<lastbox;ab++) {
			        		if(Hippopotamus[ab]!=null) {
			    		        if(Hippopotamus[ab].getPopulationDensity()==10) {
			    		        	Hippopotamuscreate[speciescreat]=Hippopotamus[ab];
			    		        	speciescreat++;
			    		        }
			        		}
		        		}
		        		Hippopotamus[] allgroupsHippopotamus=new Hippopotamus[lastbox+newspecies];
		        		int lengthHippopotamus = allgroupsHippopotamus.length;
	    				for(int i=0;i<lastbox;i++) {
	    					allgroupsHippopotamus[i]=(Hippopotamus) consumer[i];
	    				}
	    				int jiHippopotamus;
	    				for(jiHippopotamus=lastbox;jiHippopotamus<lengthHippopotamus;jiHippopotamus++) {
	    					allgroupsHippopotamus[jiHippopotamus]=Hippopotamuscreate[jiHippopotamus-lastbox];
	    				}
	    			
	    				for(int ia=0;ia<lengthHippopotamus;ia++) {
	    				}
	    				animalsInSavana.register(name, allgroupsHippopotamus);
	        				
		        		break;
		        	}
		        }
		    }
		}}
}
