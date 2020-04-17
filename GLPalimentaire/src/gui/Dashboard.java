package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import beingManagement.BeingCreator;
import data.Consumer;
import data.Producer;
import gui.images.ImagesPreferences;

public class Dashboard extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public Dashboard instance;
	
	/**
	 * pictures for Savanna Ecosystem
	 */
	private Image acaciap;
	private Image buffalop;
	private Image bushp;
	private Image cheetahp;
	private Image gazellep;
	private Image giraffep;
	private Image grassp;
	private Image hyenap;
	private Image lionp;
	private Image warthogp;
	private Image zebrap;
	
	/**
	 * pictures for Swamps Ecosystem
	 */
	private Image anaconda;
	private Image blackcaiman;
	private Image bushs;
	private Image chimpanzee;
	private Image fruittree;
	private Image hippopotamus;
	private Image jaguar;
	private Image monkey;
	private Image python;
	private Image reeds;
	private Image saltcrocodile;
	private Image turtle;
	
	/**
	 * pictures for Frosty Ecosystem
	 */
	private Image arcticwolf;
	private Image clam;
	private Image grassf;
	private Image foam;
	private Image inuit;
	private Image muskox;
	private Image phoque;
	private Image polarbear;
	
	/**
	 * pictures for Plain Ecosystem
	 */
	private Image aphid;
	private Image asianladybug;
	private Image bramble;
	private Image ferns;
	private Image herbivorous;
	private Image woodpecker;
	private Image spider;
	private Image treeleaves;
	
	
	private int heightPanel;
	private int widthPanel;
	private BeingCreator animalsInSavana = BeingCreator.getInstance();
	


	public Dashboard(){
	}    
	
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        try {
        	if(OperationZone.ecosystem.equals("Savanna")) {
        		setPictureSavanna();
        	}
        	else if(OperationZone.ecosystem.equals("Frosty")) {
        		setPictureFrosty();
        	}
        	else if(OperationZone.ecosystem.equals("Swamps")) {
        		setPictureSwamps();
        	}
        	else if(OperationZone.ecosystem.equals("Plain")) {
        		setPicturePlain();
        	}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        	heightPanel = getHeight();
        	widthPanel = getWidth();
            Graphics2D g2d = (Graphics2D)g;
            
            
            if(OperationZone.ecosystem.equals("Savanna")) {
	            g2d.setColor(Color.ORANGE);
	            g2d.fillRect(0,0, widthPanel, heightPanel);       	
	            DisplayPictureProducer(grassp, g2d,"grass");
	            DisplayPictureProducer(bushp, g2d,"bush");
	           	DisplayPictureProducer(acaciap, g2d,"acacia");
	      		DisplayPictureConsumer(gazellep, g2d,"gazelle");
	            DisplayPictureConsumer(giraffep, g2d,"giraffe");
	            DisplayPictureConsumer(hyenap, g2d,"hyena");
	            DisplayPictureConsumer(warthogp, g2d,"warthog");
	            DisplayPictureConsumer(lionp, g2d,"lion");
	            DisplayPictureConsumer(cheetahp, g2d,"cheetah");
	            DisplayPictureConsumer(buffalop, g2d,"buffalo");
	            DisplayPictureConsumer(zebrap, g2d,"zebra");
            }
            
            if (OperationZone.ecosystem.equals("Swamps")) {
            	g2d.setColor(Color.GREEN);
	            g2d.fillRect(0,0, widthPanel, heightPanel);
	            DisplayPictureProducer(bushs, g2d,"bushswamps");
	            DisplayPictureProducer(reeds, g2d,"reeds");
	           	DisplayPictureProducer(fruittree, g2d,"fruittree");
	      		DisplayPictureConsumer(anaconda, g2d,"anaconda");
	            DisplayPictureConsumer(blackcaiman, g2d,"blackcaiman");
	            DisplayPictureConsumer(chimpanzee, g2d,"chimpanzee");
	            DisplayPictureConsumer(hippopotamus, g2d,"hippopotamus");
	            DisplayPictureConsumer(jaguar, g2d,"jaguar");
	            DisplayPictureConsumer(monkey, g2d,"monkey");
	            DisplayPictureConsumer(python, g2d,"python");
	            DisplayPictureConsumer(saltcrocodile, g2d,"saltcrocodile");
	            DisplayPictureConsumer(turtle, g2d,"turtle");
            }
            
            if (OperationZone.ecosystem.equals("Frosty")) {
            	g2d.setColor(Color.BLUE);
 	            g2d.fillRect(0,0, widthPanel, heightPanel);       	
 	            DisplayPictureProducer(grassf, g2d,"grass");
 	            DisplayPictureProducer(foam, g2d,"foam");
 	      		DisplayPictureConsumer(arcticwolf, g2d,"arcticwolf");
 	            DisplayPictureConsumer(clam, g2d,"clam");
 	            DisplayPictureConsumer(inuit, g2d,"inuit");
 	            DisplayPictureConsumer(muskox, g2d,"muskox");
 	            DisplayPictureConsumer(phoque, g2d,"phoque");
 	            DisplayPictureConsumer(polarbear, g2d,"polarbear");
            }
            g.setColor(Color.BLACK);
            g.drawLine(widthPanel/2, 0, widthPanel/2, heightPanel);
            g.drawLine(0, heightPanel/2, widthPanel, heightPanel/2);
            
        }	
    

    public void setPictureSavanna() throws IOException {
		try {
            this.acaciap= ImageIO.read(new File(ImagesPreferences.ACACIA_IMG_BACKGROUND_PATH));
            this.buffalop = ImageIO.read(new File(ImagesPreferences.BUFFALO_IMG_BACKGROUND_PATH));
            this.bushp = ImageIO.read(new File(ImagesPreferences.BUSH_IMG_BACKGROUND_PATH));
            this.cheetahp = ImageIO.read(new File(ImagesPreferences.CHEETAH_IMG_BACKGROUND_PATH));
            this.gazellep = ImageIO.read(new File(ImagesPreferences.GAZELLE_IMG_BACKGROUND_PATH));
            this.giraffep= ImageIO.read(new File(ImagesPreferences.GIRAFFE_IMG_BACKGROUND_PATH));
            this.grassp= ImageIO.read(new File(ImagesPreferences.GRASS_IMG_BACKGROUND_PATH));
            this.hyenap = ImageIO.read(new File(ImagesPreferences.HYENA_IMG_BACKGROUND_PATH));
            this.lionp = ImageIO.read(new File(ImagesPreferences.LION_IMG_BACKGROUND_PATH));
            this.warthogp = ImageIO.read(new File(ImagesPreferences.WARTHOG_IMG_BACKGROUND_PATH));
            this.zebrap = ImageIO.read(new File(ImagesPreferences.ZEBRA_IMG_BACKGROUND_PATH));
        } 
        catch (IOException e) {
            throw new IOException(" one/some files are not found", e);
        }
	}
    
	public void setPicturePlain() throws IOException {
		// TODO Auto-generated method stub
		try {
            this.aphid= ImageIO.read(new File(ImagesPreferences.APHID_IMG_BACKGROUND_PATH));
            this.asianladybug = ImageIO.read(new File(ImagesPreferences.ASIANLADYBUG_IMG_BACKGROUND_PATH));
            this.bramble = ImageIO.read(new File(ImagesPreferences.BRAMBLE_IMG_BACKGROUND_PATH));
            this.ferns = ImageIO.read(new File(ImagesPreferences.FERNS_IMG_BACKGROUND_PATH));
            this.herbivorous = ImageIO.read(new File(ImagesPreferences.HERBIVOROUS_IMG_BACKGROUND_PATH));
            this.woodpecker= ImageIO.read(new File(ImagesPreferences.WOODPECKER_IMG_BACKGROUND_PATH));
            this.spider= ImageIO.read(new File(ImagesPreferences.SPIDER_IMG_BACKGROUND_PATH));
            this.treeleaves = ImageIO.read(new File(ImagesPreferences.TREELEAVES_IMG_BACKGROUND_PATH));
        } 
        catch (IOException e) {
            throw new IOException(" one/some files are not found", e);
        }
	}

	public void setPictureSwamps() throws IOException {
		// TODO Auto-generated method stub
		try {
            this.anaconda= ImageIO.read(new File(ImagesPreferences.ANACONDA_IMG_BACKGROUND_PATH));
            this.blackcaiman = ImageIO.read(new File(ImagesPreferences.BLACKCAIMAN_IMG_BACKGROUND_PATH));
            this.bushs = ImageIO.read(new File(ImagesPreferences.BUSHS_IMG_BACKGROUND_PATH));
            this.chimpanzee = ImageIO.read(new File(ImagesPreferences.CHIMPANZEE_IMG_BACKGROUND_PATH));
            this.fruittree = ImageIO.read(new File(ImagesPreferences.FRUITTREE_IMG_BACKGROUND_PATH));
            this.hippopotamus= ImageIO.read(new File(ImagesPreferences.HIPPOPOTAMUS_IMG_BACKGROUND_PATH));
            this.jaguar= ImageIO.read(new File(ImagesPreferences.JAGUAR_IMG_BACKGROUND_PATH));
            this.monkey = ImageIO.read(new File(ImagesPreferences.MONKEY_IMG_BACKGROUND_PATH));
            this.python = ImageIO.read(new File(ImagesPreferences.PYTHON_IMG_BACKGROUND_PATH));
            this.reeds = ImageIO.read(new File(ImagesPreferences.REEDS_IMG_BACKGROUND_PATH));
            this.saltcrocodile = ImageIO.read(new File(ImagesPreferences.SALTCROCODILE_IMG_BACKGROUND_PATH));
            this.turtle = ImageIO.read(new File(ImagesPreferences.TURTLE_IMG_BACKGROUND_PATH));
        } 
        catch (IOException e) {
            throw new IOException(" one/some files are not found", e);
        }
	}

	public void setPictureFrosty() throws IOException {
		// TODO Auto-generated method stub
		try {
            this.arcticwolf = ImageIO.read(new File(ImagesPreferences.ARCTICWOLF_IMG_BACKGROUND_PATH));
            this.clam = ImageIO.read(new File(ImagesPreferences.CLAM_IMG_BACKGROUND_PATH));
            this.foam = ImageIO.read(new File(ImagesPreferences.FOAM_IMG_BACKGROUND_PATH));
            this.grassf = ImageIO.read(new File(ImagesPreferences.GRASSF_IMG_BACKGROUND_PATH));
            this.inuit = ImageIO.read(new File(ImagesPreferences.INUIT_IMG_BACKGROUND_PATH));
            this.muskox = ImageIO.read(new File(ImagesPreferences.MUSKOX_IMG_BACKGROUND_PATH));
            this.phoque = ImageIO.read(new File(ImagesPreferences.PHOQUE_IMG_BACKGROUND_PATH));
            this.polarbear = ImageIO.read(new File(ImagesPreferences.POLARBEAR_IMG_BACKGROUND_PATH));
        } 
        catch (IOException e) {
            throw new IOException(" one/some files are not found", e);
        }
	}

	private void DisplayPictureConsumer(Image image, Graphics2D g2d, String name) {
		Consumer[] consumer = new Consumer[animalsInSavana.getTable(name).length];
		consumer=(Consumer[]) animalsInSavana.getTable(name);
		for(int i=0;i<animalsInSavana.getTable(name).length;i++) {
			if (image!=null && consumer[i].getIsAlive()==true) {
				g2d.drawImage(image,(consumer[i].getCordinates().getX()*widthPanel)/18, 
	          			(consumer[i].getCordinates().getY()*heightPanel)/12, (widthPanel*((consumer[i].getPopulationDensity())))/180,
	          			(heightPanel*((consumer[i].getPopulationDensity())))/120, this);
    		}
		}
    }
	private void DisplayPictureProducer(Image image, Graphics2D g2d, String name) {
		Producer[] producer = new Producer[animalsInSavana.getTable(name).length];
		producer=(Producer[]) animalsInSavana.getTable(name);
		for(int i=0; i<animalsInSavana.getTable(name).length;i++) {
			if (image!=null && producer[i].getIsAlive()==true) {
				g2d.drawImage(image,(producer[i].getCordinates().getX()*widthPanel)/18, 
	          			(producer[i].getCordinates().getY()*heightPanel)/12, (widthPanel*((producer[i].getPopulationDensity())))/180,
	          			(heightPanel*((producer[i].getPopulationDensity())))/120, this);
			}
    	}
	}
}
